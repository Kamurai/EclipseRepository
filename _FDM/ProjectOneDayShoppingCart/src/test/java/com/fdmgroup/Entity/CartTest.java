package com.fdmgroup.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.CartRecordDAO;

public class CartTest 
{
	int id;
	List<CartRecord> recordList;
	
	Cart cart0;
	Cart cart1;
	Cart cart2;
	Cart cart3;
	
	@Before
	public void SetUp()
	{
		id = 0;
		recordList = new ArrayList<CartRecord>();
		
		cart0 = new Cart();
		cart1 = new Cart(recordList);
		cart2 = new Cart(id);
		cart3 = new Cart(id, recordList);
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_getIdReturnsNotNull()
	{
		assertNotNull(cart3.getId());
	}
	
	@Test
	public void test_IdIsSetCorrectly()
	{
		assertEquals(id, cart3.getId());
	}
	
	@Test
	public void test_IdIsSetGreaterThanNegative2()
	{
		id = -2;
		recordList = new ArrayList<CartRecord>();
		cart3 = new Cart(id, recordList);
		
		assertTrue(cart3.getId() > -2);
	}
	
	@Test
	public void test_getRecordListReturnsNotNull()
	{
		assertNotNull(cart3.getRecordList());
	}
	
	@Test
	public void test_RecordListIsSetCorrectly()
	{
		assertEquals(recordList, cart3.getRecordList());
	}
	
	@Test
	public void test_NumberOfRecordsInRecordListIsSetCorrectly()
	{
		int itemId = 0;
		String name = "Monkey";
		int quantityAvailable = 5;
		BigDecimal price = new BigDecimal("1.00");
		String description = "It is a Monkey";
		
		Item item = new Item(itemId, name, quantityAvailable, price, description);
		
		CartRecord cartRecord = new CartRecord(0, id, item, 2);
		
		int setNumber = 3;
		
		for(int x = 0; x < setNumber; x++)
		{
			cart3.addRecord(cartRecord);
		}
		
		assertEquals(setNumber, cart3.getRecordList().size());
	}
	
	
}
