package com.fdmgroup.DAO;

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


public class CartRecordDAOTest 
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
	
	int manualCount;
	int sharedCartId;
	
	CartRecord cartRecord;
	CartRecordDAO cartRecordDAO;
	
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
		
		manualCount = 1; //get manually
		sharedCartId = 0;
		
		cartRecord = new CartRecord(id, cartId, item, quantityRequested);
		cartRecordDAO = new CartRecordDAO();
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_GetRecordById()
	{
		int suppliedId = 0;
		cartRecord = cartRecordDAO.getRecordById(suppliedId);
		
		assertEquals(suppliedId, cartRecord.getId() );
	}
	
	@Test
	public void test_GetRecords()
	{
		int suppliedCount = manualCount;
		
		assertEquals(suppliedCount, cartRecordDAO.getRecords().size());
	}
	
	@Test
	public void test_GetRecordsByCartId()
	{
		int suppliedCount = manualCount;
		
		assertEquals(suppliedCount, cartRecordDAO.getRecordsByCartId(sharedCartId).size());
	}
	
	@Test
	public void test_AddRecord()
	{
		int quantityRequested = 5;
		
		cartRecord = new CartRecord(sharedCartId, item, quantityRequested);
		
		int userCount = cartRecordDAO.getRecords().size();
		
		cartRecordDAO.addRecord(cartRecord);
		
		assertEquals(userCount+1, cartRecordDAO.getRecords().size());
	}
	
	@Test
	public void test_RemoveRecord()
	{
		int userCount = cartRecordDAO.getRecords().size();
		
		cartRecordDAO.removeRecord(cartRecordDAO.getRecords().size()-1);
		
		assertEquals(userCount-1, cartRecordDAO.getRecords().size());
	}
	
	@Test
	public void test_RemoveRecordsByCartId()
	{
		int userCount = cartRecordDAO.getRecords().size();
		
		cartRecordDAO.removeRecordsByCartId(sharedCartId);
		
		assertEquals(userCount-1, cartRecordDAO.getRecords().size());
	}
	
	@Test
	public void test_UpdateRecord()
	{
		int suppliedId = cartRecordDAO.getRecords().size()-1; //get last user
		String suppliedName = "Carrot"; //must be a valid item name
		
		CartRecord savedRecord = cartRecordDAO.getRecordById(suppliedId);
		
		item.setId(1); //must be a valid item index matching previous name
		
		cartRecord = new CartRecord(suppliedId, cartId, item, quantityRequested);
		
		cartRecordDAO.updateRecord(cartRecord);
		
		String fetchedName = cartRecordDAO.getRecordById(suppliedId).getItem().getName();
		
		cartRecordDAO.updateRecord(savedRecord);
		
		assertEquals(suppliedName, fetchedName);
	}
}
