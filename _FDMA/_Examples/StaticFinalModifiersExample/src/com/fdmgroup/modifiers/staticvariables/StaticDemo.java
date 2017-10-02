package com.fdmgroup.modifiers.staticvariables;

public class StaticDemo {


	public static void main(String[] args){
		
		
		// A static field can (and should) be accessed through the class name:
		
		System.out.println( "lastId start value: "+ User.lastId + "\n");
		
		// An instance field cannot be accessed in this way:
		
		// System.out.println( User.id );
	
		
		// As we create user objects and increment "lastId", its
		// value changes for all User objects that exist.
		
		User user1 =  new User();
		user1.lastId++;
		user1.id = user1.lastId;	
		
		System.out.println("user1.id: " + user1.id);
		System.out.println("user1.lastId: " + user1.lastId + "\n" );
		
		User user2 =  new User();
		user2.lastId++;
		user2.id = user2.lastId;
		
		System.out.println("user2.id: " + user2.id);
		System.out.println("user1.lastId: " + user1.lastId);
		System.out.println("user2.lastId: " + user2.lastId + "\n");
		
		
		User user3 =  new User();
		user3.lastId++;
		user3.id = user3.lastId;
		
		System.out.println("user3.id: " + user3.id);
		System.out.println("user1.lastId: " + user1.lastId);
		System.out.println("user2.lastId: " + user2.lastId);
		System.out.println("user3.lastId: " + user3.lastId);
		
		
		
		// Eclipse gives a warning about accessing 
		// lastId in this way. It should be accessed through
		// the class name instead:  User.lastId


	}
	
}
