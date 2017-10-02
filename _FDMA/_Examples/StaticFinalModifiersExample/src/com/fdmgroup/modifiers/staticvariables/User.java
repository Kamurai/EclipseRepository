package com.fdmgroup.modifiers.staticvariables;

public class User {

	public static final double PI = 3.14; 	// A public static final field is called a constant
	
	public static int lastId = 0;			// Static
											// Only one "lastId" variable exists for the User class.  
											// When  its value changes, it changes for all User objects.
	
	public int id;							// Not static
											// Each User object has its own copy of this variable,
											// so each can have a different "id" value
	
	
	
	
}
