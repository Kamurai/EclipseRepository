package com.fdmgroup.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.fdmgroup.serialization.game.Board;

public class Driver 
{
	//Driver
	static boolean stay = true;
	static int response = 0;
	
	public static void main(String[] args) 
	{
		stay = true;
		response = 0;
		
		//serialization
		FileOutputStream fileOut;
		ObjectOutputStream out;
		
		FileInputStream fileIn;
		ObjectInputStream in;
		
		//Environment
		Board MainBoard;
		//Characters
		Wizard wizard;
		Warrior warrior;
		
		MainBoard = new Board();
		wizard = new Wizard();
		warrior = new Warrior();
		
		int numHealthPacks = 3;
		//add Health Packs
		wizard.gainHealthPack(numHealthPacks);
		warrior.gainHealthPack(numHealthPacks);
		
		do
		{
			System.out.println("A wizard and a warrior are fighting!");
			System.out.println("What happens next?");
			System.out.println("0) Exit.");
			System.out.println("1) Wizard attacks.");
			System.out.println("2) Warrior attacks.");
			System.out.println("3) Wizard Uses Health Pack.");
			System.out.println("4) Warrior Uses Health Pack.");
			System.out.println("5) .");
			System.out.println("6) Load the game.");
			System.out.println("7) Save the game.");
			System.out.println("8) Check Status.");
			System.out.println("9) Reset scenario.");
			Scanner reader = new Scanner(System.in);
			response = reader.nextInt();
			
			System.out.println("");
			switch(response)
			{
				case 0:
					stay = false;
					break;
				case 1:
					//MainBoard.attack(wizard, warrior);
					MainBoard.loseHealthPoint(warrior);
					break;
				case 2:
					//MainBoard.attack(warrior, wizard);	
					MainBoard.loseHealthPoint(wizard);
					break;
				case 3:
					wizard.useHealthPack();
					break;
				case 4:
					warrior.useHealthPack();
					break;
				case 5:
					
					break;
				case 6:
					try 
					{
				         fileIn = new FileInputStream("C:/Users/Christopher.Kemerait/Documents/tmp/saveGame.txt");
				         in = new ObjectInputStream(fileIn);
				         wizard = (Wizard) in.readObject();
				         warrior = (Warrior) in.readObject();
				         in.close();
				         fileIn.close();
				    }
					catch(IOException i) 
					{
				         i.printStackTrace();
				    }
					catch(ClassNotFoundException c) 
					{
						System.out.println("JobClass not found");
						c.printStackTrace();
				    }
					break;
				case 7:
					try
					{
						fileOut = new FileOutputStream("C:/Users/Christopher.Kemerait/Documents/tmp/saveGame.txt");
						out = new ObjectOutputStream(fileOut);
						out.writeObject(wizard);
						out.writeObject(warrior);
						out.close();
						fileOut.close();
						System.out.printf("Serialized data is saved in C:/Users/Christopher.Kemerait/Documents/tmp/saveGame.txt");
					}
					catch(IOException i) 
					{
				         i.printStackTrace();
					}
					break;
				case 8:
					System.out.println("Wizard has "+wizard.getHealthPoints()+" HP");
					System.out.println("Warrior has "+warrior.getHealthPoints()+" HP");
					break;
				case 9:
					
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

}
