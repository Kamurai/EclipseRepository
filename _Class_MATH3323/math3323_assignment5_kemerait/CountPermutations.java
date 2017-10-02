package math3323_assignment5_kemerait;

import multinomials.PermutationGeneratorCoveyouSullivan;

//import java.util.ArrayList;

//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 3, Problem 1


public class CountPermutations {

	/**
	 * 	Try out permutation generator.
	 */
	public static void main(String[] args) 
	{
		//create an array of counters
		int counter[] = new int[11];
		
		//create strings to permutate
		String orig = "ABCDEFGHIJ";
		//create string to temporarily hold permutations
		//String perm = "0";
		
		// create a permutation generator for a particular string of characters
			//"ABCDEFGHIJ" 
		PermutationGeneratorCoveyouSullivan pg1 = new PermutationGeneratorCoveyouSullivan(orig);
		
		//ArrayList<String> permSet1 = new ArrayList<String>();
		
		//create tracker to mind how many permutations there are total
		int total = 0;
		
		//create fixed to mind how many letters are fixed permutation
		int fixed = 0;
		
		//walk through PermutationGeneratorCoveyouSullivan
		for(String perm: pg1)
		{
			//count total permutations
			total++;
			
			//reset fixed
			fixed = 0;
			
			//walk through the permutation ( 0-9 or 0 to length of string )
			for(int f = 0; f < perm.length(); f++)
			{
				//if current character is not last character
				if( f != perm.length()-1 )
				{
					//compare current character to current character of orig
					if( perm.substring(f, f+1).equals(orig.substring(f, f+1)) )
					{
						fixed++;
					}
				}
				//else if last character
				else
				{
					//compare last character to last character of orig
					if( perm.substring(f).equals(orig.substring(f)) )
					{
						fixed++;
					}
					
				}
			}
			
			//increment the appropriate counter for number of letters fixed
			counter[fixed]++;
			
		}
		
		//use method to find multinomial-coefficient
		int coeff1 = findmnc(orig);
		
		
		//display results of permutations and coefficients
		System.out.println("There are " + total + " permutations of " + orig + " and a multi-nomial of " + coeff1 + ".\n\n");
		

		//display results of counters
		for(int x = 0; x < counter.length; x++)
		{
			//display results by counting
			System.out.println("There are " + counter[x] + " permutations with " + x + " fixed letters.");
			if( x == 0 )
			{
				//display using h(n)
				System.out.println("Using h(n), there are " + h( orig.length() ) + " permutations with " + 0 + " fixed letters.");
			}
			//display using g(n, m)
			System.out.println("Using g(n, m), there are " + g( orig.length(), x ) + " permutations with " + x + " fixed letters.\n");
		}
		
	}
	
	private static long h(int n)
	{
		if( n == 0 )
		{
			return 1;
		}
		else if( n == 1 )
		{
			return 0;
		}
		else
		{
			return (n-1)*( h(n-1) +	 h(n-2) );
		}
	}
	
	private static long g(int n, int m)
	{
		//g(n,m) = binom(n,m) * h(n-m)
		return binom(n, m) * h(n-m);
	}
	
	private static long binom(int n, int m)
	{
		//binom(n,m) = n!/(m!(n-m)!)

		long answer = n;
		
		//get the numerator of the coefficient by factorial
		for(int x = n-1; x > 1; x--)
		{
			answer = answer * x;
		}
		
		
		//divide by a factorial of the first factor of the quotient
		for(int y = m; y > 1; y--)
		{
			//divide by current counter
			answer = answer / y;	
		}
		
		//divide by a factorial of the second factor of the quotient
		for(int y = (n-m); y > 1; y--)
		{
			//divide by current counter
			answer = answer / y;	
		}
		
		return answer;
	}
	
	private static int findmnc(String choice)
	{
		int counter = 1;
		
		int coeff = choice.length();
		//get the numerator of the coefficient by factorial
		for(int x = coeff-1; x > 1; x--)
		{
			coeff = coeff * x;
		}
		
		//use a variable to apply the appropriate division to determine the multi-nomial coefficient
		counter = 1;
		//get the denominator of the coefficient
		for(int x = 0; x < choice.length()-1; x++)
		{
			
			//if current character is the 2nd to last character
			if( x  == choice.length()-2)
			{
				
				//if the 2nd to last character equals the last
				if( choice.substring(x, x + 1).equals( choice.substring(x + 1) ) )
				{
					counter++;
					
					//divide by a factorial of the quotient
					for(int y = counter; y != 1; y--)
					{
						//divide by current counter
						coeff = coeff / y;
						
					}
					//reset quotient 
					counter = 1;
				}
				//else we are changing characters
				else
				{
					//divide by a factorial of the quotient
					for(int y = counter; y > 1; y--)
					{
						//divide by current counter
						coeff = coeff / y;
						
					}
					//reset quotient 
					counter = 1;
				}
			}
			//all but last examined character
			else
			{
			
				//System.out.print( string1.substring(x, x + 1) + " -- " + string1.substring(x + 1, x+2) + "\n" );
				
				//if the current character equals the next
				if( choice.substring(x, x + 1).equals( choice.substring(x + 1, x+2) ) )
				{
					
					counter++;
				}
				//else we are changing characters
				else
				{
					//divide by a factorial of the quotient
					for(int y = counter; y > 1; y--)
					{
						//divide by current counter
						coeff = coeff / y;
						
					}
					//reset quotient 
					counter = 1;
				}
			}
		}
		
		return coeff;
	}

}
