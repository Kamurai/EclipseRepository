package common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import validation.ComputeError;

public class Utility {
	
	public Utility(){}
	
	public static LocalTime setTime(String subject)
	{
		LocalTime result = null;
		
		//confirm given string is a Time
		if(ComputeError.isTime(subject))
		{
			//substring out given string to integers for LocalTime
			result = LocalTime.of(
					Integer.parseInt(subject.substring(0,1)), 
					Integer.parseInt(subject.substring(3,4)), 
					Integer.parseInt(subject.substring(6,7))
					);
		}
		
		return result;
	}
	
	public static LocalDate setDate(String subject)
	{
		LocalDate result = null;
		
		//confirm given string is a Date
		if(ComputeError.isDate(subject))
		{
			//substring out given string to integers for LocalDate
			result = LocalDate.of(
					Integer.parseInt(subject.substring(0,4)), 
					Integer.parseInt(subject.substring(5,7)), 
					Integer.parseInt(subject.substring(8,10))
					);
		}
				
		return result;
	}
	
	public static LocalDateTime setDateTime(String subject)
	{
		LocalDateTime result = null;
		LocalDate date = null;
		LocalTime time = null;
		String dateValue = subject.substring(0,10);
		String timeValue = subject.substring(11,19);
		
		//LocalDateTime.of(LocalDate.of(2000,1,1), LocalTime.of(0,0,0))
		
		//confirm given string is a DateTime
		if(ComputeError.isDateTime(subject))
		{
			if(ComputeError.isDate(dateValue))
			{
				date = setDate(dateValue);
			}
			
			if(ComputeError.isTime(timeValue))
			{
				time = setTime(timeValue);
			}
			
			result = LocalDateTime.of(date, time);
		}
		
		return result;
	}

}
