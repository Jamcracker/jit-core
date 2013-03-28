/**
 * 
 */
package com.jamcracker.jif.exception;

/**
 * @author ppnair
 *
 */
public class JIFException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String faultCode;
	String faultString;
	public JIFException(String faultCode, String faultString) {
		super(faultString);
		this.faultCode = faultCode;
		this.faultString = faultString;
	}
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	public String getFaultString() {
		return faultString;
	}
	public void setFaultString(String faultString) {
		this.faultString = faultString;
	}
	
}
