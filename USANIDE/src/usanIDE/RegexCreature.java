package usanIDE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCreature 
{

	public RegexCreature()
	{
		
	}
	
	public String TranslateToRegexWholeWord(String input)
	{
		String output = "";
		int startIndex = 0;
		boolean startFlag = false;
		boolean endFlag   = false;
		int startPoint = 0;
		int endPoint = input.length();
		
		
		Pattern pattern = Pattern.compile("\\W");
		Matcher matcher = pattern.matcher(input.substring(0,1));
		startFlag = matcher.find();
		
		pattern = Pattern.compile("\\W");
		matcher = pattern.matcher(input.substring(input.length()-1));
		endFlag = matcher.find();
		
		
		//if first and last index are non-word character
		if((startFlag == true) && (endFlag == true))
		{
			//then apply \\B
			//output += "\\B";
			startPoint = 1;
			endPoint = input.length()-1;
		}
		//else if first and last index are word character
		else
		{
			//apply \\b
			output += "\\b";
			//output += "\\Q";
		}
		
		output += "\\Q";
		
		for(int x=startPoint; x < endPoint; x++)
		{
			if((input.charAt(x) == '\\') || (input.charAt(x) == '[') || (input.charAt(x) == ']') || (input.charAt(x) == '^') || (input.charAt(x) == '$') || (input.charAt(x) == '.') || (input.charAt(x) == '|') || (input.charAt(x) == '?') || (input.charAt(x) == '*') || (input.charAt(x) == '+') || (input.charAt(x) == '(' || (input.charAt(x) == ')')))
			{
				output += input.substring(startIndex, (x));
				output += "\\";
				startIndex = x;
			}
		}
		
		output += input.substring(startIndex, (input.length()));
		
		
		//if first and last index are non-word character
		if((startFlag == true) && (endFlag == true))
		{
			//then apply \\B
			//output += "\\B";
			output += "\\E";
		}
		//else if first and last index are word character
		else
		{
			output += "\\E";
			//apply \\b
			output += "\\b";
		}
		
		
		return output;
	}
	
	public String TranslateToRegex(String input)
	{
		String output = "";
		int startIndex = 0;
		
		for(int x=1; x < (input.length()-1); x++)
		{
			if((input.charAt(x) == '\\') || (input.charAt(x) == '[') || (input.charAt(x) == ']') || (input.charAt(x) == '^') || (input.charAt(x) == '$') || (input.charAt(x) == '.') || (input.charAt(x) == '|') || (input.charAt(x) == '?') || (input.charAt(x) == '*') || (input.charAt(x) == '+') || (input.charAt(x) == '(' || (input.charAt(x) == ')')))
			{
				output += input.substring(startIndex, (x));
				output += "\\";
				startIndex = x;
			}
		}
		
		output += input.substring(startIndex, (input.length()));
		
		return output;
	}
	
}
