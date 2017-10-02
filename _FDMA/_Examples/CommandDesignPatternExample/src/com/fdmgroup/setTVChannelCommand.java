package com.fdmgroup;

//Concrete Command
public class setTVChannelCommand implements Command 
{
	//reference to the Television class
	Television tv;
	
	public setTVChannelCommand(Television tv)
	{
		this.tv = tv;
	}
	
	public void execute() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void executeNumeric(int NumericInput) 
	{
		tv.setChannel(NumericInput);		
	}
}