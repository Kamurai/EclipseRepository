package com.fdmgroup.patterns.factory.demo1;

public class ProductFactory {
	
	private static int idVal = 100;

	public static Product makeProduct(int number) {
		
		if (number % 2  != 0)
			return new OddProduct(number, "odd"+Integer.toString(idVal++));
		else
			return new EvenProduct(number, "even"+Integer.toString(idVal++));
	}

}
