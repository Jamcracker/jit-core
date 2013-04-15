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
 * @ClassName com.jamcracker.jif.common.AdapterFactory
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/
package com.jamcracker.jif.common;

import com.jamcracker.jif.adapter.Authentication;
import com.jamcracker.jif.adapter.IJIFAdapter;
import com.jamcracker.jif.util.PropertyReader;

/**
 * Factory class for Adapter Implementation classes
 * @author ppnair
 *
 */
public class AdapterFactory {
	public static IJIFAdapter getAdapterImpl(String type) throws Exception{
		String className = PropertyReader.getInstance("/adapter.properties").getProperty("adapter."+type);
		return (IJIFAdapter) Class.forName(className).newInstance();
	}
	
	public static Authentication getAuthenticationModule() throws Exception{
		String className = PropertyReader.getInstance("/adapter.properties").getProperty("adapter.authentication");
		return (Authentication) Class.forName(className).newInstance();
	}
}
