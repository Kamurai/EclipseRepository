package com.fdmgroup.patterns.factorymethod;

public class SquareFactory implements ShapeFactory {

	public Shape create() {
		return new Square();
	}

}
