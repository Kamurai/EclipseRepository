package com.fdmgroup.demos.inner;

public class Demo {

	public class InnerDemo {

		// This is an instance inner class --
		//
		// Instances of this class MUST be related
		// to an instance of the outer class.
		//
		// Other than that, it can be used like any
		// regular class in your application.

		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	public static void main(String[] args) {

		// InnerDemo innerDemo = new InnerDemo(); // will not work!

		Demo demo = new Demo();
		
		InnerDemo innerDemo1 = demo.new InnerDemo();
		InnerDemo innerDemo2 = demo.new InnerDemo();

		// This one is associated with a different Demo instance:
		
		InnerDemo innerDemo3 = new Demo().new InnerDemo();

	}

	// A good example is Java's Map interface, which has an inner
	// Entry interface encapsulating a single entry in the map.
	//
	// Entries cannot exist by themselves, without being associated with
	// a particular Map instance.

}
