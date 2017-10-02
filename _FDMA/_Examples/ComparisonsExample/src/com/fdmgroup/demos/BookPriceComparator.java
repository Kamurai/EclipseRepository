package com.fdmgroup.demos;

import java.util.Comparator;

// This class can be used to compare book objects by price
public class BookPriceComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		
		if(book1 == null)
			return -1;
		if(book2 == null)
			return 1;

		Double price1 = book1.getPrice();
		Double price2 = book2.getPrice();
		
		return price1.compareTo(price2);
	}

}
