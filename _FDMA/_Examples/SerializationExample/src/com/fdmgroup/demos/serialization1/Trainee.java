package com.fdmgroup.demos.serialization1;

import java.io.Serializable;

public class Trainee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Trainee(String name){
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return name;
	}
	
}
