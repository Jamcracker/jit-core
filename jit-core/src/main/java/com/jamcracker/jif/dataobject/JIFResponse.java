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
 * @ClassName com.jamcracker.wsutil.HttpClient
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/
package com.jamcracker.jif.dataobject;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the Object form of the response XML that is send back to JSDN.
 * The values are populated by the implementers
 * 
 * entityType and eventName should be same as of the request to which the response is for. This is populated by the delegater method
 * @author ppnair
 *
 */
public class JIFResponse {
	String faultCode;
	String faultString;
	String entityType;
	String eventName;
	String htmlForSSO;
	
	Map<String,Entity> fields = new HashMap<String,Entity>();
	
	/**
	 * This is the no argument constructor for the JIFRequest
	 * 
	 */
	public JIFResponse(){
		fields.put("service", new Entity());
		fields.put("company", new Entity());
		fields.put("user", new Entity());
	}

	/**
	 * @param faultCode
	 * @param faultString
	 */
	public JIFResponse(String faultCode, String faultString){
		fields.put("service", new Entity());
		fields.put("company", new Entity());
		fields.put("user", new Entity());
		this.faultCode = faultCode;
		this.faultString = faultString;
	}
	
	/**
	 * @return the faultcode 
	 * SUCCESS = 0
	 * FAILURE = non-zero number
	 */
	public String getFaultCode() {
		return faultCode;
	}
	/**
	 * @param faultCode set the faultcode
	 * SUCCESS = 0
	 * FAILURE = non-zero number
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	/**
	 * @return faultstring
	 */
	public String getFaultString() {
		return faultString;
	}
	/**
	 * @param faultString
	 */
	public void setFaultString(String faultString) {
		this.faultString = faultString;
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

	/**
	 * @return
	 */
	public String getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	/**
	 * @return
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getHtmlForSSO() {
		return htmlForSSO;
	}

	public void setHtmlForSSO(String htmlForSSO) {
		this.htmlForSSO = htmlForSSO;
	}
	
}
