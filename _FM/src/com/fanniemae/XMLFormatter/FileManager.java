package com.fanniemae.XMLFormatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager 
{
	//debug flags
	boolean debug = true;
			
	
	
	
	public FileManager()
	{
		
	}

	String pullFile(String fileInPathway)
	{
		String result = "";
		String line = "";
		File fileIn = new File(fileInPathway);
		
		try 
		{
			FileReader fr = new FileReader(fileIn);
			BufferedReader reader = new BufferedReader(fr);
			line = "";
			while ((line = reader.readLine()) != null)
			{
				result += line;
			}
		}
		catch (Exception e) 
		{
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		return result;
	}
	
	void writeFile(String contentString, String fileInPathway)
	{
		try
		{
			// Create file 
			FileWriter fstream = new FileWriter(fileInPathway+"_adjusted.xml");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(contentString);
			//Close the output stream
			out.close();
		}
		catch (Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());  
		}
	}
}