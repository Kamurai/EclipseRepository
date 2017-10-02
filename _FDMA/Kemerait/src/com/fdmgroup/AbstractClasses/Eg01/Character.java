package com.fdmgroup.AbstractClasses.Eg01;

public abstract class Character 
{
	String job;
	String name;
	
	public Character()
	{
		
	}
	
	public void Attack()
	{
		System.out.println("The " + job + " attacks!");
	}
	
	public abstract void Defend();
	
}
