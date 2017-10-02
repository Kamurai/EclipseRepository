package math3323_assignment1_kemerait;


//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 1, Problem 1


public class Problem1 
{
	public static void main(String[] args) 
	{
		int iter = 16;
		
		//Initialize expected values
			//by array
		long[] expected = new long[iter];
		
		//begin array
		expected[0] = 1;
		expected[1] = 0;
		
		//fill array
		for(int x = 2; x < expected.length; x++)
		{
			expected[x] = (x-1)*( expected[x-1] + expected[x-2] );;
		}
		
		
		//Display introduction
		displayintroduction();
		
		//Calculate values
			//initialize calculated values
				//by array
		long[] calculated = new long[iter];
		
		//use recursive function to find values
		for(int x = 0; x < calculated.length; x++)
		{
			calculated[x] = h(x);
		}
		
		//Display expected values and calculations
			//pass arrays into a method
		displayvalues(expected, calculated);
		
		//Determine result
		displayresult(expected, calculated);
		
		
	}

	//assistance methods
	
	//displays goal of assignment
	public static void displayintroduction() 
	{
		//engage user
		System.out.println(
				"Hello.\n" +
				//declare objective of this program
				"Today we are working with recursive functions.\n" +
				//display rules for subject matter
				"The rules for this function are as follows:\n\n" +
				"h(0) = 1\n" +
				"h(1) = 0\n" +
				"h(n) = (n-1) * ( h(n-1) + h(n-2) )\n\n"
				);
	}
	
	//calculates the desired values for h(n)
	public static long h(long n)
	{
		//if n = 0
		if( n == 0 )
		{
			//return 1
			return 1;
		}
		//if n = 1
		else if( n == 1 )
		{
			//return 0
			return 0;
		}
		//else
		else
		{
			//apply formula: h(n) = (n-1) * ( h(n-1) + h(n-2) ) 
			return (n-1) * ( h( n-1 ) + h( n-2 ) );
		}
	}
	
	//displays expected and calculated values
	public static void displayvalues(long[] first, long[] second) 
	{
		//create temporary string for spacing calculations
		String temp = "0";
		//create temporary string for spacing calculations
		int limit = 0;
		
		//calculate spacing
		int spaces;
		
		//output headers
			//store header in temp string
		temp = "    Expected";
		
		//if the greatest value is longer than the initial header
		if( temp.length() > Long.toString(first[first.length-1]).length() )
		{
			spaces = temp.length();
		}
		else
		{
			spaces = Long.toString(first[first.length-1]).length();
		}
		
		//store temp's length as limit
		limit = temp.length();
		
		//calculate spaces
		for(int x = 0; x < spaces - limit; x++)
		{
			temp = temp + " ";
		}
				
		//output first header
		System.out.print(temp + "\t\t\t");
		
		//store header in temp string
		temp = "    Calculated";
		
		//store temp's length as limit
		limit = temp.length();
		
		//calculate spaces
		for(int x = 0; x < spaces - limit; x++)
		{
			temp = temp + " ";
		}
		
		//output second header
		System.out.print(temp + "\n\n");
		
		
		//output information
		for(int x = 0; x < first.length; x++)
		{
			//if less than ten
			if( x < 10)
			{
				//add a space beforehand
				System.out.print(" ");
			}
			
			//store expected value as temp string
			temp = Long.toString(first[x]);
			
			//store temp's length as limit
			limit = temp.length();
			
			//calculate spaces for expected values
			for(int y = 0; y <= ( spaces - limit ); y++)
			{
				temp = " " + temp;
			}
			//System.out.print( temp.length() );
			
			//output expected values
			System.out.print(x + ": " + temp + "\t\t");
			
			//if less than ten
			if( x < 10)
			{
				//add a space beforehand
				System.out.print(" ");
			}
			
			//store calculated value as temp string
			temp = Long.toString(second[x]);
			
			//store temp's length as limit
			limit = temp.length();
			
			//calculate spaces for calculated values
			for(int y = 0; y <= ( spaces - limit ); y++)
			{
				temp = " " + temp;
			}
			
			//output calculated values
			System.out.print(x + ": " + temp + "\n");
		}
		//output end spacing
		System.out.print("\n");
	}
	
	//displays expected and calculated values
	public static void displayresult(long[] first, long[] second) 
	{
		//initialize variables
		int x = 0;
		boolean flag = true;
		
		//loop through both array to compare them
		do
		{
			//if they don't match
			if( first[x] != second[x])
			{
				//set flag to false
				flag = false;
			}
			
			//increment counter
			x++;
		}
		//loop while x does not reach the of either array
		while( x != first.length && x != second.length);
		
		
		System.out.println("This solution is ");
		if( flag == true)
		{
			System.out.println("correct.\n\n" +
					"Thank you for using this program.\n\n");
		}
		else
		{
			System.out.println("incorrect.\n\n" +
				"Please keep trying.\n\n");
		}
		
		
		
	
	}
}


