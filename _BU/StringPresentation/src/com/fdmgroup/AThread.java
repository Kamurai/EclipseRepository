package com.fdmgroup;

public class AThread extends Thread 
{
    public void run() 
    {
    	System.out.println("Starting Thread");
		
    	Driver.testStringBuilder2.insert(3, "AAAA");
    	
    	
    	
    	System.out.println("Interrupting Thread");
    }

    

}
