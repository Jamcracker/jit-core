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
package com.jamcracker.jif.adapter;

import com.jamcracker.jif.dataobject.AuthInfo;
import com.jamcracker.jif.exception.AuthenticationException;

/**
 * @author ppnair
 *
 */
public interface Authentication {
	/**
	 * This method is called prior to any method. This method should be implemented for authenticating the request
	 * by checking for the Authentication credentials 
	 * 
	 * This corresponds to the following in Request XML
	 * 
	 * 	<header>
	 *		<authinfo>
	 *			<username>authuser</username>
	 *			<password>authpassword</password>
	 *		</authinfo>
	 *	</header>
	 *  
	 * @param authInfo Object containing the Authentication info
	 * @throws Exception if authentication information are wrong
	 */
	void authenticate(AuthInfo authInfo) throws AuthenticationException;	
}
