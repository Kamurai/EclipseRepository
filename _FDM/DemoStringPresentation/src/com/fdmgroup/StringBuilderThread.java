package com.fdmgroup;

public class StringBuilderThread extends Thread
{
	boolean running;
	boolean play;
	
	String designation;
	int width;
	int depth;
	int target;
	String tempDesignation;
	Object tgtObject;
	
	StringBuilder tempStringBuilder;
	
	public void run() 
    {
		running = true;
		play = true;
		while (running)
		{
			while (play)
			{
				if(Driver.testStringBuilder2.length() < width)
				{
					Driver.testStringBuilder2.append(designation);
				}
			}
		}
//		    System.out.println("Thread " + designation + " Started");
//			
//	    	for(int x = 0; x < width; x++)
//	    	{
//	    		tempDesignation = designation;
//	    		for(int y = 1; y < depth; y++)
//		    	{
//	    			tempDesignation += designation;
//		    	}
//	    		//Driver.testStringBuilder2.append(tempDesignation);
//	    		
//	    		tempStringBuilder = new StringBuilder(Driver.testStringBuilder2);
//	    		tempStringBuilder.append(tempDesignation);
//	    		Driver.testStringBuilder2 = new StringBuilder(tempStringBuilder);
//	    		
//	    	}
//	    	
//	    	System.out.println("Thread " + designation + " Stopped");
	    	//running = false;
		//}
    }
	
	public void setTgtObject(Object obj)
	{
		tgtObject = obj;
	}
	
	public void setDesignation(String name)
	{
		designation = name;
	}

	public void setWidth(int wid)
	{
		width = wid;
	}

	public void setDepth(int dep)
	{
		depth = dep;
	}

	public void setTarget(int tar)
	{
		target = tar;
	}

	public void setRunning(boolean b) 
	{
		// TODO Auto-generated method stub
		play = b;
	}
}
