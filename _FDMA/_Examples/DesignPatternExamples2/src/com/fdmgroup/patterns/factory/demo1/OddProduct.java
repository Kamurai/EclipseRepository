package com.fdmgroup.patterns.factory.demo1;

public class OddProduct extends Product {
	
	public OddProduct(int dm1, String dm2) {
		super(dm1, dm2);
	}

	public String toString() {
		return "(OddProduct) " + super.toString();
	}
}

