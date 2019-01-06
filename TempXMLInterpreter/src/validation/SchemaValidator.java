package validation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import common.Validate;
import read.FileReader;
import read.JSONReader;
import read.XMLReader;

public class SchemaValidator extends Validator implements Validate {
	List<String> errorList = new ArrayList<String>();
	
	public SchemaValidator(){}

	@Override
	public boolean validate(File subject, String xsdPath) {
		boolean result = false;
		String mode = "XML"; // TODO Hardcoded parameter
		
		//apply validation
		if(mode == "XML")
		{
			//record them to errorList
			try {
				result = validateXML(subject, xsdPath);
			} catch (SAXException | IOException e) {
				e.printStackTrace();
			}
		}
		else if(mode == "JSON")
		{
			//record them to errorList
			result = validateJSON(subject);
		}
		return result;
	}


	public boolean validateXML(File xmlFile, String xsdPath) throws SAXException, IOException {
		try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath)); //validate with 1 schema
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        } catch (SAXException e) {
            errorList.add("SAXException: "+e.getMessage());
            return false;
        } catch (IOException e) {
        	errorList.add("IOException: "+e.getMessage());
        }
        return true;
	}

	private static boolean validateJSON(File file) {
		// TODO Auto-generated method stub
		return false;

	}

	public List<String> getErrorList()
	{
		return errorList;		
	}
	

	
	public static void main(String args[]) {
	}
	
	
}
