package Muhr.src;
/**
 * Project Muhr : This is a program that will simulate something like an evolved Tamagotchi or a virtual pet or child.
 * Health class
 * @author Ashley Rayborn and Joel Cox
 * @version 19 January 2010
 */

public class Health 
{
	public static boolean hunger(int hunger)
	{	
		if (hunger == 0)
		{
			System.out.println("I'm not really hungry right now.");
			return false;
		}
		
		else if (hunger <= 9 && hunger >= 1)
		{
			System.out.println("I'm not really hungry right now.");
			return false;
		}
		
		else if (hunger <= 19 && hunger >= 10)
		{
			System.out.println("I'm not ready to eat yet.");
			return false;
		}
		
		else if (hunger <= 29 && hunger >= 20)
		{
			System.out.println("I'm not ready to eat yet.");
			return false;
		}
		
		else if (hunger <= 39 && hunger >= 30)
		{
			System.out.println("I could go for a snack.");
			return true;
		}
		
		else if (hunger <= 49 && hunger >= 40)
		{
			System.out.println("It's mealtime.");
			return true;
		}
		
		else if (hunger <= 59 && hunger >= 50)
		{
			System.out.println("I really need to eat now.");
			return true;
		}
		
		else if (hunger <= 69 && hunger >= 60)
		{
			System.out.println("I can't find any food!");
			return true;
		}
		
		else if (hunger <= 79 && hunger >= 70)
		{
			System.out.println("Why can't I find any food?");
			return true;
		}
		
		else if (hunger <= 89 && hunger >= 80)
		{
			System.out.println("Are you trying to starve me?");
			return true;
		}
		
		else if (hunger <= 99 && hunger >= 90)
		{
			System.out.println("If I don't eat NOW, I will surely die.");
			return true;
		}
		
		return false;
	}
	
	/*
	 * Gets the tired value from Main, and depending on the value of tired,
	 * determines the value of rest, and returns rest.
	 */
	public static int sleep(int tired)
	{
		int rest = 0;
		
		if (tired == 0)
		{
			System.out.println("I don't need to sleep right now.");
		}
		
		else if (tired <= 9 && tired >= 1)
		{
			System.out.println("I don't need to sleep right now.");
		}
		
		else if (tired <= 19 && tired >= 10)
		{
			System.out.println("I don't need to sleep right now.");
		}
		
		else if (tired <= 29 && tired >= 20)
		{
			System.out.println("Blah blah blah tits.");
		}
		
		else if (tired <= 39 && tired >= 30)
		{
			System.out.println("Go fuck your mother.");
		}
		
		else if (tired <= 49 && tired >= 40)
		{
			System.out.println("Stabbity stab stab.");
		}
		
		else if (tired <= 59 && tired >= 50)
		{
			System.out.println("It's naptime.");
			rest = 300000;
		}
		
		else if (tired <= 69 && tired >= 60)
		{
			System.out.println("I think I might like to sleep now.");
			rest = 360000;
		}
		
		else if (tired <= 79 && tired >= 70)
		{
			System.out.println("I really should go to sleep now.");
			rest = 420000;
		}
		
		else if (tired <= 89 && tired >= 80)
		{
			System.out.println("If you don't let me sleep, I'll blow up this computer, I swear it.");
			rest = 480000;
		}
		
		else if (tired <= 99 && tired >= 90)
		{
			System.out.println("If I don't sleep NOW, I'm going to die.");
			rest = 540000;
		}
		
		return rest;
	}
}
