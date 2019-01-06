package read;

import java.io.File;
import java.util.ArrayList;

import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import common.Read;

public class XMLReader extends FileReader implements Read{

	public XMLReader(){}

	@Override
	// return normalized tree document if successful, else return null
	public Document readFile(File subject) {
		try {
			//File f = new File(subject);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(subject);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (Exception e) {
			System.out.println(e.getMessage()); // TODO do something with message don't print to console
			return null;
		}
	}
}
