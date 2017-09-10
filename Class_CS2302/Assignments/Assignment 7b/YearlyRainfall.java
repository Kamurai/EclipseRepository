//Kemerait, Christopher
//CSIS 2302
//Yearly Rainfall Class Assignment



import java.awt.*;
import javax.swing.*;

import java.lang.*;
//import java.lang.object;

public class YearlyRainfall
{
 	//Establish variables
   private double[] monthlyRainfall = new double[12];
	private double num;
	
	
	
   public void YearlyRainfall ()
   {
 		for(int x=0; x < 12; x++)
			monthlyRainfall[x] = 0;      
	}
	
	public void setMonthlyRainfall(int monthNum, double amount)
	{
		monthlyRainfall[monthNum] = amount;
	
	}
	
	public double getMonthlyRainfall(int monthNum)
	{
		return monthlyRainfall[monthNum];
	}
	
	public double getMinMonthlyRainfall()
	{
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
