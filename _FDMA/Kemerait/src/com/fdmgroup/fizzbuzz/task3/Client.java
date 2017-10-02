package com.fdmgroup.fizzbuzz.task3;

public class Client 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Person JohnSmith = new Person("John", "Smith", "28/06/1993");
		Person JaneDoe = new Person("Jane", "Doe", "05/01/1950");
		Person FredBloggs = new Person("Fred", "Bloggs", "12/12/1949");
		
		Person[] PersonArray = {JohnSmith, JaneDoe, FredBloggs};
		
		PensionController Controller = new PensionController();
		
		Controller.handlePensions(PersonArray);
		

	}

}
