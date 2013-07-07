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
 * @ClassName com.jamcracker.jif.common.JIFConstants
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/
package com.jamcracker.jif.common;

public interface JIFConstants {

	String SUCCESS_CODE = "0";
	String FIELD_COMPANY_ACRONYM = "companyAcronym";
	String FIELD_COMPANY_NAME = "companyName";
	String FIELD_FIRSTNAME = "firstName";
	String FIELD_LASTNAME = "lastName";
	String FIELD_EMAIL = "email";
	String FIELD_CONTACT_PHONE = "contactPhone";
	String FIELD_LOGINNAME = "loginName";
	String FIELD_PASSWORD = "password";
	
	String EVENT_CREATE = "create";
	String EVENT_UPDATE = "update";
	String EVENT_DELETE = "delete";
	String EVENT_SSO = "sso";
	
	String ENTITY_SERVICE = "service";
	String ENTITY_COMPANY = "company";
	String ENTITY_USER = "user";
	String RESPONSE  = "_Response";
	
	String PARAM_NAME = "request";
	String PROPERTY_FILE_NAME = "propertyFileName";
	String WAIT = "WAIT";
	String VALIDATION_EXCEPTION_PREFIX = "VAL_";
	String SYSTEM_EXCEPTION_PREFIX = "SYS_";
}
