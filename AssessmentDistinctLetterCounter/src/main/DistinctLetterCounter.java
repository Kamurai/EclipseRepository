package main;

import java.util.ArrayList;

public class DistinctLetterCounter 
{
	public DistinctLetterCounter()
	{
		
	}
	
	
	public static String DistinctInnerCount(String testString)
	{

		/*
		1.  Each word in the input string is replaced with the following: the first letter of the word, the count of
		 distinct letters between the first and last letter, and the last letter of the word. For example, 
		 "Automotive parts" would be replaced by "A6e p3s".

		2.  A "word" is defined as a sequence of alphabetic characters, delimited by any non-alphabetic characters.

		3.  Any non-alphabetic character in the input string should appear in the output string in its original 
		relative location.
		*/
		if(testString == "")
		{
			return "Empty String";
		}
		
		String finalResult = "";
		ArrayList<Character> characterCount = new ArrayList<Character>();
		ArrayList<String> workingArray = new ArrayList<String>();
		
		
		//walk through string as array
			//if first character is a letter
			//if first character is not a letter
		workingArray.add(testString.substring(0, 1));
		
		for(int x = 1; x < testString.length()-1; x++)
		{
			/*
			 Evaluate character by case
			 There are 5 cases:
			 non-alpha character
			 alpha character
				 beginning letter
				 	first character
				 	is after a non-alpha character
				 ending letter
				 	last character
				 	is before a non-alpha character
				 already counted letter
				 	currently is in the character count array
				 counted letter
				 	currently is not in the character count array
			 */
			//if alpha character
			if( Character.isLetter(testString.charAt(x)) )
			{
				//beginning letter
			 		//first character: is after a non-alpha character
				if( !Character.isLetter(testString.charAt(x-1)) )
				{
					workingArray.add(testString.substring(x, x+1));
				}
				//ending letter
			 		//last character: is before a non-alpha character
				else if( !Character.isLetter(testString.charAt(x+1)) )
				{
					workingArray.add(Integer.toString(characterCount.size()));
					characterCount.clear();
					
					workingArray.add(testString.substring(x, x+1));
				}
				//currently is not in the character count array
				else if( !characterCount.contains(testString.charAt(x)) )
				{
			 		characterCount.add(testString.charAt(x));
				}
				//already counted letter
				//currently is in the character count array
						//do nothing
			}
			//if non-alpha character
			else
			{
				workingArray.add(testString.substring(x, x+1));
			}
			
			
			
		}
		
		//if last character is a letter
		//if last character is not a letter
		if(characterCount.size() != 0)
		{
			workingArray.add(Integer.toString(characterCount.size()));
			characterCount.clear();
		}
		workingArray.add(testString.substring(testString.length()-1, testString.length()));
		
		
		
		//construct final result string
			//walk through working array and add to string
		for(int x = 0; x < workingArray.size(); x++)
		{
			finalResult = finalResult + workingArray.get(x);
		}
		
		return finalResult;
	}
	
}
