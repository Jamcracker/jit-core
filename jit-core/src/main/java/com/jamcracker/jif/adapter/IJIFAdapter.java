package com.jamcracker.jif.adapter;

import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.exception.JIFException;

/**
 * 
 * @author ppnair
 *
 */
public interface IJIFAdapter {
	
	JIFResponse processRequest(JIFRequest jifRequest) throws JIFException;

}
