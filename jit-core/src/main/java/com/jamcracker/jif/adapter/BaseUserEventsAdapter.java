package com.jamcracker.jif.adapter;

import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.exception.JIFException;

public class BaseUserEventsAdapter implements IJIFAdapter {

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
	public JIFResponse createUser(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Create User");
	}

	public JIFResponse updateUser(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Update User");
	}

	public JIFResponse deleteUser(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("Delete User");
	}

	public JIFResponse getHTMLForSSO(JIFRequest jifRequest) throws JIFException{
		throw new UnsupportedOperationException("User SSO");
	}
	
}
