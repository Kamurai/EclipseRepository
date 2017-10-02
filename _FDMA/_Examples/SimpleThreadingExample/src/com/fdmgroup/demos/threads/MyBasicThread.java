package com.fdmgroup.demos.threads;

public class MyBasicThread extends Thread {
	
	// Sets the name
    public MyBasicThread(String name) {
    	super(name);
    }
    
    public void run() {
    	
    	for (int i = 0; i < 10; i++) {
		    
    		System.out.println(i + " " + getName());

    		try {
    		
    			sleep((int)(Math.random() * 1000)); 			
    			
		    } catch (InterruptedException e) { 	e.printStackTrace();  }
		}
	
		System.out.println("DONE! " + getName());
    }
}