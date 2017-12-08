package tableCheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Processor {
	/*
	 * External Table Metafile Processing Engine
	 */
	String version = "External Table Metafile Processing Engine v3.0";




	// data capture
	//The data that is displayed to user. 
	private ArrayList<ArrayList<String>> etmFileBeingDisplayed; 
	private ArrayList<ArrayList<String>> csvFileBeingDisplayed; 

	//The raw data from the files.
	private ArrayList<ArrayList<String>> etmFileRaw; 
	private ArrayList<ArrayList<String>> csvFileRaw; 

	// output result
	private String output = "PASS";

	//Check for matching number of ETM rows to CSV columns?
	private boolean MatchETMRowsToCSVColumns;


	//processing and evaluating
	private ETMProcessor anEtmProcessor;
	private CSVProcessor aCSVProcessor;
	private RuleEvaluator evaluator;
	private ArrayList<String> errors;


	public Processor() 
	{

		// default output result
		output = "PASS";

		//by default, check for matching ETM Rows and CSV columns
		MatchETMRowsToCSVColumns = true;

		//The list of errors from cross validating
		this.errors = new ArrayList<String>();

		//The javascript engine that is used to process expressions. 
		evaluator = RuleEvaluator.getInstance();
	}

	/**
	 * This function process both the etm and csv files
	 * @param alpha etm file location
	 * @param beta csv file location
	 * @return
	 */
	public String ProcessTable(String alpha, String beta) 
	{
		//clear error list
		this.errors.clear();

		//process etm file
		this.anEtmProcessor = new ETMProcessor();
		this.anEtmProcessor.setFile(alpha);
		this.anEtmProcessor.processFile();
		this.etmFileBeingDisplayed = this.anEtmProcessor.getDataToDisplay();
		this.etmFileRaw = this.anEtmProcessor.getRawData();

		//processing csv file
		this.aCSVProcessor = new CSVProcessor();
		if(this.MatchETMRowsToCSVColumns)
		{
			//force csvProcessor to look for the correct number of columns
			//if setColNum() is not called, it will use the first row in the csv file to determine the column number;
			this.aCSVProcessor.setColNum(this.anEtmProcessor.getNumOfRules());
		}
		this.aCSVProcessor.setFile(beta);
		this.aCSVProcessor.processFile();
		this.csvFileBeingDisplayed = this.aCSVProcessor.dataToDisplay;
		this.csvFileRaw = this.aCSVProcessor.rawData;

		//validating the csv file using etm file
		this.crossProcess();

		if(this.hasError())
		{
			output = "Error(s) Found!\n";


			List<String> errorList = this.getAllErrors();
			for(String anError: errorList)
			{
				output += anError + "\n";
				//for debugging only
				//System.out.println(anError);			
			}
		}
		else
		{
			output = "PASS";
		}
		return output;
	}

	/**
	 * Processing the csv file using the etm file
	 */
	private void crossProcess()
	{
		ArrayList<ArrayList<String>> csvData = this.csvFileRaw;

		//a cache can help reduce the time needed to process large csv files. 
		HashMap<String, Boolean> processingCache = new HashMap<String, Boolean>();

		boolean result = false;
		for(int rowNum = 0; rowNum<csvData.size(); rowNum++)
		{
			ArrayList<String> aRow = csvData.get(rowNum);
			for(int colNum = 0; colNum<aRow.size(); colNum++)
			{
				//grab an item
				String anItem = aRow.get(colNum);

				//grab the express for that item
				String anExpression = this.anEtmProcessor.getExpression(colNum+1);

				if(anExpression==null)
				{
					//no need to do this if etm rows are not matching csv columns
					if(this.MatchETMRowsToCSVColumns)
					{
						String error = "Missing definition for colnum "+(colNum+1)+" in the CSV file";
						//only want to add this error once
						if(!this.errors.contains(error))
						{
							this.errors.add(error);
						}
						this.makeCSVErrorText(rowNum, colNum);					
					}
				}
				else
				{
					//check if the etm item contains an error
					boolean ruleContainsError = this.anEtmProcessor.itemContainsError(colNum+1);
					if(!ruleContainsError)
					{
						String keyForCache = anItem+anExpression;
						if (processingCache.containsKey(keyForCache))
						{
							result = processingCache.get(keyForCache);
						}
						else
						{
							if(anItem.length()>1){
								if(anItem.charAt(anItem.length()-1) == '"' && anItem.charAt(0) == '"'){
									anItem = anItem.substring(1, anItem.length()-1);
								}
							}
							result = this.evaluator.evalCell(anItem, anExpression);
							processingCache.put(keyForCache, result);
						}
						if(!result)
						{
							String anError = this.anEtmProcessor.getErrorText(colNum+1);
							String errorMessage = "CSV Issue: There is an issue at Row: " + (rowNum+1) + " Column: " + (colNum+1) + " : " + anError;
							this.errors.add(errorMessage);
							this.makeCSVErrorText(rowNum, colNum);
						}
					}
				}
			}
		}
	}

	private String printTable(ArrayList<ArrayList<String>> input) 
	{
		String result = "";

		for (int row = 0; row < input.size(); row++) 
		{
			result += "Row" + (row+1) + ":  ";
			for (int col = 0; col < input.get(row).size(); col++) 
			{
				//result += "Column:" + (col+1) + ":  ";
				result += input.get(row).get(col);

				if (col != (input.get(row).size() - 1)) 
				{
					result += " | ";
				}
			}
			result += "\n";
		}

		return result;
	}

	private String printTableRows(int rowNum) 
	{
		String result = "";

		for (int row = 0; row < rowNum; row++) 
		{
			result += "Row" + (row+1) + ":  ";
			result += "\n";
		}

		return result;
	}

	private String printTableCols(int colNum) 
	{
		String result = "";

		for (int col = 0; col < colNum; col++) 
		{
			//result += "Column:" + (col+1) + ":  ";
			result += "Col" + (col+1) + ":  ";

			if (col != (colNum - 1)) 
			{
				result += " | ";
			}
		}

		return result;
	}

	public String printETM()
	{
		return printTable(this.etmFileRaw);
	}

	public String printCSV()
	{
		return printTable(this.csvFileRaw);
	}

	public String printETMRows()
	{
		return printTableRows(this.etmFileRaw.size());
	}

	public String printCSVRows()
	{
		return printTableRows(this.csvFileRaw.size());
	}

	public String printETMCols()
	{
		return printTableCols(this.etmFileRaw.get(0).size());
	}

	public String printCSVCols()
	{
		return printTableCols(this.csvFileRaw.get(0).size());
	}

	public String getOutput() 
	{
		return output;
	}

	public ArrayList<ArrayList<String>> getETM()
	{

		return this.etmFileBeingDisplayed;
	}

	public ArrayList<ArrayList<String>> getCSV()
	{
		return this.csvFileBeingDisplayed;
	}

	public void setMatchETMRowsToCSVColumns(boolean input)
	{
		MatchETMRowsToCSVColumns = input;		
	}

	public boolean getMatchETMRowsToCSVColumns()
	{
		return MatchETMRowsToCSVColumns;
	}

	/**
	 * 
	 * @return an ArrayList of comments from the csv file
	 */
	public ArrayList<ArrayList<String>> getCSVComments()
	{
		return this.aCSVProcessor.getComments();
	}

	/**
	 * 
	 * @return a List of comments from the etm file
	 */
	public List<String> getEtmComments()
	{
		return this.anEtmProcessor.getComments();
	}

	/**
	 * 
	 * @return a List of errors found when processing the etm file
	 */
	public List<String> getETMErrors()
	{
		return this.anEtmProcessor.getErrors();
	}

	/**
	 * 
	 * @return a List of errors found when processing the csv file
	 */
	public List<String> getCSVErrors()
	{
		return this.aCSVProcessor.getErrors();
	}

	/**
	 * 
	 * @return a List of errors when cross processing the etm and csv file;
	 */
	public List<String> getCrossProcessingError()
	{
		return this.errors;
	}

	/**
	 * 
	 * @return if there are any errors in the whole process of processing
	 */
	public boolean hasError()
	{
		if (!this.errors.isEmpty())
		{
			return true;
		}
		if (this.anEtmProcessor.hasError())
		{
			return true;
		}
		if (this.aCSVProcessor.hasError())
		{
			return true;
		}
		return false;
	}

	/**
	 * This puts all the errors from processing to validating into a giant list
	 * This also makes sure no duplicate errors will be added
	 * It sorts the errors as well
	 * @return
	 */
	public List<String> getAllErrors()
	{
		ArrayList<String> allErrors = new ArrayList<String>();
		allErrors.addAll(this.getCSVErrors());
		allErrors.addAll(this.getETMErrors());
		allErrors.addAll(this.getCrossProcessingError());
		return allErrors;
	}

	/**
	 * Given the location of an item in the CSV file, this function changes the text in that item to the error text format. 
	 * @param rowNum
	 * @param colNum
	 */
	private void makeCSVErrorText(int rowNum, int colNum)
	{
		ArrayList<String> rawRow = this.csvFileRaw.get(rowNum);
		ArrayList<String> displayRow = this.csvFileBeingDisplayed.get(rowNum);
		String newItemToDisplay = this.errorText(rawRow.get(colNum));
		displayRow.set(colNum, newItemToDisplay);

	}

	@SuppressWarnings("unused")
	/**
	 * Given the location of an item in the ETM file, this function changes the text in that item to the error text format. 
	 * @param rowNum
	 * @param colNum
	 */
	private void makeETMErrorText(int rowNum, int colNum)
	{
		ArrayList<String> rawRow = this.etmFileRaw.get(rowNum);
		ArrayList<String> displayRow = this.etmFileBeingDisplayed.get(rowNum);
		String newItemToDisplay = this.errorText(rawRow.get(colNum));
		displayRow.set(colNum, newItemToDisplay);
	}

	/**
	 * The error text format for cross processing errors
	 * @param text the original text
	 * @return the formatted text
	 */
	private String errorText(String text)
	{
		String newText = text.trim();
		if(newText.equals("")&&!text.contains("<html>"))
		{
			return text;
		}
		return "<html><font color = 'blue'>"+text+"</font></html>";
	}

	public String[] getETMHeader(){
		ArrayList<String> headerList = this.anEtmProcessor.getHeader();
		String[] header = headerList.toArray(new String[headerList.size()]);
		return header;
	}

	public String[] getCSVHeader(){
		int size = this.aCSVProcessor.colNum;
		String [] header = new String[size+1];
		header[0] = "";
		for (int i = 1; i<=size; i++){
			header[i] = "Col "+i;
		}
		return header;
	}


	public ArrayList<ArrayList<String>> getRawETMData(){
		return this.anEtmProcessor.getRawData();
	}

	public ArrayList<ArrayList<String>> getRawCSVData(){
		return this.aCSVProcessor.getRawData();
	}
}



