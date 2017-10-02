package com.fdmgroup.modifiers.finalvariables;

public class FinalVariableDemo {

	public final int finalNumber;
	public final StringBuffer finalStringBuffer;

	public FinalVariableDemo() {

		// Final variables must be initialized
		// in the declaration or the constructor

		finalNumber = 3;
		finalStringBuffer = new StringBuffer();

	}

	public void demo() {

		// A final variable's value cannot be
		// changed after initialization:

		// finalNumber = 4;

	
		// For a reference type variable,
		// it's "value" is the reference to the object on the heap.
		
		// We cannot change which object is being referenced,
		// but the content of the object can be altered.

		
		// Will not work:

		// finalStringBuffer = null;
		// finalStringBuffer = new StringBuffer();

		// No problem:

		finalStringBuffer.append("Hello");
		finalStringBuffer.append("World");

	}

}
