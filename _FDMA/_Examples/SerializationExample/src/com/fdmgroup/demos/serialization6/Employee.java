package com.fdmgroup.demos.serialization6;

public class Employee {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		
		return Integer.toString(id);
	}
}
