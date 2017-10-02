package com.fdmgroup.demos.methodlocal;

interface Item {
	public void saySomething();
}

public class Demo {

	// This method returns an Item object
	public Item myMethod() {

		int x = 3;

		// Local inner classes are most useful as
		// a way to implement interfaces or extend
		// other classes:

		class LocalInner implements Item {

			@Override
			public void saySomething() {
				System.out.println(getMessage());
			}

			private String getMessage(){
				return "Hi from LocalInner!";
			}

		}

		/*
		 * Can instantiate it the usual way, as long as this comes after the
		 * class definition
		 */

		LocalInner myLocalInner = new LocalInner();

		return myLocalInner; // Once this object is returned, the class
								// LocalInner no longer exists. However, 
								// the myLocalInner object can still be
								// useful as an implementation of Item.
	}

	public void anotherMethod() {

		// What if there is another method in the same (outer) class
		// that defines a local inner class with the same name?

		class LocalInner {
			// Ceases to exist when the method returns
		}

		LocalInner localInner = new LocalInner();

	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		Item item = demo.myMethod(); // Actually returns a LocalInner
										// object, but the LocalInner class
										// no longer exists.
		item.saySomething();

	}

}
