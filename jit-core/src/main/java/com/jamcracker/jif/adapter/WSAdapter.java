/*
 * Class: WSAdapter.java
 *

 *
 * Version History:
 * 
 * Ver  	Date         		     Who           			   Release     What and Why
 * ---  	----------  	   	    ---------      			  -------     ---------------------------------------
 * 1.0 		27-Mar-2013            		ppnair           1.0		 Initial version
 * 
 * This software is the confidential and proprietary information of Jamcracker, Inc. 
 * ("Confidential Information").  You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement you 
 *  entered into with Jamcracker, Inc. Copyright (c) 2000 Jamcracker, Inc.  All Rights    
 *  Reserved
 *
 *
 * 
 ******************************************************/
package com.jamcracker.jif.adapter;

import java.util.Map;

import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.exception.JIFException;
import com.jamcracker.jif.util.PropertyReader;
import com.jamcracker.jif.util.WSHelper;

public class WSAdapter implements IJIFAdapter{
	
	private PropertyReader propertyReader = PropertyReader.getInstance("/adapter.properties");
	/**
	 * This Class is using for posting the soap Request with the Help of JCwsutil.
	 * 
	 * 
	 * The following methods need to be implemented to integrate with your application
	 *
	 */
	public JIFResponse processRequest(JIFRequest jifRequest)throws JIFException {
		preProcessRequest(jifRequest);
		String[] responseFields = getResponseFields(propertyReader.getProperty(jifRequest.getEventName()+jifRequest.getEntityType()+JIFConstants.RESPONSE));
		JIFResponse jifResponse = WSHelper.processRequests(jifRequest,propertyReader.getProperty(jifRequest.getEntityType()+"."+jifRequest.getEventName()),responseFields,propertyReader.getProperty("processFile"));
		postProcess(jifResponse);
		return jifResponse;
	}

	protected Map<String, String> preProcessRequest(JIFRequest jifRequest)throws JIFException {
		// TODO Auto-generated method stub
		return null;
	}


	protected void postProcess(JIFResponse jifResponse) throws JIFException {
		// TODO Auto-generated method stub
		
	}

	
	
	private String[] getResponseFields(String responseFields) throws JIFException {
		// TODO Auto-generated method stub
		if(responseFields != null && responseFields.trim().length() > 0){
			String responseFieldNames[] = responseFields.split(",");
			return responseFieldNames;
		}else{
			return new String[0];
		}
	}
	
}
