package com.fdmgroup;

public class BThread extends Thread
{
	public void run() 
    {
    	System.out.println("Starting Thread");
		
    	Driver.testStringBuilder2.insert(4, "BBBB");
    	
    	
    	
    	System.out.println("Interrupting Thread");
    }
}
