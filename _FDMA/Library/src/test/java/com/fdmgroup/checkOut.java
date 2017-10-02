package com.fdmgroup;

import java.math.BigDecimal;

public class checkOut {

	public static double calculatePrice(Basket testBasket) 
	{
		Rounder rounder = new Rounder();
		
		double discount3 = 0.00;
		double discount7 = 0.00;
		double discount10 = 0.00;
		
		double TotalDiscount = 0.00;
		double DollarDiscount = 0.00;
		double TotalPrice = 0.00;
		
		int multiplier = 1;
		int size = testBasket.getBooksInBasket().size();
		
		System.out.println("Size of Basket: " + size);
		
		for( int x=0; x < size; x++)
		{
			System.out.println(testBasket.getBooksInBasket().get(x).getPrice());
			TotalPrice += testBasket.getBooksInBasket().get(x).getPrice();
		}
		
		TotalPrice = rounder.truncateDouble(TotalPrice, 2);
		
		System.out.println("Total Price: " + TotalPrice);
		
		multiplier = size / 3;
		if( multiplier > 0 )
		{
			discount3 += multiplier * .01;
		}

		System.out.println("3's discount %: " + discount3);
		
		/*
		multiplier = size / 7;
		if ( multiplier > 0 )
		{
			discount7 += multiplier * .02;
		}

		System.out.println("7's discount %: " + discount7);
		*/
		
		multiplier = size / 10;
		if ( multiplier > 0 )
		{
			discount10 += multiplier * .10;
		}

		System.out.println("10's discount %: " + discount10);
		
		TotalDiscount = discount3 + discount7 + discount10;
		
		System.out.println("Total discount %: " + TotalDiscount);
		
		
		DollarDiscount = rounder.truncateDouble((TotalPrice * TotalDiscount), 2);
		
		System.out.println("Discount: " + DollarDiscount);
		
		TotalPrice = TotalPrice - DollarDiscount;
		
		TotalPrice = rounder.truncateDouble(TotalPrice, 2);
		
		System.out.println("Total price: " + TotalPrice);
		
		System.out.println("");
		
		return TotalPrice;
	}

}
