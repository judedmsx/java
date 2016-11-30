package com.six.xpath;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathTest {
	public static void main(String[] args) throws Exception {
		demo1();
	}
	
	public static void demo() throws Exception {
		File file = new File("E:\\workspaces\\java\\src\\com\\six\\xpath\\books.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);
		doc.getDocumentElement().normalize();

		XPath xPath = XPathFactory.newInstance().newXPath();
		String exp = "/class/student";
		NodeList nodeList = (NodeList) xPath.compile(exp).evaluate(doc,
				XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Student roll no : "
						+ eElement.getAttribute("rollno"));
				System.out.println("First Name : "
						+ eElement.getElementsByTagName("firstname").item(0)
								.getTextContent());
				System.out.println("Last Name : "
						+ eElement.getElementsByTagName("lastname").item(0)
								.getTextContent());
				System.out.println("Nick Name : "
						+ eElement.getElementsByTagName("nickname").item(0)
								.getTextContent());
				System.out.println("Marks : "
						+ eElement.getElementsByTagName("marks").item(0)
								.getTextContent());
			}
		}
	}
	
	public static void demo1() throws Exception {
		File inputFile = new File("E:\\workspaces\\java\\src\\com\\six\\xpath\\books.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		XPath xPath = XPathFactory.newInstance().newXPath();

		String expression = "/class/student[@rollno='493']";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc,
				XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Student roll no : "
						+ eElement.getAttribute("rollno"));
				System.out.println("First Name : "
						+ eElement.getElementsByTagName("firstname").item(0)
								.getTextContent());
				System.out.println("Last Name : "
						+ eElement.getElementsByTagName("lastname").item(0)
								.getTextContent());
				System.out.println("Nick Name : "
						+ eElement.getElementsByTagName("nickname").item(0)
								.getTextContent());
				System.out.println("Marks : "
						+ eElement.getElementsByTagName("marks").item(0)
								.getTextContent());
			}
		}
	}
}
