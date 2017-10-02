package com.fdmgroup.AbstractClasses.Eg06;

public class Monkey implements SecondInterface
{
	String name;
	
	public Monkey(String name)
	{
		this.name = name;
	}

	@Override
	public void Swing()
	{
		System.out.println("The Monkey swings.");
	}

	@Override
	public void EatFruit() 
	{
		System.out.println("The Monkey eats fruit.");
	}

}
