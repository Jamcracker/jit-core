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
 * @ClassName com.jamcracker.jif.dataobject.SuccessResponse
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/
package com.jamcracker.jif.dataobject;

import java.util.HashMap;
import java.util.Map;

import com.jamcracker.jif.common.JIFConstants;

/**
 * @author ppnair
 *
 */
public class SuccessResponse extends JIFResponse {
	String htmlForSSO;
	String urlForSSO;
	
	Map<String,Entity> fields = new HashMap<String,Entity>();

	/**
	 * 
	 */
	public SuccessResponse() {
		this("SUCCESS");
	}

	/**
	 * @param faultCode
	 * @param faultString
	 */
	public SuccessResponse(String successString) {
		super(JIFConstants.SUCCESS_CODE,successString);
		fields.put("service", new Entity());
		fields.put("company", new Entity());
		fields.put("user", new Entity());
	}
	/**
	 * Set the company field in the response for updating in JSDN
	 *  
	 * @param name name of the company field
	 * @param value value of the company field
	 */
	public void setCompanyField(String name, String value){
		((Entity)fields.get("company")).addField(name, value);
	}

	/**
	 * Set the user field in the response for updating in JSDN
	 *  
	 * @param name name of the company field
	 * @param value value of the company field
	 */
	public void setUserField(String name, String value){
		((Entity)fields.get("user")).addField(name, value);
	}

	/**
	 * @param name
	 * @return
	 */
	public String getCompanyField(String name){
		return ((Entity)fields.get("company")).getField(name);
	}

	/**
	 * @param name
	 * @return
	 */
	public String getUserField(String name){
		return ((Entity)fields.get("user")).getField(name);
	}
	
	public Map<String,String> getCompanyFields(){
		return ((Entity)fields.get("company")).getFields();
	}

	/**
	 * @return
	 */
	public Map<String,String> getUserFields(){
		return ((Entity)fields.get("user")).getFields();
	}


	public String getHtmlForSSO() {
		return htmlForSSO;
	}

	public void setHtmlForSSO(String htmlForSSO) {
		this.htmlForSSO = htmlForSSO;
	}

	/**
	 * @return the urlForSSO
	 */
	public String getUrlForSSO() {
		return urlForSSO;
	}

	/**
	 * @param urlForSSO the urlForSSO to set
	 */
	public void setUrlForSSO(String urlForSSO) {
		this.urlForSSO = urlForSSO;
	}
}
