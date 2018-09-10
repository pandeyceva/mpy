package com.myplantation.engine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 
 * @author Rajkumar Pandey
 * 
 */
public class ServiceHandler extends DefaultHandler {
	List<Map<String, String>> services = null;
	Map<String, String> hashMap= null;
	String value="";
	String key="";

	public List<Map<String, String>> getServiceList()
	{
		return services;
	}

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes)
					throws SAXException {
		if("service".equals(qName))
		{
			services = new ArrayList<>();
		}
		if("service-info".equals(qName))
		{
			hashMap= new HashMap<String, String>();
		}
	}

	@Override
	public void endElement(String uri, String localName,
			String qName) throws SAXException {

		if(!"service".equals(qName))
		{
			if(!"service-info".equals(qName))
			{
				hashMap.put( qName,key);
			}
			else
			{
				services.add(hashMap);
			}

		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		key=new String(ch, start, length);


	}
}

