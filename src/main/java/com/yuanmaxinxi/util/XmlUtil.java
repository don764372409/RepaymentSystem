package com.yuanmaxinxi.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class XmlUtil {
	public static Map<String,String> xmlToMap1(String xmlStr){  
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance(); 
			//reader对象，从解析器得到reader 
			XMLReader reader = factory.newSAXParser().getXMLReader(); 
			MyHandler myHandler = new MyHandler();
			reader.setContentHandler(myHandler);
			reader.parse(new InputSource(new StringReader(xmlStr)));
			return myHandler.getMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
    }  
	public static Map<String,String> xmlToMap2(String xmlStr){  
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance(); 
			//reader对象，从解析器得到reader 
			XMLReader reader = factory.newSAXParser().getXMLReader(); 
			MyHandler2 myHandler = new MyHandler2();
			reader.setContentHandler(myHandler);
			reader.parse(new InputSource(new StringReader(xmlStr)));
			Map<String, String> map = myHandler.getMap();
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}  
}
class MyHandler extends DefaultHandler{
	private String tagName;
	private Map<String,String> map = new HashMap<>();
	
	public Map<String, String> getMap() {
		return map;
	}
	public void startElement(String namespaceURI, String localName
			,String qName, Attributes attr) throws SAXException{
		tagName = qName;
	}
	//namespaceURI命名空间,得到当前正在解析的标签的命名空间，用于区分标签；localname不带前缀，qname带前缀
	public void endElement(String namespaceURI, String localName,String qName)
			throws SAXException{
		tagName="";
	}
	public void characters(char[] ch,int start,int length)throws SAXException{
		if(tagName.equals("returnstatus"))
			map.put("returnstatus", new String(ch,start,length).trim());
		else if(tagName.equals("message"))
			map.put("message", new String(ch,start,length).trim());
		else if(tagName.equals("remainpoint"))
			map.put("remainpoint", new String(ch,start,length).trim());
		else if(tagName.equals("taskID"))
			map.put("taskID", new String(ch,start,length).trim());
		else if(tagName.equals("successCounts")){
			map.put("successCounts", new String(ch,start,length).trim());
		}
	}
}
class MyHandler2 extends DefaultHandler{
	private String tagName;
	private Map<String,String> map = new HashMap<>();
	
	public Map<String, String> getMap() {
		return map;
	}
	public void startElement(String namespaceURI, String localName
			,String qName, Attributes attr) throws SAXException{
		tagName = qName;
	}
	//namespaceURI命名空间,得到当前正在解析的标签的命名空间，用于区分标签；localname不带前缀，qname带前缀
	public void endElement(String namespaceURI, String localName,String qName)
			throws SAXException{
		tagName="";
	}
	public void characters(char[] ch,int start,int length)throws SAXException{
		if(tagName.equals("returnstatus"))
			map.put("returnstatus", new String(ch,start,length).trim());
		else if(tagName.equals("message"))
			map.put("message", new String(ch,start,length).trim());
		else if(tagName.equals("payinfo"))
			map.put("payinfo", new String(ch,start,length).trim());
		else if(tagName.equals("overage"))
			map.put("overage", new String(ch,start,length).trim());
		else if(tagName.equals("sendTotal")){
			map.put("sendTotal", new String(ch,start,length).trim());
		}
	}
}
