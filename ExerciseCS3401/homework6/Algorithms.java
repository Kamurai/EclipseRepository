//Kemerait, Christopher
//CS 3401
//Homework 6

package homework6;

/*
  Write the two methods described in the attached
 specification.
 Write a test program that thoroughly
 tests the class.
 Be sure to include all of the 
necessary positive & negative tests.
WRITE A DOCUMENT THAT ANALYZES THE EFFICIENCY OF EACH METHOD.
 Submit that document as part of this assignment.
 After exchanging test programs with another student, 
follow the instructions for submitting an Eclipse program.
 */

public class Algorithms extends Object
{
	//declare variables
	
	
	
	public Algorithms()
	{
		//empty Constructor
		
	}

	//maxSortedSubString
	//Parameters:
		//arg - the string to search

///Method Case Analysis
	/*
	 The maxSortedSubString method walks through the string once
	 from the first character to the second to last, yielding
	 an O(N-1) or O(N).
	 
	 O(N)
	 */
	
	public static String maxSortedSubString(String arg)
	{
		String sortedsubstring;
		
		//if arg is empty
		if(arg.length() == 0)
		{
			//return an empty string$
			return "";			
		}
		//otherwise begin with the first character as sorted
		else
		{
			//if nothing larger than one character is found, then return the first character
			sortedsubstring = arg.substring(0, 1);
		}
		
		int index = 0;
		int length = 0;
		
		//Find the longest sorted substring of a given string 
	
//n-1	//walk through string
		for(int x = 0; x < arg.length(); x++)
		{
			//check current character against the next
				//if characters are ordered (current less than or equal to the next)
				//and if current is not the last character
			if( x != arg.length()-1 && arg.substring(x, x+1).compareTo(arg.substring((x+1), x+2)) <= 0 )
			{
				//if length = 0
				if(length == 0)
				{
				//record current as index
					index = x;
				}
				//increment length
					length++;
			}
			//else
				//if length != 0
				//or if current is last character
			else if (length != 0)
			{
				//include current character during fail or end
				length++;
					//if length > substring
					if(length > sortedsubstring.length())
					{
						//record new substring
						sortedsubstring = arg.substring(index, index+length);
					}					
					//reset length
					length = 0;
			}
			
		//move to next as current and repeat
		}
		//Returns: the sorted substring
		return sortedsubstring;
	}

	//indexOf
	//Parameters:
		//str1 - the String to search
		//str2 - the String to locate
	
///Method Case Analysis	
	/*
	 The indexOf method walks through the first string once,
	 up to the the full length minus the length of the second,
	 then one more for the final check:	 N-M+1
	 Then the second string once for each of the characters 
	 of the first that are checked: (N-M+1) * (M-1) = (N-M) * (M)
	 
	 General Case: O(NM - M^2)

///This is incorrect.  This minimizes the number of times looped through the second string
	 Worst Case: N >> M, which means M = c so (N-c+c) * (c) = 
	 Worst Case: O(N)
	 
///This is correct
	 Worst Case: M = N/2, which maximizes the number of times looped through both strings
	 N*(N/2) - (N/2)^2 = (N^2)/2 - (N^2)/4 = 2(N^2)/4 - (N^2)/4 = (N^2)/4 = O(N^2)
	 Worst Case: O(N^2)
	 
	 Best Running Case: N = M, so (N-N+1) * (N) =
	 Best Running Case: O(N)
	 
	 Best Case: M > N, and N - M yields a negative number and the for loop will not begin
	 Best Case: O(0)
	 */	
	
	
	public static int indexOf(String str1, String str2) throws IllegalArgumentException
	{
		int index = -1;
		int length = 0;
		
		//Find the position of one string in another 
		
		//Throws: IllegalArgumentException - if str2 is an empty string
		if (str2.length() == 0)
		{
			throw new IllegalArgumentException("There is no second string."); 
		}
		// If str2 does not exist in str1, returns -1
		else if(str1.contains(str2) == false)
		{
			return -1;
		}		
//N-M+1	//walk through str1
		for(int x = 0; x < str1.length()-str2.length()+1; x++)
		{
		//check current against first letter of str2
			if(str1.substring(x, x+1).equals(str2.substring(0, 1)))
			{//if match
				//record index
				index = x;
				//record length matched
				length++;
				
//*M-1			//walk through str2
				for(int y = 1; y < str2.length(); y++)
				{
					// check next character of str1 against next character of str2
					if(str1.substring((x+y), x+y+1).equals(str2.substring(y, y+1)))
					{
						//record length matched
						length++;
					}
				}
				//if length matched matches str2.length()
				if(length == str2.length())
				{
					//return index
					return index;
				}
			}
			//else
			else
			{
				//reset length and index
				length = 0;
				index = -1;				
			}							
		//check next character of str1 against first character of str2
		}				
	//Returns: index of str2 in str1.
		return index;
	}
}