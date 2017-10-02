package com.fdmgroup.demos.enums;

/*
 * Coffee makes use of two enums. 
 * 
 * CoffeeSize limits the possible sizes to three. 
 * CoffeeSize is defined in its own file.
 * 
 * BeanType has a price that can be set using its constructor.
 * BeanType is defined inside the Coffee class.
 * 
 * */
public class Coffee 
{
	enum BeanType { 
		
		// This enum has a private value called price.
		// 
		// The value is set when the enum is created, 
		// and can be retrieved using a getter method. 
		
		ARABICA(103), JAVA(57); 
		
		private int price; 
		
		private BeanType(int p)
		{
			price = p;
		}
		
		public int getPrice()
		{
			return price;
		}	 

	}	
	
	
	
	private String name;
	private BeanType bean;
	private CoffeeSize size;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CoffeeSize getSize() {
		return size;
	}

	public void setSize(CoffeeSize size) {
		this.size = size;
	}

	public BeanType getBean() {
		return bean;
	}

	public void setBean(BeanType bean) {
		this.bean = bean;
	}
	
	
}