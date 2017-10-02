package com.fdmgroup.demos;
public class Application {
	
	private Storage storage;
	
	public Application(Storage storage){
		this.storage = storage;
	}
	
    void process(Object object){
		storage.store(object);
	}
}
