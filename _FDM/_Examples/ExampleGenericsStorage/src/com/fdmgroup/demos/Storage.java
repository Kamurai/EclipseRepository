package com.fdmgroup.demos;

public interface Storage<T extends Storable> {
	
	void save(T storable);
	T get(String id);
}
