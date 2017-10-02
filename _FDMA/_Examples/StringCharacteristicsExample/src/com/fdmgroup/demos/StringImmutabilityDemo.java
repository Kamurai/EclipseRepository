package com.fdmgroup.demos;

public class StringImmutabilityDemo {

	public void run(){
		
		// java.lang.String objects are immutable
		
		String immutableString = "January ";
		
		System.out.println("Basic String: " + immutableString);		
		
		immutableString.concat("February");
		immutableString.toUpperCase();
		
		System.out.println("Basic String after operations: " + immutableString + "\n");
		
		
		// java.lang.StringBuilder objects are mutable
		
		StringBuilder mutableStringBuilder = new StringBuilder("March ");
		System.out.println("StringBuilder: " + mutableStringBuilder);
		
		mutableStringBuilder.append("April");
		
		System.out.println("StringBuilder after operations: " + mutableStringBuilder + "\n");
		
		
		
		// java.lang.StringBuffer objects are mutable
		
		StringBuffer mutableStringBuffer = new StringBuffer("May ");
		System.out.println("StringBuffer: " + mutableStringBuffer);
		mutableStringBuffer.append("June");
		
		System.out.println("StringBuffer after operations: " + mutableStringBuffer + "\n");
		
	}
	
}
