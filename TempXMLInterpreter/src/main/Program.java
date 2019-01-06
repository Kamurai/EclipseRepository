package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import comparison.Comparator;
import information.FileObject;
import interpretation.Interpreter;
import output.PrintUtility;
import output.Printer;
import selection.Selector;
import selection.Selector.MismoVersion;
import selection.Selector.Product;
import selection.Selector.TestCase;
import specification.SpecValidator;
import validation.DTDValidator;
import validation.SchemaValidator;
import validation.Validator;

public class Program {

	//Development variables
			static boolean batchMode = false;
			
	//User Input
			Product product = Product.DU;
			MismoVersion mismoVersion = MismoVersion.v34;
			TestCase testCase = TestCase.TC00;
			static String filePath = "-1";
			static List<String> targetFilePaths = new ArrayList<String>();
			
			static File targetFile;
			static File testFile;
			
			
	//Declarations
			static Selector selector = new Selector();
			static Validator validator = new Validator();
			static List<String> errorList = new ArrayList<String>();
			static List<String> returnList = new ArrayList<String>();
			static Interpreter interpreter = new Interpreter();
			static SpecValidator specValidator = new SpecValidator();
			static Comparator comparator = new Comparator();
			static FileObject fileObject;
			static int runLimit = 1;
			static List<File> targetFiles = new ArrayList<File>();
			List<File> testFiles = new ArrayList<File>();
			
	public static List<String> execute(Product productInput, MismoVersion mismoVersionInput, TestCase testCaseInput, String filePathInput, List<String> targetFilePathsInput, boolean batchModeInput){
		
		batchMode = batchModeInput;
		targetFilePaths = targetFilePathsInput;
		return execute(productInput, mismoVersionInput, testCaseInput, filePathInput);
	}
	
	public static List<String> execute(Product productInput, MismoVersion mismoVersionInput, TestCase testCaseInput, String filePathInput){
//get User input:
		if(!batchMode)
			//get file from user
			filePath = filePathInput;
			
		//get product from user
		selector.setProduct(productInput);
		//get version from user
		selector.setMismoVersion(mismoVersionInput);
		//get testcase from user
		selector.setTestCase(testCaseInput);

//Preamble
		if(batchMode){
			for(int x=0; x < targetFilePaths.size(); x++){
				targetFiles.add(new File(targetFilePaths.get(x)));
			}
			targetFile = targetFiles.get(0);
		}
		else
			//read file from location
			targetFile = new File(filePath);
		
		//Declaration: Validator
		if(selector.getProduct().toString() == "DU" && selector.getMismoVersion().toString() == "v231")
		{
			//Validate with DTD
			validator = new DTDValidator();
		}
		else
		{
			//Validate with Schema
			validator = new SchemaValidator();
		}
		
		//FileObject
		fileObject = setFileObject(selector.getProduct().toString(), selector.getMismoVersion().toString());
		
		//Interpreter
		interpreter = setInterpreter(selector.getProduct().toString(), selector.getMismoVersion().toString());
		
		//SpecValidator
		specValidator = setSpecValidator(selector.getProduct().toString(), selector.getMismoVersion().toString());
		
		//Comparator
		comparator = setComparator(selector.getProduct().toString(), selector.getMismoVersion().toString());
		
		//set run limit
		if(batchMode)
			runLimit = targetFiles.size()-1;
		else
			runLimit = 1;
		
//Main Application
		for(int x=0; x < runLimit; x++){
			if(batchMode){
				targetFile = targetFiles.get(x);
				//new file spacer
				System.out.println(PrintUtility.newFileSpacer(targetFile.getName()));
			}
				
			//get Test File
			testFile = new File(selector.selectTestCase()); //todo: expand to batch test against multiple test cases 
			
			//Section Header
			errorList.add("Schema Validation Errors:");
			
			
			//hand off to Validator: returns String(s)
			if(!validator.validate(targetFile, selector.selectSchema(selector.getProduct(), selector.getMismoVersion())))
				errorList.addAll(validator.getErrorList());
			
			//If no validation errors
			if(validator.getErrorList().size() == 0 )
			{
				//report no validation errors
				errorList.add("No validation errors.");
			}
			
			//Section Header
			errorList.add("");
			errorList.add("Interpretation Errors:");
			
			
			//hand off to interpreter: returns interpreted XML Java Object
			fileObject = interpreter.interpret(targetFile);
				
			//interpreter returns String(s)
			errorList.addAll(interpreter.getErrorList());
			
			//If no interpretation errors
			if(interpreter.getErrorList().size() == 0 )
			{
				//report no interpretation errors
				errorList.add("No interpretation errors.");
			}
			
			//Section Header
			errorList.add("");
			errorList.add("Specification Errors:");
			
			
			//hand off to specValidator: returns Strings(s)
			if(!specValidator.validate(fileObject))
				errorList.addAll(specValidator.getErrorList());
				
			//If no specification errors
			if(specValidator.getErrorList().size() == 0 )
			{
				//report no specification errors
				errorList.add("No specification errors.");
			}
			
			//Section Header
			errorList.add("");
			errorList.add("Comparison Errors:");
			
			
			//hand off to comparator (with Test Case): add errors to error list
			comparator.compare(fileObject, testFile);
			errorList.addAll(comparator.getErrorList());
				
			//If no comparison errors
			if(comparator.getErrorList().size() == 0 )
			{
				//report no comparison errors
				errorList.add("No comparison errors.");
			}
			
			if(errorList.size() != 0 )
			{
				//Output Error List to User
				returnList.addAll(new ArrayList<String>(errorList));
				
				if(batchMode)
				{
					//Clear errorLists
						//main
					errorList.clear();
					//Validator
					validator.getErrorList().clear();
					//Interpreter
					interpreter.getErrorList().clear();
					//SpecValidator
					specValidator.getErrorList().clear();
					//Comparator					
					comparator.getErrorList().clear();
				}
			}
		}
		
		return returnList;
	}
	
	private static FileObject setFileObject(String product, String mismoVersion){
		FileObject result = new FileObject();
		
		if(product == "DU" && mismoVersion == "v34")
		{
			result = new information.dU34.Message();
		}
		else if(product == "DU" && mismoVersion == "v231")
		{
			result = new information.dU231.LoanApplication();
		}
		else if(product == "UCD" && mismoVersion == "v33")
		{
			result = new information.uCD33.Message();
		}
		else if(product == "ULDD" && mismoVersion == "v30")
		{
			result = new information.uLDD30.Message();
		}
		
		return result;
	}
		
	private static Interpreter setInterpreter(String product, String mismoVersion){
		Interpreter result = new Interpreter();
		
		if(product == "DU" && mismoVersion == "v34")
		{
			result = new interpretation.dU34.Interpreter();
		}
		else if(product == "DU" && mismoVersion == "v231")
		{
			result = new interpretation.dU231.Interpreter();
		}
		else if(product == "UCD" && mismoVersion == "v33")
		{
			result = new interpretation.uCD33.Interpreter();
		}
		else if(product == "ULDD" && mismoVersion == "v30")
		{
			result = new interpretation.uLDD30.Interpreter();
		}
		
		return result;
	}
	
	private static SpecValidator setSpecValidator(String product, String mismoVersion){
		SpecValidator result = new SpecValidator();
		
		if(product == "DU" && mismoVersion == "v34")
		{
			result = new specification.dU34.SpecValidator();
		}
		else if(product == "DU" && mismoVersion == "v231")
		{
			result = new specification.dU231.SpecValidator();
		}
		else if(product == "UCD" && mismoVersion == "v33")
		{
			result = new specification.uCD33.SpecValidator();
		}
		else if(product == "ULDD" && mismoVersion == "v30")
		{
			result = new specification.uLDD30.SpecValidator();
		}
		
		return result;
	}
	
	private static Comparator setComparator(String product, String mismoVersion){
		Comparator result = new Comparator();
		
		if(product == "DU" && mismoVersion == "v34")
		{
			result = new comparison.dU34.Comparator();
		}
		else if(product == "DU" && mismoVersion == "v231")
		{
			result = new comparison.dU231.Comparator();
		}
		else if(product == "UCD" && mismoVersion == "v33")
		{
			result = new comparison.uCD33.Comparator();
		}
		else if(product == "ULDD" && mismoVersion == "v30")
		{
			result = new comparison.uLDD30.Comparator();
		}
		
		return result;
	}
}
