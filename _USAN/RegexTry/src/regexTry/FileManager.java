package regexTry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class FileManager 
{
	String source;
	File SourceFile;
	
	FileManager(String input)
	{
		source = input;
				
		//Files.createDirectories(Paths.get(dir));
		SourceFile = new File(source); //C:\\etmprocessor_support\\etmp_reference.txt
		try {
			SourceFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void SaveLineToFile(String input)
	{
		try
		{
			// Create file 
			FileWriter fstream = new FileWriter(source);
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
			FileReader fr = new FileReader(source);
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
	
	public void ClearFile()
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
