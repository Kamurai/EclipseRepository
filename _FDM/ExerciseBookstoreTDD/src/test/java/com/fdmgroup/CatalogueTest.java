package com.fdmgroup;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class CatalogueTest 
{
	Catalog catalog;
	
	ReadItemCommandObject mockReadItemCommandObject;
	WriteItemCommandObject mockWriteItemCommandObject;
	
	List<Book> mockListOfBooks;
	
	Book mockTestBook1;
	Book mockTestBook2;
	Book mockTestBook3;
	Book mockTestBook4;
	

	@Before
	public void setUp() throws Exception 
	{
		mockReadItemCommandObject = mock(ReadItemCommandObject.class);
		mockWriteItemCommandObject = mock(WriteItemCommandObject.class);
		
		catalog = new Catalog(mockReadItemCommandObject, mockWriteItemCommandObject);
		
		mockListOfBooks = mock(new ArrayList<Book>().getClass());
		
		mockTestBook1 = mock(new Book("Freedom's Landing", 5.00).getClass());
		mockTestBook2 = mock(new Book("Freedom's Choice", 6.00).getClass());
		mockTestBook3 = mock(new Book("Freedom's Challenge", 7.00).getClass());
		mockTestBook4 = mock(new Book("Freedom's Ransom", 8.00).getClass());
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_GetAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue()
	{
		assertEquals( 0, catalog.getAllBooks().size() );
	}

	@Test
	public void test_GetAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled()
	{
		catalog.getAllBooks();
		
		verify(mockReadItemCommandObject).readAll();
	}
	
	@Test
	public void test_GetAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled()
	{
		when(mockReadItemCommandObject.readAll()).thenReturn(mockListOfBooks);
		
		assertEquals(mockReadItemCommandObject.readAll(), catalog.getAllBooks());
		//verify(mockListOfBooks).equals(mockReadItemCommandObject.readAll());
	}
	
	@Test
	public void test_AddBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled()
	{
		catalog.addBook(mockTestBook1);
		
		verify(mockWriteItemCommandObject).insertItem(mockTestBook1);
	}




}
