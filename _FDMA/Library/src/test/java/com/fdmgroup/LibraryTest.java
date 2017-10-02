package com.fdmgroup;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest 
{
	Book testBook = new Book("Test Book", 5.45);
	Basket testBasket = new Basket();
	Library testLibrary = new Library();

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void test_IsBookCreated() 
	{
		assertNotNull(testBook);
	}
	
	@Test
	public void test_IsBasketCreated() 
	{
		assertNotNull(testBasket);
	}
	
	@Test
	public void test_IsLibraryCreated() 
	{
		assertNotNull(testLibrary);
	}
	
	@Test
	public void test_DoesBasketHaveBooksWhenCreated() 
	{
		assertEquals(0, testBasket.getBooksInBasket().size());
	}
	
	@Test
	public void test_DoesBasketHaveBooksWhenBooksAreAdded() 
	{
		testBasket.addBook(testBook);
		assertEquals(1, testBasket.getBooksInBasket().size());
	}
	
	@Test
	public void test_DoesBasketHaveTwoBooksWhenTwoBooksAreAdded() 
	{
		testBasket.addBook(testBook);
		testBasket.addBook(testBook);
		
		
		assertEquals(2, testBasket.getBooksInBasket().size());
	}
	
	@Test
	public void test_DoesBasketHaveZeroBalanceWhenZeroBooksAreAdded() 
	{
		//testBasket.getBooksInBasket().clear();
		
		assertEquals(0.00, checkOut.calculatePrice(testBasket), 0);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() 
	{
		testBasket.addBook(testBook);
		
		assertEquals(testBook.getPrice(), checkOut.calculatePrice(testBasket), 0);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithTwoBooks() 
	{
		testBasket.addBook(testBook);
		testBasket.addBook(testBook);
		
		assertEquals(10.90, checkOut.calculatePrice(testBasket), 0);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithThreeBooks() 
	{
		for(int x = 0; x < 3; x++)
		{
			testBasket.addBook(testBook);
		}
		
		//minus 1%
		assertEquals(16.19, checkOut.calculatePrice(testBasket), 0);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithSevenBooks() 
	{
		for(int x = 0; x < 7; x++)
		{
			testBasket.addBook(testBook);
		}
		
		//minus 2%
		assertEquals(37.39, checkOut.calculatePrice(testBasket), 0);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithTenBooks() 
	{
		for(int x = 0; x < 10; x++)
		{
			testBasket.addBook(testBook);
		}
		
		//minus 13%: 10%+3%
		assertEquals(47.42, checkOut.calculatePrice(testBasket), 0);
	}
	
}
