package com.fanniemae.XMLFormatter;

public class Driver 
{

	
	public static void main(String[] args) 
	{
		//debug flags
		boolean debug = true;
		boolean trueFileIn = true;
		boolean trueFileOut = true;
		boolean testFileIn = true;
		
		//utility classes
		FileManager fileManager = new FileManager();
		FileFormatter fileFormatter = new FileFormatter();
		
		//Main
		if(debug)
		{
			System.out.println("Start");
		}
		
		
		String fileInPathway = "";
		if(trueFileIn)
		{
			
			if(testFileIn)
			{
				fileInPathway = "C:\\Users\\r2ucdk\\Documents\\Programming\\RQ_UCD_Fannie_UCD Non-Seller ARM IO.xml";
			}
			else
			{
				fileInPathway = args[0];
			}
		}
		else
		{
			fileInPathway = ""; 
		}

		String contentString = "";
		
		//Pull file
			//convert file contents to string
		if(trueFileIn)
		{
			contentString = fileManager.pullFile(fileInPathway);
		}
		else
		{
			contentString = "<MESSAGE xmlns=\"http://www.mismo.org/residential/2009/schemas\" xmlns:xsi=\"http://www.w3.org/Residential/2009/schema\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:mismo=\"http://www.mismo.org/residential/2009/schemas\" xmlns:n1=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.mismo.org/residential/2009/schemas schemas/UCD/UCD_3.3.0_B299.xsd\"><ABOUT_VERSIONS><ABOUT_VERSION><!--This is a comment--><CreatedDatetime>2017-09-05T21:04:06Z</CreatedDatetime><gse:DocumentSignatureRequiredIndicator>false</gse:DocumentSignatureRequiredIndicator><mismo:RELATIONSHIP SequenceNumber=\"1\" xlink:from=\"PARTY2_ROLE1\" xlink:to=\"PARTY1_ROLE1\" xlink:arcrole=\"urn:fdc:mismo.org:2009:residential/ROLE_IsEmployedBy_ROLE\"/><mismo:ClosingAdjustmentItemType gse:DisplayLabelText=\"Second Loan (Principal Balance $19,000)\">ProceedsOfSubordinateLiens</mismo:ClosingAdjustmentItemType><gse:IntegratedDisclosureSectionType xmlns:gse=\"http://www.datamodelextension.org\">PayoffsAndPayments</gse:IntegratedDisclosureSectionType><gse:LiabilitySecuredBySubjectPropertyIndicator xmlns:gse=\"http://www.datamodelextension.org\">true</gse:LiabilitySecuredBySubjectPropertyIndicator><DOCUMENT MISMOReferenceModelIdentifier=\"3.3.0299\"></DOCUMENT></ABOUT_VERSION></ABOUT_VERSIONS></MESSAGE>"; 
		}
		
		//format content string
		contentString = fileFormatter.formatContent(contentString);
		
		//Globalize References
		contentString = fileFormatter.globalizeReferences(contentString);	
			
		//output to console (control by flag)
		if(debug)
		{
			System.out.println("Contents: ");
			System.out.println(contentString);
		}
		
		if(trueFileOut)
		{
			//write to file
			fileManager.writeFile(contentString, fileInPathway);
		}
		
		if(debug)
		{
			System.out.println("End");
		}
		
		
	}
	
	
	
	
	
}
