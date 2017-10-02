package com.fdmgroup.demos.exceptions;

import java.util.Random;

public class Client {

	public static void main(String[] args) {

		try {
			badCode();
			
		} catch (SpecificExceptionOne e) {
			System.out.println("SpecificExceptionOne was caught!");
		} catch (SpecificExceptionTwo e) {
			System.out.println("SpecificExceptionTwo was caught!");
		} catch (GeneralException e) {
			System.out.println("GeneralException was caught!");
		}

	}

	private static void badCode() throws GeneralException, SpecificExceptionOne, SpecificExceptionTwo {
		
		Random random = new Random();
	
		switch(random.nextInt(3)){
		
		case 0: throw new GeneralException();
		case 1: throw new SpecificExceptionOne();
		case 2: throw new SpecificExceptionTwo();		
		}
	}
}
