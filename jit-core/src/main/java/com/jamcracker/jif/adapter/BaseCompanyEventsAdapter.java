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
