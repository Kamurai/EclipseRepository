package com.fdmgroup;

//Receiver
public class Television 
{
	private boolean on;
	private boolean hasCable;
	private boolean operable;
	private int channel;
	
	public void switchOn()
	{
		System.out.println("Turning on the TV.");
		on = true;
	}
  
	public void switchOff()
	{
		System.out.println("Turning off the TV.");
		on = false;
	}
	
	public void quitCable()
	{
		System.out.println("Quitting cable.");
		hasCable = false;
	}
  
	public void subscribeCable()
	{
		System.out.println("Bring cable back.");
		hasCable = true;
	}
	
	public void fixTV()
	{
		System.out.println("Fixing the TV.");
		operable = true;
	}
  
	public void destroyTV()
	{
		System.out.println("Breaking the TV.");
		operable = false;
	}
	
	public void setChannel(int channel)
	{
		System.out.println("Setting the TV channel to " + channel + ".");
		this.channel = channel;
	}

	public boolean getTVState() {
		// TODO Auto-generated method stub
		return on;
	}
	
	public boolean getTVOperable() {
		// TODO Auto-generated method stub
		return operable;
	}
	
	public boolean getTVCable() {
		// TODO Auto-generated method stub
		return hasCable;
	}
	
	public int getTVChannel()
	{
		return channel;
	}
	
}
