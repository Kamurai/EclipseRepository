package com.fdmgroup.demos.exceptions;

public class Demo2 {

	/**
	 * Demonstrates use of defensive code to prevent RuntimeExceptions,
	 * and use of custom exceptions to pass along information about 
	 * the problem.
	 * 
	 * This forces the methods to add a throws declaration.
	 * 
	 * When input is invalid, the program still crashes,
	 * but now with a checked exception - InvalidInputException. 
	 * Its stack trace is printed to the console.
	 * 
	 * The main() method does not finish executing.
	 */
	
	public static void main(String[] args) throws InvalidInputException {

		int result = divideStrings("8", "0");
		System.out.println("Result: "+result);
		System.out.println("All done!");
	}

	private static int divideStrings(String... stringOps) throws InvalidInputException {
		
		// Checks that all strings contain only digits
		for (int i = 0; i <stringOps.length; i++){
			for (int j = 0; j < stringOps[i].length(); j++) {
				if(!Character.isDigit(stringOps[i].charAt(j)))
					throw new InvalidInputException("Strings must contain numeric values.");	
			}
		}

		int[] intOps = new int[stringOps.length];
		
		for(int i = 0; i<stringOps.length ; i++)
			intOps[i] = Integer.parseInt(stringOps[i]);
		
		return divideArray(intOps);
	}

	private static int divideArray(int[] intOps) throws InvalidInputException {
		if(intOps.length != 2)
			throw new InvalidInputException("Array must have two elements.");
		
		return divideInts(intOps[0],intOps[1]);
	}

	private static int divideInts(int op1, int op2) throws InvalidInputException {
		if(op2 == 0)
			throw new InvalidInputException("Divisor cannot be zero.");
		
		return op1/op2;
	}
	

}
