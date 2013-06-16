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
 * @ClassName com.jamcracker.jif.servlet.JSDNJIFServletUserEventsTest
 * @version 1.0
 * @author Prasad P Nair
 * @date 13-Dec-2012
 * @see
 *   
 /*************************************************************************/

package com.jamcracker.jif.servlet;
import static org.easymock.EasyMock.expect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;

import com.jamcracker.jif.common.JIFConstants;
import com.jamcracker.jif.util.JIFUtil;

/**
 * @author ppnair
 *
 */
public class JSDNJIFServletUserEventsTest {
	private static IMocksControl mocks;
	private static JSDNJIFServlet servlet;

	@BeforeClass
	public static void setUpBeforeClass() {
	    mocks = EasyMock.createControl();
	    servlet = new JSDNJIFServlet();
	}

	@After
	public void tearDown() {
	    mocks.reset();
	}
	
	/**
	 * Test method for {@link com.jamcracker.jif.servlet.JSDNJIFServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws Exception 
	 */
	@Test
	public void testCreateUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/request_createuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/response_createuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}

	@Test
	public void testUpdateUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/request_updateuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/response_updateuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}	

	@Test
	public void testDeleteUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/request_deleteuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/response_deleteuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}
	/**
	 * Test method for {@link com.jamcracker.jif.servlet.JSDNJIFServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws Exception 
	 */
	@Test
	public void testFailCreateUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/fail_request_createuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/fail_response_createuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}

	@Test
	public void testFailUpdateUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/fail_request_updateuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/fail_response_updateuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}	

	@Test
	public void testFailDeleteUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/fail_request_deleteuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/fail_response_deleteuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}

	/**
	 * Test method for {@link com.jamcracker.jif.servlet.JSDNJIFServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws Exception 
	 */
	@Test
	public void testWaitCreateUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/wait_request_createuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/wait_response_createuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}

	@Test
	public void testWaitUpdateUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/wait_request_updateuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/wait_response_updateuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}	

	@Test
	public void testWaitDeleteUser() throws Exception {
	    HttpServletRequest request = mocks.createMock(HttpServletRequest.class);
	    HttpServletResponse response = mocks.createMock(HttpServletResponse.class);
	    String xml = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/requests/wait_request_deleteuser.xml"));
	    expect(request.getParameter(JIFConstants.PARAM_NAME)).andReturn(xml);
	    ByteArrayOutputStream oStream = new ByteArrayOutputStream();
	    expect(response.getWriter()).andReturn((new PrintWriter(oStream)));
	    mocks.replay();
	    servlet.doPost(request, response);
	    mocks.verify();
	    String actual = readStream(oStream);
	    String expected = JIFUtil.readXMLFromFile(JSDNJIFServletUserEventsTest.class.getResourceAsStream("/xmls/responses/wait_response_deleteuser.xml"));
	    Assert.assertEquals(stripWhiteSpace(expected.trim()),stripWhiteSpace(actual.trim()));
	    mocks.reset();
	}
	
	
	public static String readStream(ByteArrayOutputStream os) throws Exception {
    	String out = new String(os.toByteArray(), "UTF-8");
    	return out;
    }
    
    public static Document getXMLDocument(String xml) throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
    	return doc;
    }
    
    public String stripWhiteSpace(String xml){
    	xml = xml.replaceAll(">[ \r\t\n]*<", "><");
    	return xml;
    }
    
	
}
