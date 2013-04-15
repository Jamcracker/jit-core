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
 * @ClassName com.jamcracker.jif.adapter.BaseCompanyEventsAdapter
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

public class BaseCompanyEventsAdapter implements IJIFAdapter {
	public JIFResponse processRequest(JIFRequest jifRequest) throws JIFException{
		JIFResponse jifResponse = null;
		
		if(jifRequest.getEntityType().equals(JIFConstants.ENTITY_COMPANY)){
			if(jifRequest.getEventName().equals(JIFConstants.EVENT_CREATE)){
				jifResponse = createCompany(jifRequest);
			}else if(jifRequest.getEventName().equals(JIFConstants.EVENT_UPDATE)){
				jifResponse = updateCompany(jifRequest);
			}else if(jifRequest.getEventName().equals(JIFConstants.EVENT_DELETE)){
				jifResponse = deleteCompany(jifRequest);
			}
		}
		return jifResponse;
	}
	public JIFResponse createCompany(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Create Company");
	}

	public JIFResponse updateCompany(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Update Company");
	}

	public JIFResponse deleteCompany(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Delete Company");
	}
}
