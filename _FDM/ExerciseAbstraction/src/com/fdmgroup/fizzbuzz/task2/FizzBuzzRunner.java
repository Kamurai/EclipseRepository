package com.fdmgroup.fizzbuzz.task2;

public class FizzBuzzRunner 
{
	public FizzBuzzRunner()
	{
		
	}
	
	public void fizzBuzz(int number)
	{
		boolean vDebug = true;
		
		
		// TODO Auto-generated method stub
		for(int x=0; x <= number; x++)
		{
			if( fizzbuzz(x) )
			{
				if(vDebug)
					System.out.print( x + " "); //debug
				
				System.out.println("FizzBuzz");
			}
			else if( fizz(x) )
			{
				if(vDebug)
					System.out.print( x + " Fizz"); //debug
				System.out.println( "Fizz");
			}
			else if( buzz(x) )
			{
				if(vDebug)
					System.out.print( x + " Buzz"); //debug
				System.out.println( "Buzz");
			}
		}
	}
	
	private boolean fizz(int num)
	{
		if( num % 3 == 0 )
		{
			return true;
		}
		
		return false;
	}
	
	private boolean buzz(int num)
	{
		if( num % 5 == 0 )
		{
			return true;
		}
		
		return false;
	}
	
	private boolean fizzbuzz(int num)
	{
		if( num % 3 == 0 && num % 5 == 0 )
		{
			return true;
		}
		
		return false;
	}
}

