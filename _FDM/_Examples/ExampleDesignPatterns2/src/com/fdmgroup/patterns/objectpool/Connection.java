package com.fdmgroup.patterns.objectpool;

public class Connection {
	
	public Connection(){
		
		System.out.println("Waiting for 2 secs as this object is expensive to create");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
