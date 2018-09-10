package com.myplantation.engine;


import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
/**
 * 
 * @author Rajkumar Pandey
 * 
 */
public class ServiceDescriptorParser {

	static final String AUTH_FILE="/configs/service.xml";
	static final String NON_AUTH_FILE="/configs/noauth.xml";
	
	public static List<Map<String, String>> parseXML(String servicetype) 
	{
		ServiceHandler handler = new ServiceHandler();
		try 
		{
			String fname="noauth".equals(servicetype)?NON_AUTH_FILE:AUTH_FILE;
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			InputStream data = ServiceDescriptorParser.class.getResourceAsStream(fname);
			parser.parse(data, handler);
		} 
		catch (java.lang.IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return handler.getServiceList();
	}
}

