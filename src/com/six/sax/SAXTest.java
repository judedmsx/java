package com.six.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest {
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
//		MyHandler handler = ;
		parser.parse("E:\\workspaces\\java\\src\\com\\six\\sax\\books.xml", new MyHandler());
	}
	
	static class MyHandler extends DefaultHandler{

		@Override
		public void startDocument() throws SAXException {
			System.out.println("----------start document---------");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("---------- end  document---------");
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			System.out.println("startelement uri:{"+uri+"} localName:{"+localName+"} qName:{"+qName+"}");
			if("book".equals(qName)){
				System.out.println(attributes.getValue("id")+" "+attributes.getValue("type"));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			System.out.println("endelement  uri:{"+uri+"} localName:{"+localName+"} qName:{"+qName+"}");
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			String content = new String(ch, start, length);  
	        System.out.println("characters: " + content); 
		}
	}
}
