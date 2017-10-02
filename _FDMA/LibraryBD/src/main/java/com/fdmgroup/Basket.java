package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class Basket 
{
	List<Book> bookList;

	public Basket() 
	{
		bookList = new ArrayList<Book>();
	}

	public List<Book> getBooksInBasket() {
		// TODO Auto-generated method stub
		return bookList;
	}

	public void addBook(Book someBook)
	{
		// TODO Auto-generated method stub
		bookList.add(someBook);
	}

}
