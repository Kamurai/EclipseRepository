package math3323_assignment2_kemerait;

//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 2, Problem 1


public class Problem1 
{
	public static void main(String[] args) 
	{
		int iter = 35;
		
		//Initialize expected values
			//by array
		long[] expected = new long[iter];
		
		//begin array
		expected[0] = 0;
		expected[1] = 1;
		expected[2] = 4;
		
		//fill array
		for(int x = 3; x < expected.length; x++)
		{
			expected[x] = 3*expected[x-1] - 3*expected[x-2] + expected[x-3];
		}
		
		
		//Display introduction
		displayintroduction();
		
		//Calculate values
			//initialize calculated values
				//by array
		long[] calculated = new long[iter];
		//initialize calculation time
			//by array
		double[] elapsed = new double[iter];

		//temp longs to record elapsed times
		long t0, t1;
		
		//use recursive function to find values
		for(int x = 0; x < calculated.length; x++)
		{
			t0 = System.nanoTime();
			calculated[x] = vbrf(x);
			t1 = System.nanoTime();
			elapsed[x] = (t1-t0)*1.0e-9;

			
		}
		
		//Display expected values and calculations
			//pass arrays into a method
		displayvalues(expected, calculated, elapsed);
		
		//Determine result
		displayresult(expected, calculated, elapsed);
		
		
	}

	//assistance methods
	
	//displays goal of assignment
	public static void displayintroduction() 
	{
		//engage user
		System.out.println(
				"Hello.\n" +
				//declare objective of this program
				"Today we are working with poor recursive functions.\n" +
				//display rules for subject matter
				"The rules for this function are as follows:\n\n" +
				"vbrf(0) = 0\n" +
				"vbrf(1) = 1\n" +
				"vbrf(2) = 4\n" +
				"vbrf(n) = 3*vbrf(n-1) - 3*vbrf(n-2) + vbrf(n-3)\n\n"
				);
	}
	
	//calculates the desired values for h(n)
	public static long vbrf(long n)
	{
		//if n = 0
		if( n == 0 )
		{
			//return 0
			return 0;
		}
		//if n = 1
		else if( n == 1 )
		{
			//return 1
			return 1;
		}
		//if n = 2
		else if( n == 2 )
		{
			//return 4
			return 4;
		}
		//else
		else
		{
			//apply formula: h(n) = (n-1) * ( h(n-1) + h(n-2) ) 
			return 3*vbrf(n-1) - 3*vbrf(n-2) + vbrf(n-3);
		}
	}
	
	//displays expected and calculated values
	public static void displayvalues(long[] first, long[] second, double[] third) 
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
		System.out.print(temp + "\t\t");
		
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
		System.out.print(temp + "\t\t");
		
		//store header in temp string
		temp = "    Seconds";
		
		//store temp's length as limit
		limit = temp.length();
		
		//calculate spaces
		for(int x = 0; x < spaces - limit; x++)
		{
			temp = temp + " ";
		}
		
		//output third header
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
			System.out.print(x + ": " + temp + "\t");
			
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
			System.out.print(x + ": " + temp + "\t");
			
			//if less than ten
			if( x < 10)
			{
				//add a space beforehand
				System.out.print(" ");
			}
			
			//store calculated value as temp string
			temp = Double.toString(third[x]);
			
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
	public static void displayresult(long[] first, long[] second, double[] third) 
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
					"This formula seems to represent all the square numbers.\n" +
					"A value of " + first.length + " takes approximately " + third[third.length-1] + " seconds to compute " + first[first.length-1]+".\n" +
					"A much faster way to compute a number's square would be to multiple it by itself.\n" +
					"Such as vbrf(n) = n^2.\n" +
					"Thank you for using this program.\n\n");
		}
		else
		{
			System.out.println("incorrect.\n\n" +
				"Please keep trying.\n\n");
		}
		
		
		
	
	}
}


