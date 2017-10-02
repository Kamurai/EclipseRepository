package main;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileManager 
{
	String reference;
	File ReferenceFile;
	String keyWordsSource;
	File keyWords;
	String target;
	File TargetFile;
	
	FileManager(String input)
	{
		reference = input;
		keyWordsSource = "keyWords.csv";
				
		//Files.createDirectories(Paths.get(dir));
		ReferenceFile = new File(reference); //C:\\etmprocessor_support\\etmp_reference.txt
		try 
		{
			ReferenceFile.createNewFile();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		keyWords = new File(keyWordsSource);
		try {
			keyWords.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String separateFilename(String input)
	{
		String output = "";
		boolean result = true;
		String filepathway = input.toLowerCase();
		
		
		if(filepathway.length() < 4)
		{
			return "default.htkb";
		}
		
		if(filepathway.substring(filepathway.length()-4,filepathway.length()).compareTo(".app") != 0)
		{
			return "default.htkb";
		}
		
		for(int x=(filepathway.length()-1); x > (-1); x--)
		{
			if(filepathway.charAt(x) == '\\')
			{
				output = filepathway.substring(x+1,filepathway.length());
				break;
			}
		}
		
		
		if(!result)
		{
			output = "default.htkb";
		}
		
		return output;
	}
	
	
	public ArrayList<ArrayList<String>> pullKeyWords()
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		String keyWords = "";
		int tracker = 0;
		int row = 0;
		int column = 0;
		int startIndex = 0;
		int endIndex = 0;
		int limit = 0;
		
		//check for keyWords file
		//if does not exist???
			//then create blank file
		//else
			//pull file
		
		keyWords = PullFile("keyWords.csv");
		
		output.add(new ArrayList<String>());
		limit = keyWords.length();
		
		//interpret table
		while( tracker < limit)
		{
			if( (keyWords.charAt(tracker) == ',') || (keyWords.charAt(tracker) == '\n'))
			{
				endIndex = (tracker);
				//assign to keyWords
				output.get(row).add(keyWords.substring(startIndex, endIndex));
				column++;
				startIndex = (tracker+1);
			
				//assumes number of columns
				if((((column) % 4) == 0) && (tracker < (limit-1)))
				{
					output.add(new ArrayList<String>());
					row++;
					column = 0;
				}
			}
			tracker++;
		}
		//remove headers
		output.remove(0);
		
		
		return output;		
	}
	
	//highlights are misaligned when using this method
	public String SpeedPullFile(String alpha) throws java.io.IOException
	{
		String output = "";
		String charsetName = null;
		
		java.io.InputStream is = new java.io.FileInputStream(alpha);
		
		try
		{
			final int bufsize = 1024;
			int available = is.available();
			byte data[] = new byte[available < bufsize ? bufsize : available];
			int used = 0;
			
			while(true)
			{
				if(data.length - used < bufsize)
				{
					byte newData[] = new byte[data.length << 1];
					System.arraycopy(data, 0, newData, 0, used);
					data = newData;
				}
				int got = is.read(data, used, data.length - used);
				if(got <= 0) break;
				used += got;
			}
			return charsetName != null ? new String(data, 0, used, charsetName): new String(data,0,used);
			
		}
		finally
		{
			is.close();
		}
		
		
		
		//return output;	
	}
	
	//highlights are misaligned similar to "SpeedPullFile"
	public String PullFileFaster(String alpha) 
	{
		// initialize files
		File Charmander;
		
		// output result
		String output = "";
		
		Charmander = new File(alpha);
		
		
		
		try 
		{
			output = FileUtils.readFileToString(Charmander);
		}
		catch (Exception e) {
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		// output result
		return output;
	}
	
	public String PullFile2(String alpha) 
	{
		// output result
		String output = "";
		
		target = alpha;
		TargetFile = new File(target);
		
		try 
		{
			FileReader fr = new FileReader(TargetFile);
			BufferedReader reader = new BufferedReader(fr);
			String st = "";
			while ((st = reader.readLine()) != null)
			{
				output += st + "\n";
			}
		}
		catch (Exception e) {
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		// output result
		return output;
	}
	
	public String PullFile(String alpha) 
	{
		// initialize files
		File Charmander;
		
		// output result
		String output = "";
		
		Charmander = new File(alpha);
		
		try 
		{
			FileReader fr = new FileReader(Charmander);
			BufferedReader reader = new BufferedReader(fr);
			String st = "";
			while ((st = reader.readLine()) != null)
			{
				output += st + "\n";
			}
		}
		catch (Exception e) {
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		// output result
		return output;
	}
	
	public void SaveLineToReference(String input)
	{
		try
		{
			// Create file 
			FileWriter fstream = new FileWriter(reference);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(input);
			//Close the output stream
			out.close();
		}
		catch (Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());  
		}
	}
	
	public void SaveToFile(String input)
	{
		try
		{
			// Create file 
			FileWriter fstream = new FileWriter(target);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(input);
			//Close the output stream
			out.close();
		}
		catch (Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());  
		}
	}
	
	public String GetLineFromFile(int index)
	{
		String output = "";
		int tracker = 0;
		

		try 
		{
			FileReader fr = new FileReader(reference);
			BufferedReader reader = new BufferedReader(fr);
			String st = "";
			while ((st = reader.readLine()) != null) //wtf?
			{
				if(tracker == index)
				{
					return st;
				}
								
				tracker++;
			}
		}
		catch (Exception e) 
		{
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return output;		
	}
	
	public String GetLineFromReference(int index)
	{
		String output = "";
		int tracker = 0;
		

		try 
		{
			FileReader fr = new FileReader(reference);
			BufferedReader reader = new BufferedReader(fr);
			String st = "";
			while ((st = reader.readLine()) != null) //wtf?
			{
				if(tracker == index)
				{
					return st;
				}
								
				tracker++;
			}
		}
		catch (Exception e) 
		{
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return output;		
	}
	
	public void ClearReferenceFile()
	{
		try
		{
			
		}
		catch (Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());  
		}
	}
	
}
