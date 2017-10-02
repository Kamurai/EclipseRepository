package com.fdmgroup;

public class StringBufferThread extends Thread
{
	boolean running;
	boolean play;
	
	String designation;
	int width;
	int depth;
	int target;
	String tempDesignation;
	Object tgtObject;
	
	StringBuffer tempStringBuffer;
	
	public void run() 
    {
		
		running = true;
		play = true;
		while (running)
		{
			while (play)
			{
				if(Driver.testStringBuffer2.length() < width)
				{
					Driver.testStringBuffer2.append(designation);
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
//	    		//Driver.testStringBuffer2.append(tempDesignation);
//	    		
//	    		tempStringBuffer = new StringBuffer(Driver.testStringBuffer2);
//	    		tempStringBuffer.append(tempDesignation);
//	    		Driver.testStringBuffer2 = new StringBuffer(tempStringBuffer);
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
