package com.fdmgroup.demos;

public class GroundVehicle extends Vehicle {
	private int numberOfWheels;

	public GroundVehicle(){
		this(4);
		System.out.println("GroundVehicle() NO-ARG");
	}
	
	public GroundVehicle(int numberOfWheels){
		setNumberOfWheels(numberOfWheels);
		System.out.println("GroundVehicle() ONE-ARG");
	}
	
	public GroundVehicle(int numberOfWheels, String size){
		super(size);
		setNumberOfWheels(numberOfWheels);
		System.out.println("GroundVehicle() TWO-ARG");
	}
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
}
