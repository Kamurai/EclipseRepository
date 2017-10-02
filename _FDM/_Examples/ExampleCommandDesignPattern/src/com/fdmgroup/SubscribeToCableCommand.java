package com.fdmgroup;

public class SubscribeToCableCommand implements Command 
{
	//reference to the Television class
	Television tv;
	
	public SubscribeToCableCommand(Television tv)
	{
		this.tv = tv;
	}
	
	public void execute() 
	{
		tv.subscribeCable();

	}

	@Override
	public void executeNumeric(int NumericInput) {
		// TODO Auto-generated method stub
		
	}
}
