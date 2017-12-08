package tableCheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the blueprint for the CSV processor and ETM processor
 * It basically handles file IO and the backbone data structures. 
 * @author wai.ngai
 *
 */
public abstract class FileProcessor 
{
	//protected ArrayList<ArrayList<String>> comments;

	/**
	 * The data that will actually be drawn
	 */
	protected ArrayList<ArrayList<String>> dataToDisplay;
	
	/**
	 * The data representing the file itself unmodified
	 */
	protected ArrayList<ArrayList<String>> rawData;
	
	/**
	 * the number of rows in the file
	 */
	protected int rowNum;
	
	/**
	 * the number of columns in the table
	 */
	protected int colNum;
	
	/**
	 * a list of errors
	 */
	protected ArrayList<String> errors;
	
	/**
	 * a list of warnings, currently not used
	 */
	protected ArrayList<String> warnings;
	
	/**
	 * The type of file being processed
	 */
	protected String type;
	
	//file reading stuff
	protected String filename;
	protected File csvFile;
	protected FileReader fr;
	protected BufferedReader br;

	public FileProcessor()
	{
		//comments  = new ArrayList<ArrayList<String>>();
		this.dataToDisplay = new ArrayList<ArrayList<String>>();
		this.rawData = new ArrayList<ArrayList<String>>();
		this.errors = new ArrayList<String>();
		this.type = "";
		this.errors.add("No File Selected");
		this.rowNum = 0;
		this.colNum = 0;
	}

	public abstract void processFile();

	public int getRowNum()
	{
		return this.rowNum;
	}

	public ArrayList<ArrayList<String>> getDataToDisplay()
	{
		return this.dataToDisplay;
	}

	public ArrayList<ArrayList<String>> getRawData()
	{
		return this.rawData;
	}

	public void setFile(String filename)
	{
		this.filename = filename;
		this.errors.clear();
	}

	protected void openFile()
	{
		try
		{
			this.csvFile = new File(this.filename);
			if(this.fileExist())
			{
				this.fr = new FileReader(this.csvFile);
				if(this.fr != null)
				{
					this.br = new BufferedReader(this.fr);
				}
			}
			else
			{
				this.errors.add("There is a problem with the "+this.type+" file pathway.");
			}
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

	protected void closeFile()
	{
		try
		{
			if(this.br !=null)
			{
				br.close();
				if(this.fr != null)
				{
					this.fr.close();
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

	protected String readALine()
	{
		try
		{
			if(this.br!=null)
			{
				return this.br.readLine();
			}
		}
		catch(Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
		return null;
	}

	private boolean fileExist()
	{
		if(this.csvFile!= null && this.csvFile.exists())
		{
			return true;
		}
		else 
			return false;
	}

	public boolean hasError()
	{
		return !this.errors.isEmpty();
	}

	protected String errorText(String text)
	{
		String newText = text.trim();
		if(newText.equals("")&&!text.contains("<html>"))
		{
			return text;
		}
		return "<html><font color = 'red'>"+text+"</font></html>";
	}

	protected ArrayList<String> errorRow(ArrayList<String> items)
	{
		ArrayList<String> newFormattedItems = new ArrayList<String>();
		for(String anItem: items)
		{
			newFormattedItems.add(this.errorText(anItem));
		}
		return newFormattedItems;
	}
	
	protected List<String> getErrors()
	{
		
		ArrayList<String> errorList = new ArrayList<String>();
		for (String error: this.errors)
		{
			errorList.add(this.type+": "+error);
		}
		
		return errorList;
	}
}
