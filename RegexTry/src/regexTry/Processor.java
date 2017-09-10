package regexTry;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Processor {
	/*
	 * External Table Metafile Processing Engine
	 */

	String version = "External Table Metafile Processing Engine v1.4.1";

	/*
	 * 
	 * History v1.0 dc 2005-04-13 Initial Version - Basic Functionality v1.1 ar
	 * 2007-06-07 Added functionality for the prompts function to validate TTS
	 * prompts. v1.2 ar 2007-12-06 Added empty() to check for NULL in the cell
	 * v1.3 dec 2009-05-07 Added four new attributes: name, desc, confidential,
	 * encrypted v1.4 dec 2010-07-29 Bug fix: crashes when using -l and newline
	 * in row v1.4.1 ck 2011-10-13 Java adaption
	 */

	boolean result;
	String source;
	String regex;
	
	

	Processor() 
	{
		result = false;
		//source = "Monday Tuesday Wednesday Thursday";
		//regex = "/((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)\\w*)*/i";
	}
	
	public void setSource(String input)
	{
		source = input;
	}

	public void setRegex(String input)
	{
		regex = input;
	}

	public void attemptRegex()
	{
		try
		{
			Pattern pat = Pattern.compile(regex);
			Matcher mat = pat.matcher(source);
			result = mat.lookingAt();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public String printSource()
	{
		String output = "";
		
		output = "Source Data:\n" + source;
		
		return output;
	}
	
	public String printRegex()
	{
		String output = "";
		
		output = "Regex Data:\n" + regex;
		
		return output;
	}
	
	public String printResult()
	{
		String output = "Sorry, it didn't work.";
		
		if(result)
		{
			output = "You got it!";
		}
		
		return output;
	}
	
	
	
	
	
	
	
	
}
