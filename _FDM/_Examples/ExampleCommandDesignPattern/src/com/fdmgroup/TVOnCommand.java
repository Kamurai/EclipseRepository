package com.fdmgroup;

//Concrete Command
public class TVOnCommand implements Command 
{
	//reference to the Television class
	Television tv;
	
	public TVOnCommand(Television tv)
	{
		this.tv = tv;
	}
	
	public void execute() 
	{
		tv.switchOn();

	}

	@Override
	public void executeNumeric(int NumericInput) {
		// TODO Auto-generated method stub
		
	}
}
