package com.fdmgroup.patterns.factory.demo1;

public class EvenProduct extends Product {
	
	public EvenProduct(int dm1, String dm2) {
		super(dm1, dm2);
	}

	public String toString() {
		return "(EvenProduct) " + super.toString();
	}
}
