package com.fdmgroup;

//Invoker
public class RemoteControl 
{
	private Command command;
	private int number = -1;
	
	public void setCommand(Command command)
	{
		this.command = command;
	}
	  
	public void setNumericInput(int number)
	{
		this.number = number;
	}
	  
	public void pressButton()
	{
		if( number == -1 )
		{
			command.execute();
		}
		else
		{
			command.executeNumeric(number);
			number = -1;
		}
	}
	
	
}
