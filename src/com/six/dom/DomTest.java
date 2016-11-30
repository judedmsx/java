package com.six.dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {
	public static void main(String[] args) throws Exception {
		demo2();
	}
	
	public static void demo1() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("E:\\workspaces\\java\\src\\com\\six\\dom\\books.xml");
		
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getChildNodes();
		for(int i = 0;i < nodeList.getLength();i++){
			Node books = nodeList.item(i);
//			System.out.println("1-level  nodename{"+books.getNodeName()+"} nodetype{"+books.getNodeType()+"} nodevalue{"+books.getNodeValue()+"}");
			
			for(Node node = books.getFirstChild();node!=null;node=node.getNextSibling()){
				if(node.getNodeType() == 3){
					System.out.println(node.getNodeValue().equals(node.getTextContent()));
//					System.out.println("2-level  nodename{"+node.getNodeName()+"} nodetype{"+node.getNodeType()+"} nodevalue{"+node.getNodeValue()+"} "+node.getTextContent());	
				}
				
			}
		}
	}
	
	public static void demo2() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("E:\\workspaces\\java\\src\\com\\six\\dom\\products.xml");
		Element root = document.getDocumentElement();
		
		Element project = document.createElement("project");
		project.setAttribute("id", "1");
		
		Element author = document.createElement("author");
		author.setTextContent("maosixi");
		project.appendChild(author);
		root.appendChild(project);
		output(root,"E:\\workspaces\\java\\src\\com\\six\\dom\\products.xml");
	}
	
	public static void output(Node node,String filename) throws FileNotFoundException, TransformerException{
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer former = transFactory.newTransformer();
		former.setOutputProperty("encoding", "UTF-8");
		DOMSource source = new DOMSource();
		source.setNode(node);
		StreamResult result = new StreamResult();
		if(filename == null)
			result.setOutputStream(System.out);
		else
			result.setOutputStream(new FileOutputStream(filename));
		
		former.transform(source, result);
	}
}
