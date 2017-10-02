package com.fdmgroup.demos;

public class User implements Storable {

	private String username;
	
	public User(String username){
		this.username = username;
	}
	
	@Override
	public String getId() {
		return username;
	}
	
	@Override
	public String toString(){
		return username;
	}

}