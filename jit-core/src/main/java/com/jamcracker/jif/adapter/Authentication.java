/**
 * 
 */
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
