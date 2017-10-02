package com.fdmgroup.demos.enums;

public class CoffeeMaker 
{
	public static void main(String[] args)
	{
		Coffee decaf = new Coffee();
		
		decaf.setName("Decaf");		
		decaf.setSize(CoffeeSize.HUGE);  		// Size is restricted to enum values
		decaf.setBean(Coffee.BeanType.ARABICA);	// BeanType is also restricted
		
		System.out.println("Bean price is: " + decaf.getBean().getPrice());
		
		decaf.setBean(Coffee.BeanType.JAVA);
		
		System.out.println("Bean price is: " + decaf.getBean().getPrice());

		System.out.println("Type of coffee is: " + decaf.getName());
		System.out.println("Size of coffee is: " + decaf.getSize());
		
		
		// Every enum has a values() method that returns all of its values.
		
		Coffee.BeanType[] beans = Coffee.BeanType.values();
	
		System.out.println("\nBeanType values: ");
		for (int i=0; i<beans.length; i++)
			System.out.println(beans[i]);


	}
}