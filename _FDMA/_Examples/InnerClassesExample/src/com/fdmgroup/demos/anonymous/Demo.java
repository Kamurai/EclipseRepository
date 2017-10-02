package com.fdmgroup.demos.anonymous;

interface Item {
	public void saySomething();
}

public class Demo {

	// This method returns an Item object:
	
	public Item myMethod() {

		// Anonymous inner classes are similar
		// to local inner classes.
		// 
		// Useful only for creating single-object
		// implementations of interfaces or extensions
		// of other classes:

		
		Item myItem = new Item(){

			@Override
			public void saySomething() {
				System.out.println("Hello from anonymous"
						+ " implementation of Item");
			}
			
		};
	
		// The above statement creates an anonymous class
		// that implements Item (with the provided class definition)
		// and immediately makes a single instance of it.
		//
		// myItem references that instance, but the class 
		// no longer exists.

		return myItem; 
	}

	
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		Item item = demo.myMethod(); 	
		
		item.saySomething();

	}

}
