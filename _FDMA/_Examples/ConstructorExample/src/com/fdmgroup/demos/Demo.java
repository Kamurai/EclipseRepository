package com.fdmgroup.demos;

public class Demo {

	public static void main(String[] args) {
		
		// What will be the output of this line of code?
		
		Car car = new Car();
		
		// What about this one?
		
		// Car car = new Car("Maserati","GranTurismo");
		
		System.out.println();
		System.out.println("Car make: "+car.getMake());
		System.out.println("Car model: "+car.getModel());
		System.out.println("Car number of wheels: "+car.getNumberOfWheels());
		System.out.println("Car size: "+car.getSize());
	}

}
