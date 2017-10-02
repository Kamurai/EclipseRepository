package com.fdmgroup.demos;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

	public static void main(String[] args) {
		
		// Can only reference Lists of <Object>:

		List<Object> objectList = new ArrayList<Object>();

		// Can reference Lists of any kind:

		List<?> somethingList = new ArrayList<Object>();
		
		somethingList = new ArrayList<String>();
		somethingList = new ArrayList<WildCardDemo>();
		somethingList = new ArrayList<Integer>();
		somethingList = new ArrayList<List<String>>();
		
		// Can reference Lists of any kind:
		
		List<? extends Object> somethingList2 = new ArrayList<Object>();

		somethingList2 = new ArrayList<String>();
		somethingList2 = new ArrayList<WildCardDemo>();
		somethingList2 = new ArrayList<Integer>();
		somethingList2 = new ArrayList<List<String>>();
	}
}
