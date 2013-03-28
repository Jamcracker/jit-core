/***************************************************
 * 
 * This software is the confidential and proprietary information of Jamcracker, Inc. 
 * ("Confidential Information").  You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement you 
 *  entered into with Jamcracker, Inc. Copyright (c) 2000 Jamcracker, Inc.  All Rights    
 *  Reserved
 *
 * @ClassName PropertyReader
 * @version 1.0
 * @since Feb 2007
 * @author ppnair
 * @see
 *
 * 
 ******************************************************/
package com.jamcracker.jif.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;


/**
 * This Class is used to read a property from a property file. An instance/property file 
 * is created and cached for further use. If a property file is modified after it is loaded by the PropertyReader,
 * its reloaded on the call.
 * 
 *  
 * @author  ppnair
 */
public class PropertyReader {
	//to hold the property file name to be loaded by this instance
	private String propertyFile;
	private static final int HASH_MAP_INITIAL_CAPACITY = 100;
	// to hold the PropertyReader instances for each property file
	private static Hashtable<String,PropertyReader> propInstances = new Hashtable<String,PropertyReader>(HASH_MAP_INITIAL_CAPACITY);
	private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PropertyReader.class.getName());
	// to hold properties of the loaded property file
	private Properties properties = null;
	//This property specifies whether the loaded file is watchable or not. The file is considered as watchable if its loaded by absolute filepath than classpath
	private boolean watchable = false;
	private long lastModified = 0;

	/**
	 * Private constructor to ensure that the class is not instantiated by any other classes
	 * 
	 * @param pFile the property file to be loaded by this instance
	 * @throws Exception if file not found
	 */
	private PropertyReader(String pFile) throws Exception{
			propertyFile = pFile;
			loadProperty();
	}

	
	/**
	 * This method load all the properties from the file which is specified for the PropertyReader instance
	 * 
	 */
	private boolean loadProperty() {
		boolean flag = false;
		// Load the Property file
		InputStream fs = null;
		try {
			properties = new Properties();
			File file = new File(propertyFile);
			//See if the absolute path exists
			//If exists the loaded file is watchable. The file is considered as watchable if its loaded by absolute filepath than classpath
			if(file.exists()){
				fs = new FileInputStream(file);
				watchable = true;
				lastModified = file.lastModified();
			}else{
				fs  = PropertyReader.class.getResourceAsStream(propertyFile);
			}
			properties.load(fs);
			flag = true;
		} catch (FileNotFoundException e) {
			LOG.error("PropertyReader: Exception thrown is " + e.getMessage(),e);
		} catch (IOException e) {
			LOG.error("PropertyReader: Exception thrown is " + e.getMessage(),e);
		} finally{
			if(fs != null){
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					LOG.error(e.getMessage(),e);
				}
			}
		}
		return flag;
	}
	
	/**
	 * Load the property if its watchable and modified
	 * 
	 */
	private void loadPropertyIfModified(){
		//if not watchable, then return
		if(!watchable){
			return;
		}
		File file = new File(propertyFile);
		long modifiedTime = file.lastModified();
		if(modifiedTime > lastModified){
			LOG.info("\'"+ propertyFile + "\' Modified. Loading the modified file...");
			loadProperty();
		}
	}
	/**
	 * This methods returns the instance of PropertyReader associated with the propertyfile.
	 * If an instance is already loaded for the property file, it returns the instance from cache,
	 * else it creates an instance and returns it after caching the same
	 * 
	 * @param propertyFile the name of the property file with reference to PP_CONFIG home(/adaptor-name/adaptor.properties)
	 * @return PropertyReader loaded with the specified file
	 * @throws RuntimeException if file not found
	 */
	public static synchronized PropertyReader getInstance(String propertyFile) {
		PropertyReader instance = (PropertyReader)propInstances.get(propertyFile);
		if (instance == null) {
			LOG.debug("Instance not in cache. Creating the Instance...");
			try {
				instance = new PropertyReader(propertyFile);
				propInstances.put(propertyFile, instance);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		}
		return instance;
	}	
	
	/**
	 * This method returns the property value read from the 
	 * propertyfile of this PropertyReader instance. The method returns null
	 * if property not found in the file
	 * 
	 * @param propertyName property name
	 * @return property value;
	 */
	public String getProperty(String propertyName) {
		loadPropertyIfModified();
		String propertyValue = properties.getProperty(propertyName);

		if (propertyValue != null) {
			propertyValue = propertyValue.trim();
		}

		return propertyValue;
	}


}
