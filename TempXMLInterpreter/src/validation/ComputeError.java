package validation;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.w3c.dom.Node;

public abstract class ComputeError 
{
	//Does the subject exist?
	public static boolean isThere(Object subject)
	{
		boolean result = false;
		
		try
		{
			if(subject.equals(null))
			{
				result = false;
			}
			else
			{
				result = true;
			}
		}
		catch(NullPointerException e)
		{
			result = false;
		}
		
		return result;
	}
	
	//Does the subject exist, but is empty?
	public static boolean isEmpty(String subject)
	{
		boolean result = false;
		
		if(!isThere(subject))
			result = true;
		else
		{
			switch(subject)
			{
				case "":
					result = true;
					break;
				default:
					result = false;
					break;
			}
		}
		
		return result;
	}
	
	//Is the subject string a valid boolean?
	public static boolean isBoolean(String subject)
	{
		boolean result = false;
		
		if(isEmpty(subject))
			result = false;
		else
		{
			switch(subject.toLowerCase())
			{
				case "true":
					result = true;
					break;
				case "false":
					result = true;
					break;
				case "y":
					result = true;
					break;
				case "n":
					result = true;
					break;
				default:
					result = false;
					break;
			}
		}
		
		return result;
	}
	
	//Does the string contain a negative zero, e.g. -000.000
	private static boolean scanForNegativeZero(String subject)
	{
		boolean result = false;
		
		if( subject.charAt(0) != '-')
			result = false;
		else
		{
			for(int x = 1; x < subject.length(); x++)
			{
				if(subject.charAt(x) == '0')
					result = true;
				else if(subject.charAt(x) == '.')
					result = true;
				else
				{
					result = false;
					break;
				}
			}
		}		
		
		return result;
	}
	
	//Is the subject string a valid number?
	public static boolean isNumber(String subject)
	{
		boolean result = false;
		int startIndex = 0;
		boolean foundDecimal = false;
		
		if(isEmpty(subject))
			result = false;
		else if(subject.equals("."))
			result = false;
		else if(subject.equals("-."))
			result = false;
		else if(subject.equals("-0"))
			result = false;
		else if(scanForNegativeZero(subject))
			result = false;
		else
		{
			if(subject.charAt(0) == '-')
			{
				startIndex = 1;
			}
			
			result = true;			
			for(int x = startIndex; x < subject.length(); x++ )
			{
				if(subject.charAt(x) == '.')
				{
					if(!foundDecimal)
						foundDecimal = true;
					else
					{
						result = false;
						break;
					}
				}
				else
				{
					switch(subject.charAt(x))
					{
						case '0':
							continue;
						case '1':
							continue;
						case '2':
							continue;
						case '3':
							continue;
						case '4':
							continue;
						case '5':
							continue;
						case '6':
							continue;
						case '7':
							continue;
						case '8':
							continue;
						case '9':
							continue;
						default:
							result = false;
							break;
					}
				}
			}
		}
		return result;
	}
	
	//Is the subject string a valid integer?
	public static boolean isInteger(String subject)
	{
		boolean result = false;
		int startIndex = 0;
		
		if(isEmpty(subject))
			result = false;
		else
		{
			result = true;			
			for(int x = startIndex; x < subject.length(); x++ )
			{
				switch(subject.charAt(x))
				{
					case '0':
						continue;
					case '1':
						continue;
					case '2':
						continue;
					case '3':
						continue;
					case '4':
						continue;
					case '5':
						continue;
					case '6':
						continue;
					case '7':
						continue;
					case '8':
						continue;
					case '9':
						continue;
					default:
						result = false;
						break;
				}
			}
		}
		return result;
	}
	
	//Is the subject string a valid positive number
	public static boolean isPositiveNumber(String subject)
	{
		boolean result = false;
		BigDecimal zero = new BigDecimal("0");
		BigDecimal convert;
		
		if(!isNumber(subject))
			result = false;
		else
		{
			convert = new BigDecimal(subject);
			
			if(convert.compareTo(zero) > 0)
			{
				result = true;
			}
			else
				result = false;
		}
		
		return result;
	}
	
	//Is the subject string a valid positive number or zero
	public static boolean isPositiveOrZeroNumber(String subject)
	{
		boolean result = false;
		BigDecimal zero = new BigDecimal("0");
		BigDecimal convert;
		
		if(!isNumber(subject))
			result = false;
		else
		{
			convert = new BigDecimal(subject);
			
			if(convert.compareTo(zero) >= 0)
			{
				result = true;
			}
			else
				result = false;
		}
		
		return result;
	}
	
	//Is the subject string a valid negative number
	public static boolean isNegativeNumber(String subject)
	{
		boolean result = false;
		BigDecimal zero = new BigDecimal("0");
		BigDecimal convert;
		
		if(!isNumber(subject))
			result = false;
		else
		{
			convert = new BigDecimal(subject);
			
			if(convert.compareTo(zero) < 0)
			{
				result = true;
			}
			else
				result = false;
		}
		
		return result;
	}
	
	//Is the subject string a valid negative number or zero
	public static boolean isNegativeOrZeroNumber(String subject)
	{
		boolean result = false;
		BigDecimal zero = new BigDecimal("0");
		BigDecimal convert;
		
		if(!isNumber(subject))
			result = false;
		else
		{
			convert = new BigDecimal(subject);
			
			if(convert.compareTo(zero) <= 0)
			{
				result = true;
			}
			else
				result = false;
		}
		
		return result;
	}
	
	//Is the subject string a valid postive or negative number
	public static boolean isPositiveOrNegativeNumber(String subject)
	{
		boolean result = false;
		BigDecimal zero = new BigDecimal("0");
		BigDecimal convert;
		
		if(!isNumber(subject))
			result = false;
		else
		{
			convert = new BigDecimal(subject);
			
			if(convert.compareTo(zero) != 0)
			{
				result = true;
			}
			else
				result = false;
		}
		
		return result;
	}
	
	//Does subject string have up to numberPlaces of characters before the decimal point?
	public static boolean checkNumberPlaces(String subject, int numberPlaces)
	{
		boolean result = false;
		int startIndex = 0;
		
		if(subject.charAt(0) == '-')
		{
			startIndex = 1;
		}
		
		for(int x = startIndex; x <= numberPlaces+startIndex; x++)
		{
			if(subject.charAt(x) == '.')
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	//Does subject string have exactly numberPlaces of characters before the decimal point?
	public static boolean checkNumberPlacesFixed(String subject, int numberPlaces)
	{
		boolean result = false;
		int startIndex = 0;
		
		if(subject.charAt(0) == '-')
		{
			startIndex = 1;
		}
		
		if(subject.charAt(numberPlaces+startIndex) != '.')
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Does subject string have exactly decimalPlaces of characters after the decimal point?
	public static boolean checkDecimalPlacesFixed(String subject, int decimalPlaces)
	{
		boolean result = false;
		int checkPosition = subject.length()-1-decimalPlaces;
		
		if(checkPosition > 0)
		{
			if(subject.charAt(checkPosition) != '.')
				result = false;
			else
				result = true;
		}
		
		return result;
	}
	
	//Is the subject string a valid (4.4) percentage?  e.g. 3000.0003
	public static boolean isPercentage(String subject)
	{
		boolean result = false;
		int numberPlaces = 4;
		int decimalPlaces = 4;
		
		result = isPercentage(subject, numberPlaces, decimalPlaces);
		
		return result;
	}
	
	//Is the subject string a valid (x.y) percentage value?  e.g. x.y
	public static boolean isPercentage(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isNumber(subject))
			result = false;
		else if(!subject.contains("."))
		{
			result = false;
		}
		else
		{
			if(checkNumberPlaces(subject,numberPlaces))
			{
				if(checkDecimalPlacesFixed(subject,decimalPlaces))
				{
					result = true;
				}
			}
		}
		
		return result;
	}
	
	//Is the subject string a valid (4.4) percentage not equal to zero?  e.g. 3000.0003
	public static boolean isPositiveOrNegativePercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrNegativeNumber(subject))
			result = false;
		else if(!isPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (4.4) percentage not equal to zero?  e.g. 3000.0003
	public static boolean isPositiveOrNegativePercentage(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isPositiveOrNegativeNumber(subject))
			result = false;
		else if(!isPercentage(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a positive valid (4.4) percentage?  e.g. 3000.0003
	public static boolean isPositivePercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveNumber(subject))
			result = false;
		else if(!isPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a positive valid (4.4) percentage?  e.g. 3000.0003
	public static boolean isPositivePercentage(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isPositiveNumber(subject))
			result = false;
		else if(!isPercentage(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a positive valid (4.4) percentage or zero?  e.g. 3000.0003
	public static boolean isPositiveOrZeroPercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrZeroNumber(subject))
			result = false;
		else if(!isPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a positive valid (4.4) percentage or zero?  e.g. 3000.0003
	public static boolean isPositiveOrZeroPercentage(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isPositiveOrZeroNumber(subject))
			result = false;
		else if(!isPercentage(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a negative valid (4.4) percentage?  e.g. -3000.0003
	public static boolean isNegativePercentage(String subject)
	{
		boolean result = false;
		
		if(!isNegativeNumber(subject))
			result = false;
		else if(!isPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a negative valid (4.4) percentage?  e.g. -3000.0003
	public static boolean isNegativePercentage(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isNegativeNumber(subject))
			result = false;
		else if(!isPercentage(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a negative valid (4.4) percentage or zero?  e.g. -3000.0003
	public static boolean isNegativeOrZeroPercentage(String subject)
	{
		boolean result = false;
		
		if(!isNegativeOrZeroNumber(subject))
			result = false;
		else if(!isPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a negative valid (4.4) percentage or zero?  e.g. -3000.0003
	public static boolean isNegativeOrZeroPercentage(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isNegativeOrZeroNumber(subject))
			result = false;
		else if(!isPercentage(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (3.3) percentage?  e.g. -300.003
	public static boolean isWeakPercentage(String subject)
	{
		boolean result = false;
		int numberPlaces = 3;
		int decimalPlaces = 3;
		
		result = isPercentage(subject, numberPlaces, decimalPlaces);
		
		return result;
	}
	
	//Is the subject string a valid (3.3) percentage not equal to zero?  e.g. 3000.0003
	public static boolean isPositiveOrNegativeWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrNegativeNumber(subject))
			result = false;
		else if(!isWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid positive (3.3) percentage?  e.g. -300.003
	public static boolean isPositiveWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveNumber(subject))
			result = false;
		else if(!isWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a positive valid (3.3) percentage or zero?  e.g. 300.003
	public static boolean isPositiveOrZeroWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrZeroNumber(subject))
			result = false;
		else if(!isWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (3.3) percentage?  e.g. -300.003
	public static boolean isNegativeWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isNegativeNumber(subject))
			result = false;
		else if(!isWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (3.3) percentage or zero?  e.g. -300.003
	public static boolean isNegativeOrZeroWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isNegativeOrZeroNumber(subject))
			result = false;
		else if(!isWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (2.2) percentage?  e.g. 30.03
	public static boolean isSuperWeakPercentage(String subject)
	{
		boolean result = false;
		int numberPlaces = 2;
		int decimalPlaces = 2;
		
		result = isPercentage(subject, numberPlaces, decimalPlaces);
		
		return result;
	}
	
	//Is the subject string a valid (2.2) percentage not equal to zero?  e.g. 30.03
	public static boolean isPositiveOrNegativeSuperWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrNegativeNumber(subject))
			result = false;
		else if(!isSuperWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a positive valid (2.2) percentage?  e.g. 30.03
	public static boolean isPositiveSuperWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveNumber(subject))
			result = false;
		else if(!isSuperWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a positive valid (2.2) percentage or zero?  e.g. 30.03
	public static boolean isPositiveOrZeroSuperWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrZeroNumber(subject))
			result = false;
		else if(!isSuperWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a negative valid (2.2) percentage?  e.g. -30.03
	public static boolean isNegativeSuperWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isNegativeNumber(subject))
			result = false;
		else if(!isSuperWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a negative valid (2.2) percentage or zero?  e.g. -30.03
	public static boolean isNegativeOrZeroSuperWeakPercentage(String subject)
	{
		boolean result = false;
		
		if(!isNegativeOrZeroNumber(subject))
			result = false;
		else if(!isSuperWeakPercentage(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (9.2) money value?  e.g. 300111000.03
	public static boolean isMoney(String subject)
	{
		boolean result = false;
		int numberPlaces = 9;
		int decimalPlaces = 2;
		
		result = isMoney(subject, numberPlaces, decimalPlaces);
		
		return result;
	}
	
	//Is the subject string a valid (x.y) money value?  e.g. x.y
	public static boolean isMoney(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isNumber(subject))
			result = false;
		else if(!subject.contains("."))
		{
			result = false;
		}
		else
		{
			if(checkNumberPlaces(subject,numberPlaces))
			{
				if(checkDecimalPlacesFixed(subject,decimalPlaces))
				{
					result = true;
				}
			}
		}
		
		return result;
	}
	
	//Is the subject string a valid positive (9.2) money value?  e.g. 300111000.03
	public static boolean isPositiveMoney(String subject)
	{
		boolean result = false;
		
		if(!isPositiveNumber(subject))
			result = false;
		else if(!isMoney(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid positive (x.y) money value with a specified number of digits before and after the decimal place?  e.g. x.y
	public static boolean isPositiveMoney(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isPositiveNumber(subject))
			result = false;
		else if(!isMoney(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid positive (9.2) money value or zero?  e.g. 300111000.03
	public static boolean isPositiveOrZeroMoney(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrZeroNumber(subject))
			result = false;
		else if(!isMoney(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid positive (x.y) money value or zero with a specified number of digits before and after the decimal place?  e.g. x.y
	public static boolean isPositiveOrZeroMoney(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isPositiveOrZeroNumber(subject))
			result = false;
		else if(!isMoney(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (9.2) money value not equal to zero?  e.g. 300111000.03
	public static boolean isPositiveOrNegativeMoney(String subject)
	{
		boolean result = false;
		
		if(!isPositiveOrNegativeNumber(subject))
			result = false;
		else if(!isMoney(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid (x.y) money value not equal to zero?  e.g. x.y
	public static boolean isPositiveOrNegativeMoney(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isPositiveOrNegativeNumber(subject))
			result = false;
		else if(!isMoney(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid negative (9.2) money value?  e.g. 300111000.03
	public static boolean isNegativeMoney(String subject)
	{
		boolean result = false;
		
		if(!isNegativeNumber(subject))
			result = false;
		else if(!isMoney(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid negative (x.y) money value?  e.g. x.y
	public static boolean isNegativeMoney(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isNegativeNumber(subject))
			result = false;
		else if(!isMoney(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid negative (9.2) money value or zero?  e.g. 300111000.03
	public static boolean isNegativeOrZeroMoney(String subject)
	{
		boolean result = false;
		
		if(!isNegativeOrZeroNumber(subject))
			result = false;
		else if(!isMoney(subject))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string a valid negative (x.y) money value or zero?  e.g. x.y
	public static boolean isNegativeOrZeroMoney(String subject, int numberPlaces, int decimalPlaces)
	{
		boolean result = false;
		
		if(!isNegativeOrZeroNumber(subject))
			result = false;
		else if(!isMoney(subject, numberPlaces, decimalPlaces))
			result = false;
		else
			result = true;
		
		return result;
	}
	
	//Is the subject string equal to or higher than the given lower bound?
	public static boolean isWithinLowerBound(String subject, BigDecimal lowerBound)
	{
		boolean result = false;
		
		if(!isNumber(subject))
			result = false;
		else if(new BigDecimal(subject).compareTo(lowerBound) >= 0)
			result = true;
		else
			result = false;
		
		return result;
	}
	
	//Is the subject string equal to or lower than the given upper bound?
	public static boolean isWithinUpperBound(String subject, BigDecimal upperBound)
	{
		boolean result = false;
		
		if(!isNumber(subject))
			result = false;
		else if(new BigDecimal(subject).compareTo(upperBound) <= 0)
			result = true;
		else
			result = false;
		
		return result;
	}
	
	//Is the subject string equal to or higher than the given lower bound?
	public static boolean isWithinBounds(String subject, BigDecimal lowerBound, BigDecimal upperBound)
	{
		boolean result = false;
		
		if(isWithinLowerBound(subject, lowerBound))
			result = true;
		
		if(!isWithinUpperBound(subject, upperBound))
			result = false;
		
		return result;
	}
	
	public static boolean isWithinBounds(String subject, int i, int j) {
		boolean result = false;
		
		result = isWithinBounds(subject, new BigDecimal(Integer.toString(i)), new BigDecimal(Integer.toString(j)));
		
		return result;
	}
	
	//Is the subject string length within the given bounds?
	public static boolean isWithinStringLength(String subject, int i, int j) {
		boolean result = false;
		
		if(subject.length() >= i && subject.length() <= j)
			result = true;
		else
			result = false;
		
		return result;
	}
		
		
	public static boolean isDate(String subject){
		boolean result = false;
		String year;
		String month;
		String day;
		
		//CCYY-MM-DD
		if(subject.length() == 10){
			year = subject.substring(0, 4);
			month = subject.substring(5, 7);
			day = subject.substring(8, 10);
			
			if(
					isInteger(year) &&
					subject.charAt(4) == '-' &&
					isInteger(month) &&
					isWithinBounds(month, 1, 12) &&
					subject.charAt(7) == '-' &&
					isInteger(day)				
			){
				switch(month){
					case "01":
						if(isWithinBounds(day, 1, 31))
							result = true;
						break;
					case "02":
						if( Integer.parseInt(year) % 4 == 0 ){
							if(isWithinBounds(day, 1, 29))
								result = true;
						}
						else{
							if(isWithinBounds(day, 1, 28))
								result = true;
						}
						break;
					case "03":
						if(isWithinBounds(day, 1, 31))
							result = true;
						break;
					case "04":
						if(isWithinBounds(day, 1, 30))
							result = true;
						break;
					case "05":
						if(isWithinBounds(day, 1, 31))
							result = true;
						break;
					case "06":
						if(isWithinBounds(day, 1, 30))
							result = true;
						break;
					case "07":
						if(isWithinBounds(day, 1, 31))
							result = true;
						break;
					case "08":
						if(isWithinBounds(day, 1, 31))
							result = true;
						break;
					case "09":
						if(isWithinBounds(day, 1, 30))
							result = true;
						break;
					case "10":
						if(isWithinBounds(day, 1, 31))
							result = true;
						break;
					case "11":
						if(isWithinBounds(day, 1, 30))
							result = true;
						break;
					case "12":
						if(isWithinBounds(day, 1, 31))
							result = true;
						break;
					default:
						result = false;
						break;
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public static boolean isTime(String subject){
		boolean result = false;
		String hour;
		String minute;
		String second;
		
		//hh:mm:ss
		if(subject.length() == 8){
			hour = subject.substring(0, 2);
			minute = subject.substring(3, 5);
			second = subject.substring(6, 8);
			
			if(
				isInteger(hour) &&
				isWithinBounds(hour, 0, 24) &&
				subject.charAt(2) == ':' && 
				isInteger(minute) &&
				isWithinBounds(minute, 0, 60) &&
				subject.charAt(5) == ':' &&
				isInteger(second) &&
				isWithinBounds(second, 0, 60)
			){
				result = true;
			}
		}
		else{
			result = false;
		}
		
		return result;
	}
	
	public static boolean isDateTime(String subject){
		boolean result = false;
		
		if(subject.length() == 20){
			if(!isDate(subject.substring(0,10))){
			result = false;
			}
			else if( subject.charAt(10) != 'T' ){
					result = false;
			}
			else if(!isTime(subject.substring(11,19))){
				result = false;
			}
			else if( subject.charAt(19) != 'Z' ){
				result = false;
			}
			else{
				result = true;
			}
		}
		else{
			result = false;
		}
		return result;
	}
	
}
