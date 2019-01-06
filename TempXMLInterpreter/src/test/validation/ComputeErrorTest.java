package test.validation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import validation.ComputeError;

public class ComputeErrorTest {

	@Test
	public void isThereTest() 
	{
		assertEquals("isThere pos test", true, ComputeError.isThere(new String()));
		assertEquals("isThere neg test", false, ComputeError.isThere(null));
	}
	
	@Test
	public void isEmptyTest() 
	{
		assertEquals("isEmpty pos test", true, ComputeError.isEmpty(""));
		assertEquals("isEmpty pos null test", true, ComputeError.isEmpty(null));
		assertEquals("isEmpty neg empty test", false, ComputeError.isEmpty("empty"));
	}
	
	@Test
	public void isBoolean() 
	{
		assertEquals("isBoolean pos True test", true, ComputeError.isBoolean("True"));
		assertEquals("isBoolean pos False test", true, ComputeError.isBoolean("False"));
		assertEquals("isBoolean pos false test", true, ComputeError.isBoolean("false"));
		assertEquals("isBoolean pos true test", true, ComputeError.isBoolean("true"));
		assertEquals("isBoolean neg empty test", false, ComputeError.isBoolean("empty"));
	}
	
	@Test
	public void isNumber() 
	{
		assertEquals("isNumber pos Test", true, ComputeError.isNumber("0"));
		assertEquals("isNumber pos Test", true, ComputeError.isNumber("-1"));
		assertEquals("isNumber pos Test", true, ComputeError.isNumber("1"));
		assertEquals("isNumber pos Test", true, ComputeError.isNumber("0.00003"));
		assertEquals("isNumber pos Test", true, ComputeError.isNumber("-100000.0000004"));
		assertEquals("isNumber neg -0 Test", false, ComputeError.isNumber("-0"));
		assertEquals("isNumber neg empty Test", false, ComputeError.isNumber("empty"));
		assertEquals("isNumber neg -. Test", false, ComputeError.isNumber("-."));
		assertEquals("isNumber neg -empty Test", false, ComputeError.isNumber("-empty"));
		assertEquals("isNumber neg emp.ty Test", false, ComputeError.isNumber("emp.ty"));
	}
	
	@Test
	public void isPositiveNumber() 
	{
		assertEquals("isPositiveNumber pos Test", true, ComputeError.isPositiveNumber("1"));
		assertEquals("isPositiveNumber pos Test", true, ComputeError.isPositiveNumber("0.00003"));
		assertEquals("isPositiveNumber neg -100... Test", false, ComputeError.isPositiveNumber("-100000.0000004"));
		assertEquals("isPositiveNumber neg -1 Test", false, ComputeError.isPositiveNumber("-1"));
		assertEquals("isPositiveNumber neg -0 Test", false, ComputeError.isPositiveNumber("-0"));
		assertEquals("isPositiveNumber neg 0 Test", false, ComputeError.isPositiveNumber("0"));
		assertEquals("isPositiveNumber neg empty Test", false, ComputeError.isPositiveNumber("empty"));
		assertEquals("isPositiveNumber neg -. Test", false, ComputeError.isPositiveNumber("-."));
		assertEquals("isPositiveNumber neg -empty Test", false, ComputeError.isPositiveNumber("-empty"));
		assertEquals("isPositiveNumber neg emp.ty Test", false, ComputeError.isPositiveNumber("emp.ty"));
	}
	
	@Test
	public void isPositiveOrZeroNumber() 
	{
		assertEquals("isPositiveOrZeroNumber pos Test", true, ComputeError.isPositiveOrZeroNumber("1"));
		assertEquals("isPositiveOrZeroNumber pos Test", true, ComputeError.isPositiveOrZeroNumber("0.00003"));
		assertEquals("isPositiveOrZeroNumber pos 0 Test", true, ComputeError.isPositiveOrZeroNumber("0"));
		assertEquals("isPositiveOrZeroNumber neg -0 Test", false, ComputeError.isPositiveOrZeroNumber("-0"));
		assertEquals("isPositiveOrZeroNumber neg Test", false, ComputeError.isPositiveOrZeroNumber("-100000.0000004"));
		assertEquals("isPositiveOrZeroNumber neg Test", false, ComputeError.isPositiveOrZeroNumber("-1"));
		assertEquals("isPositiveOrZeroNumber neg empty Test", false, ComputeError.isPositiveOrZeroNumber("empty"));
		assertEquals("isPositiveOrZeroNumber neg -. Test", false, ComputeError.isPositiveOrZeroNumber("-."));
		assertEquals("isPositiveOrZeroNumber neg -empty Test", false, ComputeError.isPositiveOrZeroNumber("-empty"));
		assertEquals("isPositiveOrZeroNumber neg emp.ty Test", false, ComputeError.isPositiveOrZeroNumber("emp.ty"));
	}
	
	
	
	@Test
	public void isNegativeNumber() 
	{
		assertEquals("isNegativeNumber pos -1 Test", true, ComputeError.isNegativeNumber("-1"));
		assertEquals("isNegativeNumber pos -100... Test", true, ComputeError.isNegativeNumber("-100000.0000004"));
		assertEquals("isNegativeNumber neg Test", false, ComputeError.isNegativeNumber("1"));
		assertEquals("isNegativeNumber neg Test", false, ComputeError.isNegativeNumber("0.00003"));
		assertEquals("isNegativeNumber neg -0 Test", false, ComputeError.isNegativeNumber("-0"));
		assertEquals("isNegativeNumber neg 0 Test", false, ComputeError.isNegativeNumber("0"));
		assertEquals("isNegativeNumber neg empty Test", false, ComputeError.isNegativeNumber("empty"));
		assertEquals("isNegativeNumber neg -. Test", false, ComputeError.isNegativeNumber("-."));
		assertEquals("isNegativeNumber neg -empty Test", false, ComputeError.isNegativeNumber("-empty"));
		assertEquals("isNegativeNumber neg emp.ty Test", false, ComputeError.isNegativeNumber("emp.ty"));
	}
	
	@Test
	public void isNegativeOrZeroNumber() 
	{
		assertEquals("isNegativeOrZeroNumber pos Test", true, ComputeError.isNegativeOrZeroNumber("-100000.0000004"));
		assertEquals("isNegativeOrZeroNumber pos Test", true, ComputeError.isNegativeOrZeroNumber("-1"));
		assertEquals("isNegativeOrZeroNumber pos 0 Test", true, ComputeError.isNegativeOrZeroNumber("0"));
		assertEquals("isNegativeOrZeroNumber neg Test", false, ComputeError.isNegativeOrZeroNumber("1"));
		assertEquals("isNegativeOrZeroNumber neg Test", false, ComputeError.isNegativeOrZeroNumber("0.00003"));
		assertEquals("isNegativeOrZeroNumber neg -0 Test", false, ComputeError.isNegativeOrZeroNumber("-0"));
		assertEquals("isNegativeOrZeroNumber neg empty Test", false, ComputeError.isNegativeOrZeroNumber("empty"));
		assertEquals("isNegativeOrZeroNumber neg -. Test", false, ComputeError.isNegativeOrZeroNumber("-."));
		assertEquals("isNegativeOrZeroNumber neg -empty Test", false, ComputeError.isNegativeOrZeroNumber("-empty"));
		assertEquals("isNegativeOrZeroNumber neg emp.ty Test", false, ComputeError.isNegativeOrZeroNumber("emp.ty"));
	}
	
	@Test
	public void isPositiveOrNegativeNumber() 
	{
		assertEquals("isPositiveOrNegativeNumber pos -100... Test", true, ComputeError.isPositiveOrNegativeNumber("-100000.0000004"));
		assertEquals("isPositiveOrNegativeNumber pos -1 Test", true, ComputeError.isPositiveOrNegativeNumber("-1"));
		assertEquals("isPositiveOrNegativeNumber pos 1 Test", true, ComputeError.isPositiveOrNegativeNumber("1"));
		assertEquals("isPositiveOrNegativeNumber pos 0.00003 Test", true, ComputeError.isPositiveOrNegativeNumber("0.00003"));
		
		assertEquals("isPositiveOrNegativeNumber neg 0 Test", false, ComputeError.isPositiveOrNegativeNumber("0"));
		assertEquals("isPositiveOrNegativeNumber neg -0 Test", false, ComputeError.isPositiveOrNegativeNumber("-0"));
		assertEquals("isPositiveOrNegativeNumber neg empty Test", false, ComputeError.isPositiveOrNegativeNumber("empty"));
		assertEquals("isPositiveOrNegativeNumber neg -. Test", false, ComputeError.isPositiveOrNegativeNumber("-."));
		assertEquals("isPositiveOrNegativeNumber neg -empty Test", false, ComputeError.isPositiveOrNegativeNumber("-empty"));
		assertEquals("isPositiveOrNegativeNumber neg emp.ty Test", false, ComputeError.isPositiveOrNegativeNumber("emp.ty"));
	}
	
	@Test
	public void isPercentage()
	{
		assertEquals("isPercentage pos 1000.0001 Test", true, ComputeError.isPercentage("1000.0001"));
		assertEquals("isPercentage pos 1.0001 Test", true, ComputeError.isPercentage("1.0001"));
		assertEquals("isPercentage pos -1000.0001 Test", true, ComputeError.isPercentage("-1000.0001"));
		assertEquals("isPercentage pos -1.0001 Test", true, ComputeError.isPercentage("-1.0001"));
		assertEquals("isPercentage pos 0000.0000 Test", true, ComputeError.isPercentage("0000.0000"));
		assertEquals("isPercentage pos 0.0000 Test", true, ComputeError.isPercentage("0.0000"));
		
		assertEquals("isPercentage neg 1000.0 Test", false, ComputeError.isPercentage("1000.0"));
		assertEquals("isPercentage neg -1000.0 Test", false, ComputeError.isPercentage("-1000.0"));
		assertEquals("isPercentage neg 0000.0 Test", false, ComputeError.isPercentage("0000.0"));
		assertEquals("isPercentage neg 0.0 Test", false, ComputeError.isPercentage("0.0"));
		assertEquals("isPercentage neg -0.000 Test", false, ComputeError.isPercentage("-0.0000"));
		assertEquals("isPercentage neg 10000.0000 Test", false, ComputeError.isPercentage("10000.0000"));
		assertEquals("isPercentage neg 0.000 Test", false, ComputeError.isPercentage("0.000"));
		assertEquals("isPercentage neg .000 Test", false, ComputeError.isPercentage(".000"));
		assertEquals("isPercentage neg 0.0001 Test", false, ComputeError.isPercentage("0.001"));
		assertEquals("isPercentage neg -0.001 Test", false, ComputeError.isPercentage("-0.001"));
		assertEquals("isPercentage neg .001 Test", false, ComputeError.isPercentage(".001"));
		assertEquals("isPercentage neg -.001 Test", false, ComputeError.isPercentage("-.001"));
		assertEquals("isPercentage neg 1 Test", false, ComputeError.isPercentage("1"));
		assertEquals("isPercentage neg 0 Test", false, ComputeError.isPercentage("0"));
		assertEquals("isPercentage neg -0 Test", false, ComputeError.isPercentage("-0"));
		assertEquals("isPercentage neg 0.00001 Test", false, ComputeError.isPercentage("0.00001"));
		assertEquals("isPercentage neg 10000.0 Test", false, ComputeError.isPercentage("10000.0"));
		assertEquals("isPercentage neg -0.00001 Test", false, ComputeError.isPercentage("-0.00001"));
		assertEquals("isPercentage neg -10000.0 Test", false, ComputeError.isPercentage("-10000.0"));
		assertEquals("isPercentage neg empty Test", false, ComputeError.isPercentage("empty"));
		assertEquals("isPercentage neg -. Test", false, ComputeError.isPercentage("-."));
		assertEquals("isPercentage neg -empty Test", false, ComputeError.isPercentage("-empty"));
		assertEquals("isPercentage neg emp.ty Test", false, ComputeError.isPercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveOrNegativePercentage()
	{
//		assertEquals("isPositiveOrNegativePercentage pos 1000.0001 Test", true, ComputeError.isPositiveOrNegativePercentage("1000.0001"));
//		assertEquals("isPositiveOrNegativePercentage pos 1.0001 Test", true, ComputeError.isPositiveOrNegativePercentage("1.0001"));
//		assertEquals("isPositiveOrNegativePercentage pos -1000.0001 Test", true, ComputeError.isPositiveOrNegativePercentage("-1000.0001"));
//		assertEquals("isPositiveOrNegativePercentage pos -1.0001 Test", true, ComputeError.isPositiveOrNegativePercentage("-1.0001"));
		
		assertEquals("isPositiveOrNegativePercentage neg 1000.0 Test", false, ComputeError.isPositiveOrNegativePercentage("1000.0"));
		assertEquals("isPositiveOrNegativePercentage neg -1000.0 Test", false, ComputeError.isPositiveOrNegativePercentage("-1000.0"));
		assertEquals("isPositiveOrNegativePercentage neg 10000.0000 Test", false, ComputeError.isPositiveOrNegativePercentage("10000.0000"));
		assertEquals("isPositiveOrNegativePercentage neg 0000.0000 Test", false, ComputeError.isPositiveOrNegativePercentage("0000.0000"));
		assertEquals("isPositiveOrNegativePercentage neg 0.000 Test", false, ComputeError.isPositiveOrNegativePercentage("0.0000"));
		assertEquals("isPositiveOrNegativePercentage neg .000 Test", false, ComputeError.isPositiveOrNegativePercentage(".0000"));
		assertEquals("isPositiveOrNegativePercentage neg 0.001 Test", false, ComputeError.isPositiveOrNegativePercentage("0.001"));
		assertEquals("isPositiveOrNegativePercentage neg -0.001 Test", false, ComputeError.isPositiveOrNegativePercentage("-0.001"));
		assertEquals("isPositiveOrNegativePercentage neg .001 Test", false, ComputeError.isPositiveOrNegativePercentage(".001"));
		assertEquals("isPositiveOrNegativePercentage neg -.001 Test", false, ComputeError.isPositiveOrNegativePercentage("-.001"));
		assertEquals("isPositiveOrNegativePercentage neg 1 Test", false, ComputeError.isPositiveOrNegativePercentage("1"));
		assertEquals("isPositiveOrNegativePercentage neg 0 Test", false, ComputeError.isPositiveOrNegativePercentage("0"));
		assertEquals("isPositiveOrNegativePercentage neg -0 Test", false, ComputeError.isPositiveOrNegativePercentage("-0"));
		assertEquals("isPositiveOrNegativePercentage neg -0 Test", false, ComputeError.isPositiveOrNegativePercentage("0.00001"));
		assertEquals("isPositiveOrNegativePercentage neg -0 Test", false, ComputeError.isPositiveOrNegativePercentage("10000.0"));
		assertEquals("isPositiveOrNegativePercentage neg -0 Test", false, ComputeError.isPositiveOrNegativePercentage("-0.00001"));
		assertEquals("isPositiveOrNegativePercentage neg -0 Test", false, ComputeError.isPositiveOrNegativePercentage("-10000.0"));
		assertEquals("isPositiveOrNegativePercentage neg empty Test", false, ComputeError.isPositiveOrNegativePercentage("empty"));
		assertEquals("isPositiveOrNegativePercentage neg -. Test", false, ComputeError.isPositiveOrNegativePercentage("-."));
		assertEquals("isPositiveOrNegativePercentage neg -empty Test", false, ComputeError.isPositiveOrNegativePercentage("-empty"));
		assertEquals("isPositiveOrNegativePercentage neg emp.ty Test", false, ComputeError.isPositiveOrNegativePercentage("emp.ty"));
	}
	
	@Test
	public void isPositivePercentage()
	{
//		assertEquals("isPositivePercentage pos 1000.0001 Test", true, ComputeError.isPositivePercentage("1000.0001"));
//		assertEquals("isPositivePercentage pos 1.0001 Test", true, ComputeError.isPositivePercentage("1.0001"));
//		
//		assertEquals("isPositivePercentage neg 1000.0 Test", false, ComputeError.isPositivePercentage("1000.0"));
//		assertEquals("isPositivePercentage neg 10000.0000 Test", false, ComputeError.isPositivePercentage("10000.0000"));
//		assertEquals("isPositivePercentage neg -1000.0001 Test", false, ComputeError.isPositivePercentage("-1000.0001"));
//		assertEquals("isPositivePercentage neg 0000.0000 Test", false, ComputeError.isPositivePercentage("0000.0000"));
//		assertEquals("isPositivePercentage neg 0.000 Test", false, ComputeError.isPositivePercentage("0.0000"));
//		assertEquals("isPositivePercentage neg .000 Test", false, ComputeError.isPositivePercentage(".0000"));
		assertEquals("isPositivePercentage neg 0.001 Test", false, ComputeError.isPositivePercentage("0.001"));
		assertEquals("isPositivePercentage neg -0.001 Test", false, ComputeError.isPositivePercentage("-0.001"));
		assertEquals("isPositivePercentage neg .001 Test", false, ComputeError.isPositivePercentage(".001"));
		assertEquals("isPositivePercentage neg -.001 Test", false, ComputeError.isPositivePercentage("-.001"));
		assertEquals("isPositivePercentage neg 1 Test", false, ComputeError.isPositivePercentage("1"));
		assertEquals("isPositivePercentage neg 0 Test", false, ComputeError.isPositivePercentage("0"));
		assertEquals("isPositivePercentage neg -0 Test", false, ComputeError.isPositivePercentage("-0"));
		assertEquals("isPositivePercentage neg -0 Test", false, ComputeError.isPositivePercentage("0.00001"));
		assertEquals("isPositivePercentage neg -0 Test", false, ComputeError.isPositivePercentage("10000.0"));
		assertEquals("isPositivePercentage neg -0 Test", false, ComputeError.isPositivePercentage("-0.00001"));
		assertEquals("isPositivePercentage neg -0 Test", false, ComputeError.isPositivePercentage("-10000.0"));
		assertEquals("isPositivePercentage neg empty Test", false, ComputeError.isPositivePercentage("empty"));
		assertEquals("isPositivePercentage neg -. Test", false, ComputeError.isPositivePercentage("-."));
		assertEquals("isPositivePercentage neg -empty Test", false, ComputeError.isPositivePercentage("-empty"));
		assertEquals("isPositivePercentage neg emp.ty Test", false, ComputeError.isPositivePercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveOrZeroPercentage()
	{
//		assertEquals("isPositiveOrZeroPercentage pos 1000.0001 Test", true, ComputeError.isPositiveOrZeroPercentage("1000.0001"));
//		assertEquals("isPositiveOrZeroPercentage pos 0000.0000 Test", true, ComputeError.isPositiveOrZeroPercentage("0000.0000"));
//		assertEquals("isPositiveOrZeroPercentage pos 1.0001 Test", true, ComputeError.isPositiveOrZeroPercentage("1.0001"));
//		assertEquals("isPositiveOrZeroPercentage pos 0.0000 Test", true, ComputeError.isPositiveOrZeroPercentage("0.0000"));
//		
//		assertEquals("isPositiveOrZeroPercentage neg 1000.0 Test", false, ComputeError.isPositiveOrZeroPercentage("1000.0"));
//		assertEquals("isPositiveOrZeroPercentage neg -1000.0 Test", false, ComputeError.isPositiveOrZeroPercentage("-1000.0"));
//		assertEquals("isPositiveOrZeroPercentage neg 0000.0 Test", false, ComputeError.isPositiveOrZeroPercentage("0000.0"));
//		assertEquals("isPositiveOrZeroPercentage neg 10000.0000 Test", false, ComputeError.isPositiveOrZeroPercentage("10000.0000"));
//		assertEquals("isPositiveOrZeroPercentage neg -1000.0001 Test", false, ComputeError.isPositiveOrZeroPercentage("-1000.0001"));
//		assertEquals("isPositiveOrZeroPercentage neg 0.000 Test", false, ComputeError.isPositiveOrZeroPercentage("0.000"));
		assertEquals("isPositiveOrZeroPercentage neg .000 Test", false, ComputeError.isPositiveOrZeroPercentage(".000"));
		assertEquals("isPositiveOrZeroPercentage neg 0.001 Test", false, ComputeError.isPositiveOrZeroPercentage("0.001"));
		assertEquals("isPositiveOrZeroPercentage neg -0.001 Test", false, ComputeError.isPositiveOrZeroPercentage("-0.001"));
		assertEquals("isPositiveOrZeroPercentage neg .001 Test", false, ComputeError.isPositiveOrZeroPercentage(".001"));
		assertEquals("isPositiveOrZeroPercentage neg -.001 Test", false, ComputeError.isPositiveOrZeroPercentage("-.001"));
		assertEquals("isPositiveOrZeroPercentage neg 1 Test", false, ComputeError.isPositiveOrZeroPercentage("1"));
		assertEquals("isPositiveOrZeroPercentage neg 0 Test", false, ComputeError.isPositiveOrZeroPercentage("0"));
		assertEquals("isPositiveOrZeroPercentage neg -0 Test", false, ComputeError.isPositiveOrZeroPercentage("-0"));
		assertEquals("isPositiveOrZeroPercentage neg 0.00001 Test", false, ComputeError.isPositiveOrZeroPercentage("0.00001"));
		assertEquals("isPositiveOrZeroPercentage neg 10000.0 Test", false, ComputeError.isPositiveOrZeroPercentage("10000.0"));
		assertEquals("isPositiveOrZeroPercentage neg -0.00001 Test", false, ComputeError.isPositiveOrZeroPercentage("-0.00001"));
		assertEquals("isPositiveOrZeroPercentage neg -10000.0 Test", false, ComputeError.isPositiveOrZeroPercentage("-10000.0"));
		assertEquals("isPositiveOrZeroPercentage neg empty Test", false, ComputeError.isPositiveOrZeroPercentage("empty"));
		assertEquals("isPositiveOrZeroPercentage neg -. Test", false, ComputeError.isPositiveOrZeroPercentage("-."));
		assertEquals("isPositiveOrZeroPercentage neg -empty Test", false, ComputeError.isPositiveOrZeroPercentage("-empty"));
		assertEquals("isPositiveOrZeroPercentage neg emp.ty Test", false, ComputeError.isPositiveOrZeroPercentage("emp.ty"));
	}
	
	@Test
	public void isNegativePercentage()
	{
//		assertEquals("isNegativePercentage pos -1000.0001 Test", true, ComputeError.isNegativePercentage("-1000.0001"));
//		assertEquals("isNegativePercentage pos -1.0001 Test", true, ComputeError.isNegativePercentage("-1.0001"));
//		
//		assertEquals("isNegativePercentage neg 1000.0 Test", false, ComputeError.isNegativePercentage("1000.0"));
//		assertEquals("isNegativePercentage neg -1000.0 Test", false, ComputeError.isNegativePercentage("-1000.0"));
//		assertEquals("isNegativePercentage neg 0000.0 Test", false, ComputeError.isNegativePercentage("0000.0"));
//		assertEquals("isNegativePercentage neg 10000.0000 Test", false, ComputeError.isNegativePercentage("10000.0000"));
//		assertEquals("isNegativePercentage neg 1000.0001 Test", false, ComputeError.isNegativePercentage("1000.0001"));
//		assertEquals("isNegativePercentage neg 0000.0000 Test", false, ComputeError.isNegativePercentage("0000.0000"));
//		assertEquals("isNegativePercentage neg 0.000 Test", false, ComputeError.isNegativePercentage("0.000"));
//		assertEquals("isNegativePercentage neg .000 Test", false, ComputeError.isNegativePercentage(".000"));
//		assertEquals("isNegativePercentage neg 0.001 Test", false, ComputeError.isNegativePercentage("0.001"));
//		assertEquals("isNegativePercentage neg -0.001 Test", false, ComputeError.isNegativePercentage("-0.001"));
//		assertEquals("isNegativePercentage neg .001 Test", false, ComputeError.isNegativePercentage(".001"));
		assertEquals("isNegativePercentage neg -.001 Test", false, ComputeError.isNegativePercentage("-.001"));
		assertEquals("isNegativePercentage neg 1 Test", false, ComputeError.isNegativePercentage("1"));
		assertEquals("isNegativePercentage neg 0 Test", false, ComputeError.isNegativePercentage("0"));
		assertEquals("isNegativePercentage neg -0 Test", false, ComputeError.isNegativePercentage("-0"));
		assertEquals("isNegativePercentage neg 0.00001 Test", false, ComputeError.isNegativePercentage("0.00001"));
		assertEquals("isNegativePercentage neg 10000.0 Test", false, ComputeError.isNegativePercentage("10000.0"));
		assertEquals("isNegativePercentage neg -0.00001 Test", false, ComputeError.isNegativePercentage("-0.00001"));
		assertEquals("isNegativePercentage neg -10000.0 Test", false, ComputeError.isNegativePercentage("-10000.0"));
		assertEquals("isNegativePercentage neg empty Test", false, ComputeError.isNegativePercentage("empty"));
		assertEquals("isNegativePercentage neg -. Test", false, ComputeError.isNegativePercentage("-."));
		assertEquals("isNegativePercentage neg -empty Test", false, ComputeError.isNegativePercentage("-empty"));
		assertEquals("isNegativePercentage neg emp.ty Test", false, ComputeError.isNegativePercentage("emp.ty"));
	}
	
	@Test
	public void isNegativeOrZeroPercentage()
	{
		assertEquals("isNegativeOrZeroPercentage pos -1000.0001 Test", true, ComputeError.isNegativeOrZeroPercentage("-1000.0001"));
		assertEquals("isNegativeOrZeroPercentage pos 0000.0000 Test", true, ComputeError.isNegativeOrZeroPercentage("0000.0000"));
		assertEquals("isNegativeOrZeroPercentage pos -1.0001 Test", true, ComputeError.isNegativeOrZeroPercentage("-1.0001"));
		assertEquals("isNegativeOrZeroPercentage pos 0.0000 Test", true, ComputeError.isNegativeOrZeroPercentage("0.0000"));
		
		assertEquals("isNegativeOrZeroPercentage neg 1000.0 Test", false, ComputeError.isNegativeOrZeroPercentage("1000.0"));
		assertEquals("isNegativeOrZeroPercentage neg -1000.0 Test", false, ComputeError.isNegativeOrZeroPercentage("-1000.0"));
		assertEquals("isNegativeOrZeroPercentage neg 0000.0 Test", false, ComputeError.isNegativeOrZeroPercentage("0000.0"));
		assertEquals("isNegativeOrZeroPercentage neg 10000.0000 Test", false, ComputeError.isNegativeOrZeroPercentage("10000.0000"));
		assertEquals("isNegativeOrZeroPercentage neg 1000.00001 Test", false, ComputeError.isNegativeOrZeroPercentage("1000.00001"));
		assertEquals("isNegativeOrZeroPercentage neg 0.000 Test", false, ComputeError.isNegativeOrZeroPercentage("0.000"));
		assertEquals("isNegativeOrZeroPercentage neg .000 Test", false, ComputeError.isNegativeOrZeroPercentage(".000"));
		assertEquals("isNegativeOrZeroPercentage neg 0.001 Test", false, ComputeError.isNegativeOrZeroPercentage("0.001"));
		assertEquals("isNegativeOrZeroPercentage neg -0.001 Test", false, ComputeError.isNegativeOrZeroPercentage("-0.001"));
		assertEquals("isNegativeOrZeroPercentage neg .001 Test", false, ComputeError.isNegativeOrZeroPercentage(".001"));
		assertEquals("isNegativeOrZeroPercentage neg -.001 Test", false, ComputeError.isNegativeOrZeroPercentage("-.001"));
		assertEquals("isNegativeOrZeroPercentage neg 1 Test", false, ComputeError.isNegativeOrZeroPercentage("1"));
		assertEquals("isNegativeOrZeroPercentage neg 0 Test", false, ComputeError.isNegativeOrZeroPercentage("0"));
		assertEquals("isNegativeOrZeroPercentage neg -0 Test", false, ComputeError.isNegativeOrZeroPercentage("-0"));
		assertEquals("isNegativeOrZeroPercentage neg 0.00001 Test", false, ComputeError.isNegativeOrZeroPercentage("0.00001"));
		assertEquals("isNegativeOrZeroPercentage neg 10000.0 Test", false, ComputeError.isNegativeOrZeroPercentage("10000.0"));
		assertEquals("isNegativeOrZeroPercentage neg -0.00001 Test", false, ComputeError.isNegativeOrZeroPercentage("-0.00001"));
		assertEquals("isNegativeOrZeroPercentage neg -10000.0 Test", false, ComputeError.isNegativeOrZeroPercentage("-10000.0"));
		assertEquals("isNegativeOrZeroPercentage neg empty Test", false, ComputeError.isNegativeOrZeroPercentage("empty"));
		assertEquals("isNegativeOrZeroPercentage neg -. Test", false, ComputeError.isNegativeOrZeroPercentage("-."));
		assertEquals("isNegativeOrZeroPercentage neg -empty Test", false, ComputeError.isNegativeOrZeroPercentage("-empty"));
		assertEquals("isNegativeOrZeroPercentage neg emp.ty Test", false, ComputeError.isNegativeOrZeroPercentage("emp.ty"));
	}
	
	@Test
	public void isWeakPercentage()
	{
		assertEquals("isWeakPercentage pos 100.001 Test", true, ComputeError.isWeakPercentage("100.001"));
		assertEquals("isWeakPercentage pos -100.001 Test", true, ComputeError.isWeakPercentage("-100.001"));
		assertEquals("isWeakPercentage pos 000.000 Test", true, ComputeError.isWeakPercentage("000.000"));
		assertEquals("isWeakPercentage pos 1.001 Test", true, ComputeError.isWeakPercentage("1.001"));
		assertEquals("isWeakPercentage pos -1.001 Test", true, ComputeError.isWeakPercentage("-1.001"));
		assertEquals("isWeakPercentage pos 0.000 Test", true, ComputeError.isWeakPercentage("0.000"));
		
		assertEquals("isWeakPercentage neg 100.0 Test", false, ComputeError.isWeakPercentage("100.0"));
		assertEquals("isWeakPercentage neg -100.0 Test", false, ComputeError.isWeakPercentage("-100.0"));
		assertEquals("isWeakPercentage neg 0000.0 Test", false, ComputeError.isWeakPercentage("000.0"));
		assertEquals("isWeakPercentage neg 10000.0000 Test", false, ComputeError.isWeakPercentage("10000.0000"));
		assertEquals("isWeakPercentage neg 0.000 Test", false, ComputeError.isWeakPercentage("0.0000"));
		assertEquals("isWeakPercentage neg .000 Test", false, ComputeError.isWeakPercentage(".0000"));
		assertEquals("isWeakPercentage neg 0.0001 Test", false, ComputeError.isWeakPercentage("0.0001"));
		assertEquals("isWeakPercentage neg -0.001 Test", false, ComputeError.isWeakPercentage("-0.0001"));
		assertEquals("isWeakPercentage neg .0001 Test", false, ComputeError.isWeakPercentage(".0001"));
		assertEquals("isWeakPercentage neg -.0001 Test", false, ComputeError.isWeakPercentage("-.0001"));
		assertEquals("isWeakPercentage neg 1 Test", false, ComputeError.isWeakPercentage("1"));
		assertEquals("isWeakPercentage neg 0 Test", false, ComputeError.isWeakPercentage("0"));
		assertEquals("isWeakPercentage neg -0 Test", false, ComputeError.isWeakPercentage("-0"));
		assertEquals("isWeakPercentage neg -0 Test", false, ComputeError.isWeakPercentage("0.00001"));
		assertEquals("isWeakPercentage neg -0 Test", false, ComputeError.isWeakPercentage("10000.0"));
		assertEquals("isWeakPercentage neg -0 Test", false, ComputeError.isWeakPercentage("-0.00001"));
		assertEquals("isWeakPercentage neg -0 Test", false, ComputeError.isWeakPercentage("-10000.0"));
		assertEquals("isWeakPercentage neg empty Test", false, ComputeError.isWeakPercentage("empty"));
		assertEquals("isWeakPercentage neg -. Test", false, ComputeError.isWeakPercentage("-."));
		assertEquals("isWeakPercentage neg -empty Test", false, ComputeError.isWeakPercentage("-empty"));
		assertEquals("isWeakPercentage neg emp.ty Test", false, ComputeError.isWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveOrNegativeWeakPercentage()
	{
		assertEquals("isPositiveOrNegativeWeakPercentage pos 100.001 Test", true, ComputeError.isPositiveOrNegativeWeakPercentage("100.001"));
		assertEquals("isPositiveOrNegativeWeakPercentage pos -100.001 Test", true, ComputeError.isPositiveOrNegativeWeakPercentage("-100.001"));
		assertEquals("isPositiveOrNegativeWeakPercentage pos 1.001 Test", true, ComputeError.isPositiveOrNegativeWeakPercentage("1.001"));
		assertEquals("isPositiveOrNegativeWeakPercentage pos -1.001 Test", true, ComputeError.isPositiveOrNegativeWeakPercentage("-1.001"));
		
		assertEquals("isPositiveOrNegativeWeakPercentage neg 1000.0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("100.0"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -1000.0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-100.0"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg 0000.0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("000.0"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg 10000.0000 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("10000.0000"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg 0000.0000 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("0000.0000"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg 0.000 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("0.0000"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg .000 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage(".0000"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg 0.0001 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("0.0001"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -0.001 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-0.0001"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg .0001 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage(".0001"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -.0001 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-.0001"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg 1 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("1"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg 0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("0"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-0"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("0.00001"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("10000.0"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-0.00001"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-10000.0"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg empty Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("empty"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -. Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-."));
		assertEquals("isPositiveOrNegativeWeakPercentage neg -empty Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("-empty"));
		assertEquals("isPositiveOrNegativeWeakPercentage neg emp.ty Test", false, ComputeError.isPositiveOrNegativeWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveWeakPercentage()
	{
		assertEquals("isPositiveWeakPercentage pos 100.001 Test", true, ComputeError.isPositiveWeakPercentage("100.001"));
		assertEquals("isPositiveWeakPercentage pos 1.001 Test", true, ComputeError.isPositiveWeakPercentage("1.001"));
		
		assertEquals("isPositiveWeakPercentage neg 100.0 Test", false, ComputeError.isPositiveWeakPercentage("100.0"));
		assertEquals("isPositiveWeakPercentage neg -100.0 Test", false, ComputeError.isPositiveWeakPercentage("-100.0"));
		assertEquals("isPositiveWeakPercentage neg 000.0 Test", false, ComputeError.isPositiveWeakPercentage("000.0"));
		assertEquals("isPositiveWeakPercentage neg 10000.0000 Test", false, ComputeError.isPositiveWeakPercentage("1000.000"));
		assertEquals("isPositiveWeakPercentage neg -1000.0001 Test", false, ComputeError.isPositiveWeakPercentage("-1000.0001"));
		assertEquals("isPositiveWeakPercentage neg 0000.0000 Test", false, ComputeError.isPositiveWeakPercentage("0000.0000"));
		assertEquals("isPositiveWeakPercentage neg 0.000 Test", false, ComputeError.isPositiveWeakPercentage("0.0000"));
		assertEquals("isPositiveWeakPercentage neg .000 Test", false, ComputeError.isPositiveWeakPercentage(".0000"));
		assertEquals("isPositiveWeakPercentage neg 0.0001 Test", false, ComputeError.isPositiveWeakPercentage("0.0001"));
		assertEquals("isPositiveWeakPercentage neg -0.001 Test", false, ComputeError.isPositiveWeakPercentage("-0.0001"));
		assertEquals("isPositiveWeakPercentage neg .0001 Test", false, ComputeError.isPositiveWeakPercentage(".0001"));
		assertEquals("isPositiveWeakPercentage neg -.0001 Test", false, ComputeError.isPositiveWeakPercentage("-.0001"));
		assertEquals("isPositiveWeakPercentage neg 1 Test", false, ComputeError.isPositiveWeakPercentage("1"));
		assertEquals("isPositiveWeakPercentage neg 0 Test", false, ComputeError.isPositiveWeakPercentage("0"));
		assertEquals("isPositiveWeakPercentage neg -0 Test", false, ComputeError.isPositiveWeakPercentage("-0"));
		assertEquals("isPositiveWeakPercentage neg -0 Test", false, ComputeError.isPositiveWeakPercentage("0.00001"));
		assertEquals("isPositiveWeakPercentage neg -0 Test", false, ComputeError.isPositiveWeakPercentage("10000.0"));
		assertEquals("isPositiveWeakPercentage neg -0 Test", false, ComputeError.isPositiveWeakPercentage("-0.00001"));
		assertEquals("isPositiveWeakPercentage neg -0 Test", false, ComputeError.isPositiveWeakPercentage("-10000.0"));
		assertEquals("isPositiveWeakPercentage neg empty Test", false, ComputeError.isPositiveWeakPercentage("empty"));
		assertEquals("isPositiveWeakPercentage neg -. Test", false, ComputeError.isPositiveWeakPercentage("-."));
		assertEquals("isPositiveWeakPercentage neg -empty Test", false, ComputeError.isPositiveWeakPercentage("-empty"));
		assertEquals("isPositiveWeakPercentage neg emp.ty Test", false, ComputeError.isPositiveWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveOrZeroWeakPercentage()
	{
		assertEquals("isPositiveOrZeroWeakPercentage pos 100.0001 Test", true, ComputeError.isPositiveOrZeroWeakPercentage("100.001"));
		assertEquals("isPositiveOrZeroWeakPercentage pos 000.000 Test", true, ComputeError.isPositiveOrZeroWeakPercentage("000.000"));
		assertEquals("isPositiveOrZeroWeakPercentage pos 1.001 Test", true, ComputeError.isPositiveOrZeroWeakPercentage("1.001"));
		assertEquals("isPositiveOrZeroWeakPercentage pos 0.000 Test", true, ComputeError.isPositiveOrZeroWeakPercentage("0.000"));
		
		assertEquals("isPositiveOrZeroWeakPercentage neg 100.0 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("100.0"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -100.0 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-100.0"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 000.0 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("000.0"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 10000.0000 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("10000.0000"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -1000.0001 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-1000.0001"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 0.000 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("0.0000"));
		assertEquals("isPositiveOrZeroWeakPercentage neg .000 Test", false, ComputeError.isPositiveOrZeroWeakPercentage(".0000"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 0.0001 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("0.0001"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -0.001 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-0.0001"));
		assertEquals("isPositiveOrZeroWeakPercentage neg .0001 Test", false, ComputeError.isPositiveOrZeroWeakPercentage(".0001"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -.0001 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-.0001"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 1 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("1"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 0 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("0"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-0"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 0.00001 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("0.00001"));
		assertEquals("isPositiveOrZeroWeakPercentage neg 10000.0 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("10000.0"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -0.00001 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-0.00001"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -10000.0 Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-10000.0"));
		assertEquals("isPositiveOrZeroWeakPercentage neg empty Test", false, ComputeError.isPositiveOrZeroWeakPercentage("empty"));
		assertEquals("isPositiveOrZeroWeakPercentage neg -. Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-."));
		assertEquals("isPositiveOrZeroWeakPercentage neg -empty Test", false, ComputeError.isPositiveOrZeroWeakPercentage("-empty"));
		assertEquals("isPositiveOrZeroWeakPercentage neg emp.ty Test", false, ComputeError.isPositiveOrZeroWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isNegativeWeakPercentage()
	{
		assertEquals("isNegativeWeakPercentage pos -100.001 Test", true, ComputeError.isNegativeWeakPercentage("-100.001"));
		assertEquals("isNegativeWeakPercentage pos -1.001 Test", true, ComputeError.isNegativeWeakPercentage("-1.001"));
		
		assertEquals("isNegativeWeakPercentage neg 100.0 Test", false, ComputeError.isNegativeWeakPercentage("100.0"));
		assertEquals("isNegativeWeakPercentage neg -100.0 Test", false, ComputeError.isNegativeWeakPercentage("-100.0"));
		assertEquals("isNegativeWeakPercentage neg 000.0 Test", false, ComputeError.isNegativeWeakPercentage("000.0"));
		assertEquals("isNegativeWeakPercentage neg 10000.0000 Test", false, ComputeError.isNegativeWeakPercentage("1000.000"));
		assertEquals("isNegativeWeakPercentage neg 1000.0001 Test", false, ComputeError.isNegativeWeakPercentage("1000.0001"));
		assertEquals("isNegativeWeakPercentage neg 0000.0000 Test", false, ComputeError.isNegativeWeakPercentage("0000.0000"));
		assertEquals("isNegativeWeakPercentage neg 0.000 Test", false, ComputeError.isNegativeWeakPercentage("0.0000"));
		assertEquals("isNegativeWeakPercentage neg .000 Test", false, ComputeError.isNegativeWeakPercentage(".0000"));
		assertEquals("isNegativeWeakPercentage neg 0.0001 Test", false, ComputeError.isNegativeWeakPercentage("0.0001"));
		assertEquals("isNegativeWeakPercentage neg -0.001 Test", false, ComputeError.isNegativeWeakPercentage("-0.0001"));
		assertEquals("isNegativeWeakPercentage neg .0001 Test", false, ComputeError.isNegativeWeakPercentage(".0001"));
		assertEquals("isNegativeWeakPercentage neg -.0001 Test", false, ComputeError.isNegativeWeakPercentage("-.0001"));
		assertEquals("isNegativeWeakPercentage neg 1 Test", false, ComputeError.isNegativeWeakPercentage("1"));
		assertEquals("isNegativeWeakPercentage neg 0 Test", false, ComputeError.isNegativeWeakPercentage("0"));
		assertEquals("isNegativeWeakPercentage neg -0 Test", false, ComputeError.isNegativeWeakPercentage("-0"));
		assertEquals("isNegativeWeakPercentage neg 0.00001 Test", false, ComputeError.isNegativeWeakPercentage("0.00001"));
		assertEquals("isNegativeWeakPercentage neg 10000.0 Test", false, ComputeError.isNegativeWeakPercentage("10000.0"));
		assertEquals("isNegativeWeakPercentage neg -0.00001 Test", false, ComputeError.isNegativeWeakPercentage("-0.00001"));
		assertEquals("isNegativeWeakPercentage neg -10000.0 Test", false, ComputeError.isNegativeWeakPercentage("-10000.0"));
		assertEquals("isNegativeWeakPercentage neg empty Test", false, ComputeError.isNegativeWeakPercentage("empty"));
		assertEquals("isNegativeWeakPercentage neg -. Test", false, ComputeError.isNegativeWeakPercentage("-."));
		assertEquals("isNegativeWeakPercentage neg -empty Test", false, ComputeError.isNegativeWeakPercentage("-empty"));
		assertEquals("isNegativeWeakPercentage neg emp.ty Test", false, ComputeError.isNegativeWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isNegativeOrZeroWeakPercentage()
	{
		assertEquals("isNegativeOrZeroWeakPercentage pos -100.001 Test", true, ComputeError.isNegativeOrZeroWeakPercentage("-100.001"));
		assertEquals("isNegativeOrZeroWeakPercentage pos 000.000 Test", true, ComputeError.isNegativeOrZeroWeakPercentage("000.000"));
		assertEquals("isNegativeOrZeroWeakPercentage pos -1.001 Test", true, ComputeError.isNegativeOrZeroWeakPercentage("-1.001"));
		assertEquals("isNegativeOrZeroWeakPercentage pos 0.000 Test", true, ComputeError.isNegativeOrZeroWeakPercentage("0.000"));
		
		assertEquals("isNegativeOrZeroWeakPercentage neg 100.0 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("100.0"));
		assertEquals("isNegativeOrZeroWeakPercentage neg -100.0 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-100.0"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 000.0 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("000.0"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 10000.0000 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("10000.0000"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 1000.0001 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("1000.0001"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 0.000 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("0.0000"));
		assertEquals("isNegativeOrZeroWeakPercentage neg .000 Test", false, ComputeError.isNegativeOrZeroWeakPercentage(".0000"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 0.0001 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("0.0001"));
		assertEquals("isNegativeOrZeroWeakPercentage neg -0.001 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-0.0001"));
		assertEquals("isNegativeOrZeroWeakPercentage neg .0001 Test", false, ComputeError.isNegativeOrZeroWeakPercentage(".0001"));
		assertEquals("isNegativeOrZeroWeakPercentage neg -.0001 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-.0001"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 1 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("1"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 0 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("0"));
		assertEquals("isNegativeOrZeroWeakPercentage neg -0 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-0"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 0.00001 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("0.00001"));
		assertEquals("isNegativeOrZeroWeakPercentage neg 10000.0 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("10000.0"));
		assertEquals("isNegativeOrZeroWeakPercentage neg -0.00001 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-0.00001"));
		assertEquals("isNegativeOrZeroWeakPercentage neg -10000.0 Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-10000.0"));
		assertEquals("isNegativeOrZeroWeakPercentage neg empty Test", false, ComputeError.isNegativeOrZeroWeakPercentage("empty"));
		assertEquals("isNegativeOrZeroWeakPercentage neg -. Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-."));
		assertEquals("isNegativeOrZeroWeakPercentage neg -empty Test", false, ComputeError.isNegativeOrZeroWeakPercentage("-empty"));
		assertEquals("isNegativeOrZeroWeakPercentage neg emp.ty Test", false, ComputeError.isNegativeOrZeroWeakPercentage("emp.ty"));
	}

	@Test
	public void isSuperWeakPercentage()
	{
		assertEquals("isSuperWeakPercentage pos 10.01 Test", true, ComputeError.isSuperWeakPercentage("10.01"));
		assertEquals("isSuperWeakPercentage pos -10.01 Test", true, ComputeError.isSuperWeakPercentage("-10.01"));
		assertEquals("isSuperWeakPercentage pos 00.00 Test", true, ComputeError.isSuperWeakPercentage("00.00"));
		assertEquals("isSuperWeakPercentage pos 1.01 Test", true, ComputeError.isSuperWeakPercentage("1.01"));
		assertEquals("isSuperWeakPercentage pos -1.01 Test", true, ComputeError.isSuperWeakPercentage("-1.01"));
		assertEquals("isSuperWeakPercentage pos 0.00 Test", true, ComputeError.isSuperWeakPercentage("0.00"));
		
		assertEquals("isSuperWeakPercentage neg 10.0 Test", false, ComputeError.isSuperWeakPercentage("10.0"));
		assertEquals("isSuperWeakPercentage neg -10.0 Test", false, ComputeError.isSuperWeakPercentage("-10.0"));
		assertEquals("isSuperWeakPercentage neg 00.0 Test", false, ComputeError.isSuperWeakPercentage("00.0"));
		assertEquals("isSuperWeakPercentage neg 10000.0000 Test", false, ComputeError.isSuperWeakPercentage("10000.0000"));
		assertEquals("isSuperWeakPercentage neg 0.000 Test", false, ComputeError.isSuperWeakPercentage("0.0000"));
		assertEquals("isSuperWeakPercentage neg .000 Test", false, ComputeError.isSuperWeakPercentage(".0000"));
		assertEquals("isSuperWeakPercentage neg 0.0001 Test", false, ComputeError.isSuperWeakPercentage("0.0001"));
		assertEquals("isSuperWeakPercentage neg -0.001 Test", false, ComputeError.isSuperWeakPercentage("-0.0001"));
		assertEquals("isSuperWeakPercentage neg .0001 Test", false, ComputeError.isSuperWeakPercentage(".0001"));
		assertEquals("isSuperWeakPercentage neg -.0001 Test", false, ComputeError.isSuperWeakPercentage("-.0001"));
		assertEquals("isSuperWeakPercentage neg 1 Test", false, ComputeError.isSuperWeakPercentage("1"));
		assertEquals("isSuperWeakPercentage neg 0 Test", false, ComputeError.isSuperWeakPercentage("0"));
		assertEquals("isSuperWeakPercentage neg -0 Test", false, ComputeError.isSuperWeakPercentage("-0"));
		assertEquals("isSuperWeakPercentage neg -0 Test", false, ComputeError.isSuperWeakPercentage("0.00001"));
		assertEquals("isSuperWeakPercentage neg -0 Test", false, ComputeError.isSuperWeakPercentage("10000.0"));
		assertEquals("isSuperWeakPercentage neg -0 Test", false, ComputeError.isSuperWeakPercentage("-0.00001"));
		assertEquals("isSuperWeakPercentage neg -0 Test", false, ComputeError.isSuperWeakPercentage("-10000.0"));
		assertEquals("isSuperWeakPercentage neg empty Test", false, ComputeError.isSuperWeakPercentage("empty"));
		assertEquals("isSuperWeakPercentage neg -. Test", false, ComputeError.isSuperWeakPercentage("-."));
		assertEquals("isSuperWeakPercentage neg -empty Test", false, ComputeError.isSuperWeakPercentage("-empty"));
		assertEquals("isSuperWeakPercentage neg emp.ty Test", false, ComputeError.isSuperWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveOrNegativeSuperWeakPercentage()
	{
		assertEquals("isPositiveOrNegativeSuperWeakPercentage pos 10.01 Test", true, ComputeError.isPositiveOrNegativeSuperWeakPercentage("10.01"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage pos -10.01 Test", true, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-10.01"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage pos 1.01 Test", true, ComputeError.isPositiveOrNegativeSuperWeakPercentage("1.01"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage pos -1.01 Test", true, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-1.01"));
		
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 10.0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("10.0"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -10.0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-10.0"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 00.0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("00.0"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 10000.0000 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("10000.0000"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 0000.0000 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("0000.0000"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 0.000 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("0.0000"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg .000 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage(".0000"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 0.0001 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("0.0001"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -0.001 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-0.0001"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg .0001 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage(".0001"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -.0001 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-.0001"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 1 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("1"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg 0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("0"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-0"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("0.00001"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("10000.0"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-0.00001"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-10000.0"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg empty Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("empty"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -. Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-."));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg -empty Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("-empty"));
		assertEquals("isPositiveOrNegativeSuperWeakPercentage neg emp.ty Test", false, ComputeError.isPositiveOrNegativeSuperWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveSuperWeakPercentage()
	{
		assertEquals("isPositiveSuperWeakPercentage pos 10.01 Test", true, ComputeError.isPositiveSuperWeakPercentage("10.01"));
		assertEquals("isPositiveSuperWeakPercentage pos 1.0001 Test", true, ComputeError.isPositiveSuperWeakPercentage("1.01"));
		
		assertEquals("isPositiveSuperWeakPercentage neg 10.0 Test", false, ComputeError.isPositiveSuperWeakPercentage("10.0"));
		assertEquals("isPositiveSuperWeakPercentage neg -10.0 Test", false, ComputeError.isPositiveSuperWeakPercentage("-10.0"));
		assertEquals("isPositiveSuperWeakPercentage neg 00.0 Test", false, ComputeError.isPositiveSuperWeakPercentage("00.0"));
		assertEquals("isPositiveSuperWeakPercentage neg 0.00 Test", false, ComputeError.isPositiveSuperWeakPercentage("0.00"));
		assertEquals("isPositiveSuperWeakPercentage neg -1000.0001 Test", false, ComputeError.isPositiveSuperWeakPercentage("-1000.0001"));
		assertEquals("isPositiveSuperWeakPercentage neg 0000.0000 Test", false, ComputeError.isPositiveSuperWeakPercentage("0000.0000"));
		assertEquals("isPositiveSuperWeakPercentage neg 0.000 Test", false, ComputeError.isPositiveSuperWeakPercentage("0.0000"));
		assertEquals("isPositiveSuperWeakPercentage neg .000 Test", false, ComputeError.isPositiveSuperWeakPercentage(".0000"));
		assertEquals("isPositiveSuperWeakPercentage neg 0.0001 Test", false, ComputeError.isPositiveSuperWeakPercentage("0.0001"));
		assertEquals("isPositiveSuperWeakPercentage neg -0.001 Test", false, ComputeError.isPositiveSuperWeakPercentage("-0.0001"));
		assertEquals("isPositiveSuperWeakPercentage neg .0001 Test", false, ComputeError.isPositiveSuperWeakPercentage(".0001"));
		assertEquals("isPositiveSuperWeakPercentage neg -.0001 Test", false, ComputeError.isPositiveSuperWeakPercentage("-.0001"));
		assertEquals("isPositiveSuperWeakPercentage neg 1 Test", false, ComputeError.isPositiveSuperWeakPercentage("1"));
		assertEquals("isPositiveSuperWeakPercentage neg 0 Test", false, ComputeError.isPositiveSuperWeakPercentage("0"));
		assertEquals("isPositiveSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveSuperWeakPercentage("-0"));
		assertEquals("isPositiveSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveSuperWeakPercentage("0.00001"));
		assertEquals("isPositiveSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveSuperWeakPercentage("10000.0"));
		assertEquals("isPositiveSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveSuperWeakPercentage("-0.00001"));
		assertEquals("isPositiveSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveSuperWeakPercentage("-10000.0"));
		assertEquals("isPositiveSuperWeakPercentage neg empty Test", false, ComputeError.isPositiveSuperWeakPercentage("empty"));
		assertEquals("isPositiveSuperWeakPercentage neg -. Test", false, ComputeError.isPositiveSuperWeakPercentage("-."));
		assertEquals("isPositiveSuperWeakPercentage neg -empty Test", false, ComputeError.isPositiveSuperWeakPercentage("-empty"));
		assertEquals("isPositiveSuperWeakPercentage neg emp.ty Test", false, ComputeError.isPositiveSuperWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isPositiveOrZeroSuperWeakPercentage()
	{
		assertEquals("isPositiveOrZeroSuperWeakPercentage pos 10.01 Test", true, ComputeError.isPositiveOrZeroSuperWeakPercentage("10.01"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage pos 00.00 Test", true, ComputeError.isPositiveOrZeroSuperWeakPercentage("00.00"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage pos 1.01 Test", true, ComputeError.isPositiveOrZeroSuperWeakPercentage("1.01"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage pos 0.00 Test", true, ComputeError.isPositiveOrZeroSuperWeakPercentage("0.00"));
		
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 10.0 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("10.0"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -10.0 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-10.0"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 00.0 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("00.0"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 10000.0000 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("10000.0000"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -1000.0001 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-1000.0001"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 0.000 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("0.0000"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg .000 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage(".0000"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 0.0001 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("0.0001"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -0.001 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-0.0001"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg .0001 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage(".0001"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -.0001 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-.0001"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 1 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("1"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 0 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("0"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -0 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-0"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 0.00001 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("0.00001"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg 10000.0 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("10000.0"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -0.00001 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-0.00001"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -10000.0 Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-10000.0"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg empty Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("empty"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -. Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-."));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg -empty Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("-empty"));
		assertEquals("isPositiveOrZeroSuperWeakPercentage neg emp.ty Test", false, ComputeError.isPositiveOrZeroSuperWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isNegativeSuperWeakPercentage()
	{
		assertEquals("isNegativeSuperWeakPercentage pos -10.01 Test", true, ComputeError.isNegativeSuperWeakPercentage("-10.01"));
		assertEquals("isNegativeSuperWeakPercentage pos -1.01 Test", true, ComputeError.isNegativeSuperWeakPercentage("-1.01"));
		
		assertEquals("isNegativeSuperWeakPercentage neg 10.0 Test", false, ComputeError.isNegativeSuperWeakPercentage("10.0"));
		assertEquals("isNegativeSuperWeakPercentage neg -10.0 Test", false, ComputeError.isNegativeSuperWeakPercentage("-10.0"));
		assertEquals("isNegativeSuperWeakPercentage neg 00.0 Test", false, ComputeError.isNegativeSuperWeakPercentage("00.0"));
		assertEquals("isNegativeSuperWeakPercentage neg 10000.0000 Test", false, ComputeError.isNegativeSuperWeakPercentage("10.00"));
		assertEquals("isNegativeSuperWeakPercentage neg 1000.0001 Test", false, ComputeError.isNegativeSuperWeakPercentage("1000.0001"));
		assertEquals("isNegativeSuperWeakPercentage neg 0000.0000 Test", false, ComputeError.isNegativeSuperWeakPercentage("0000.0000"));
		assertEquals("isNegativeSuperWeakPercentage neg 0.000 Test", false, ComputeError.isNegativeSuperWeakPercentage("0.0000"));
		assertEquals("isNegativeSuperWeakPercentage neg .000 Test", false, ComputeError.isNegativeSuperWeakPercentage(".0000"));
		assertEquals("isNegativeSuperWeakPercentage neg 0.0001 Test", false, ComputeError.isNegativeSuperWeakPercentage("0.0001"));
		assertEquals("isNegativeSuperWeakPercentage neg -0.001 Test", false, ComputeError.isNegativeSuperWeakPercentage("-0.0001"));
		assertEquals("isNegativeSuperWeakPercentage neg .0001 Test", false, ComputeError.isNegativeSuperWeakPercentage(".0001"));
		assertEquals("isNegativeSuperWeakPercentage neg -.0001 Test", false, ComputeError.isNegativeSuperWeakPercentage("-.0001"));
		assertEquals("isNegativeSuperWeakPercentage neg 1 Test", false, ComputeError.isNegativeSuperWeakPercentage("1"));
		assertEquals("isNegativeSuperWeakPercentage neg 0 Test", false, ComputeError.isNegativeSuperWeakPercentage("0"));
		assertEquals("isNegativeSuperWeakPercentage neg -0 Test", false, ComputeError.isNegativeSuperWeakPercentage("-0"));
		assertEquals("isNegativeSuperWeakPercentage neg 0.00001 Test", false, ComputeError.isNegativeSuperWeakPercentage("0.00001"));
		assertEquals("isNegativeSuperWeakPercentage neg 10000.0 Test", false, ComputeError.isNegativeSuperWeakPercentage("10000.0"));
		assertEquals("isNegativeSuperWeakPercentage neg -0.00001 Test", false, ComputeError.isNegativeSuperWeakPercentage("-0.00001"));
		assertEquals("isNegativeSuperWeakPercentage neg -10000.0 Test", false, ComputeError.isNegativeSuperWeakPercentage("-10000.0"));
		assertEquals("isNegativeSuperWeakPercentage neg empty Test", false, ComputeError.isNegativeSuperWeakPercentage("empty"));
		assertEquals("isNegativeSuperWeakPercentage neg -. Test", false, ComputeError.isNegativeSuperWeakPercentage("-."));
		assertEquals("isNegativeSuperWeakPercentage neg -empty Test", false, ComputeError.isNegativeSuperWeakPercentage("-empty"));
		assertEquals("isNegativeSuperWeakPercentage neg emp.ty Test", false, ComputeError.isNegativeSuperWeakPercentage("emp.ty"));
	}
	
	@Test
	public void isNegativeOrZeroSuperWeakPercentage()
	{
		assertEquals("isNegativeOrZeroSuperWeakPercentage pos -10.01 Test", true, ComputeError.isNegativeOrZeroSuperWeakPercentage("-10.01"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage pos 00.00 Test", true, ComputeError.isNegativeOrZeroSuperWeakPercentage("00.00"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage pos -1.01 Test", true, ComputeError.isNegativeOrZeroSuperWeakPercentage("-1.01"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage pos 0.00 Test", true, ComputeError.isNegativeOrZeroSuperWeakPercentage("0.00"));
		
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 10.0 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("10.0"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -10.0 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-10.0"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 00.0 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("00.0"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 10000.0000 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("10000.0000"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 1000.0001 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("1000.0001"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 0.000 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("0.0000"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg .000 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage(".0000"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 0.0001 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("0.0001"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -0.001 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-0.0001"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg .0001 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage(".0001"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -.0001 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-.0001"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 1 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("1"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 0 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("0"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -0 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-0"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 0.00001 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("0.00001"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg 10000.0 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("10000.0"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -0.00001 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-0.00001"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -10000.0 Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-10000.0"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg empty Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("empty"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -. Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-."));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg -empty Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("-empty"));
		assertEquals("isNegativeOrZeroSuperWeakPercentage neg emp.ty Test", false, ComputeError.isNegativeOrZeroSuperWeakPercentage("emp.ty"));
	}

	@Test
	public void isWithinLowerBound()
	{
		assertEquals("isWithinLowerBound pos 25 >= 0", true, ComputeError.isWithinLowerBound("25", new BigDecimal(0)));
		assertEquals("isWithinLowerBound pos 0 >= 0", true, ComputeError.isWithinLowerBound("0", new BigDecimal(0)));
		
		assertEquals("isWithinLowerBound neg -25 !>= 0", false, ComputeError.isWithinLowerBound("-25", new BigDecimal(0)));
		assertEquals("isWithinLowerBound neg blue !>= 0", false, ComputeError.isWithinLowerBound("blue", new BigDecimal(0)));
	}
	
	@Test
	public void isWithinUpperBound()
	{
		assertEquals("isWithinUpperBound pos -25 <= 0", true, ComputeError.isWithinUpperBound("-25", new BigDecimal(0)));
		assertEquals("isWithinUpperBound pos 0 <= 0", true, ComputeError.isWithinUpperBound("0", new BigDecimal(0)));
		
		assertEquals("isWithinUpperBound neg 25 !>= 0", false, ComputeError.isWithinUpperBound("25", new BigDecimal(0)));
		assertEquals("isWithinUpperBound neg blue !>= 0", false, ComputeError.isWithinUpperBound("blue", new BigDecimal(0)));
	}
	
	@Test
	public void isWithinBounds()
	{
		assertEquals("isWithinBounds pos 1 is 1:5", true, ComputeError.isWithinBounds("1", new BigDecimal(1), new BigDecimal(5)));
		assertEquals("isWithinBounds pos 3 is 1:5", true, ComputeError.isWithinBounds("3", new BigDecimal(1), new BigDecimal(5)));
		assertEquals("isWithinBounds pos 5 is 1:5", true, ComputeError.isWithinBounds("5", new BigDecimal(1), new BigDecimal(5)));
		
		assertEquals("isWithinBounds neg 0 is !1:5", false, ComputeError.isWithinBounds("0", new BigDecimal(1), new BigDecimal(5)));
		assertEquals("isWithinBounds neg 6 is !1:5", false, ComputeError.isWithinBounds("6", new BigDecimal(1), new BigDecimal(5)));
		assertEquals("isWithinBounds neg blue is !1:5", false, ComputeError.isWithinBounds("blue", new BigDecimal(1), new BigDecimal(5)));
	}
	
	@Test
	public void isWithinBoundsWithIntegers()
	{
		assertEquals("isWithinBounds pos 1 is 1:5", true, ComputeError.isWithinBounds("1", 1, 5));
		assertEquals("isWithinBounds pos 3 is 1:5", true, ComputeError.isWithinBounds("3", 1, 5));
		assertEquals("isWithinBounds pos 5 is 1:5", true, ComputeError.isWithinBounds("5", 1, 5));
				
		assertEquals("isWithinBounds neg 0 is !1:5", false, ComputeError.isWithinBounds("0", 1, 5));
		assertEquals("isWithinBounds neg 6 is !1:5", false, ComputeError.isWithinBounds("6", 1, 5));
		assertEquals("isWithinBounds neg blue is !1:5", false, ComputeError.isWithinBounds("blue", 1, 5));
	}
	
	@Test
	public void isDate()
	{
		assertEquals("isDate pos 0000-01-01", true, ComputeError.isDate("0000-01-01"));
		assertEquals("isDate pos 2018-01-31", true, ComputeError.isDate("2018-01-31"));
		assertEquals("isDate pos 2018-02-28", true, ComputeError.isDate("2018-02-28"));
		assertEquals("isDate pos 2016-02-29", true, ComputeError.isDate("2016-02-29"));
		assertEquals("isDate pos 2018-03-31", true, ComputeError.isDate("2018-03-31"));
		assertEquals("isDate pos 2018-04-30", true, ComputeError.isDate("2018-04-30"));
		assertEquals("isDate pos 2018-05-31", true, ComputeError.isDate("2018-05-31"));
		assertEquals("isDate pos 2018-06-30", true, ComputeError.isDate("2018-06-30"));
		assertEquals("isDate pos 2018-07-31", true, ComputeError.isDate("2018-07-31"));
		assertEquals("isDate pos 2018-08-31", true, ComputeError.isDate("2018-08-31"));
		assertEquals("isDate pos 2018-09-30", true, ComputeError.isDate("2018-09-30"));
		assertEquals("isDate pos 2018-10-31", true, ComputeError.isDate("2018-10-31"));
		assertEquals("isDate pos 2018-11-30", true, ComputeError.isDate("2018-11-30"));
		assertEquals("isDate pos 2018-12-31", true, ComputeError.isDate("2018-12-31"));
		assertEquals("isDate pos 9999-12-31", true, ComputeError.isDate("9999-12-31"));
		
		assertEquals("isDate neg 9999-13-31", false, ComputeError.isDate("9999-13-31"));
		assertEquals("isDate neg 2018-01-32", false, ComputeError.isDate("2018-01-32"));
		assertEquals("isDate neg 2018-02-29", false, ComputeError.isDate("2018-02-29"));
		assertEquals("isDate neg 2016-02-30", false, ComputeError.isDate("2016-02-30"));
		assertEquals("isDate neg 2018-03-32", false, ComputeError.isDate("2018-03-32"));
		assertEquals("isDate neg 2018-04-31", false, ComputeError.isDate("2018-04-31"));
		assertEquals("isDate neg 2018-05-32", false, ComputeError.isDate("2018-05-32"));
		assertEquals("isDate neg 2018-06-31", false, ComputeError.isDate("2018-06-31"));
		assertEquals("isDate neg 2018-07-32", false, ComputeError.isDate("2018-07-32"));
		assertEquals("isDate neg 2018-08-32", false, ComputeError.isDate("2018-08-32"));
		assertEquals("isDate neg 2018-09-31", false, ComputeError.isDate("2018-09-31"));
		assertEquals("isDate neg 2018-10-32", false, ComputeError.isDate("2018-10-32"));
		assertEquals("isDate neg 2018-11-31", false, ComputeError.isDate("2018-11-31"));
		assertEquals("isDate neg 2018-12-32", false, ComputeError.isDate("2018-12-32"));
		
		assertEquals("isDate neg !", false, ComputeError.isDate("!"));
		assertEquals("isDate neg blue", false, ComputeError.isDate("blue"));
		assertEquals("isDate neg Christopher Moriarty", false, ComputeError.isDate("Christopher Moriarty"));
		}
	
	@Test
	public void isTime()
	{
		assertEquals("isTime pos 00:00:00", true, ComputeError.isTime("00:00:00"));
		assertEquals("isTime pos 06:12:24", true, ComputeError.isTime("06:12:24"));
		assertEquals("isTime pos 24:60:60", true, ComputeError.isTime("24:60:60"));
		
		assertEquals("isTime neg 25:60:60", false, ComputeError.isTime("25:60:60"));
		assertEquals("isTime neg 24:61:60", false, ComputeError.isTime("24:61:60"));
		assertEquals("isTime neg 24:60:61", false, ComputeError.isTime("24:60:61"));		
	
		assertEquals("isTime neg !", false, ComputeError.isTime("!"));
		assertEquals("isTime neg blue", false, ComputeError.isTime("blue"));
		assertEquals("isTime neg Christopher Moriarty", false, ComputeError.isTime("Christopher Moriarty"));
		}
	
	@Test
	public void isDateTime()
	{
		assertEquals("isDateTime pos 0000-01-31T00:00:00Z", true, ComputeError.isDateTime("0000-01-31T00:00:00Z"));
		assertEquals("isDateTime pos 2018-05-25T06:12:24Z", true, ComputeError.isDateTime("2018-05-25T06:12:24Z"));
		assertEquals("isDateTime pos 9999-12-31T24:60:60Z", true, ComputeError.isDateTime("9999-12-31T24:60:60Z"));
		
		assertEquals("isDateTime pos 0000-01-01T06:12:24Z", true, ComputeError.isDateTime("0000-01-01T06:12:24Z"));
		assertEquals("isDateTime pos 2018-01-31T06:12:24Z", true, ComputeError.isDateTime("2018-01-31T06:12:24Z"));
		assertEquals("isDateTime pos 2018-02-28T06:12:24Z", true, ComputeError.isDateTime("2018-02-28T06:12:24Z"));
		assertEquals("isDateTime pos 2016-02-29T06:12:24Z", true, ComputeError.isDateTime("2016-02-29T06:12:24Z"));
		assertEquals("isDateTime pos 2018-03-31T06:12:24Z", true, ComputeError.isDateTime("2018-03-31T06:12:24Z"));
		assertEquals("isDateTime pos 2018-04-30T06:12:24Z", true, ComputeError.isDateTime("2018-04-30T06:12:24Z"));
		assertEquals("isDateTime pos 2018-05-31T06:12:24Z", true, ComputeError.isDateTime("2018-05-31T06:12:24Z"));
		assertEquals("isDateTime pos 2018-06-30T06:12:24Z", true, ComputeError.isDateTime("2018-06-30T06:12:24Z"));
		assertEquals("isDateTime pos 2018-07-31T06:12:24Z", true, ComputeError.isDateTime("2018-07-31T06:12:24Z"));
		assertEquals("isDateTime pos 2018-08-31T06:12:24Z", true, ComputeError.isDateTime("2018-08-31T06:12:24Z"));
		assertEquals("isDateTime pos 2018-09-30T06:12:24Z", true, ComputeError.isDateTime("2018-09-30T06:12:24Z"));
		assertEquals("isDateTime pos 2018-10-31T06:12:24Z", true, ComputeError.isDateTime("2018-10-31T06:12:24Z"));
		assertEquals("isDateTime pos 2018-11-30T06:12:24Z", true, ComputeError.isDateTime("2018-11-30T06:12:24Z"));
		assertEquals("isDateTime pos 2018-12-31T06:12:24Z", true, ComputeError.isDateTime("2018-12-31T06:12:24Z"));
		assertEquals("isDateTime pos 9999-12-31T06:12:24Z", true, ComputeError.isDateTime("9999-12-31T06:12:24Z"));
		
		assertEquals("isDateTime neg 0000-01-31T00:00:00Z", false, ComputeError.isDateTime("0000-01-31T25:60:60Z"));
		assertEquals("isDateTime neg 2018-05-25T06:12:24Z", false, ComputeError.isDateTime("2018-05-25T24:61:60Z"));
		assertEquals("isDateTime neg 9999-12-31T24:60:60Z", false, ComputeError.isDateTime("9999-12-31T24:60:61Z"));
		
		assertEquals("isDateTime neg 9999-13-31T06:12:24Z", false, ComputeError.isDateTime("9999-13-31T06:12:24Z"));
		assertEquals("isDateTime neg 2018-01-32T06:12:24Z", false, ComputeError.isDateTime("2018-01-32T06:12:24Z"));
		assertEquals("isDateTime neg 2018-02-29T06:12:24Z", false, ComputeError.isDateTime("2018-02-29T06:12:24Z"));
		assertEquals("isDateTime neg 2016-02-30T06:12:24Z", false, ComputeError.isDateTime("2016-02-30T06:12:24Z"));
		assertEquals("isDateTime neg 2018-03-32T06:12:24Z", false, ComputeError.isDateTime("2018-03-32T06:12:24Z"));
		assertEquals("isDateTime neg 2018-04-31T06:12:24Z", false, ComputeError.isDateTime("2018-04-31T06:12:24Z"));
		assertEquals("isDateTime neg 2018-05-32T06:12:24Z", false, ComputeError.isDateTime("2018-05-32T06:12:24Z"));
		assertEquals("isDateTime neg 2018-06-31T06:12:24Z", false, ComputeError.isDateTime("2018-06-31T06:12:24Z"));
		assertEquals("isDateTime neg 2018-07-32T06:12:24Z", false, ComputeError.isDateTime("2018-07-32T06:12:24Z"));
		assertEquals("isDateTime neg 2018-08-32T06:12:24Z", false, ComputeError.isDateTime("2018-08-32T06:12:24Z"));
		assertEquals("isDateTime neg 2018-09-31T06:12:24Z", false, ComputeError.isDateTime("2018-09-31T06:12:24Z"));
		assertEquals("isDateTime neg 2018-10-32T06:12:24Z", false, ComputeError.isDateTime("2018-10-32T06:12:24Z"));
		assertEquals("isDateTime neg 2018-11-31T06:12:24Z", false, ComputeError.isDateTime("2018-11-31T06:12:24Z"));
		assertEquals("isDateTime neg 2018-12-32T06:12:24Z", false, ComputeError.isDateTime("2018-12-32T06:12:24Z"));
	
		assertEquals("isDateTime neg !", false, ComputeError.isDateTime("!"));
		assertEquals("isDateTime neg blue", false, ComputeError.isDateTime("blue"));
		assertEquals("isDateTime neg Christopher Moriarty", false, ComputeError.isDateTime("Christopher Moriarty"));
		}
	
	
}
