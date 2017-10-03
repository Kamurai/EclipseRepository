package com.fdmgroup.Entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest 
{
	
	int id;
	String name;
	int quantityAvailable;
	BigDecimal price;
	String description;
	
	Item item0;
	Item item1;
	Item item2;
	
	@Before
	public void SetUp()
	{
		id = 0;
		name = "Monkey";
		quantityAvailable = 5;
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		
		item0 = new Item();
		item1 = new Item(name, quantityAvailable, price, description);
		item2 = new Item(id, name, quantityAvailable, price, description);
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_getIdReturnsNotNull()
	{
		assertNotNull(item2.getId());
	}
	
	@Test
	public void test_IdIsSetCorrectly()
	{
		assertEquals(id, item2.getId());
	}
	
	@Test
	public void test_IdIsSetGreaterThanNegative2()
	{
		id = -2;
		name = "Monkey";
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item2 = new Item(id, name, quantityAvailable, price, description);
		
		assertTrue(item2.getId() > -2);
	}
	
	@Test
	public void test_getNameNotNull()
	{
		assertNotNull(item2.getName());
	}
	
	@Test
	public void test_ItemNameIsSetCorrectly()
	{
		assertEquals(name, item2.getName());
	}
	
	@Test
	public void test_NameIsThirtyCharactersOrLess()
	{
		id = 0;
		name = "MonkeyMonkeyMonkeyMonkeyMonkey123";
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item2 = new Item(id, name, quantityAvailable, price, description);
		
		assertTrue(item2.getName().length() < 31);
	}
		
	@Test
	public void test_getPriceReturnsNotNull()
	{
		assertNotNull(item2.getPrice());
	}
	
	@Test
	public void test_PriceIsSetCorrectly()
	{
		assertEquals(price, item2.getPrice());
	}
	
	@Test
	public void test_PriceIsPositive()
	{
		id = 0;
		name = "Monkey";
		price = new BigDecimal("-1.00");
		description = "It is a Monkey";
		item2 = new Item(id, name, quantityAvailable, price, description);
		
		assertTrue(item2.getPrice().doubleValue() >= 0);
	}
	
	@Test
	public void test_getDescriptionReturnsNotNull()
	{
		assertNotNull(item2.getDescription());
	}
	
	@Test
	public void test_DescriptionIsSetCorrectly()
	{
		assertEquals(description, item2.getDescription());
	}
	
	@Test
	public void test_DescriptionIsThreeHundredCharactersOrLess()
	{
		id = 0;
		name = "Monkey";
		price = new BigDecimal("1.00");
		description = "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "MonkeyMonkeyMonkeyMonkeyMonkey"
				+ "123"
				;
		item2 = new Item(id, name, quantityAvailable, price, description);
		
		assertTrue(item2.getDescription().length() < 301);
	}
}
