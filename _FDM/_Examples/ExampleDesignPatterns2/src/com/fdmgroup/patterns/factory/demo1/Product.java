package com.fdmgroup.patterns.factory.demo1;

public class Product {
	private int number;
	private String name;

	public Product(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public String toString() {
		return "Product number: " + number + " Product name: "
				+ name;
	}
}