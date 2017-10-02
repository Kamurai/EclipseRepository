package com.fdmgroup.demos.exceptions;

public class Demo1 {

	/**
	 * Demonstrates the normal flow of the program. 
	 * Does not handle the possibility of bad input.
	 * 
	 * When input is invalid, the program crashes
	 * with a RuntimeException. Remember that 
	 * RuntimeExceptions can be avoided completely
	 * with defensive code.
	 * 
	 * The main() method does not finish executing.
	 */

	public static void main(String[] args) {

		int result = divideStrings("8", "4");
		System.out.println("Result: "+result);
		System.out.println("All done!");
	}

	private static int divideStrings(String... stringOps) {
		
		int[] ops = new int[stringOps.length];
		
		for(int i = 0; i<stringOps.length ; i++)
			ops[i] = Integer.parseInt(stringOps[i]);
		
		return divideArray(ops);
	}

	private static int divideArray(int[] ops) {
		return divideInts(ops[0],ops[1]);
	}

	private static int divideInts(int op1, int op2) {
		return op1/op2;
	}

}
