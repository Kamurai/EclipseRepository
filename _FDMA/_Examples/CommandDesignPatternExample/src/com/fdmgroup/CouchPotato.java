package com.fdmgroup;

import java.util.Scanner;

/* This example was based off of the example at:
 * https://dzone.com/articles/design-patterns-command
 */

//Client
public class CouchPotato 
{
		
	public static void main(String[] args) 
	{
		//Menu items
		boolean stay = true;
		int response;
		
		//Define Invoker
		RemoteControl control = new RemoteControl();
		
		//Define Receiver
	    Light light = new Light();
	    Television tv = new Television();
	    
		//Define Concrete Commands
	    Command lightsOn = new LightOnCommand(light);
	    Command lightsOff = new LightOffCommand(light);
	    
	    Command TVOn = new TVOnCommand(tv);
	    Command TVOff = new TVOffCommand(tv);
	    Command setTVChannel = new setTVChannelCommand(tv);
		    
	    Command QuitCable = new QuitCableCommand(tv);
	    Command SubscribeToCable = new SubscribeToCableCommand(tv);
	    
	    Command DestroyTV = new DestroyTVCommand(tv);
	    Command FixTV = new FixTVCommand(tv);
		  
		
		//Perform the scene
	    do
		{
			System.out.println("Hello Couch Potato, what would you like me to do?");
			System.out.println(" 0) Exit.");
			System.out.println(" 1) Display settings.");
			System.out.println(" 2) Switch on light.");
			System.out.println(" 3) Switch off light.");
			System.out.println(" 4) Switch on TV.");
			System.out.println(" 5) Switch off TV.");
			System.out.println(" 6) Change the TV channel.");
			System.out.println(" 7) Quit cable.");
			System.out.println(" 8) Destroy TV.");
			System.out.println(" 9) Reset test variables.");
			System.out.println("10) Watch Game of Thrones.");
			System.out.println("11) Prepare for next week.");
			Scanner reader = new Scanner(System.in);
			response = reader.nextInt();
			
			System.out.println("");
			switch(response)
			{
				case 0:
					stay = false;
					break;
				case 1:
					DisplayStates(light, tv);
					break;
				case 2:
					//switch on light
				    control.setCommand(lightsOn);
				    control.pressButton();
					break;
				case 3:
					//switch off light
				    control.setCommand(lightsOff);
				    control.pressButton();
					break;
				case 4:
					//switch on tv
				    control.setCommand(TVOn);
				    control.pressButton();
					break;
				case 5:
					//switch off tv
				    control.setCommand(TVOff);
				    control.pressButton();
					break;
				case 7:
					//set tv channel
				    control.setCommand(setTVChannel);
				    control.setNumericInput(27);
				    control.pressButton();
					break;
				case 8:
					//quit cable
					control.setCommand(QuitCable);
				    control.pressButton();
					break;
				case 9:
					//destroy TV
					control.setCommand(DestroyTV);
				    control.pressButton();
					break;
				case 10:
					//Watch Game of Thrones
						//turn on TV
					control.setCommand(TVOn);
				    control.pressButton();
					
						//set channel
				    control.setCommand(setTVChannel);
				    control.setNumericInput(27);
				    control.pressButton();
					
						//turn off lights
				    control.setCommand(lightsOff);
				    control.pressButton();
				    
						//break TV
				    control.setCommand(DestroyTV);
				    control.pressButton();
					
						//turn on lights
				    control.setCommand(lightsOn);
				    control.pressButton();
				    
						//quit cable
				    control.setCommand(QuitCable);
				    control.pressButton();
					break;
				case 11:
					//Prepare for next week
						//turn off TV
					control.setCommand(TVOff);
				    control.pressButton();
						
						//fix TV
					control.setCommand(FixTV);
				    control.pressButton();
					
						//subscribe to cable
				    control.setCommand(SubscribeToCable);
				    control.pressButton();
					
						//turn off lights
				    control.setCommand(lightsOff);
				    control.pressButton();
					break;
				default:
					stay = false;
					break;
			}
			System.out.println("");
			System.out.println("");
		}
		while(stay);
	}
	
	public static void DisplayStates(Light lit, Television vis)
	{
		if(lit.getLightState())
		{
			System.out.println("The light is on.");
		}
		else
		{
			System.out.println("The light is off.");
		}
		
		if(vis.getTVState())
		{
			System.out.println("The TV is on.");
		}
		else
		{
			System.out.println("The TV is off.");
		}
		
		if(vis.getTVCable())
		{
			System.out.println("We have cable.");
		}
		else
		{
			System.out.println("The cable is out.");
		}
		
		if(vis.getTVOperable())
		{
			System.out.println("The TV is working.");
		}
		else
		{
			System.out.println("The TV is broken.");
		}
		
		System.out.println("The TV is on channel " + vis.getTVChannel() );
	}

}
