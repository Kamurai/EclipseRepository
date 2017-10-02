package com.fdmgroup.modifiers.staticmethods;

public class Demo {

	public static void staticMethod() {
		
		// Within a static method, we can invoke other static methods:
		
		anotherStaticMethod();
		
		
		// Instance methods belong to instances of a class.
		//
		// We cannot call them from a static method directly --
		// they must be called on a specific instance, as below:
		
		
		new Demo().anotherNonStaticMethod(); 	// No problem
		
		// anotherNonStaticMethod();			// Does not work		
		
	
	}

	public void nonStaticMethod() {
		
		// Within a non-static method, we can call both
		// static and non-static methods directly by name:
		
		anotherStaticMethod();
		anotherNonStaticMethod();  
		
	}
	
	public static void anotherStaticMethod(){}
	
	public void anotherNonStaticMethod(){}
	
	
}
