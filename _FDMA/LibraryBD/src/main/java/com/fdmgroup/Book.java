package com.fdmgroup;

import java.math.BigDecimal;

public class Book 
{
	String title;
	BigDecimal price;
	
	public Book(String title, BigDecimal price) 
	{
		this.title = title;
		this.price = price;
	}

	public BigDecimal getPrice() 
	{
		return price;
	}

	public String getTitle()
	{
		return title;
	}

}
