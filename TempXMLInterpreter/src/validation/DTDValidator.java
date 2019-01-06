package validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// DOM
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// SAX
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;

import common.Validate;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.InputSource;

public class DTDValidator extends Validator implements Validate {
	List<String> errorList = new ArrayList<String>();

	public DTDValidator() {
	}

	public static ErrorHandler makeErrorHandler() {
		return new ErrorHandler() {
			public void warning(SAXParseException e) throws SAXException {
				System.out.println("WARNING : " + e.getMessage()); // do
																	// nothing
				int line = e.getLineNumber();
				int col = e.getColumnNumber();
				String message = e.getMessage();
				System.out.println("Error when validate XML against XSD Schema\n" + "line: " + line + "\n" + "column: "
						+ col + "\n" + "message: " + message.substring(message.indexOf(":") + 2));
			}

			public void error(SAXParseException e) throws SAXException {
				System.out.println("ERROR : " + e.getMessage());
				int line = e.getLineNumber();
				int col = e.getColumnNumber();
				String message = e.getMessage();
				System.out.println("Error when validate XML against XSD Schema\n" + "line: " + line + "\n" + "column: "
						+ col + "\n" + "message: " + message.substring(message.indexOf(":") + 2));
				throw e;
			}

			public void fatalError(SAXParseException e) throws SAXException {
				System.out.println("FATAL : " + e.getMessage());
				int line = e.getLineNumber();
				int col = e.getColumnNumber();
				String message = e.getMessage();
				System.out.println("Error when validate XML against XSD Schema\n" + "line: " + line + "\n" + "column: "
						+ col + "\n" + "message: " + message.substring(message.indexOf(":") + 2));
				throw e;
			}
		};
	}

	// validate using DOM (DTD as defined in the XML)
	public static boolean validateWithDTDUsingDOM(String xml) throws ParserConfigurationException, IOException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			factory.setValidating(true);
			factory.setNamespaceAware(true);

			DocumentBuilder builder = factory.newDocumentBuilder();

			builder.setErrorHandler(makeErrorHandler());
			builder.parse(new InputSource(xml));
			System.out.println("Validation is successful");
			return true;
		} catch (ParserConfigurationException pce) {
			throw pce;
		} catch (IOException io) {
			throw io;
		} catch (SAXException se) {
			return false;
		}
	}

	// validate using SAX (DTD as defined in the XML)
	public static boolean validateWithDTDUsingSAX(String xml) throws ParserConfigurationException, IOException {
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			
			factory.setValidating(true);
			factory.setNamespaceAware(true);

			SAXParser parser = factory.newSAXParser();

			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(makeErrorHandler());
				
			reader.parse(new InputSource(xml));
			System.out.println("Validation is successful");
			return true;
		} catch (ParserConfigurationException pce) {
			throw pce;
		} catch (IOException io) {
			throw io;
		} catch (SAXException se) {
			return false;
		}
	}

	public static void main(String args[]) throws Exception {
		long domStartTime = System.nanoTime();
		System.out.println(DTDValidator.validateWithDTDUsingDOM(
				"C:/Users/r2usjd/workspace/TestingAutomation/DI Test Case - C01 - Fixed - Primary - Attached - BW - 05-2014 .xml"));
		long domDuration = System.nanoTime() - domStartTime;
		long saxStartTime = System.nanoTime();
		System.out.println(DTDValidator.validateWithDTDUsingSAX(
				"C:/Users/r2usjd/workspace/TestingAutomation/DI Test Case - C01 - Fixed - Primary - Attached - BW - 05-2014 .xml"));
		long saxDuration = System.nanoTime() - saxStartTime;
		System.out.println("DOM duration: " + domDuration);
		System.out.println("SAX duration: " + saxDuration);

	}

	public List<String> getErrorList() {
		return errorList;
	}
}
