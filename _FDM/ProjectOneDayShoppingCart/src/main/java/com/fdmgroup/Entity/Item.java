package com.fdmgroup.Entity;

import java.math.BigDecimal;

import com.fdmgroup.Utility.Constant;

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
		this.id = Constant.invalidId();
		this.name = null;
		this.quantityAvailable = Constant.invalidId();
		this.price = Constant.minimumDollar();
		this.description = null;
	}
	
	//new constructor
	public Item(String name, int quantityAvailable, BigDecimal price, String description) 
	{
		this.id = Constant.invalidId();
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
		
		if(result < Constant.invalidId())
			result = Constant.invalidId();
		
		return result;
	}
	
	public String restrictName(String name)
	{
		String result = name;
		
		if(result.length() > Constant.maximumShortString())
			result = result.substring(0, Constant.maximumShortString());
		
		return result;
	}
	
	public int restrictQuantityAvailable(int quantityAvailable)
	{
		int result = quantityAvailable;
		
		if(result < Constant.minimumAmount())
			result = Constant.minimumAmount();
		
		return result;
	}

	public BigDecimal restrictPrice(BigDecimal price)
	{
		BigDecimal result = price;
		
		if(result.doubleValue() < Constant.minimumDollar().doubleValue())
			result = Constant.minimumDollar();
		
		return result;
	}
	
	public String restrictDescription(String description)
	{
		String result = description;
		
		if(result.length() > Constant.maximumDescription())
			result = result.substring(0, Constant.maximumDescription());
		
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
