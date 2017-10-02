package com.fdmgroup.demos;


public class AssertExample {
	
	public static void main(String[] args){
		
		int myFive;
		
		// We know this variable SHOULD hold a five
		myFive = getFive();
		
		assert(myFive == 5);
		
		System.out.println("All good.");
		
	}
	
	public static int getFive(){
		
		// Bad code!
		return 4;
	}
	
}
