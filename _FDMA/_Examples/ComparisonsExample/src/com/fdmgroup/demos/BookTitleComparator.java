package com.fdmgroup.demos;

import java.util.Comparator;

// This class can be used to compare book objects by title
public class BookTitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		
		if(book1 == null)
			return -1;
		if(book2 == null)
			return 1;
		
		return book1.getTitle().compareTo(book2.getTitle());
	}

}
