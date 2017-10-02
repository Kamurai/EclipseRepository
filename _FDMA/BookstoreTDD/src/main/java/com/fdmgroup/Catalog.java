package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class Catalog
{
	List<Book> bookList;
	ReadItemCommandObject readItemCommandObject;
	WriteItemCommandObject writeItemCommandObject;

	public Catalog(ReadItemCommandObject mockReadItemCommand, WriteItemCommandObject writeItemCommandObject) 
	{
		this.bookList = new ArrayList<Book>();
		this.readItemCommandObject = mockReadItemCommand;
		this.writeItemCommandObject = writeItemCommandObject;
	}

	public List<Book> getAllBooks() 
	{
		bookList = readAll();
		return bookList;
	}

	public List<Book> readAll() 
	{
		return readItemCommandObject.readAll();
		
	}

	public void addBook(Book book) 
	{
		bookList = writeItemCommandObject.insertItem(book);
		
	}

}
