package com.fdmgroup.patterns.factorymethod;


public class Client {
	
	public static void main(String[] args){		
		
		ShapeFactory factory = new SquareFactory();
		
		Shape shape = factory.create();
		shape.draw();
	}

}
