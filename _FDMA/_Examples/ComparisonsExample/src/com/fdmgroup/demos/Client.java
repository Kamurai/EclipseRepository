package com.fdmgroup.demos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Client {

	public static void main(String[] args) {

		Book book1 = new Book("1234", "Macbeth", 3.40);
		Book book2 = new Book("1235", "King Lear", 3.50);
		Book book3 = new Book("1236", "Taming Of The Shrew", 2.50);
		Book book4 = new Book("1007", "Merchant Of Venice", 4.50);
		Book book5 = new Book("1064", "Romeo And Juliet", 3.20);
		Book book6 = new Book("1234", "Macbeth", 3.40);

		
		demoUnsortedCollection(book1,book2,book3,book4,book5,book6);
		
		demoSortedCollection(book1,book2,book3,book4,book5,book6);
	
	}



	// Demonstrates manual sorting of an unsorted Collection
	private static void demoUnsortedCollection(Book... bookArray) {
		
		List<Book> bookList = new ArrayList<Book>();

		for(Book book : bookArray)
			bookList.add(book);
		
		System.out.println("Unsorted:\n");
		printBooks(bookList);

		// ArrayList is an unsorted Collection,
		// but we can sort its elements using
		// the Collections.sort() utility

		Collections.sort(bookList);

		System.out.println("ArrayList sorted by natural ordering (isbn):\n");
		printBooks(bookList);

		// Collections.sort() can also take a Comparator object,
		// if we want a different ordering of the elements

		Collections.sort(bookList, new BookTitleComparator());

		System.out.println("ArrayList sorted by title:\n");
		printBooks(bookList);


		Collections.sort(bookList, new BookPriceComparator());

		System.out.println("ArrayList sorted by price:\n");
		printBooks(bookList);
		
	}

	
	// Demonstrates storing elements in a sorted Collection
	private static void demoSortedCollection(Book... bookArray) {
		
		// To use a sorted Collection, such as a TreeSet, 
		// either the element type must be Comparable,
		// or a Comparator must be given to the constructor.
		
		TreeSet<Book> bookSet = new TreeSet<Book>(); 
		
		for(Book book : bookArray)
			bookSet.add(book);
		
		System.out.println("TreeSet sorted by natural ordering (isbn):\n");
		printBooks(bookSet);
		
		// Using a Comparator to sort by title:
		
		TreeSet<Book> bookSetByTitle = new TreeSet<Book>(new BookTitleComparator()); 
		
		for(Book book : bookArray)
			bookSetByTitle.add(book);
		
		System.out.println("TreeSet sorted by title:\n");
		printBooks(bookSetByTitle);
		
		
		// Using a Comparator to sort by Price
		
		TreeSet<Book> bookSetByPrice = new TreeSet<Book>(new BookPriceComparator()); 
		for(Book book : bookArray)
			bookSetByPrice.add(book);
		
		System.out.println("TreeSet sorted by price:\n");
		printBooks(bookSetByPrice);
	}
	
	
	private static void printBooks(Collection<Book> books) {
		
		for (Book book : books)
			System.out.println(book);
		System.out.println();

	}

}
