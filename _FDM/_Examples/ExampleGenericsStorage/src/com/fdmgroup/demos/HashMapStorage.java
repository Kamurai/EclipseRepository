package com.fdmgroup.demos;

import java.util.*;

public class HashMapStorage<T extends Storable> implements Storage<T> {

	private HashMap<String,T> items;
	
	public HashMapStorage() {
		items = new HashMap<String, T>();
	}
	
	@Override
	public void save(T storable) {
		items.put(storable.getId(), storable);
	}

	@Override
	public T get(String id) {
		return items.get(id);
	}

}
