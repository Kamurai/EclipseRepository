package read;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import selection.Selector;
import selection.Selector.MismoVersion;
import selection.Selector.Product;
import selection.Selector.TestCase;

public class XmlToObject {
	public static void main(String[] args) {
		
		printAllNodes(Product.DU,MismoVersion.v231,TestCase.TC01);
		
		//XmlToObject interpreter = new XmlToObject();
		//interpreter.putDataIntoObj(Product.DU,MismoVersion.v231,TestCase.TC01);

		
	}
	public static void printAllNodes(Product vProduct, MismoVersion vMismoVersion, TestCase vTestCase) {
		String testCasePath = Selector.selectTestCase(vProduct, vMismoVersion, vTestCase);
		System.out.println(testCasePath);
		File testCaseFile = new File(testCasePath);
		XMLReader xmlreader = new XMLReader();
		Document doc = xmlreader.readFile(testCaseFile);
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		if (doc.hasChildNodes()) {
			printNode(doc.getChildNodes());
		}

//		try {
//			
//			
//			File file = new File(selectTestCase); 
//			
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			Document doc = dBuilder.parse(file);
//			
//			doc.getDocumentElement().normalize();
//			
//			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//			if (doc.hasChildNodes()) {
//				printNode(doc.getChildNodes());
//			}
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
	}
	
	public static void printNode(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());

				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					
					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());

					}
				}

				if (tempNode.hasChildNodes()) {

					// loop again if has child nodes
					printNode(tempNode.getChildNodes());
				}
				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
			}
		}
	}
	public boolean putDataIntoObj(Product vProduct, MismoVersion vMismoVersion, TestCase vTestCase) {
		try {
			String selectTestCase = Selector.selectTestCase(vProduct, vMismoVersion, vTestCase);
			File file = new File(selectTestCase);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
		    /*parser.parse(file);
		    Document doc = parser.getDocument();*/
		 
		    // Get the document's root XML node
		    NodeList root = doc.getChildNodes();
		 
		    // Navigate down the hierarchy to get to the Transmittal Data node
		    Node LoaApp = getNode("LOAN_APPLICATION", root);
		    
		    Node DatInf = getNode("_DATA_INFORMATION", LoaApp.getChildNodes() );
		    //Node DatVer = getNode("DATA_VERSION", DatInf.getChildNodes() );
		    for (int i = 0; i < DatInf.getChildNodes().getLength(); i++) {
		    	Node n = DatInf.getChildNodes().item(i);
		    	if (n.getNodeType() == Node.ELEMENT_NODE) {
		    		Element e = (Element) n;
		    		System.out.println(e.getAttribute("_Name"));
		    	}
		    }
		    
		    NodeList TraDatList = doc.getElementsByTagName("TRANSMITTAL_DATA");
		    System.out.println(getNodeAttr("InvestorLoanIdentifier", TraDatList.item(0)).isEmpty());
		    
		    NodeList AssetList = doc.getElementsByTagName("ASSET");
		    System.out.println(getNodeAttr("_AccountIdentifier", AssetList.item(0)).isEmpty());
		    
//		    NodeList DatVerList = doc.getElementsByTagName("DATA_VERSION");
//		    for (int i =0; i < DatVerList.getLength(); i++) {
//		    	//System.out.println("_Name", DatVer);
//		    	System.out.println(getNodeAttr("_Name", DatVerList.item(i)));
//		    	
//		    }
//		    
//		    System.out.println(DatVerList.getLength());

		    //String name0 = getNodeAttr("_Name", DatVer.getChildNodes().item(0));
		    //String name1 = getNodeAttr("_Name", DatVer.getChildNodes().item(1));
		    //System.out.println(DatVer.getAttribute("_Name"));
		 
		    // Load the executive's data from the XML
//		    NodeList nodes = exec.getChildNodes();
//		    String lastName = getNodeValue("LastName", nodes);
//		    String firstName = getNodeValue("FirstName", nodes);
//		    String street = getNodeValue("street", nodes);
//		    String city = getNodeValue("city", nodes);
//		    String state = getNodeValue("state", nodes);
//		    String zip = getNodeValue("zip", nodes);
//		 
//		    System.out.println("Executive Information:");
//		    System.out.println("Type: " + execType);
//		    System.out.println(lastName + ", " + firstName);
//		    System.out.println(street);
//		    System.out.println(city + ", " + state + " " + zip);
		    return true;
		}
		catch ( Exception e ) {
		    e.printStackTrace();
		    return false;
		}

	}
	
	//get Node from list of Nodes and element name ignores case
	private Node getNode(String elementName, NodeList nodes) {
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(elementName)) {
	            return node;
	        }
	        
	    }
	    return null;
	}
	
	//get the value of a Node
	private String getNodeValue( Node node ) {
	    NodeList childNodes = node.getChildNodes();
	    for (int x = 0; x < childNodes.getLength(); x++ ) {
	        Node data = childNodes.item(x);
	        if ( data.getNodeType() == Node.TEXT_NODE )
	            return data.getNodeValue();
	    }
	    return "";
	}
	 
	private String getNodeValue(String tagName, NodeList nodes ) {
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(tagName)) {
	            NodeList childNodes = node.getChildNodes();
	            for (int y = 0; y < childNodes.getLength(); y++ ) {
	                Node data = childNodes.item(y);
	                if ( data.getNodeType() == Node.TEXT_NODE )
	                    return data.getNodeValue();
	            }
	        }
	    }
	    return "";
	}
	 
	private String getNodeAttr(String attrName, Node node ) {
	    NamedNodeMap attrs = node.getAttributes();
	    for (int y = 0; y < attrs.getLength(); y++ ) {
	        Node attr = attrs.item(y);
	        if (attr.getNodeName().equalsIgnoreCase(attrName)) {
	            return attr.getNodeValue();
	        }
	    }
	    return "";
	}
	 
	private String getNodeAttr(String tagName, String attrName, NodeList nodes ) {
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(tagName)) {
	            NodeList childNodes = node.getChildNodes();
	            for (int y = 0; y < childNodes.getLength(); y++ ) {
	                Node data = childNodes.item(y);
	                if ( data.getNodeType() == Node.ATTRIBUTE_NODE ) {
	                    if ( data.getNodeName().equalsIgnoreCase(attrName) )
	                        return data.getNodeValue();
	                }
	            }
	        }
	    }
	 
	    return "";
	}

	
	
}
