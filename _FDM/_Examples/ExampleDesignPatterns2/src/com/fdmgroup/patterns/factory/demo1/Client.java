package com.fdmgroup.patterns.factory.demo1;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		List<Product> products = new ArrayList<Product>();

		for (int i = 0; i < 10; i++) {
			products.add(ProductFactory.makeProduct(i));
		}

		for (Product product : products) {
			System.out.println(product);
		}
	}
}
