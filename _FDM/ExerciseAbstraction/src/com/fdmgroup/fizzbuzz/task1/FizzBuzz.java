package com.fdmgroup.fizzbuzz.task1;

public class FizzBuzz 
{

	public static void main(String[] args) 
	{
		boolean vDebug = true;
		
		
		// TODO Auto-generated method stub
		for(int x=0; x <= 100; x++)
		{
			if( x % 3 == 0 && x % 5 == 0)
			{
				if(vDebug)
					System.out.print( x + " "); //debug
				
				System.out.println("FizzBuzz");
			}
			else if( x % 3 == 0 )
			{
				if(vDebug)
					System.out.print( x + " Fizz"); //debug
				System.out.println( "Fizz");
			}
			else if( x % 5 == 0 )
			{
				if(vDebug)
					System.out.print( x + " Buzz"); //debug
				System.out.println( "Buzz");
			}
		}
	}

}
