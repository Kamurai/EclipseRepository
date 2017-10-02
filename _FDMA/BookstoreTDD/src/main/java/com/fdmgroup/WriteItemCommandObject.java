package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class WriteItemCommandObject implements WriteItemCommand
{
	List<Book> bookList;

	public WriteItemCommandObject()
	{
		this.bookList = new ArrayList<Book>();

	}
	
	public List<Book> insertItem(Book book)
	{
		bookList.add(book);
		return bookList;
	}
}
