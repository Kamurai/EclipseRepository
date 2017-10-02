package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class ReadItemCommandObject implements ReadItemCommand
{
	List<Book> bookList = new ArrayList<Book>();

	public ReadItemCommandObject(List<Book> bookList)
	{
		this.bookList = bookList;
	}
	
	public List<Book> readAll() 
	{
		return bookList;
	}
	

}
