package com.fdmgroup;

//Concrete Command
public class LightOnCommand implements Command 
{
	//reference to the Light Class
	Light light;
	public LightOnCommand(Light light)
	{
		this.light = light;
	}
	
	public void execute()
	{
		light.switchOn();
	}
	
	public void executeNumeric(int NumericInput) {
		// TODO Auto-generated method stub
		
	}
}
