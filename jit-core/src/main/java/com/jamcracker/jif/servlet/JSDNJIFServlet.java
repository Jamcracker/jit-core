package com.jamcracker.jif.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jamcracker.jif.adapter.IJIFAdapter;
import com.jamcracker.jif.common.AdapterFactory;
import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.dataobject.JIFRequest;
import com.jamcracker.jif.dataobject.JIFResponse;
import com.jamcracker.jif.exception.AuthenticationException;
import com.jamcracker.jif.util.JIFUtil;


/**
 * This Class is the template for writing a web interface adapter
 * which receives the JIF requests from JSDN marketplace.
 * 
 * The doPost() method authenticate and process the RequestXML from JSDN, create an JIFRequest object
 * and delegate it to the corresponding methods in {@link IJIFAdapter}
 * 
 * The following methods need to be implemented to integrate with your application
 *  <br>
 *  authenticate()<br>
 *  createCompany()<br>
 *  updateCompany()<br>
 *  deleteCompany()<br>
 *  createUser()<br>
 *  updateUser()<br>
 *  deleteUser()<br>
 *  
 *
 */
public class JSDNJIFServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(JSDNJIFServlet.class);

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		LOG.debug("START:<<doPost>>");
		JIFResponse jifResponse = null;
		JIFRequest jifRequest = null;
		IJIFAdapter adapter = null;
		PrintWriter out = response.getWriter();
		String xmlMessage=(String)request.getParameter(JIFConstants.PARAM_NAME);
			try{
				if(xmlMessage==null || xmlMessage.trim().length()==0){
					jifResponse = new JIFResponse();
					jifResponse.setFaultCode("899");
					jifResponse.setFaultString("XML not found in REQUEST field.");
					jifResponse.setEntityType(jifRequest.getEntityType());
					jifResponse.setEventName(jifRequest.getEventName());
					String responseMessage =	JIFUtil.createResponseXML(jifResponse);
					out.println(responseMessage);
					out.flush();
					return;
				}else{
					try{
						jifRequest = JIFUtil.processRequest(xmlMessage);
						adapter = AdapterFactory.getAdapterImpl(jifRequest.getEntityType());
						AdapterFactory.getAuthenticationModule().authenticate(jifRequest.getAuthInfo());
					}catch(AuthenticationException e){
						jifResponse = new JIFResponse(e.getFaultCode(),e.getFaultString());	
						jifResponse.setEntityType(jifRequest.getEntityType());
						jifResponse.setEventName(jifRequest.getEventName());
						String responseMessage =	JIFUtil.createResponseXML(jifResponse);
						out.println(responseMessage);
						out.flush();
						return;
					}
					jifResponse = adapter.processRequest(jifRequest);
				}
			}catch(Exception exec){
				if(jifResponse == null){
					jifResponse = new JIFResponse();
				}
				jifResponse.setFaultCode("12345");
				jifResponse.setFaultString(exec.getMessage());
			}
			jifResponse.setEntityType(jifRequest.getEntityType());
			jifResponse.setEventName(jifRequest.getEventName());
			String responseMessage =	JIFUtil.createResponseXML(jifResponse);
			out.println(responseMessage);
			out.flush();
			return;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	
}
