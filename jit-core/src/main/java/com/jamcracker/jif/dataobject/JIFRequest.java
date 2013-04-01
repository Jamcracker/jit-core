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
 * @ClassName com.jamcracker.jif.dataobject.JIFRequest
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/
package com.jamcracker.jif.dataobject;

import java.util.HashMap;
import java.util.Map;

import com.jamcracker.jif.common.JIFConstants;

/**
 * This class is the Object form of the request XML that is received from JSDN.
 * The values are populated by the Digester. The implementors usually don't have to modify this class.
 * 
 * 
 * entityType 
 * 	user - For user events
 * 	company - For Company events
 * 
 * eventName
 * 	create - For create event
 *  update - For update event
 *  delete - For delete event
 *  
 *  The values of these decides what event is triggered
 *  
 * @author ppnair
 *
 */
public class JIFRequest {
	Map<String,Entity> fields = new HashMap<String,Entity>();
	String entityType;
	String eventName;
	AuthInfo authInfo;
	
	/**
	 * @return
	 * 
	 * returns  the fields which contains All data of RequestXML
	 */
	public Map<String,Entity> getFields() {
		return fields;
	}
	/**
	 * @return
	 * 
	 * returns  the AuthInfo which contains AuthenticationInfo in RequestXML
	 */
	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	/**
	 * @param authInfo
	 */
	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

	/**
	 * @param datafield
	 */
	public void addEntity(Entity entity){
		fields.put(entity.getType(), entity);
	}
	
	/**
	 * @param name
	 * @return
	 */
	public String getServiceField(String name){
		Entity entity = (Entity)fields.get(JIFConstants.ENTITY_SERVICE);
		if(entity != null){
			return entity.getField(name);
		}
		return null;
	}
	
	/**
	 * @param name,value
	 * @return
	 */
	public void setServiceField(String name,String value){
		Entity entity = (Entity)fields.get(JIFConstants.ENTITY_SERVICE);
		if(entity != null){
			entity.addField(name, value);
		}
	}
	
	/**
	 * @param name
	 * @return
	 */
	public String getCompanyField(String name){
		Entity entity = (Entity)fields.get(JIFConstants.ENTITY_COMPANY);
		if(entity != null){
			return entity.getField(name);
		}
		return null;
	}
	
	/**
	 * @param name,value
	 * @return
	 */
	public void setCompanyField(String name,String value){
		Entity entity = (Entity)fields.get(JIFConstants.ENTITY_COMPANY);
		if(entity != null){
			entity.addField(name, value);
		}
	}

	/**
	 * @param name
	 * @return
	 */
	public String getUserField(String name){
		Entity entity = (Entity)fields.get(JIFConstants.ENTITY_USER);
		if(entity != null){
			return entity.getField(name);
		}
		return null;
	}
	
	/**
	 * @param name,value
	 * @return
	 */
	public void setUserField(String name,String value){
		Entity entity = (Entity)fields.get(JIFConstants.ENTITY_USER);
		if(entity != null){
			entity.addField(name, value);
		}
	}


	/**
	 * entityType 
	 * 	user - For user events
	 * 	company - For Company events
	 * 
	 * @return
	 */
	public String getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType
	 * entityType 
	 * 	user - For user events
	 * 	company - For Company events
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	/**
	 * eventName
	 * 	create - For create event
	 *  update - For update event
	 *  delete - For delete event
	 *  
	 * @return
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param name
	 * eventName
	 * 	create - For create event
	 *  update - For update event
	 *  delete - For delete event
	 */
	public void setEventName(String name) {
		this.eventName = name;
	}
}
