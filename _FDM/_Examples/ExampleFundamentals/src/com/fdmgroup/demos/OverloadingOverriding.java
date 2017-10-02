package com.fdmgroup.demos;

public class OverloadingOverriding {

	public static void main(String[] args) {

		Animal demoAnimal = new Dog();
		demoAnimal.eat("salad");
		Dog demoDog = new Dog();
		demoDog.eat();
	}

}

class Animal {

	public void eat(String food) {
		System.out.println("Animal eating "+food);

	}

}

class Dog extends Animal {

	@Override
	public void eat(String food) {
		System.out.println("Dog eating "+food);

	}

	// Overload
	public void eat() {
		System.out.println("Dog eating dog food");

	}
}
