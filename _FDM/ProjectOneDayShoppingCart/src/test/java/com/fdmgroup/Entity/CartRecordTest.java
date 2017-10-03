package com.fdmgroup.Entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.Entity.CartRecord;
import com.fdmgroup.Entity.Item;



public class CartRecordTest 
{
	
	int id;
	int cartId;
	int itemId;
	String name;
	int quantityAvailable;
	BigDecimal price;
	String description;
	Item item;
	int quantityRequested;
	
	CartRecord cartRecord0;
	CartRecord cartRecord1;
	CartRecord cartRecord2;
	
	@Before
	public void SetUp()
	{
		id = 0;
		cartId = 0;
		itemId = 0;
		name = "Monkey";
		quantityAvailable = 5;
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item = new Item(id, name, quantityAvailable, price, description);
		quantityRequested = 1;
		
		cartRecord0 = new CartRecord();
		cartRecord1 = new CartRecord(cartId, item, quantityRequested);
		cartRecord2 = new CartRecord(id, cartId, item, quantityRequested);
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_getIdReturnsNotNull()
	{
		assertNotNull(cartRecord2.getId());
	}
	
	@Test
	public void test_IdIsSetCorrectly()
	{
		assertEquals(id, cartRecord2.getId());
	}
	
	@Test
	public void test_IdIsSetGreaterThanNegative2()
	{
		id = -2;
		cartId = 0;
		itemId = 0;
		name = "Monkey";
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item = new Item(id, name, quantityAvailable, price, description);
		quantityRequested = 1;
		quantityAvailable = 5;
		cartRecord2 = new CartRecord(id, cartId, item, quantityRequested);
		
		assertTrue(cartRecord2.getId() > -2);
	}
	
	@Test
	public void test_getCartIdReturnsNotNull()
	{
		assertNotNull(cartRecord2.getId());
	}
	
	@Test
	public void test_CartIdIsSetCorrectly()
	{
		assertEquals(id, cartRecord2.getId());
	}
	
	@Test
	public void test_CartIdIsSetGreaterThanNegative2()
	{
		id = 0;
		cartId = -2;
		itemId = 0;
		name = "Monkey";
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item = new Item(id, name, quantityAvailable, price, description);
		quantityRequested = 1;
		quantityAvailable = 5;
		cartRecord2 = new CartRecord(id, cartId, item, quantityRequested);
		
		assertTrue(cartRecord2.getId() > -2);
	}
	
	@Test
	public void test_getItemReturnsNotNull()
	{
		assertNotNull(cartRecord2.getItem());
	}
	
	@Test
	public void test_ItemIsSetCorrectly()
	{
		assertEquals(item, cartRecord2.getItem());
	}
	
		
	@Test
	public void test_getQuantityRequestedReturnsNotNull()
	{
		assertNotNull(cartRecord2.getId());
	}
	
	@Test
	public void test_QuantityRequestedIsSetCorrectly()
	{
		assertEquals(id, cartRecord2.getId());
	}
	
	@Test
	public void test_QuantityRequestedIsSetToAtLeastZero()
	{
		id = 0;
		cartId = 0;
		itemId = 0;
		name = "Monkey";
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item = new Item(id, name, quantityAvailable, price, description);
		quantityRequested = -1;
		quantityAvailable = 5;
		cartRecord2 = new CartRecord(id, cartId, item, quantityRequested);
		
		assertTrue(cartRecord2.getId() > -2);
	}
	
	@Test
	public void test_getQuantityAvailableReturnsNotNull()
	{
		assertNotNull(cartRecord2.getId());
	}
	
	@Test
	public void test_QuantityAvailableIsSetCorrectly()
	{
		assertEquals(id, cartRecord2.getId());
	}
	
	@Test
	public void test_QuantityAvailableIsSetToAtLeastZero()
	{
		id = 0;
		cartId = 0;
		itemId = 0;
		name = "Monkey";
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item = new Item(id, name, quantityAvailable, price, description);
		quantityRequested = 1;
		quantityAvailable = -1;
		cartRecord2 = new CartRecord(id, cartId, item, quantityRequested);
		
		assertTrue(cartRecord2.getId() > -2);
	}
	
	
}
