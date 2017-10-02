//Masom Hamadeh
//MATH 3323 - A5s

package a5_CountPermutations;

import java.util.*;
import multinomials.*;

public class CountPermutations
 {

	//Write a program that generates all the permutations of the string "ABCDEFGHIJ". 
	//Count how many permutations fix no elements, fix 1 element and so on. Display these results. 
	//Compute the function g described in Counting Permutations and compare with your actual count.
	
	public static void main(String[] args)
	{
		String test = "ABCDEFGHIJ";
		PermutationGeneratorCoveyouSullivan p = new PermutationGeneratorCoveyouSullivan(test);
		
		int[] counters = new int[test.length()+1]; //array used to add to counters
		
		//using the h function to display how many permutations there are with test.length() elements and ZERO fixed - comparing to this.
		long testH = h(test.length());
		System.out.println("Using the h function:\nThe number of permutations with " + test.length() + " elements and ZERO fixed elements is: [" + testH +"]\n");
		
		//using the g function to display how many permutations there are with test.length() elements and "i" fixed elements - comparing to this
		System.out.println("Using the g function:");
		for (int i = 0; i < test.length()+1; i++)
		{
			long gTest = g(test.length(), i);
			System.out.println("The number of permutations with " + test.length() + " elements and " + i + " fixed elements is: [" + gTest + "]");
		}
		
		//now we are going to be using the brute force way of how to do counting - manually and then compare
		System.out.println("\nUsing my brute force technique to figure out the number of permutations:");
		for (String s : p)
		{
			int controller = 0; //controller variable that will reset for every loop - for each seperate index
			
			for (int i = 0; i < test.length(); i++) //this is the tester to compare the characters at each index
			{
				if (s.charAt(i) == test.charAt(i))
					controller++;
			}
			
			counters[controller]++; //I'm still not understanding how these counters are working: I know it works, but how does it know what index to be in?
		}
		
		for (int i = 0; i < counters.length; i++)
			System.out.println("With " + i + " fixed elements, there are: [" + counters[i] + "] permutations");
		
		/**********************************
		 * Finally, my methods and brute force technique are correct do to the equality of the different functions/parameters as well as my brute force technique!
		 * I also checked different test strings including my name, etc and they are also equal.
		 * 
		 * Questions: One thing I noticed in the sequence is that g(test.length(), 0) and g(test.length(), 1) are somehow related b/c there is a difference of ONE?? 
		 * Is this true for all strings?
		 *********************************/
	}
	
	public static long h (int n)
	{
		//h function recursively found - iterative way may be better
		if (n == 1)
	    	return 0;
	    else if (n == 2)
	    	return 1;
	    else 
	    	return (n-1)*(h(n-1)+h(n-2));
	}
	
	public static long g (int n, int m)
	{
		//g function method that will the multinomials method within the multinomials class to find binom
			//we got to set up some pre conditions - or else we get an overflow
		if (n == m)
			return 1;
		else if (m == n-1)
			return 0;
		else
			return Multinomials.multinomial((n-m), m) * h(n-m); 
	}
	
}
