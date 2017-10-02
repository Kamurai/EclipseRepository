package com.fdmgroup.demos;

public class Car extends GroundVehicle {
	private String make;
	private String model;
	
	public Car(){
		this("Toyota","Prius");
		System.out.println("Car() NO-ARG");
	}
	
	public Car(String make, String model){
		super(4,"car-sized");
		setMake(make);
		setModel(model);
		System.out.println("Car() TWO-ARG");
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}
