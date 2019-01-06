package test.validation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import validation.SchemaValidator;

public class SchemaValidatorTest {
	String xsdMainPath = "R:\\DU34\\Schema\\DU_ExtensionV3_4.xsd";
	
	static List<String> xmlPaths = new ArrayList<String>();
	static List<File> xmlFiles = new ArrayList<File>();
	
	SchemaValidator sv = new SchemaValidator();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		xmlPaths.add("DU Fixed Primary Attchd XML_Match DI-C01_v3.2_08062018.xml");
		xmlPaths.add("DU ARM 4-Unit XML_Match DI C02_v5.1_07202018.xml");
		xmlPaths.add("DU Refi CO 2nd Home XML_Match DI C03_v3.1_post-scrub_07242018.xml");
		xmlPaths.add("DU Refi Ltd CO Undrawn HELOC XML_Match DI C04_v3.2_08092018.xml");
		xmlPaths.add("DU Fixed Construction XML_Match DI-C05_v3.2_addLotCost_08242018.xml");
		xmlPaths.add("DU Constr-to-Perm XML_Match DI-C06_v3_post-scrub_07242018.xml");
		xmlPaths.add("DU Community 2nd XML_Match DI-C07_v2.2_07302018.xml");
		xmlPaths.add("DU Purchase Manufctd XML_Match DI-C08_v3.3_post-scrub_valid_08062018.xml");
		xmlPaths.add("DU Homestyle Purchase XML_Match DI-CL01_v3.1_08072018.xml");
		xmlPaths.add("DU 203b251 FHA ARM XML_Match DI-FHA01_v3.1_08152018.xml");
		xmlPaths.add("DU FHA 203b Refi XML_Match DI-FHA02_v2.0_08132018.xml");
		xmlPaths.add("DU VA 30 Yr Fixed XML_Match DI-VA01_v3.0_08102018.xml");
		xmlPaths.add("DU VA ARM XML_Match DI-VA02_v2.0_08142018.xml");
		
		
		String xmlMainPath = "R:\\DU34\\DU Test Cases\\";
		
		for (int i = 0; i < xmlPaths.size(); i++) {
			xmlFiles.add(new File(xmlMainPath+xmlPaths.get(i)));
		}
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testNonexistantFileArgument() throws SAXException, IOException {
		assertFalse(sv.validateXML(new File("badPath.xsd"), xsdMainPath));
	}
	
	@Test
	public void testSchemaAgainstControlTestSuite() {
		for (File xmlFile : xmlFiles) {
			assertTrue(sv.validate(xmlFile, xsdMainPath));
		}
	}

}
