package com.fdmgroup;

import java.math.BigDecimal;

public class Book 
{
	String title;
	double price;
	
	public Book(String title, double price) 
	{
		this.title = title;
		this.price = price;
	}

	public double getPrice() 
	{
		return price;
	}

	public String getTitle()
	{
		return title;
	}

}
