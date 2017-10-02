package com.fdmgroup.demos.defensive;

public class Client {

	public static void main(String[] args) {
		demoCastingIssue();
		//demoDivisionIssue();
		//demoNullReferenceIssue();
	}

	private static void demoCastingIssue() {

		// Valid input
		NonDefensiveCode.downcast(new String("hi")); 	
		
		// Bad input - crashes!
		NonDefensiveCode.downcast(new Object());		
		
		// Valid input
		//DefensiveCode.downcastToString(new String("hi")); 	
		
		// Bad input - Fails, but does not crash
		//DefensiveCode.downcastToString(new Object());			
	}

	private static void demoDivisionIssue() {
		
		// Valid input
		NonDefensiveCode.divide(4, 2);	
		
		// Bad input - crashes!
		NonDefensiveCode.divide(4, 0);	
		
		// Valid input
		//DefensiveCode.divide(4, 2);		
		
		// Bad input - Fails, but does not crash
		//DefensiveCode.divide(4, 0);
		
	}

	private static void demoNullReferenceIssue() {

		// Valid input
		NonDefensiveCode.callToString(new String("hello")); 

		// Bad input - crashes!
		NonDefensiveCode.callToString(null); 				
		
		// Valid input
		//DefensiveCode.callToString(new String("hello"));	

		// Bad input - Fails, but does not crash
		//DefensiveCode.callToString(null);			
		
	}

}
