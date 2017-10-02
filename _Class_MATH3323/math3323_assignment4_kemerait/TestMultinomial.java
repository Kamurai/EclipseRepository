package math3323_assignment4_kemerait;

import java.util.Set;
import java.util.TreeSet;

import multinomials.PermutationGeneratorCoveyouSullivan;


//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 3, Problem 1


public class TestMultinomial {

	/**
	 * 	Try out permutation generator.
	 */
	public static void main(String[] args) 
	{
		//create strings to permutate
		String string1 = "AAAA";
		String string2 = "AABB";
		String string3 = "AABBBCCC";
		String string4 = "ABBCCCDDDD";
		
		
		//prompt user
		System.out.println("Program is processing...1");
		
		// create a permutation generator for a particular string of characters
		//"AAAA" 
		PermutationGeneratorCoveyouSullivan pg1 = new PermutationGeneratorCoveyouSullivan(string1);
		//"AABB"
		PermutationGeneratorCoveyouSullivan pg2 = new PermutationGeneratorCoveyouSullivan(string2);
		//"AABBBCCC"
		PermutationGeneratorCoveyouSullivan pg3 = new PermutationGeneratorCoveyouSullivan(string3);
		//"ABBCCCDDDD"
		PermutationGeneratorCoveyouSullivan pg4 = new PermutationGeneratorCoveyouSullivan(string4);
		
		
		
		// Create permutations and count them by making a set of them
		Set<String> permSet1 = new TreeSet<String>();
		Set<String> permSet2 = new TreeSet<String>();
		Set<String> permSet3 = new TreeSet<String>();
		Set<String> permSet4 = new TreeSet<String>();
		
		//add permutations to respective sets
		for(String s: pg1) {
			permSet1.add(s);
		}
		//use method to find multinomial-coefficient
		int coeff1 = findmnc(string1);
		
		//prompt user
		System.out.println("Program is processing...2");
				
		for(String s: pg2) {
			permSet2.add(s);
		}
		//use method to find multinomial-coefficient
		int coeff2 = findmnc(string2);
		
		//prompt user
		System.out.println("Program is processing...3");
		
		for(String s: pg3) {
			permSet3.add(s);
		}
		//use method to find multinomial-coefficient
		int coeff3 = findmnc(string3);
		
		//prompt user
		System.out.println("Program is processing...4");
		
		for(String s: pg4) {
			permSet4.add(s);
		}
		//use method to find multinomial-coefficient
		int coeff4 = findmnc(string4);
		
		//prompt user
		System.out.println("Program is processing...5");
		
		//display results of permutations and coefficients
		System.out.println("There are " + permSet1.size() + " permutations of AAAA and a multi-nomial of " + coeff1 + ".");
		System.out.println("There are " + permSet2.size() + " permutations of AABB and a multi-nomial of " + coeff2 + ".");
		System.out.println("There are " + permSet3.size() + " permutations of AABBBCCC and a multi-nomial of " + coeff3 + ".");
		System.out.println("There are " + permSet4.size() + " permutations of ABBCCCDDDD and a multi-nomial of " + coeff4 + ".");
		//System.out.println("6! = 720");
		

	}
	
	private static int findmnc(String choice)
	{
		int counter = 1;
		
		int coeff = choice.length();
		//get the numerator of the coefficient by factorial
		for(int x = coeff-1; x != 1; x--)
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
					for(int y = counter; y != 1; y--)
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
					for(int y = counter; y != 1; y--)
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
