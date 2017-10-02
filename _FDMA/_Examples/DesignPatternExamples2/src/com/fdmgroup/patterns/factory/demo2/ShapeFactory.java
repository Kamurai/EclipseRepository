package com.fdmgroup.patterns.factory.demo2;

public class ShapeFactory {
	
	public static Shape create(String type){
		
		if(type.equalsIgnoreCase("triangle"))
			return new Triangle(); 

		if(type.equalsIgnoreCase("square"))
			return new Square();
		
		return null;
	}

}
