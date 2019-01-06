package com.fanniemae.XMLFormatter;

import java.util.ArrayList;
import java.util.regex.*;

public class RegexUtility 
{
	public RegexUtility()
	{
		
	}
	
	public ArrayList<ArrayList<Integer>> regexIt(String word, String content)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub = new ArrayList<Integer>();
		
		if ( (word == null || word.equals("")) || (content == null || content.equals("")) )
		{
			result.add(new ArrayList<Integer>());
			result.get(0).add(-1);
		}
		
		String subject = TranslateToRegexWholeWord(word);
		
		String regex = "";
		
		regex = subject;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		
		int startIndex = 0;
		int endIndex = 0;
		
		while(matcher.find() == true)
		{
			startIndex = matcher.start();
			endIndex = matcher.end();
			
			sub.add(startIndex);
			sub.add(endIndex);
			result.add(new ArrayList<Integer>(sub));
			sub.clear();
		}
				
		return result;
	}
	
	public String TranslateToRegexWholeWord(String nonRegex)
	{
		String result = "";
		int startIndex = 0;
		boolean startFlag = false;
		boolean endFlag = false;
		int startPoint = 0;
		int endPoint = nonRegex.length();
		
		Pattern pattern = Pattern.compile("\\W");
		Matcher matcher = pattern.matcher(nonRegex.substring(0,1));
		startFlag = matcher.find();
		
		//if first and last index are non-word character
		if( startFlag && endFlag )
		{
			//then apply \\B
			//output += "\\B";
			startPoint = 1;
			endPoint = nonRegex.length()-1;
		}
		//else if first and last index are word character
		else
		{
			//apply \\b
			result += "\\b";
			//output += "\\Q";
		}
		
		result += "\\Q";
		
		for(int x=startPoint; x < endPoint; x++)
		{
			if( 
					(nonRegex.charAt(x) == '\\') || 
					(nonRegex.charAt(x) == '[') || 
					(nonRegex.charAt(x) == ']') || 
					(nonRegex.charAt(x) == '^') || 
					(nonRegex.charAt(x) == '$') || 
					(nonRegex.charAt(x) == '.') || 
					(nonRegex.charAt(x) == '|') || 
					(nonRegex.charAt(x) == '?') || 
					(nonRegex.charAt(x) == '*') || 
					(nonRegex.charAt(x) == '+') || 
					(nonRegex.charAt(x) == '(') || 
					(nonRegex.charAt(x) == ')')  
			)
			{
				result += nonRegex.substring(startIndex, x);
				result += "\\";
				startIndex = x;
			}
		}
		
		result += nonRegex.substring(startIndex, nonRegex.length());
		
		//if first and last index are non-word character
		if( startFlag && endFlag )
		{
			//then apply \\B
			//output += "\\B";
			result += "\\E";
		}
		//else if first and last index are word character
		else
		{
			result += "\\E";
			//apply \\b
			result += "\\b";
		}
		
		return result;
	}
	
	
	
	
	
}
