package com.fdmgroup.patterns.factorymethod;

public class TriangleFactory implements ShapeFactory{
	
	public Shape create(){
		return new Triangle();
	}

}
