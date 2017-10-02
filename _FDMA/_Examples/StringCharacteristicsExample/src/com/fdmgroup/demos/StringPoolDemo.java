package com.fdmgroup.demos;

public class StringPoolDemo {
	
	public void run() {
		
		// All String literals will be placed into the String pool:
		
		String quote1 = "Do, or do not. There is no 'try'."; 
		String quote2 = "Live long and prosper.";
		String quote3 = "Do, or do not. There is no 'try'.";	// Retrieved from String pool
		
		
		System.out.println("Different objects (both in pool), different content: ");
		System.out.println();
		System.out.println("Q1 == Q2: "+ (quote1 == quote2));
		System.out.println("Q1.equals(Q2): "+ quote1.equals(quote2));
		System.out.println();

		System.out.println("Same object (in pool): ");
		System.out.println();
		System.out.println("Q1 == Q3: "+ (quote1 == quote3));
		System.out.println("Q1.equals(Q3): "+ quote1.equals(quote3));
		System.out.println();
		
		// Non-literal Strings will not be placed in the String pool:
		
		String quote4 = new String(quote1); 
		
		System.out.println("Different objects (one in pool, one outside), same content: ");
		System.out.println();
		System.out.println("Q1 == Q4: "+ (quote1 == quote4));
		System.out.println("Q1.equals(Q4): "+ quote1.equals(quote4));

	}
}
