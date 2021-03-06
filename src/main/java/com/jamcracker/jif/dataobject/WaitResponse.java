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
 * @ClassName com.jamcracker.jif.dataobject.WaitResponse
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/

package com.jamcracker.jif.dataobject;

import com.jamcracker.jif.common.JIFConstants;
/**
 * This class corresponds to success and wait response of an operation. If the integration operation is success, send this response which will 
 * generate a success response XML as below
 * &lt;?xml&nbsp;version="1.0"&nbsp;encoding="UTF-8"?&gt;<br>
 *&nbsp;&lt;jcprovisionmessage&gt;<br>
 *&nbsp;&nbsp;&nbsp;&lt;body&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;response&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;command&nbsp;type="${eventType}"&nbsp;name="${eventName}"&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;entityresponse&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultcode&gt;0&lt;/faultcode&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultstring&gt;WAIT&lt;/faultstring&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/entityresponse&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/command&gt;<br>
 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/response&gt;<br>
 *&nbsp;&nbsp;&nbsp;&lt;/body&gt;<br>
 *&nbsp;&lt;/jcprovisionmessage&gt;
 * 
 * @author ppnair
 *
 */
public class WaitResponse extends SuccessResponse {

	/**
	 * generate a success WAIT response XML as below<br>
	 * &lt;?xml&nbsp;version="1.0"&nbsp;encoding="UTF-8"?&gt;<br>
	 *&nbsp;&lt;jcprovisionmessage&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&lt;body&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;response&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;command&nbsp;type="${eventType}"&nbsp;name="${eventName}"&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;entityresponse&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultcode&gt;0&lt;/faultcode&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;faultstring&gt;WAIT&lt;/faultstring&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/entityresponse&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/command&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/response&gt;<br>
	 *&nbsp;&nbsp;&nbsp;&lt;/body&gt;<br>
	 *&nbsp;&lt;/jcprovisionmessage&gt;
	 */
	public WaitResponse() {
		super(JIFConstants.WAIT);
	}

}
