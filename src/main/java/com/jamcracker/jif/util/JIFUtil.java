 /************************************************************************ 
 *   Copyright [2013] [Jamcracker Inc]
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 *   
 *   
 * @ClassName com.jamcracker.jif.util.JIFUtil
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/
package com.jamcracker.jif.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.Entity;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;

/**
 * Utility class for processing, constructing JIF compatible request/ response
 * @author ppnair
 *
 */
public class JIFUtil {

	/**
	 * @param args
	 */
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(JIFUtil.class);
	/**
	 * @param xmlMessage
	 * @return
	 * @throws Exception
	 */
	public static JIFRequest processRequest(String xmlMessage) throws Exception{
		try{
			Digester digester = DigesterLoader.createDigester(JIFUtil.class.getResource("/operation-rule.xml"));
			digester.setUseContextClassLoader(true);
			InputStream stream = new  ByteArrayInputStream(xmlMessage.getBytes());
			JIFRequest requestMsgObj =  (JIFRequest) digester.parse(stream);
			return requestMsgObj;
		}
		catch(Exception exec){
			LOG.error("Exception occured in <<JIFUtil>>",exec);
			throw exec;
		}
		
	}
	
	
	
	public static String createResponseXML(JIFResponse response){
		Map<String, String> cFields = response.getCompanyFields();
		
		List<Map<String,String>> companyList = new ArrayList<Map<String,String>>();
		Iterator<String> iter = cFields.keySet().iterator();
		boolean hasCompanyFields = false;
		boolean hasUserFields = false;
		while(iter.hasNext()){
			hasCompanyFields = true;
			Map<String,String> fieldMap = new HashMap<String,String>();
			String key = iter.next();
			fieldMap.put("fieldName", key);
			fieldMap.put("fieldValue", cFields.get(key));
			companyList.add(fieldMap);
		}
		Map<String, String> ufields = response.getUserFields();
		List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
		iter = ufields.keySet().iterator();
		while(iter.hasNext()){
			hasUserFields = true;
			Map<String, String> fieldMap = new HashMap<String, String>();
			String key = (String) iter.next();
			fieldMap.put("fieldName", key);
			fieldMap.put("fieldValue", ufields.get(key));
			userList.add(fieldMap);
		}
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		fieldMap.put("CompanyList", companyList);
		fieldMap.put("UserList", userList);
		fieldMap.put("entityType", response.getEntityType());
		fieldMap.put("eventName", response.getEventName());
		fieldMap.put("faultCode", response.getFaultCode());
		fieldMap.put("faultString", response.getFaultString());
		fieldMap.put("htmlContent", response.getHtmlForSSO());
		String responseXML = construct(fieldMap);
		//If there are not company fields to update, remove it from the responseXML
		if(!hasCompanyFields){
			responseXML = responseXML.replaceAll("<entitydata entitytype=\"company\">[\\s\\t\\r]*</entitydata>", "");
		}
		//If there are not user fields to update, remove it from the responseXML
		if(!hasUserFields){
			responseXML = responseXML.replaceAll("<entitydata entitytype=\"user\">[\\s\\t\\r]*</entitydata>", "");
		}
		
		//If the event is not SSO, remove the SSO content from responseXML  
		if(!response.getEventName().equals(JIFConstants.EVENT_SSO)){
			responseXML = responseXML.replaceAll("<entitydata entitytype=\"sso\">[a-zA-Z0-9_\\s\\W]*</entitydata>", "");
		}
		
		return responseXML;
	}
	
	
    /**
     * 
     * @param smap
     * @param fileName RequestXMLTemplate
     * @return
     * @throws FileNotFoundException
     * @throws Exception
     */
     
    private static String construct(Map<String, Object> smap) {
        String finalXML = "";
        try {
            // Get the path of the template xml file.
            String xml = readXMLFromFile(JIFUtil.class.getResourceAsStream("/ResponseMessage.xml"));
            finalXML = setPlaceholdersWithValues(smap, xml, "@@");
        } catch (Exception fe) {
            fe.printStackTrace();
        }
        return finalXML;
    }
    
    /**
     * setPlaceholdersWithValues method replaces the tokens with actual values for template xml
     * @param smap
     * @param xml
     * @param placeholderStr '@@'
     * @return
     */
     
    private static String setPlaceholdersWithValues(Map<String, Object> smap, String xml, 
                                             String placeholderStr) {

        Iterator<String> iter = smap.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object value = smap.get(key);
            String placeHolder = placeholderStr + key + placeholderStr;
            LOG.debug("SelfTestUtil -->placeHolder-->" + placeHolder);
            if (value != null) {
                //If value is instance of List, it should be replaced by the List of Blocks
                if (value instanceof List) {
                    @SuppressWarnings("unchecked")
					List<Map<String, Object>> valueList = (List<Map<String, Object>>)value;
                    int len = placeHolder.length();
                    //Find the block to be replaced by the list of blocks with replaced values
                    int index1 = xml.indexOf(placeHolder);
                    int index2 = 
                        xml.indexOf(placeHolder, index1 + placeHolder.length());
                    String listKey = xml.substring(index1, index2 + len);
                    String listStr = xml.substring(index1 + len, index2);
                    // To hold the list of blocks replaced by actual values
                    StringBuffer lstStrBuffer = new StringBuffer();
                    //Iterate thru the List of date Objects
                    for (int i = 0; i < valueList.size(); i++) {
                        Map<String, Object> map = valueList.get(i);
                        //recursively call and replace the place holders in the block by actual data values
                        //append to the list of block
                        lstStrBuffer.append(setPlaceholdersWithValues(map, listStr, placeholderStr));
                    }
                    // replace the single block with List of blocks which are replaced with actual data values
                    //Escapes $ character
                    String strValue = 
                        lstStrBuffer.toString().replaceAll("[$]", "\\\\\\$");
                    // '\\Q' and '\\E' quote the complete list key, so that it can contain even regular expression special characters.
                    xml = xml.replaceAll("\\Q" + listKey + "\\E", strValue);
                } else {
                    //replace the placeholder with the value from the map
                    //Escapes $ character
                    String strValue = 
                        value.toString().replaceAll("[$]", "\\\\\\$");
                    // '\\Q' and '\\E' quote the complete list key, so that it can contain even regular expression special characters.
                    xml = xml.replaceAll("\\Q" + placeHolder + "\\E", strValue);
                }
            }
        }
        return xml;
    }

    /**
     * readXMLFromFile method reads the template request xml file.
     * @param inputStream
     * @return
     * @throws Exception
     */
     
    public static String readXMLFromFile(InputStream inputStream) throws Exception {
    	BufferedReader in = null;
        StringBuffer strBuffer = new StringBuffer();

        try{
            in = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = in.readLine()) != null) {
                strBuffer.append(str + "\n");
            }
        }finally{
        	if(in != null){
        		in.close();
        	}
        }

        String returnString = strBuffer.toString();

        return returnString;

    }

	public static Map<String, String> getFieldMap(JIFRequest jifRequest) {
		Map<String, Entity> fields = jifRequest.getFields();
		Map<String,String> fieldMap = new HashMap<String, String>();
		for (String key: fields.keySet()) {
			Map<String, String> data = (Map<String,String>)((Entity)fields.get(key)).getFields();
			for (String fieldName : data.keySet() ) {
				fieldMap.put(key.substring(0, 1).toUpperCase()+"."+fieldName, data.get(fieldName) );
			}
		}
		return fieldMap;

	}
	
}
