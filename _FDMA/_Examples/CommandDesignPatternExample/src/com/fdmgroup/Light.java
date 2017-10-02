package com.fdmgroup;

//Receiver
public class Light 
{
	private boolean on;
	
	public void switchOn()
	{
		System.out.println("Turning on the lights.");
		on = true;
	}
  
	public void switchOff()
	{
		System.out.println("Turning off the lights.");
		on = false;
	}
	
	public boolean getLightState()
	{
		return on;
	}
}
