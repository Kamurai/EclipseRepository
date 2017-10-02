package com.fdmgroup.fizzbuzz.task3;

public class View 
{

	public View()
	{
		
	}
	
	public void printEligible(Person person)
	{
		System.out.println(person.getFirstName() + " " + person.getLastName() + "may qualify for a pension this year.");
	}
	
	public void printIneligible(Person person)
	{
		System.out.println(person.getFirstName() + " " + person.getLastName() + " is not old enough yet.");
	}

	
}
