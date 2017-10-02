package com.fdmgroup.patterns.singleton;

import java.util.ArrayList;
import java.util.List;

public class NameStorage {

	private List<String> names;

	private static NameStorage storage; // Maintains an instance of itself

	// Private constructor
	private NameStorage() {
		names = new ArrayList<String>();
	}

	public static NameStorage getInstance() {

		// Lazy instantiation
		if (storage == null) 
			storage = new NameStorage();
		
		return storage;
	}

	public void add(String name) {
		names.add(name);
	}

	public List<String> getNames() {
		return names;
	}

}
