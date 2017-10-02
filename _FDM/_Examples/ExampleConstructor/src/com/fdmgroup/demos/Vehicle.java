package com.fdmgroup.demos;

public class Vehicle {
	
	private String size;

	public Vehicle(){
		this("average size");
		System.out.println("Vehicle() NO-ARG");
	}
	
	public Vehicle(String size){
		setSize(size);
		System.out.println("Vehicle() ONE-ARG");
	}
	
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
