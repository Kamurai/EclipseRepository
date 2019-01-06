package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import debug.DebugSettings;
import main.Program;
import output.Printer;
import selection.Selector.MismoVersion;
import selection.Selector.Product;
import selection.Selector.TestCase;

public class ApplicationPanel extends JPanel{

	//User Input
	Product product;
	MismoVersion mismoVersion;
	TestCase testCase;
	String filePath;
	
	//User Input Objects
	JPanel northPanel;
	JPanel westPanel;
	JPanel productPanel;
	JLabel productLabel;
	JComboBox<String> productSelection;
	JPanel mismoPanel;
	JLabel mismoLabel;
	JComboBox<String> mismoSelection;
	JPanel testCasePanel;
	JLabel testCaseLabel;
	JComboBox<String> testCaseSelection;
	JPanel runButtonPanel;
	JButton runButton;
	JPanel eastPanel;
	JFileChooser fileChooser;
	
	//Application Results
	JPanel southPanel;
	JPanel resultsLabelPanel;
	JLabel resultLabel;
	JPanel resultsPanel;
	JTextArea resultArea;
	JScrollPane resultScroll;
	
	//Declarations
	boolean runListeners;
	
	
	public ApplicationPanel()
	{
		//User Input
		product = Product.DU;
		mismoVersion = MismoVersion.v34;
		testCase = TestCase.TC00;
		filePath = "-1";

		//User Input Objects
		northPanel = new JPanel();
		westPanel = new JPanel();
		productPanel = new JPanel();
		productLabel = new JLabel("Product:");
		productSelection = new JComboBox<String>();
		productSelection.addItem("DU");
		productSelection.addItem("UCD");
		productSelection.addItem("ULDD");
		productSelection.setSelectedIndex(0);
		
		mismoPanel = new JPanel();
		mismoLabel = new JLabel("Mismo Version");
		mismoSelection = new JComboBox<String>();
		mismoSelection.addItem("2.3.1");
		mismoSelection.addItem("3.4");
		mismoSelection.setSelectedIndex(0);
		
		testCasePanel = new JPanel();
		testCaseLabel = new JLabel("Test Case:");
		testCaseSelection = new JComboBox<String>();
		testCaseSelection.addItem("TC01 C01_Fixed_Primary_Attached_BW");
		testCaseSelection.addItem("TC02 C02_ARM_FNM_ARM_Plan_4_Unit_Investor_BW_BW_QZ");
		testCaseSelection.addItem("TC03 C03_Fixed_Refi_CO_Second_Home_IO_BW_QZ");
		testCaseSelection.addItem("TC04 C04_Fixed_Refi_Ltd_CO_Primary_Undrawn_HELOC_BW_QZ");
		testCaseSelection.addItem("TC05 C05_Fixed_Construction_Primary_80_10_10_BW");
		testCaseSelection.addItem("TC06 C06_Fixed_ConPerm_Primary_BW_BW");
		testCaseSelection.addItem("TC07 C07_Fixed_Purchase_Primary_Financed_MI_Ground_Rent_BW");
		testCaseSelection.addItem("TC08 C08_Fixed_Purchase_Primary_Manufactured_BW_QZ");
		testCaseSelection.addItem("TC09 CL01_Fixed_HomeStyle_Primary_Purchase_80_10_10_BW");
		testCaseSelection.addItem("TC10 FHA01_203b");
		testCaseSelection.addItem("TC11 FHA02_203b_Refi");
		testCaseSelection.addItem("TC12 VA01_30Yr_Fixed");
		testCaseSelection.addItem("TC13 VA02_ARM");
		testCaseSelection.setSelectedIndex(0);
		
		runButtonPanel = new JPanel();
		runButton = new JButton("Compare Files");
		
		eastPanel = new JPanel();
		fileChooser = new JFileChooser("Select File");
		
		//Application Results
		southPanel = new JPanel();
		resultsLabelPanel = new JPanel();
		resultLabel = new JLabel("Results:");
		resultsPanel = new JPanel();
		resultArea = new JTextArea("Click \"Compare Files\"");
		resultScroll = new JScrollPane(resultArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//Declarations
		runListeners = true;
		
		//Add objects to Panels
		productPanel.add(productLabel);
		productPanel.add(productSelection);
		mismoPanel.add(mismoLabel);
		mismoPanel.add(mismoSelection);
		testCasePanel.add(testCaseLabel);
		testCasePanel.add(testCaseSelection);
		runButtonPanel.add(runButton);
		
		westPanel.add(productPanel);
		westPanel.add(productPanel);
		westPanel.add(mismoPanel);
		westPanel.add(mismoPanel);
		westPanel.add(testCasePanel);
		westPanel.add(testCasePanel);
		westPanel.add(runButtonPanel);
		
		eastPanel.add(fileChooser);
		
		northPanel.add(westPanel);
		northPanel.add(eastPanel);
		
		resultsLabelPanel.add(resultLabel);
		resultsPanel.add(resultScroll);
		
		southPanel.add(resultsLabelPanel);
		southPanel.add(resultsPanel);
		
		//set Layout
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.X_AXIS));
		mismoPanel.setLayout(new BoxLayout(mismoPanel, BoxLayout.X_AXIS));
		testCasePanel.setLayout(new BoxLayout(testCasePanel, BoxLayout.X_AXIS));
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		
		//add Panels to application Panel
		this.add(northPanel);
		this.add(southPanel);
		
		//GUI Object Sizes
		northPanel.setPreferredSize(new Dimension(DisplaySettings.getNorthPanelWidth(), DisplaySettings.getNorthPanelHeight()));
		westPanel.setPreferredSize(new Dimension(DisplaySettings.getWestPanelWidth(), DisplaySettings.getWestPanelHeight()));
		productPanel.setPreferredSize(new Dimension(DisplaySettings.getProductPanelWidth(), DisplaySettings.getProductPanelHeight()));
		productLabel.setPreferredSize(new Dimension(DisplaySettings.getProductLabelWidth(), DisplaySettings.getProductLabelHeight()));
		productSelection.setPreferredSize(new Dimension(DisplaySettings.getProductSelectionWidth(), DisplaySettings.getProductSelectionHeight()));
		mismoPanel.setPreferredSize(new Dimension(DisplaySettings.getMismoPanelWidth(), DisplaySettings.getMismoPanelHeight()));
		mismoLabel.setPreferredSize(new Dimension(DisplaySettings.getMismoLabelWidth(), DisplaySettings.getMismoLabelHeight()));
		mismoSelection.setPreferredSize(new Dimension(DisplaySettings.getMismoSelectionWidth(), DisplaySettings.getMismoSelectionHeight()));
		testCasePanel.setPreferredSize(new Dimension(DisplaySettings.getTestCasePanelWidth(), DisplaySettings.getTestCasePanelHeight()));
		testCaseLabel.setPreferredSize(new Dimension(DisplaySettings.getTestCaseLabelWidth(), DisplaySettings.getTestCaseLabelHeight()));
		testCaseSelection.setPreferredSize(new Dimension(DisplaySettings.getTestCaseSelectionWidth(), DisplaySettings.getTestCaseSelectionHeight()));
		runButtonPanel.setPreferredSize(new Dimension(DisplaySettings.getRunButtonPanelWidth(), DisplaySettings.getRunButtonPanelHeight()));
		runButton.setPreferredSize(new Dimension(DisplaySettings.getRunButtonWidth(), DisplaySettings.getRunButtonHeight()));
		eastPanel.setPreferredSize(new Dimension(DisplaySettings.getEastPanelWidth(), DisplaySettings.getEastPanelHeight()));
		fileChooser.setPreferredSize(new Dimension(DisplaySettings.getFileChooserWidth(), DisplaySettings.getFileChooserHeight()));
		
		southPanel.setPreferredSize(new Dimension(DisplaySettings.getSouthPanelWidth(), DisplaySettings.getSouthPanelHeight()));
		resultLabel.setPreferredSize(new Dimension(DisplaySettings.getResultLabelWidth(), DisplaySettings.getResultLabelHeight()));
		resultScroll.setPreferredSize(new Dimension(DisplaySettings.getResultScrollWidth(), DisplaySettings.getResultScrollHeight()));
		resultArea.setPreferredSize(new Dimension(DisplaySettings.getResultAreaWidth(), DisplaySettings.getResultAreaHeight()));
		
		//GUI settings
		northPanel.setVisible(true);
		southPanel.setVisible(true);
		resultArea.setLineWrap(true);
		resultArea.setWrapStyleWord(true);
		resultArea.setEditable(false);
						
		//borders
		if(DebugSettings.getBorderMode()){
			northPanel.setBorder(BorderFactory.createLineBorder(new Color(0,255,0))); 
			southPanel.setBorder(BorderFactory.createLineBorder(new Color(0,0,255)));
			
			westPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,255)));
			eastPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,255)));
			
			productPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
			mismoPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
			testCasePanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
			runButtonPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
			
			productLabel.setBorder(BorderFactory.createLineBorder(new Color(0,255,255))); 
			mismoLabel.setBorder(BorderFactory.createLineBorder(new Color(0,255,255))); 
			testCaseLabel.setBorder(BorderFactory.createLineBorder(new Color(0,255,255))); 
			fileChooser.setBorder(BorderFactory.createLineBorder(new Color(0,255,255))); 
			productSelection.setBorder(BorderFactory.createLineBorder(new Color(255,255,0))); 
			mismoSelection.setBorder(BorderFactory.createLineBorder(new Color(255,255,0))); 
			testCaseSelection.setBorder(BorderFactory.createLineBorder(new Color(255,255,0))); 
			runButton.setBorder(BorderFactory.createLineBorder(new Color(255,255,0)));
		}
		
		//Add listeners
		productSelection.addActionListener(new ProductListener());
		mismoSelection.addActionListener(new MismoVersionListener());
		testCaseSelection.addActionListener(new TestCaseListener());
		runButton.addActionListener(new CompareListener());
	}
	
	private class ProductListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			if (event.getSource() == productSelection && runListeners) {
				//set product
				if(productSelection.getSelectedItem().toString().equals("DU")){
					product = Product.DU;
				}
				else if(productSelection.getSelectedItem().toString().equals("UCD")){
					product = Product.UCD;
				}
				else if(productSelection.getSelectedItem().toString().equals("ULDD")){
					product = Product.ULDD;
				}
				
				//Update Combo Box options
				runListeners = false;
				updateMismoVersions(productSelection.getSelectedItem().toString());
				runListeners = true;
			}
  		}
	}
	
	private class MismoVersionListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			if (event.getSource() == mismoSelection && runListeners) {
				
				//set MismoVersion
				if(mismoSelection.getSelectedItem().toString().equals("2.3.1")){
					mismoVersion = MismoVersion.v231;
				}
				else if(mismoSelection.getSelectedItem().toString().equals("3.0")){
					mismoVersion = MismoVersion.v30;
				}
				else if(mismoSelection.getSelectedItem().toString().equals("3.3")){
					mismoVersion = MismoVersion.v33;
				}
				else if(mismoSelection.getSelectedItem().toString().equals("3.4")){
					mismoVersion = MismoVersion.v34;
				}
				
				//Update Combo Box options
				runListeners = false;
				updateTestCases(productSelection.getSelectedItem().toString(), mismoSelection.getSelectedItem().toString());
				runListeners = true;
			}
  		}
	}
	
	private class TestCaseListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
  		{
			if(event.getSource() == testCaseSelection && runListeners) {
				//set TestCase
				if(product == Product.DU){
					if(mismoVersion == MismoVersion.v231){
						//update Test Case Combo Box
						if(testCaseSelection.getSelectedItem().toString().equals("TC01 C01_Fixed_Primary_Attached_BW")){
							testCase = TestCase.TC01;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC02 C02_ARM_FNM_ARM_Plan_4_Unit_Investor_BW_BW_QZ")){
							testCase = TestCase.TC02;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC03 C03_Fixed_Refi_CO_Second_Home_IO_BW_QZ")){
							testCase = TestCase.TC03;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC04 C04_Fixed_Refi_Ltd_CO_Primary_Undrawn_HELOC_BW_QZ")){
							testCase = TestCase.TC04;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC05 C05_Fixed_Construction_Primary_80_10_10_BW")){
							testCase = TestCase.TC05;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC06 C06_Fixed_ConPerm_Primary_BW_BW")){
							testCase = TestCase.TC06;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC07 C07_Fixed_Purchase_Primary_Financed_MI_Ground_Rent_BW")){
							testCase = TestCase.TC07;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC08 C08_Fixed_Purchase_Primary_Manufactured_BW_QZ")){
							testCase = TestCase.TC08;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC09 CL01_Fixed_HomeStyle_Primary_Purchase_80_10_10_BW")){
							testCase = TestCase.TC09;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC10 FHA01_203b")){
							testCase = TestCase.TC10;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC11 FHA02_203b_Refi")){
							testCase = TestCase.TC11;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC12 VA01_30Yr_Fixed")){
							testCase = TestCase.TC12;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC13 VA02_ARM")){
							testCase = TestCase.TC13;
						}
					}
					else if(mismoVersion == MismoVersion.v34){
						//update Test Case Combo Box
						if(testCaseSelection.getSelectedItem().toString().equals("TC01 Fixed_Primary_Attchd_XML_Match_DI-C01")){
							testCase = TestCase.TC01;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC02 ARM_4-Unit_XML_Match_DI_C02")){
							testCase = TestCase.TC02;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC03 Refi_CO_2nd_Home_XML_Match_DI_C03")){
							testCase = TestCase.TC03;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC04 Refi_Ltd_CO_Undrawn_HELOC_XML_Match_DI_C04")){
							testCase = TestCase.TC04;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC05 Fixed_Construction_XML_Match_DI-C05")){
							testCase = TestCase.TC05;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC06 Constr-to-Perm_XML_Match_DI-C06")){
							testCase = TestCase.TC06;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC07 Community_2nd_XML_Match_DI-C07")){
							testCase = TestCase.TC07;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC08 Purchase_Manufctd_XML_Match_DI-C08")){
							testCase = TestCase.TC08;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC09 Homestyle_Purchase_XML_Match_DI-CL01")){
							testCase = TestCase.TC09;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC10 203b251_FHA_ARM_XML_Match_DI-FHA01")){
							testCase = TestCase.TC10;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC11 FHA_203b_Refi_XML_Match_DI-FHA02")){
							testCase = TestCase.TC11;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC12 VA 30_Yr_Fixed_XML_Match_DI-VA01")){
							testCase = TestCase.TC12;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC13 VA_ARM_XML_Match_DI-VA02")){
							testCase = TestCase.TC13;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC14 Purchase_ULAD")){
							testCase = TestCase.TC14;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC15 Refinance_ULAD")){
							testCase = TestCase.TC15;
						}						
					}
				}
				else if(product.equals("UCD")){
					if(mismoVersion == MismoVersion.v33){
						//update Test Case Combo Box
						if(testCaseSelection.getSelectedItem().toString().equals("TC01 Purchase_Fixed")){
							testCase = TestCase.TC01;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC02 Purchase_ARM")){
							testCase = TestCase.TC02;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC03 Refinance_Fixed")){
							testCase = TestCase.TC03;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC04 Refinance_ARM")){
							testCase = TestCase.TC04;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC05 Refinance_ARM_IO-C05")){
							testCase = TestCase.TC05;
						}
					}
				}
				else if(product.equals("ULDD")){
					if(mismoVersion == MismoVersion.v30){
						if(testCaseSelection.getSelectedItem().toString().equals("TC01")){
							testCase = TestCase.TC01;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC02")){
							testCase = TestCase.TC02;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC03")){
							testCase = TestCase.TC03;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC04")){
							testCase = TestCase.TC04;
						}
						else if(testCaseSelection.getSelectedItem().toString().equals("TC05")){
							testCase = TestCase.TC05;
						}
					}
				}
			}
  		}
	}
	
	private class CompareListener implements ActionListener
	{
		
		public void actionPerformed (ActionEvent event)
  		{
			List<String> errorList = new ArrayList<String>();
			//clear previous error list
			errorList.clear();
			
			if (event.getSource() == runButton) {
				
				filePath = fileChooser.getSelectedFile().getPath();
				
				//Display working message
				resultArea.selectAll();
				//Cleear Text
				resultArea.setText("");
				resultArea.setText("Getting Results");
				
				//Main Application
				errorList = Program.execute(product,mismoVersion,testCase,filePath); //standard
				//errorList = program.execute(product,mismoVersion,testCase,filePath, targetFilePaths, true, false); //batch mode
				
				//Cleear Text
				resultArea.selectAll();
				resultArea.setText("");
				resultArea.setText(Printer.printToTextArea(errorList));
				
				resultArea.setCaretPosition(0);
			}
  		}
	}
	
	private void updateMismoVersions(String product)
	{
		//remove all options from Combo Box
		mismoSelection.removeAllItems();
				
		if(product.equals("DU")){
			//update Mismo Version Combo Box
			mismoSelection.addItem("2.3.1");
			mismoSelection.addItem("3.4");
			mismoVersion = MismoVersion.v231;
			
			//set Test Case Combo Box
			runListeners = false;
			updateTestCases(product, "2.3.1");
			runListeners = true;
		}
		else if(product.equals("UCD")){
			//update Mismo Version Combo Box
			mismoSelection.addItem("3.3");
			mismoVersion = MismoVersion.v33;
			
			//set Test Case Combo Box
			runListeners = false;
			updateTestCases(product, "3.3");
			runListeners = true;
		}
		else if(product.equals("ULDD")){
			//update Mismo Version Combo Box
			mismoSelection.addItem("3.0");
			mismoVersion = MismoVersion.v30;
			
			//set Test Case Combo Box
			runListeners = false;
			updateTestCases(product, "3.0");
			runListeners = true;
		}
	}
	
	private void updateTestCases(String product, String mismoVersion)
	{
		//remove all options from Combo Box
		testCaseSelection.removeAllItems(); //TODO: error here
		
		if(product.equals("DU")){
			if(mismoVersion.equals("2.3.1")){
				//update Test Case Combo Box
				testCaseSelection.addItem("TC01 C01_Fixed_Primary_Attached_BW");
				testCaseSelection.addItem("TC02 C02_ARM_FNM_ARM_Plan_4_Unit_Investor_BW_BW_QZ");
				testCaseSelection.addItem("TC03 C03_Fixed_Refi_CO_Second_Home_IO_BW_QZ");
				testCaseSelection.addItem("TC04 C04_Fixed_Refi_Ltd_CO_Primary_Undrawn_HELOC_BW_QZ");
				testCaseSelection.addItem("TC05 C05_Fixed_Construction_Primary_80_10_10_BW");
				testCaseSelection.addItem("TC06 C06_Fixed_ConPerm_Primary_BW_BW");
				testCaseSelection.addItem("TC07 C07_Fixed_Purchase_Primary_Financed_MI_Ground_Rent_BW");
				testCaseSelection.addItem("TC08 C08_Fixed_Purchase_Primary_Manufactured_BW_QZ");
				testCaseSelection.addItem("TC09 CL01_Fixed_HomeStyle_Primary_Purchase_80_10_10_BW");
				testCaseSelection.addItem("TC10 FHA01_203b");
				testCaseSelection.addItem("TC11 FHA02_203b_Refi");
				testCaseSelection.addItem("TC12 VA01_30Yr_Fixed");
				testCaseSelection.addItem("TC13 VA02_ARM");
			}
			else if(mismoVersion.equals("3.4")){
				//update Test Case Combo Box
				testCaseSelection.addItem("TC01 Fixed_Primary_Attchd_XML_Match_DI-C01");
				testCaseSelection.addItem("TC02 ARM_4-Unit_XML_Match_DI_C02");
				testCaseSelection.addItem("TC03 Refi_CO_2nd_Home_XML_Match_DI_C03");
				testCaseSelection.addItem("TC04 Refi_Ltd_CO_Undrawn_HELOC_XML_Match_DI_C04");
				testCaseSelection.addItem("TC05 Fixed_Construction_XML_Match_DI-C05");
				testCaseSelection.addItem("TC06 Constr-to-Perm_XML_Match_DI-C06");
				testCaseSelection.addItem("TC07 Community_2nd_XML_Match_DI-C07");
				testCaseSelection.addItem("TC08 Purchase_Manufctd_XML_Match_DI-C08");
				testCaseSelection.addItem("TC09 Homestyle_Purchase_XML_Match_DI-CL01");
				testCaseSelection.addItem("TC10 203b251_FHA_ARM_XML_Match_DI-FHA01");
				testCaseSelection.addItem("TC11 FHA_203b_Refi_XML_Match_DI-FHA02");
				testCaseSelection.addItem("TC12 VA 30_Yr_Fixed_XML_Match_DI-VA01");
				testCaseSelection.addItem("TC13 VA_ARM_XML_Match_DI-VA02");
				testCaseSelection.addItem("TC14 Purchase_ULAD");
				testCaseSelection.addItem("TC15 Refinance_ULAD");
			}
		}
		else if(product.equals("UCD")){
			if(mismoVersion.equals("3.3")){
				//update Test Case Combo Box
				testCaseSelection.addItem("TC01 Purchase_Fixed");
				testCaseSelection.addItem("TC02 Purchase_ARM");
				testCaseSelection.addItem("TC03 Refinance_Fixed");
				testCaseSelection.addItem("TC04 Refinance_ARM");
				testCaseSelection.addItem("TC05 Refinance_ARM_IO");
			}
		}
		else if(product.equals("ULDD")){
			if(mismoVersion.equals("3.0")){
				//update Test Case Combo Box
				testCaseSelection.addItem("TC01");
				testCaseSelection.addItem("TC02");
				testCaseSelection.addItem("TC03");
				testCaseSelection.addItem("TC04");
				testCaseSelection.addItem("TC05");				
			}
		}
		testCase = TestCase.TC01;
	}
	
}
