package com.fdmgroup.DAO;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.Entity.Item;


public class ItemDAOTest 
{
	
	int id;
	String name;
	int quantityAvailable;
	BigDecimal price;
	String description;
	Item item;
	ItemDAO itemDAO;
	
	@Before
	public void SetUp()
	{
		id = 0;
		name = "Monkey";
		quantityAvailable = 1;
		price = new BigDecimal("1.00");
		description = "It is a Monkey";
		item = new Item(id, name, quantityAvailable, price, description);
		itemDAO = new ItemDAO();
		
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_GetItemById()
	{
		int suppliedId = 0;
		item = itemDAO.getItemById(suppliedId);
		
		assertEquals(item.getId(), suppliedId);
	}
	
	@Test
	public void test_GetUserByUsername()
	{
		String suppliedUsername = "Cucumber"; //check manually
		item = itemDAO.getItemByName(suppliedUsername);
		
		assertEquals(suppliedUsername, item.getName());
	}
	
	@Test
	public void test_GetItems()
	{
		int suppliedCount = 10; //get manually
		
		assertEquals(suppliedCount, itemDAO.getItems().size());
	}
	
	@Test
	public void test_AddItem()
	{
		int userCount = itemDAO.getItems().size();
		
		itemDAO.addItem(item, 5);
		
		assertEquals(userCount+1, itemDAO.getItems().size());
	}
	
	@Test
	public void test_RemoveItem()
	{
		int userCount = itemDAO.getItems().size();
		
		itemDAO.removeItem(itemDAO.getItems().size()-1);
		
		assertEquals(userCount-1, itemDAO.getItems().size());
	}
	
	@Test
	public void test_UpdateItem()
	{
		int suppliedId = itemDAO.getItems().size()-1; //get last user
		String suppliedName = "Pickle";
		
		Item savedItem = itemDAO.getItemById(suppliedId);
		
		item = new Item(suppliedId, suppliedName, quantityAvailable, price, description);
		
		itemDAO.updateItem(item);
		
		String fetchedUsername = itemDAO.getItemById(suppliedId).getName();
		
		itemDAO.updateItem(savedItem);
		
		assertEquals(suppliedName, fetchedUsername);
	}
}
