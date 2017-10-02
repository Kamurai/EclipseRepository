package com.fdmgroup.DAO;

public class DBRunner 
{

	public static void main(String[] args) 
	{
		DBSetup dBSetup = new DBSetup();
		
		boolean forDemo = false;
		
		System.out.println("Tearing down that DB.");
		dBSetup.tearDownDB();
		System.out.println("DB is tore down.\n");
		
		System.out.println("Setting up this DB.");
		dBSetup.setupDB();
		System.out.println("DB is set up.\n");
		
		System.out.println("Stubbing DB.");
		dBSetup.stubDBwithHeroes();
		System.out.println("DB is stubbed.\n");
		
	}

}
