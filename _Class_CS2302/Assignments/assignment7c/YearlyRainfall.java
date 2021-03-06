//Kemerait, Christopher
//CSIS 2302
//Yearly Rainfall Class Assignment

package assignment7;

import java.awt.*;
import javax.swing.*;

import java.lang.*;
//import java.lang.object;

public class YearlyRainfall
{
 	//Establish variables
   private double[] monthlyRainfall = new double[12];
	private double num;
	
	/***********************************************
	should be a local variable - not an instance
	field
	***********************************************/
	
	
	
   public void YearlyRainfall ()
   {
 		for(int x=0; x < 12; x++)
			monthlyRainfall[x] = 0;      
	}
	
	public void setMonthlyRainfall(int monthNum, double amount)
	{
		monthlyRainfall[monthNum] = amount;
	
	/*******************************************************
	problem specifications say that monthNum runs from 1 to 12
	********************************************************/
	
	}
	
	public double getMonthlyRainfall(int monthNum)
	{
		return monthlyRainfall[monthNum];
		
		/******************************
		same commment
		*******************************/
	}
	
	public double getMinMonthlyRainfall()
	{
	
	/*************************************
	num is not initialized properly
	**************************************/
	
		//Returns: minimun monthly rainfall
		for(int x=0; x < 12; x++)
		{
			if( monthlyRainfall[x] < num )
			{
				num = monthlyRainfall[x];
			};
		}
		
		return num;
		
	}


	public double getMaxMonthlyRainfall()
	{
		//Returns: maximum monthly rainfall
		for(int x=0; x < 12; x++)
		{
			if( monthlyRainfall[x] > num )
			{
				num = monthlyRainfall[x];
			};
		}
		
		return num;
		

	}

	public double getAveMonthlyRainfall()
	{
		//Returns: average monthly rainfall
		for(int x=0; x < 12; x++)
		{
			num += monthlyRainfall[x];
		}
		
		num = num / monthlyRainfall.length;
		
		return num;
		

	}


}
