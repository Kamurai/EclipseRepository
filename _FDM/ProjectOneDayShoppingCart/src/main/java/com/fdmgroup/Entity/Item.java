package com.fdmgroup.Entity;

import java.math.BigDecimal;

public class Item 
{
	int id;
	String name;
	int quantityAvailable;
	BigDecimal price;
	String description;
	
	//bean constructor
	public Item() 
	{
		this.id = -1;
		this.name = null;
		this.quantityAvailable = -1;
		this.price = new BigDecimal("0.00");
		this.description = null;
	}
	
	//new constructor
	public Item(String name, int quantityAvailable, BigDecimal price, String description) 
	{
		this.id = -1;
		this.name = restrictName(name);
		this.quantityAvailable = restrictQuantityAvailable(quantityAvailable);
		this.price = restrictPrice(price);;
		this.description = restrictDescription(description);
	}
	
	//existing constructor
	public Item(int id, String name, int quantityAvailable, BigDecimal price, String description) 
	{
		this.id = restrictId(id);
		this.name = restrictName(name);
		this.quantityAvailable = restrictQuantityAvailable(quantityAvailable);
		this.price = restrictPrice(price);
		this.description = restrictDescription(description);
	}
	
	public int restrictId(int id)
	{
		int result = id;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	public String restrictName(String name)
	{
		String result = name;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
	
	public int restrictQuantityAvailable(int quantityAvailable)
	{
		int result = quantityAvailable;
		
		if(result < 0)
			result = 0;
		
		return result;
	}

	public BigDecimal restrictPrice(BigDecimal price)
	{
		BigDecimal result = price;
		
		if(result.doubleValue() < 0)
			result = new BigDecimal("0.00");
		
		return result;
	}
	
	public String restrictDescription(String description)
	{
		String result = description;
		
		if(result.length() > 300)
			result = result.substring(0, 300);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	
	
}
