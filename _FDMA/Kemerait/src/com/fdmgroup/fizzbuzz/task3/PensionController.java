package com.fdmgroup.fizzbuzz.task3;

public class PensionController 
{
	PensionLogic Logic;
	View TheView;
	
	public PensionController()
	{
		Logic = new PensionLogic();
		TheView = new View();
	}
	
	public void handlePensions(Person[] people)
	{
		for( int x = 0; x < people.length; x++)
		{
			if(Logic.isPensionable(people[x], "2014"))
			{
				TheView.printEligible(people[x]);
			}
			else
			{
				TheView.printIneligible(people[x]);
			}
		}
	}
	
}
