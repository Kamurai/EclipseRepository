package com.fdmgroup.AbstractClasses;

import java.util.Scanner;

import com.fdmgroup.AbstractClasses.Eg01.Knight;
import com.fdmgroup.AbstractClasses.Eg03.Protoss;
import com.fdmgroup.AbstractClasses.Eg06.Monkey;

public class Driver {

	public static void main(String[] args) 
	{
		boolean stay = true;
		int response = 0;
		
		Knight Arthur = new Knight("Arthur");
		
		Protoss Tassadar = new Protoss("Tassadar");
		
		Monkey Bubbles = new Monkey("Bubbles");
		
		// TODO Auto-generated method stub
		do
		{
			//prompt user for response
			System.out.println("Hey there, whatcha want?");
			System.out.println("Eg 01: Use abstract and concrete methods in an abstract class.");
			System.out.println("Eg 03: User abstract class implementation of an interface.");
			System.out.println("Eg 06: Implement a interface extending an interface.");
			System.out.println("Eg 13: Override (?) a member variable in an abstract class.");
			
			//receive response
			Scanner reader = new Scanner(System.in);
			response = reader.nextInt();
			
			//switch-case the response
			switch (response)
			{
				case 0:
					stay=false;
					break;
				case 1:
					Arthur.RaiseShield();
					Arthur.Attack();
					Arthur.Defend();
					break;
				case 2:
					break;
				case 3:
					Tassadar.Attack();
					Tassadar.Invade();
					Tassadar.Assimilate();
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					Bubbles.Swing();
					Bubbles.EatFruit();
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					System.out.println(Protoss.designation);
					Protoss.designation = "Terran";
					System.out.println(Protoss.designation);
					
					break;
				case 14:
					break;
				case 15:
					break;
				default:
					break;
			}
			
			System.out.println();
			System.out.println();
		}
		while (stay);
	}

}
