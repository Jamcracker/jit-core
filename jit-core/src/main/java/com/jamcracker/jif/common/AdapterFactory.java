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
