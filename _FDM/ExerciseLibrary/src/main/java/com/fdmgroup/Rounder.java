package com.fdmgroup;

public class Rounder 
{
	public Rounder()
	{
		
	}
	
	public double truncateDouble(double givenDouble, int power)
	{
		double Result = 0.00;
		
		Result = Math.floor(givenDouble * Math.pow(10, power)) / Math.pow(10, power);
		
		return Result;
	}
	
	
}
