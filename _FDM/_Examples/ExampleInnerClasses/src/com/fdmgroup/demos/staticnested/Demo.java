package com.fdmgroup.demos.staticnested;

public class Demo {

	public static class StaticNestedDemo {
		
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	
	public static void main(String[] args){
		
		StaticNestedDemo staticDemo = new StaticNestedDemo();
		staticDemo.setMessage("hello");
		System.out.println(staticDemo.getMessage());
		
	}

}


class AnotherClass {
	void anotherMethod(){
		
		// When using the static nested class outside of its outer class,
		// it must be located using the outer class name:
		
		// StaticNestedDemo staticDemo = new StaticNestedDemo();  // will not work!
		Demo.StaticNestedDemo staticDemo = new Demo.StaticNestedDemo(); 
	}
}
