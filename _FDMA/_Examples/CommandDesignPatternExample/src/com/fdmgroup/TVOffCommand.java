package com.fdmgroup;

//Concrete Command
public class TVOffCommand implements Command 
{
	//reference to the Television class
	Television tv;
	
	public TVOffCommand(Television tv)
	{
		this.tv = tv;
	}
	
	public void execute() 
	{
		tv.switchOff();

	}

	@Override
	public void executeNumeric(int NumericInput) {
		// TODO Auto-generated method stub
		
	}
}
