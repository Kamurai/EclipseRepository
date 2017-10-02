package com.fdmgroup;

import java.util.Scanner;

public class Driver 
{
	static boolean stay = true;
	static int response = 0;
	
	public static void main(String[] args) 
	{
		stay = true;
		response = 0;
		
		do
		{
			System.out.println("Hello, what would you like to do?");
			System.out.println("0) Exit.");
			System.out.println("1) Run set example.");
			System.out.println("2) Run hashmap example.");
			System.out.println("3) Run letter counting example.");
			System.out.println("4) Run duplicate word counting example.");
			System.out.println("5) Run linked list example.");
			System.out.println("6) Run split example.");
			System.out.println("7) Run varArg PriorityQueue example.");
			System.out.println("8) .");
			System.out.println("9) Reset test variables.");
			Scanner reader = new Scanner(System.in);
			response = reader.nextInt();
			
			System.out.println("");
			switch(response)
			{
				case 0:
					stay = false;
					break;
				case 1:
					
					break;
				case 2:
									
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
									
					break;
				case 8:
					
					break;
				case 9:
					
					break;
				default:
					stay = false;
					break;			
			}
		}
		while(stay);
	}

}
