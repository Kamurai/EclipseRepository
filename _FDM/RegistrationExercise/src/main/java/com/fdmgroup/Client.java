package com.fdmgroup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Client 
{
	//Driver
	static boolean stay = true;
	static int response = 0;
	
	static FileReadCommand fileReadCommand = new FileReadCommand("testFileDemoBackup.txt");
	static FileWriteCommand fileWriteCommand = new FileWriteCommand("testFileRegistrationBackup.txt");
	static UserFactory userFactory = new UserFactory();
	
	static RegistrationController registrationController = new RegistrationController(fileReadCommand, fileWriteCommand, userFactory);
	
	static String username;
	static String password;
	static String role;
	
		
	public static void main(String[] args) 
	{
		stay = true;
		response = 0;
		
		setupRegistrationController();
		
		do
		{
			System.out.println("Welcome to this user system!");
			System.out.println("What would you like to do?");
			System.out.println("0) Exit.");
			System.out.println("1) Add Captain America.");
			System.out.println("2) Add Iron Man.");
			System.out.println("3) Add Spiderman.");
			System.out.println("4) Add Daredevil.");
			System.out.println("5) Save Daredevil by name.");
			System.out.println("6) Load Daredevil by name.");
			System.out.println("7) Save User List.");
			System.out.println("8) Load User List.");
			System.out.println("9) Print Users.");
			System.out.println("99) Reset scenario.");
			Scanner reader = new Scanner(System.in);
			response = reader.nextInt();
			
			System.out.println("");
			
			switch(response)
			{
				case 0:
					stay = false;
					break;
				case 1:
					username = "Steve Rogers";
					password = "Peggy";
					role = "Captain America";
					registrationController.registerNewUser( username, password, role );
					break;
				case 2:
					username = "Tony Stark";
					password = "Pepper";
					role = "Iron Man";
					registrationController.registerNewUser( username, password, role );
					
					break;
				case 3:
					username = "Peter Parker";
					password = "Felicia";
					role = "Spiderman";
					registrationController.registerNewUser( username, password, role );
					
					break;
				case 4:
					username = "Matt Murdock";
					password = "Electra";
					role = "Daredevil";
					registrationController.registerNewUser( username, password, role );
					break;
				case 5:
					registrationController.writeUser("Matt Murdock");
					break;
				case 6:
					registrationController.readUser("Matt Murdock");
					break;
				case 7:
					registrationController.BackUpUsersToFile();
					break;
				case 8:
					registrationController.ReadUsersBackUpFromFile();
					break;
				case 9:
					registrationController.printUsers();
					break;
				case 99:
					setupRegistrationController();
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
	
	public static void setupRegistrationController()
	{
		fileReadCommand = new FileReadCommand("testFileDemoBackup.txt");
		fileWriteCommand = new FileWriteCommand("testFileRegistrationBackup.txt");
		userFactory = new UserFactory();
		registrationController = new RegistrationController(fileReadCommand, fileWriteCommand, userFactory);
	}
	

}
