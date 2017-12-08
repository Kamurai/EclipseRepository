package tableCheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class processes an etm file
 * It makes sure each item is in correct format
 * It makes sure no item is missing
 * It also stores the data into different format for easy accessing. 
 * @author wai.ngai
 *
 */
public class ETMProcessor extends FileProcessor {

	/**
	 * etm enhanced flag
	 */
	private boolean etmEnhanced;
	/**
	 * a list of comments
	 */
	private ArrayList<String> comments;
	/**
	 * a list of required item based on if it is etm ehanced
	 */
	private ArrayList<String> expectedItems;
	/**
	 * a hashmap storing the rows in the etm file for fast accessing
	 */
	private HashMap<String, ArrayList<String>>rules;
	/**
	 * the engine to make sure each expression is valid
	 */
	private RuleEvaluator evaluator;
	/**
	 * The cache to speed up processing repeated items
	 */
	private HashMap<String, Boolean> processingCache;

	/**
	 * constructor
	 */
	public ETMProcessor(){
		super();
		this.type = ".etm";
		this.comments = new ArrayList<String>();
		this.etmEnhanced = false;
		this.expectedItems = this.getNonEtmEnhancedItems();
		this.rules = new HashMap<String, ArrayList<String>>();
		this.colNum = this.rules.size();
		this.evaluator = RuleEvaluator.getInstance();
	}

	@Override
	/**
	 * process the etm file
	 */
	public void processFile() {
		this.processingCache = new HashMap<String, Boolean>();
		this.rowNum = 0;
		this.openFile();
		String processedLine = ""; 
		int currentLineNum = 0;
		String st = "";
		while ((st = this.readALine()) != null)
		{
			currentLineNum++;
			processedLine = st.trim();
			//see if it is comment
			if(this.isThisLineComment(processedLine))
			{
				//checking if etmEnhanced
				if(processedLine.contains("etm enhanced"))
				{
					this.etmEnhanced = true;
					this.expectedItems = this.getEtmEnhancedItems();
					this.colNum = this.expectedItems.size();
				}
				this.comments.add(processedLine);
			}
			//comment processing end
			else if(!processedLine.equals(""))
			{
				//process a line contains a rule
				String[] items = processedLine.split(",");
				this.processALine(items, currentLineNum);
				this.rowNum++;
			}
		}
		this.closeFile();

	}

	/**
	 * Helper to help processFile() to process a line
	 * @param items, all the items in an array of stirngs
	 * @param lineNum, line number
	 */
	private void processALine(String[] items, Integer lineNum){
		LinkedList<String> itemsToLookFor = new LinkedList<String>(this.expectedItems);
		int itemsArrayCount = 0;
		ArrayList<String> aFormattedRule = new ArrayList<String>(7); //The list that will be displayed to user visually
		ArrayList<String> aRawRule = new ArrayList<String>(7); //The raw data obtained from the etm file
		ArrayList<String> aRule = new ArrayList<String>(8); //The list in the format that the program understands
		String key = ""; //The key to the hashmap that is used to store rules.
		boolean error = false;
		String textToDisplay = ""; //what to display to user on the application window
		String rawItem = ""; //the actual unmodified item from the etm file itself
		String processedItem = ""; //the rawItem that is processed to the form that the program understands. 
		String errorMessage = ""; //what to display in the error log 
		boolean errorExist = false; // this is used to notified the processor class if they can skip the processing due to an expression error. 
		while (!itemsToLookFor.isEmpty()){
			String itemToLookFor = itemsToLookFor.removeFirst();
			error = false;
			textToDisplay = ""; 
			errorMessage = "ETM Issue: "; 
			rawItem = ""; 
			processedItem = "";
			if(itemsArrayCount<items.length)
			{
				rawItem = items[itemsArrayCount];
				processedItem = rawItem.trim();
				if(itemToLookFor.equals("Column Number"))
				{
					key = processedItem;
					try 
					{ 
						Integer rowNumber = Integer.parseInt(processedItem);
						processedItem = rowNumber.toString();
						key = processedItem;
					} 
					catch(NumberFormatException e) 
					{ 
						errorMessage += "Line "+lineNum+": Expecting to start with an integer";
						error = true;
					}
				}
				else if(itemToLookFor.equals("Description"))
				{
				}
				else if(itemToLookFor.equals("Name"))
				{
					if(!processedItem.matches("[0-9]{3}"))
					{
						errorMessage += "Line "+lineNum+": Expecting a three digits column name";
						error = true;
					}
				}
				else if(itemToLookFor.equals("Confidential"))
				{
					if(!processedItem.matches("[YNyn]"))
					{
						errorMessage += "Line "+lineNum+": Expecting a Confidential Flag (Y/N)";
						error = true;
					}
				}
				else if(itemToLookFor.equals("Encrypted"))
				{
					if(!processedItem.matches("[YNyn]"))
					{
						errorMessage += "Line "+lineNum+": Expecting a Encrypted Flag (Y/N)";
						error = true;
					}
				}
				else if(itemToLookFor.equals("Expression"))
				{
					LinkedList<Character> stack = new LinkedList<Character>();
					int charAt = 0;
					while(!stack.isEmpty()||charAt<processedItem.length()) //try to combine more than one items
					{
						char aChar = processedItem.charAt(charAt);
						if (aChar == '(')
						{
							stack.addLast(aChar);
						}
						else if(aChar ==')')
						{
							if(stack.isEmpty())
							{
								errorMessage += "Line "+lineNum+": Expression Error, Parentheses Mismatch";
								error = true;
								break;
							}
							else
							{
								stack.removeLast();
							}
						}
						charAt++;
						if(charAt>=processedItem.length())
						{
							if(!stack.isEmpty())
							{
								itemsArrayCount++;
								if(itemsArrayCount<items.length)
								{
									String newItem = items[itemsArrayCount];
									rawItem += newItem;
									newItem = newItem.trim();
									processedItem = processedItem +","+newItem;
								}
								else
								{
									errorMessage += "Line "+lineNum+": Expression Error, Parentheses Mismatch";
									error = true;
									break;
								}
							}

						}
					}

				}
				else if(itemToLookFor.equals("Error Text"))
				{
					itemsArrayCount++;
					while(itemsArrayCount<items.length)
					{
						String errorText2 = items[itemsArrayCount];
						rawItem += errorText2;
						errorText2 = errorText2.trim();
						processedItem += "," + errorText2;
						itemsArrayCount++;
					}
				}
				textToDisplay = processedItem;
				itemsArrayCount++;

				if(itemToLookFor.equals("Expression"))
				{
					//making the express to a format the program understands
					processedItem = this.processExpression(processedItem, lineNum);
					boolean valid = false;
					if(this.processingCache.containsKey(processedItem)){
						valid = this.processingCache.get(processedItem);
					}else{
						valid = this.evaluator.validExpression(processedItem);
						this.processingCache.put(processedItem, valid);
					}
					if (!valid){
						errorMessage = "Line "+lineNum+": \""+processedItem+"\" is not a valid expression";
						error = true;
						errorExist = true;
					}
				}
			}
			else
			{
				textToDisplay = itemToLookFor;
				error = true;
				errorMessage += "Line "+lineNum+": Expecting "+itemToLookFor+", but not found";
			}
			if(error)
			{
				aFormattedRule.add(this.errorText(textToDisplay));
				this.errors.add(errorMessage);
			}
			else
			{
				aFormattedRule.add(textToDisplay);
			}
			aRule.add(processedItem);
			aRawRule.add(rawItem);
		}
		//add the captured data to different data structures
		this.dataToDisplay.add(aFormattedRule);
		this.rawData.add(aRawRule);
		if(errorExist)
		{
			aRule.add("true");
		}
		else
		{
			aRule.add("false");
		}
		if(this.rules.containsKey(key))
		{
			this.errors.add("ETM Issue: Line "+lineNum+": Rule already defined");
			this.dataToDisplay.remove(this.dataToDisplay.size()-1);
			this.dataToDisplay.add(this.errorRow(aFormattedRule));
			//currentRowNum--;
		}
		else
		{
			this.rules.put(key, aRule);
		}
	}

	/**
	 * Expanding (x-y) to (x,x+1,....,y-1,y)
	 * @param expression the original expression
	 * @param lineNum the line number
	 * @return
	 */
	private String processExpression(String expression, int lineNum){
		Pattern numberRange = Pattern.compile("[(,]\\s*\\d+\\s*-\\s*\\d+\\s*[,)]");
		Pattern digits = Pattern.compile("\\d+");
		Matcher rangerMatcher = numberRange.matcher(expression);
		//System.out.println(expression);
		while (rangerMatcher.find()) 
		{
			String match = rangerMatcher.group();
			match = match.substring(1,match.length()-1);
			//System.out.println("Match: "+match);
			int idx = expression.indexOf(match);
			String pre = expression.substring(0,idx);
			String post = expression.substring(idx+match.length());

			Matcher numMatcher = digits.matcher(match);
			String beginString = "";
			String endString = "";
			int begin = 0;
			int end = 0;
			if(numMatcher.find())
			{
				beginString = numMatcher.group();
			}
			else
			{
				this.errors.add("ETM Issue: Line "+lineNum+": expression invalid range");
			}
			if(numMatcher.find())
			{
				endString = numMatcher.group();
			}
			else
			{
				this.errors.add("ETM Issue: Line "+lineNum+": expression invalid range");
			}
			try
			{
				begin = Integer.parseInt(beginString);
				end = Integer.parseInt(endString);
			}
			catch(Exception e)
			{
				this.errors.add("ETM Issue: Line "+lineNum+": expression invalid range");
				System.err.println(e.toString());
			}
			match = "";
			for (int i = begin; i<=end;i++)
			{
				match +=i;
				if(i<end)
				{
					match+=",";
				}
			}
			expression = pre +match+post;
		}
		return expression;
	}

	/**
	 * Determine if a line is comment or not
	 * @param aLine, the line to be determined
	 * @return true for is comment false for otherwise
	 */
	private boolean isThisLineComment(String aLine){
		String allLowerCaseProcessedLine = aLine.toLowerCase();
		if(allLowerCaseProcessedLine.startsWith("comment"))
		{
			return true;
		}
		return false;
	}

	/**
	 * extracting a rule given the row number
	 * @param rowNum
	 * @return
	 */
	private ArrayList<String> getARule(Integer rowNum){
		String rowNumString = rowNum.toString();
		if(this.rules.containsKey(rowNumString))
		{
			return this.rules.get(rowNumString);
		}
		return null;
	}
	
	/**
	 * get column number of a given row
	 * @param rowNum
	 * @return
	 */
	public String getColumnNum(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			return aRule.get(0);
		}
		return null;
	}

	/**
	 * get description given a row
	 * @param rowNum
	 * @return
	 */
	public String getDescription(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			return aRule.get(1);
		}
		return null;
	}

	/**
	 * get the expression given a row
	 * @param rowNum
	 * @return
	 */
	public String getExpression(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			if(this.etmEnhanced)
			{
				return aRule.get(5);
			}
			else
			{
				return aRule.get(2);
			}

		}
		return null;
	}

	/**
	 * get the name given a row
	 * @param rowNum
	 * @return
	 */
	public String getName(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			if(this.etmEnhanced)
			{
				return aRule.get(2);
			}
		}
		return null;
	}

	/**
	 * get the confidential flag given a row
	 * @param rowNum
	 * @return
	 */
	public String getConfidential(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			if(this.etmEnhanced)
			{
				return aRule.get(3);
			}
		}
		return null;
	}

	/**
	 * get the encrypted flag given a row
	 * @param rowNum
	 * @return
	 */
	public String getEncrypted(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			if(this.etmEnhanced)
			{
				return aRule.get(4);
			}
		}
		return null;
	}

	/**
	 * get the error text given a row
	 * @param rowNum
	 * @return
	 */
	public String getErrorText(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			if(this.etmEnhanced)
			{
				return aRule.get(6);
			}
			else
			{
				return aRule.get(3);
			}

		}
		return null;
	}

	/**
	 * get if the expression is invalid given a row
	 * @param rowNum
	 * @return
	 */
	public boolean itemContainsError(Integer rowNum){
		ArrayList<String> aRule = this.getARule(rowNum);
		if(aRule!=null)
		{
			String hasError = aRule.get(aRule.size()-1);
			if(hasError.equals("true"))
			{
				return true;
			}
			return false; 
		}
		return false;
	}

	/**
	 * The list of items to look for for etm enhanced tables;
	 * @return
	 */
	private ArrayList<String> getEtmEnhancedItems(){
		ArrayList<String> items = new ArrayList<String>();
		items.add("Column Number");
		items.add("Description");
		items.add("Name");
		items.add("Confidential");
		items.add("Encrypted");
		items.add("Expression");
		items.add("Error Text");
		return items;
	}

	/**
	 * The list of items to look for for non etm enhanced tables
	 * @return
	 */
	private ArrayList<String> getNonEtmEnhancedItems(){
		ArrayList<String> items = new ArrayList<String>();
		items.add("Column Number");
		items.add("Description");
		items.add("Expression");
		items.add("Error Text");
		return items;
	}

	/**
	 * return if the file is etm enhanced
	 * @return
	 */
	public boolean isETMEnhanced(){
		return this.etmEnhanced;
	}

	/**
	 * return the expected items based on if it is etm enhanced or not
	 * @return
	 */
	public ArrayList<String> getExpectedItems(){
		return this.expectedItems;
	}

	/**
	 * return a list of comments captured from the etm file
	 * @return
	 */
	public List<String> getComments(){
		return this.comments;
	}

	/**
	 * determine how many rules are captured from processing the etm file. 
	 * @return
	 */
	public int getNumOfRules(){
		return this.rules.size();
	}
	
	public ArrayList<String> getHeader(){
		ArrayList<String> header = new ArrayList<String>();
		header.add("Col Num");
		header.add("Description");
		header.add("Name");
		header.add("Confidential");
		header.add("Encrypted");
		header.add("Expression");
		header.add("Error Text");
		return header;
	}
}
