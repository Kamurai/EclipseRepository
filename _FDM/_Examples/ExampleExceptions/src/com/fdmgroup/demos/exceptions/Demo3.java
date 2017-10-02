package com.fdmgroup.demos.exceptions;

public class Demo3 {

	/**
	 * To regain control over the program, we can catch
	 * InvalidInputException in the main() method.
	 * 
	 * Now when the input is invalid, the program does not crash. 
	 * We log the stack trace and output a neat message to the user.
	 * 
	 * The main() method is able to continue executing, even if input is invalid.
	 * 
	 * Note: If we catch InvalidInputException in main(), main() no longer
	 * "throws" the exception, so we can remove its "throws" declaration.
	 */

	public static void main(String[] args) {

		int result;

		try {
			result = divideStrings("8", "0");
			System.out.println("Result: " + result);

		} catch (InvalidInputException exception) {
			
			// First, the exception should be logged,
			// if a logging mechanism is set up:
			//
			// log.error(exception); 

			// We should also provide a way to "recover" from the
			// fact that divideStrings() failed. In this case,
			// a user-friendly message should be sufficient.

			System.out.println("Division could not complete: "
					+ exception.getMessage());
		}

		System.out.println("All done!");
	}

	private static int divideStrings(String... stringOps)
			throws InvalidInputException {

		// Checks that all strings contain only digits
		for (int i = 0; i < stringOps.length; i++) {
			for (int j = 0; j < stringOps[i].length(); j++) {
				if (!Character.isDigit(stringOps[i].charAt(j)))
					throw new InvalidInputException(
							"Strings must contain numeric values.");
			}
		}

		int[] intOps = new int[stringOps.length];

		for (int i = 0; i < stringOps.length; i++)
			intOps[i] = Integer.parseInt(stringOps[i]);

		return divideArray(intOps);
	}

	private static int divideArray(int[] intOps) throws InvalidInputException {
		if (intOps.length != 2)
			throw new InvalidInputException("Array must have two elements.");

		return divideInts(intOps[0], intOps[1]);
	}

	private static int divideInts(int op1, int op2)
			throws InvalidInputException {
		if (op2 == 0)
			throw new InvalidInputException("Divisor cannot be zero.");

		return op1 / op2;
	}

}
