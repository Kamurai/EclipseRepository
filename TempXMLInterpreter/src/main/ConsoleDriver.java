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
import selection.Selector.*;
import specification.SpecValidator;
import validation.SchemaValidator;
import validation.Validator;
import validation.DTDValidator;

public class ConsoleDriver {

	public static void main(String[] args) {
		
//User Input
		Product product = Product.DU;
		MismoVersion mismoVersion = MismoVersion.v34;
		TestCase testCase = TestCase.TC01;
		String filePath = "R:\\DU34\\Test_Scenarios\\TC01\\TC01_Chaos.xml";
		List<String> targetFilePaths = new ArrayList<String>();
		
//Declarations
		List<String> errorList = new ArrayList<String>();
		
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Control.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_01.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_02.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_03.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_04.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_05.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_06.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_07.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_08.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_09.xml");
//		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\ULAD_Refinance\\ULAD_Refinance_Scenario_10.xml");
		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\Scenario_ConstructionPeriodInterestRatePercent_C06.xml");
		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\Scenario_CreatedDateTimeAttr_C01.xml");
		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\Scenario_IneligibleLoanProductIndicator_C02.xml");
		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\Scenario_LiabilityTypeAttr_C01.xml");
		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\Scenario_LienPriorityTyeAttr_C01.xml");
		targetFilePaths.add("R:\\DU34\\Test_Scenarios\\PropertyInProjectIndicatorBool_C01.xml");
		targetFilePaths.add("R:\\DU34\\DU Test Cases\\DU VA 30 Yr Fixed XML_Match DI-VA01_v3.0_08102018.xml");
		
//Main Application
		errorList = Program.execute(product,mismoVersion,testCase,filePath); //standard
		//errorList = program.execute(product,mismoVersion,testCase,filePath, targetFilePaths, true, false); //batch mode
		
		Printer.printList(errorList);
		
	}
}
