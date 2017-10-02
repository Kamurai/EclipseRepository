package com.fdmgroup.fizzbuzz.task3;

public class PensionLogic 
{
	public PensionLogic()
	{
		
	}
	
	public boolean isPensionable(Person person, String year)
	{
		boolean Result = false;
		int TargetAge = 65;
		
		int PersonAge = 0;
		int BirthYear = 0;
		
		String BirthDateString = person.getBirthDate();
		
		BirthDateString = BirthDateString.substring(BirthDateString.length()-4);
		
		BirthYear = Integer.parseInt(BirthDateString);
		
		//subtract 4 digit birth year from 2014
		PersonAge = 2014 - BirthYear;
		
		if( PersonAge >= TargetAge )
		{
			Result = true;
		}
		
		return Result;
	}
}
