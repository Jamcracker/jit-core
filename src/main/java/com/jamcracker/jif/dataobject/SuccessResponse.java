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
 * This class corresponds to success response of an operation. If the integration operation is success, send this response which will 
 * generate a success response XML as below<br>
 * &lt;?xml&nbsp;version="1.0"&nbsp;encoding="UTF-8"?&gt;<br>
 *&nbsp;&lt;jcprovisionmessage&gt;<br>
 *&nbsp;&nbsp;&nbsp;&lt;body&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;response&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;command&nbsp;type="${eventType}"&nbsp;name="${eventName}"&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;entityresponse&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultcode&gt;0&lt;/faultcode&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultstring&gt;SUCCESS&lt;/faultstring&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/entityresponse&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/command&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/response&gt;<br>
 *&nbsp;&nbsp;&nbsp;&lt;/body&gt;<br>
 *&nbsp;&lt;/jcprovisionmessage&gt;
 * 
 * @author ppnair
 *
 */
public class SuccessResponse extends JIFResponse {
	String htmlForSSO;
	String urlForSSO;
	
	Map<String,Entity> fields = new HashMap<String,Entity>();

	/**
	 * This corresponds to the success response to JSDN. If the integration operation is success, send this response;
	 * generate a success response XML as below<br>
	 * &lt;?xml&nbsp;version="1.0"&nbsp;encoding="UTF-8"?&gt;<br>
	 *&nbsp;&lt;jcprovisionmessage&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&lt;body&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;response&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;command&nbsp;type="${eventType}"&nbsp;name="${eventName}"&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;entityresponse&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultcode&gt;0&lt;/faultcode&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultstring&gt;SUCCESS&lt;/faultstring&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/entityresponse&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/command&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/response&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&lt;/body&gt;<br>
	 *&nbsp;&lt;/jcprovisionmessage&gt;

	 */
	public SuccessResponse() {
		this("SUCCESS");
	}


	/**
	 * Use this constructor if you want to send another string as the success message. Recommended to use the no argument constructor.
	 * @param successString
	 */
	public SuccessResponse(String successString) {
		super(JIFConstants.SUCCESS_CODE,successString);
		fields.put("service", new Entity());
		fields.put("company", new Entity());
		fields.put("user", new Entity());
	}
	/**
	 * Set the company field in the response for updating in JSDN. This creates the following section in the response XML
	 * <br>
	 * &lt;entitydata entitytype="company"&gt;<br>
	 * &nbsp;&nbsp;&lt;datafield datatype="string"&gt;<br>
	 * &nbsp;&nbsp;&nbsp; &lt;name&gt;name&lt;/name&gt;<br>
	 * &nbsp;&nbsp;&nbsp;    &lt;value&gt;value&lt;/value&gt;<br>
	 * &nbsp;&nbsp;  &lt;/datafield&gt;<br>
	 * &lt;/entitydata&gt;<br>
	 *  
	 * @param name name of the company field in JSDN
	 * @param value value of the company field to be update in JSDN
	 */
	public void setCompanyField(String name, String value){
		((Entity)fields.get("company")).addField(name, value);
	}

	/**
	 * Set the user field in the response for updating in JSDN. This creates the following section in the response XML
	 * <br>
	 * &lt;entitydata entitytype="user"&gt;<br>
	 * &nbsp;&nbsp;&lt;datafield datatype="string"&gt;<br>
	 * &nbsp;&nbsp;&nbsp; &lt;name&gt;name&lt;/name&gt;<br>
	 * &nbsp;&nbsp;&nbsp;    &lt;value&gt;value&lt;/value&gt;<br>
	 * &nbsp;&nbsp;  &lt;/datafield&gt;<br>
	 * &lt;/entitydata&gt;<br>
	 *  
	 *  
	 * @param name name of the company field in JSDN
	 * @param value value of the company field to be updated in JSDN
	 */
	public void setUserField(String name, String value){
		((Entity)fields.get("user")).addField(name, value);
	}


	/**
	 * Returns the Company field set
	 * @param name
	 * @return
	 */
	public String getCompanyField(String name){
		return ((Entity)fields.get("company")).getField(name);
	}


	/**
	 * Returns the User field set
	 * @param name
	 * @return
	 */
	public String getUserField(String name){
		return ((Entity)fields.get("user")).getField(name);
	}
	
	/**
	 * Return all Company fields
	 * @return
	 */
	public Map<String,String> getCompanyFields(){
		return ((Entity)fields.get("company")).getFields();
	}

	/**
	 * Return all user fields
	 * @return
	 */
	public Map<String,String> getUserFields(){
		return ((Entity)fields.get("user")).getFields();
	}


	public String getHtmlForSSO() {
		return htmlForSSO;
	}

	/**
	 * This method sets the SSO HTML in the response XML as below
	 * &lt;entitydata&nbsp;entitytype="sso"&gt;<br>
	 * &nbsp;&nbsp;&lt;datafield&nbsp;datatype="string"&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;name&gt;ssocontent&lt;/name&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;value&gt;&lt;![CDATA[html]]&gt;&lt;/value&gt;<br>
	 * &nbsp;&nbsp;&lt;/datafield&gt;<br>
	 * &lt;/entitydata&gt;<br>
	 * 
	 * @param htmlForSSO
	 */
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
	 * This method sets the SSO URL in the response XML as below
	 * &lt;entitydata&nbsp;entitytype="sso"&gt;<br>
	 * &nbsp;&nbsp;&lt;datafield&nbsp;datatype="string"&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;name&gt;ssoURL&lt;/name&gt;<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;value&gt;&lt;![CDATA[http://sso.xyz.com/DAFAD23432SDE]]&gt;&lt;/value&gt;<br>
	 * &nbsp;&nbsp;&lt;/datafield&gt;<br>
	 * &lt;/entitydata&gt;<br>
	 * @param urlForSSO the urlForSSO t
	 */
	public void setUrlForSSO(String urlForSSO) {
		this.urlForSSO = urlForSSO;
	}
}
