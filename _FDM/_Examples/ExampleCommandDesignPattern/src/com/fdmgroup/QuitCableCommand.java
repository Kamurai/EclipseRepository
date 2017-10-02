package com.fdmgroup;

//Concrete Command
public class QuitCableCommand implements Command 
{
	//reference to the Television class
	Television tv;
		
	public QuitCableCommand(Television tv)
	{
		this.tv = tv;
	}
	
	public void execute() 
	{
		tv.quitCable();

	}

	@Override
	public void executeNumeric(int NumericInput) {
		// TODO Auto-generated method stub
		
	}

}
