package com.fdmgroup.patterns.singleton;

import java.util.ArrayList;

public class Client {
	
	public static void main(String[] args){
		
		NameStorage storage = NameStorage.getInstance();
		
		storage.add("Chris");
		storage.add("Dave");
		storage.add("Bob");
		
		NameStorage storage2 = NameStorage.getInstance();  // Same instance is returned
		
		ArrayList<String> names = (ArrayList<String>) storage2.getNames();
		
		for(String name : names){
			System.out.println(name);
		}
	}

}
