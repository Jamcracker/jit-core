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
 * @ClassName com.jamcracker.jif.adapter.BaseUserEventsAdapter
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/
package com.jamcracker.jif.adapter;

import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.exception.JIFException;

public class BaseUserEventsAdapter implements IJIFAdapter {

	/* 
	 * This method process the JIFRequest and delegate to the corresponding method for action.
	 * (non-Javadoc)
	 * @see com.jamcracker.jif.adapter.IJIFAdapter#processRequest(com.jamcracker.jif.dataobject.JIFRequest)
	 */
	public JIFResponse processRequest(JIFRequest jifRequest) throws JIFException {
		JIFResponse jifResponse = null;
		
		if(jifRequest.getEntityType().equals(JIFConstants.ENTITY_USER)){
			if(jifRequest.getEventName().equals(JIFConstants.EVENT_CREATE)){
				jifResponse = createUser(jifRequest);
			}else if(jifRequest.getEventName().equals(JIFConstants.EVENT_UPDATE)){
				jifResponse = updateUser(jifRequest);
			}else if(jifRequest.getEventName().equals(JIFConstants.EVENT_DELETE)){
				jifResponse = deleteUser(jifRequest);
			}else if(jifRequest.getEventName().equals(JIFConstants.EVENT_SSO)){
				jifResponse = getHTMLForSSO(jifRequest);
			}
		}
		return jifResponse;
	}
	/**
	 * This method corresponds to the create user event. Subclasses should override this method to implement the 
	 * create user in the target application
	 * 
	 * @param jifRequest
	 * @return
	 * @throws JIFException
	 */
	public JIFResponse createUser(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Create User Not implemented");
	}

	/**
	 * This method corresponds to the update user event. Subclasses should override this method to implement the 
	 * update user in the target application
	 * @param jifRequest
	 * @return
	 * @throws JIFException
	 */
	public JIFResponse updateUser(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Update User Not implemented");
	}

	/**
	 * This method corresponds to the delete user event. Subclasses should override this method to implement the 
	 * delete user in the target application
	 * @param jifRequest
	 * @return
	 * @throws JIFException
	 */
	public JIFResponse deleteUser(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Delete User Not implemented");
	}

	public JIFResponse getHTMLForSSO(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("User SSO Not implemented");
	}
	
}
