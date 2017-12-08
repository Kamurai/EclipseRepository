package tableCheck;

import java.util.ArrayList;

/**
 * This class process the csv file into data structures the program understands
 * It makes sure all rows have the correct number of columns
 * @author wai.ngai
 *
 */
public class CSVProcessor extends FileProcessor {

	/**
	 * The comments captured from the csv file
	 */
	private ArrayList<ArrayList<String>> comments;

	/**
	 * constructor
	 */
	public CSVProcessor(){
		super();
		this.comments = new ArrayList<ArrayList<String>>();
		this.colNum = -1; //if it is -1, the number of columns will be set dynamically
		this.type = ".csv";
	}

	@Override
	/**
	 * To process a csv file
	 */
	public void processFile() {
		this.openFile();
		this.rowNum = 0;
		int tracker = 0;
		int index = 0;
		int lineNum = 0;
		boolean tumble = false;
		boolean isComment = false;
		ArrayList<String> sub = new ArrayList<String>();
		String st = "";
		while ((st = this.readALine()) != null) 
		{
			lineNum++;
			if (!st.equals("")) 
			{
				if (st.substring(0, 1).equals(";")) 
				{
					//handle comments

					st = st.substring(1);
					isComment = true;
				}
				tracker = 0;
				index = 0;
				//colcounter = 0;
				// walk through line and write to Array List
				//this does not compensate for lazy spaces
				while (tracker < st.length()) 
				{
					if (st.charAt(tracker) == ',' && !tumble) 
					{
						String anItem = st.substring(index, (tracker));
						sub.add(anItem);
						if((tracker +1) != st.length())
						{
							index = (tracker + 1);
						}
					} 
					else if (tumble && st.charAt(tracker) == '"') 
					{
						tumble = false;
					}
					else if (st.charAt(tracker) == '"' && !tumble) 
					{
						tumble = true;
					}

					if ((tracker+1) == st.length() && st.charAt(tracker) != ',' )
					{
						String anItem = st.substring(index, (tracker+1));
						//spaces are part of a csv file, so shouldn't be trimmed
						//anItem = anItem.trim();
						sub.add(anItem);
						//sub.add(st.substring(index, (tracker+1)));
					}
					else if((tracker+1) == st.length() && st.charAt(tracker) == ',' )
					{
						sub.add("");
					}

					tracker++;
				}
				if(isComment)
				{
					this.comments.add(new ArrayList<String>(sub));
					isComment = false;
				}
				else
				{
					this.rawData.add(new ArrayList<String>(sub));
					this.rowNum++;
					if(this.colNum==-1)
					{
						this.colNum = sub.size();
					}
					else
					{
						if(sub.size()!=this.colNum)
						{
							this.errors.add("Line "+lineNum+": Expecting "+this.colNum+" columns, but got "+sub.size()+"!");
							sub = this.errorRow(sub);
						}
					}
					this.dataToDisplay.add(new ArrayList<String>(sub));
				}
				sub.clear();
			}
		}
		this.closeFile();		
	}
	
	/**
	 * set the column number
	 * @param colNum
	 */
	public void setColNum(int colNum){
		this.colNum = colNum;
	}

	/**
	 * getting the list of comments
	 * @return
	 */
	public ArrayList<ArrayList<String>> getComments(){
		return this.comments;
	}

	
}
