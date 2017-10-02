package com.fdmgroup.modifiers.staticmethods;

public class Client {

	public static void main(String[] args) {

		// Invoking an instance method
		
		Demo demoObject = new Demo();  		// must first create an instance of Demo
		demoObject.nonStaticMethod(); 		// now we can call goNonStatic() on the reference
		
		
		// Invoking a static method
		
		Demo.staticMethod();				// do not need to create any instances
		
		
		// Invoking a static method through an object reference
		// (not recommended)
		
		demoObject.staticMethod();
		
	}
}
