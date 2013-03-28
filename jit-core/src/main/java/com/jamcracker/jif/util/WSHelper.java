/*
 * Class: WSHelper.java
 *

 *
 * Version History:
 * 
 * Ver  	Date         		     Who           			   Release     What and Why
 * ---  	----------  	   	    ---------      			  -------     ---------------------------------------
 * 1.0 		27-Mar-2013            		ppnair           1.0		 Initial version
 * 
 * This software is the confidential and proprietary information of Jamcracker, Inc. 
 * ("Confidential Information").  You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement you 
 *  entered into with Jamcracker, Inc. Copyright (c) 2000 Jamcracker, Inc.  All Rights    
 *  Reserved
 *
 *
 * 
 ******************************************************/
package com.jamcracker.jif.util;

import java.util.Map;

import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.exception.JIFException;
import com.jamcracker.wsutil.HttpClient;
import com.jamcracker.wsutil.WSResponse;
import com.jamcracker.wsutil.exception.WSException;

/**
 * @author ppnair
 *
 */
public class WSHelper {
	/**
	 * @param jifRequest
	 * @param fieldMap
	 * @param operationName
	 * @param processFile
	 * @return
	 * @throws JIFException
	 */
	public static JIFResponse processRequests(JIFRequest jifRequest, String operationName, String[] responseFields, String processFile) throws JIFException {
		
		// TODO Auto-generated method stub
		
		WSResponse wsResponse = null;
		HttpClient client = null;
		JIFResponse jifResponse = new JIFResponse();
		jifResponse.setEntityType(jifRequest.getEntityType());
		jifResponse.setEventName(jifRequest.getEventName());
		String key = jifRequest.getEventName()+jifRequest.getEntityType();
		Map fieldMap = JIFUtil.getFieldMap(jifRequest);
		if(operationName == null){
			throw new JIFException("2222", "Please provide the OperationnName for "+key+ " Event");
		}
		if(!operationName.equalsIgnoreCase("none")){
			try {
				client = new HttpClient(processFile);
				wsResponse = client.processOperations(processFile, operationName, fieldMap);
				if(wsResponse.getReturnCode() == null && wsResponse.getReturnString() ==  null){
					jifResponse.setFaultCode("0");
					jifResponse.setFaultString("success");
					jifResponse = setResponseFields(wsResponse.getReturnValues(),jifResponse,responseFields);
				}else{
					jifResponse.setFaultCode(wsResponse.getReturnCode());
					jifResponse.setFaultString(wsResponse.getReturnString());
				}
			} catch (WSException e) {
				// TODO Auto-generated catch block
				throw new JIFException("1111111", e.toString());
			}
		}
		else{
			jifResponse.setFaultCode("0");
			jifResponse.setFaultString("success");
		}
		return jifResponse;
	}	
	
	private static JIFResponse setResponseFields(Map returnValues,JIFResponse jifResponse, String[] responseFields) throws JIFException {
		// TODO Auto-generated method stub
		for (int i = 0; i < responseFields.length; i++) {
			String entityType = responseFields[i].substring(0,1);
			if(entityType.equalsIgnoreCase("C")){
				jifResponse.setCompanyField(responseFields[i].substring(2), returnValues.get(responseFields[i]).toString());
			}else if(entityType.equalsIgnoreCase("U")){
				jifResponse.setUserField(responseFields[i].substring(2), returnValues.get(responseFields[i]).toString());
			}else{
				throw new JIFException("3333", "Please provide the proper Entity Type for Response Fields");
			}
		}
		return jifResponse;
	}



}
