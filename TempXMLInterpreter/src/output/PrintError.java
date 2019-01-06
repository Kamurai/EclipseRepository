package output;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class PrintError 
{
	private static String printFor(String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = " for " + forNode + " = " + forNodeValue + ".";
		
		return result;
	}
	
	private static String printFor(String forNode, String forNodeValue, boolean periodFlag)
	{
		String result = "-1";
		
		result = printFor(forNode, forNodeValue);
		
		if(periodFlag)
			result += ".";
		
		return result;
	}
	
	private static String printFor(String forNode)
	{
		String result = "-1";
		
		result = " for " + forNode;
		
		return result;
	}
	
	private static String printFor(String forNode, boolean periodFlag)
	{
		String result = "-1";
		
		result = printFor(forNode);
		
		if(periodFlag)
			result += ".";
		
		return result;
	}
	
	private static List<String> setToArrayList(Set<String> valueSet)
	{
		List<String> valueList = new ArrayList<String>();
		for (String enumeration : valueSet)  
			valueList.add(enumeration);
		
		return valueList;
	}
	
	private static String printArrayList(List<String> valueList)
	{
		String result = valueList.get(0);
		for(int x=1; x < valueList.size(); x++)
			result += ", " + valueList.get(x);
		
		return result;
	}
	
	private static String compileError(String nodeName, String first, String value)
	{
		String result = "-1";
		
		result = nodeName + first + value + ".";
		
		return result;
	}
	
	private static String compileError(String nodeName, String first, Set<String> valueSet)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + first + printArrayList(valueList) + ".";
		
		return result;
	}
	
	private static String compileError(String nodeName, String first, String value, String second, Set<String> valueSet)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + first + value + second + printArrayList(valueList) + ".";
		
		return result;
	}
	
	private static String compileError(String nodeName, String first, String value, String second)
	{
		String result = "-1";
		
		result = nodeName + first + value + second + ".";
		
		return result;
	}
	
	private static String compileError(String nodeName, String first, String value, String second, int one)
	{
		String result = "-1";
		
		result = nodeName + first + value + second + one + ".";
		
		return result;
	}
	
	private static String compileError(String nodeName, String first, int count, String second, int one)
	{
		String result = "-1";
		
		result = nodeName + first + count + second + one + ".";
		
		return result;
	}
	
	private static String compileError(String nodeName, String first, String value, String second, int one, int two)
	{
		String result = "-1";
		
		result = nodeName + first + value + second + one + " and " + two + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, String value, String forNode)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, false) + first + value + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, Set<String> valueSet, String forNode)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + printFor(forNode, false) + first + printArrayList(valueList) + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, String value, String second, Set<String> valueSet, String forNode)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + printFor(forNode, false) + first + value + second + printArrayList(valueList) + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, String value, String second, String forNode)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, false) + first + value + second + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, String value, Set<String> valueSet, String forNode)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + first + printArrayList(valueList) + ".";
		
		return result;
	}	
	
	private static String compileErrorWithForNode(String nodeName, String first, String value, String second, int one, String forNode)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, false) + first + value + second + one + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, int count, String second, int one, String forNode)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, false) + first + count + second + one + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, String value, String second, int one, int two, String forNode)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, false) + first + value + second + one + " and " + two + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNodeValue(String nodeName, String first, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, forNodeValue) + first + value + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNodeValue(String nodeName, String first, Set<String> valueSet, String forNode, String forNodeValue)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + printFor(forNode, forNodeValue) + first + printArrayList(valueList) + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNodeValue(String nodeName, String first, String value, String second, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, forNodeValue) + first + value + second + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNodeValue(String nodeName, String first, String value, String second, Set<String> valueSet, String forNode, String forNodeValue)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + printFor(forNode, forNodeValue, false) + first + value + second + printArrayList(valueList) + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNode(String nodeName, String first, String value, String second, Set<String> valueSet, String forNode, String forNodeValue)
	{
		String result = "-1";
		List<String> valueList = setToArrayList(valueSet);  
		
		result = nodeName + printFor(forNode, forNodeValue, false) + first + value + second + printArrayList(valueList) + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNodeValue(String nodeName, String first, String value, String second, int one, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, forNodeValue) + first + value + second + one + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNodeValue(String nodeName, String first, int count, String second, int one, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, forNodeValue) + first + count + second + one + ".";
		
		return result;
	}
	
	private static String compileErrorWithForNodeValue(String nodeName, String first, String value, String second, int one, int two, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = nodeName + printFor(forNode, forNodeValue) + first + value + second + one + " and " + two + ".";
		
		return result;
	}
	
	public static String unexpectedValue(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " has an unexpected value. Found value = ", value);
		
		return result;
	}
	
	public static String unexpectedValue(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " has an unexpected value ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String missing(String nodeName)
	{
		String result = "-1";
		
		result = nodeName + " is missing.";
		
		return result;
	}
	
	public static String missing(String nodeName, String forNode)
	{
		String result = "-1";
		
		result = nodeName + " is missing in " + forNode + ".";
		
		return result;
	}
	
	public static String missing(String nodeName, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = nodeName + " is missing in " + forNode + " with value of " + forNodeValue + ".";
		
		return result;
	}
	
	public static String unexpectedNode(String nodeName)
	{
		String result = "-1";
		
		result = nodeName + " is an unexpected node.";
		
		return result;
	}
	
	public static String unexpectedNode(String nodeName, String forNode)
	{
		String result = "-1";
		
		result = nodeName + " is an unexpected node for " + forNode + ".";
		
		return result;
	}
	
	public static String unexpectedNode(String nodeName, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = nodeName + " is an unexpected node for " + forNode + " with value of "+ forNodeValue + ".";
		
		return result;
	}
	
	public static String duplicate(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is a duplicate.  Found value = ", value, ".  Only one instance is expected.");
		
		return result;
	}
	
	public static String duplicate(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is a duplicate.  Found value = ", value, ".  Only one instance is expected.", forNode, forNodeValue);
		
		return result;
	}
	
	public static String noneExpected(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is unexpected.  Found value = ", value, ".  No instances are expected.");
		
		return result;
	}
	
	public static String noneExpected(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is unexpected.  Found value = ", value, ".  No instances are expected.", forNode, forNodeValue);
		
		return result;
	}
	
	public static String notANumber(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a number.  Found value = ", value);
		
		return result;
	}
	
	public static String notANumber(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a number.  Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notAPositiveNumber(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a positive number.  Found value = ", value);
		
		return result;
	}
	
	public static String notAPositiveNumber(String nodeName, String value, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " is not a positive number.  Found value = ", value, forNode);
		
		return result;
	}
	
	public static String notAPositiveNumber(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a positive number.  Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notAPositiveOrZeroNumber(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a positive number or zero.  Found value = ", value);
		
		return result;
	}
	
	public static String notAPositiveOrZeroNumber(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a positive number or zero.  Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notANegativeNumber(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a negative number.  Found value = ", value);
		
		return result;
	}
	
	public static String notANegativeNumber(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a negative number.  Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notANegativeOrZeroNumber(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a negative number or zero.  Found value = ", value);
		
		return result;
	}
	
	public static String notANegativeOrZeroNumber(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a negative number or zero.  Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String stringLengthOutsideRange(String nodeName, String value, int lowerBound, int upperBound)
	{
		String result = "-1";
		
		result = compileError(nodeName, " has a character length outside the expected range.  Found value = ", value, ".  Length of value should be between ", lowerBound, upperBound);
		
		return result;
	}
	
	public static String stringLengthOutsideRange(String nodeName, String value, int lowerBound, int upperBound, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " has a character length outside the expected range.  Found value = ", value, ".  Length of value should be between ", lowerBound, upperBound, forNode);
		
		return result;
	}
	
	public static String stringLengthOutsideRange(String nodeName, String value, int lowerBound, int upperBound, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " has a character length outside the expected range.  Found value = ", value, ".  Length of value should be between ", lowerBound, upperBound, forNode, forNodeValue);
		
		return result;
	}
	
	public static String outsideRange(String nodeName, String value, int lowerBound, int upperBound)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is outside expected number range.  Found value = ", value, ".  Number should be between ", lowerBound, upperBound);
		
		return result;
	}
	
	public static String outsideRange(String nodeName, String value, int lowerBound, int upperBound, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " is outside expected number range.  Found value = ", value, ".  Number should be between ", lowerBound, upperBound, forNode);
		
		return result;
	}
	
public static String outsideRange(String nodeName, String value, int lowerBound, int upperBound, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is outside expected number range.  Found value = ", value, ".  Number should be between ", lowerBound, upperBound, forNode, forNodeValue);
		
		return result;
	}
	
	public static String outsideLowerBound(String nodeName, String value, int lowerBound)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is outside the lower bound.  Found value = ", value, ".  Number should be greater than or equal to ", lowerBound);
		
		return result;
	}
	
	public static String outsideLowerBound(String nodeName, String value, int lowerBound, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is outside the lower bound.  Found value = ", value, ".  Number should be greater than or equal to ", lowerBound, forNode, forNodeValue);
		
		return result;
	}
	
	public static String outsideUpperBound(String nodeName, String value, int upperBound)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is outside the upper bound.  Found value = ", value, ".  Number should be less than or equal to ", upperBound);
		
		return result;
	}
	
	public static String outsideUpperBound(String nodeName, String value, int upperBound, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is outside the upper bound.  Found value = ", value, ".  Number should be less than or equal to ", upperBound, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notExactCount(String nodeName, int count, int exactCount)
	{
		String result = "-1";
		
		result = compileError(nodeName, " has an unexpected count of ", count, ".  The number of occurrences should be ", exactCount);
		
		return result;
	}
	
	public static String notExactCount(String nodeName, int count, int exactCount, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " has an unexpected count of ", count, ".  The number of occurrences should be ", exactCount, forNode, forNodeValue);
		
		return result;
	}
	
	public static String outsideLowerCount(String nodeName, int count, int lowerBound)
	{
		String result = "-1";
		
		result = compileError(nodeName, " has an unexpected count of ", count, ".  The number of occurrences should be greater than or equal to ", lowerBound);
		
		return result;
	}
	
	public static String outsideLowerCount(String nodeName, int count, int lowerBound, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " has an unexpected count of ", count, ".  The number of occurrences should be greater than or equal to ", lowerBound, forNode, forNodeValue);
		
		return result;
	}
	
	public static String outsideUpperCount(String nodeName, int count, int upperBound)
	{
		String result = "-1";
		
		result = compileError(nodeName, " has an unexpected count of ", count, ".  The number of occurrences should be less than or equal to ", upperBound);
		
		return result;
	}
	
	public static String outsideUpperCount(String nodeName, int count, int upperBound, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " has an unexpected count of ", count, ".  The number of occurrences should be less than or equal to ", upperBound, forNode, forNodeValue);
		
		return result;
	}
	
	public static String foundDecimalPoint(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " has an unexpected '.'. Found value = ", value);
		
		return result;
	}
	
	public static String foundDecimalPoint(String nodeName, String value, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " has an unexpected '.'. Found value = ", value, forNode);
		
		return result;
	}
	
	public static String foundDecimalPoint(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " has an unexpected '.'. Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String noDecimalPoint(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " does not have a '.'. Found value = ", value);
		
		return result;
	}
	
	public static String noDecimalPoint(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " does not have a '.'. Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String noDecimalPoint(String nodeName, String value, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " does not have a '.'. Found value = ", value, forNode);
		
		return result;
	}
	
	public static String missingXPreciseDecimalPoints(String nodeName, int numDigits, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " does not have " + numDigits + " precise digits after the '.'. Found value = ", value);
		
		return result;
	}
	
	public static String missingXPreciseDecimalPoints(String nodeName, int numDigits, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " does not have " + numDigits + " precise digits after the '.'. Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String moreThanXDigitsBeforeDecimal(String nodeName, int numDigits, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " has more than " + numDigits + " digits before the '.'. Found value = ", value);
		
		return result;
	}
	
	public static String moreThanXDigitsBeforeDecimal(String nodeName, int numDigits, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " has more than " + numDigits + " digits before the '.'. Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notADate(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a date. Found value = ", value);
		
		return result;
	}
	
	public static String notADate(String nodeName, String value, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " is not a date. Found value = ", value, forNode);
		
		return result;
	}
	
	public static String notADate(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a date. Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notATime(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a time. Found value = ", value);
		
		return result;
	}
	
	public static String notATime(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a time. Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notADateTime(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a date-time stamp. Found value = ", value);
		
		return result;
	}
	
	public static String notADateTime(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a date-time stamp. Found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	public static String notABoolean(String nodeName, String value)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not a boolean.  Expected \"true\" or \"false\", found value = ", value);
		
		return result;
	}
	
	public static String notABoolean(String nodeName, String value, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " is not a boolean.  Expected \"true\" or \"false\", found value = ", value, forNode);
		
		return result;
	}
	
	public static String notABoolean(String nodeName, String value, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not a boolean.  Expected \"true\" or \"false\", found value = ", value, forNode, forNodeValue);
		
		return result;
	}
	
	
	public static String UnexpectedEnumeration(String nodeName, Set<String> valueSet)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not an expected enumeration.  Expected one of the following values: ", valueSet);
		
		return result;
	}
	
	public static String UnexpectedEnumeration(String nodeName, Set<String> valueSet, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " is not an expected enumeration.  Expected one of the following values: ", valueSet, forNode);
		
		return result;
	}
	
	public static String UnexpectedEnumeration(String nodeName, Set<String> valueSet, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not an expected enumeration.  Expected one of the following values: ", valueSet, forNode, forNodeValue);
		
		return result;
	}
	
	public static String UnexpectedEnumeration(String nodeName, String nodeValue, Set<String> valueSet)
	{
		String result = "-1";
		
		result = compileError(nodeName, " is not an expected enumeration.  Found value = ", nodeValue, "; expected one of the following values: ", valueSet);
		
		return result;
	}
	
	public static String UnexpectedEnumeration(String nodeName, String nodeValue, Set<String> valueSet, String forNode)
	{
		String result = "-1";
		
		result = compileErrorWithForNode(nodeName, " is not an expected enumeration.  Found value = ", nodeValue, "; expected one of the following values: ", valueSet, forNode);
		
		return result;
	}
	
	public static String UnexpectedEnumeration(String nodeName, String nodeValue, Set<String> valueSet, String forNode, String forNodeValue)
	{
		String result = "-1";
		
		result = compileErrorWithForNodeValue(nodeName, " is not an expected enumeration.  Found value = ", nodeValue, "; expected one of the following values: ", valueSet, forNode, forNodeValue);
		
		return result;
	}
	
	public static String couldNotReadFile()
	{
		String result = "-1";
		
		result = "Could not read file.";
		
		return result;
	}
	
}
