package com.fdmgroup.demos;


public class Demo {

	public static void main(String[] args) {
		
		User user = new User("john.smith");
		
    	UserStorage storage = new UserStorage();
    	storage.save(user);
    	
    	System.out.println(storage.get(user.getId()));
	}

}
