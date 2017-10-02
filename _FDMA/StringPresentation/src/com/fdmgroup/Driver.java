package com.fdmgroup;

import java.util.Scanner;

public class Driver 
{
	static boolean stay = true;
	static int response = 0;
	
	static String testString =                                  "Penguin";
	static String testString2 =                                 "Penguin";
	static StringBuilder testStringBuilder = new StringBuilder( "Penguin");
	static StringBuilder testStringBuilder2 = new StringBuilder("Penguin");
	static StringBuffer testStringBuffer = new StringBuffer(    "Penguin");
	static StringBuffer testStringBuffer2 = new StringBuffer(   "Penguin");
	
	static char[] testStringArray = testString.toCharArray();
	static char[] testStringBuilderArray = testStringBuilder.toString().toCharArray();
	static char[] testStringBufferArray = testStringBuffer.toString().toCharArray();

	static char[] testStringArray2 = testString.toCharArray();
	static char[] testStringBuilderArray2 = testStringBuilder.toString().toCharArray();
	static char[] testStringBufferArray2 = testStringBuffer.toString().toCharArray();

	static StringBuilderThread AdderA = new StringBuilderThread();
	static StringBuilderThread AdderB = new StringBuilderThread();
	static StringBufferThread AdderC = new StringBufferThread();
	static StringBufferThread AdderD = new StringBufferThread();
	
	static boolean AdderAStarted = false;
	static boolean AdderBStarted = false;
	static boolean AdderCStarted = false;
	static boolean AdderDStarted = false;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		stay = true;
		response = 0;
		
		testString =                           "Penguin";
		testString2 =                          "Penguin";
		testStringBuilder = new StringBuilder( "Penguin");
		testStringBuilder2 = new StringBuilder("Penguin");
		testStringBuffer = new StringBuffer(   "Penguin");
		testStringBuffer2 = new StringBuffer(  "Penguin");
		
		testStringArray = testString.toCharArray();
		testStringBuilderArray = testStringBuilder.toString().toCharArray();
		testStringBufferArray = testStringBuffer.toString().toCharArray();
		
		testStringArray2 = testString2.toCharArray();
		testStringBuilderArray2 = testStringBuilder2.toString().toCharArray();
		testStringBufferArray2 = testStringBuffer2.toString().toCharArray();
		
		AdderA.setDesignation("A");
		AdderA.setWidth(100);
//		AdderA.setDepth(1);
//		AdderA.setTarget(3);
		AdderB.setDesignation("B");
		AdderB.setWidth(100);
//		AdderB.setDepth(1);
//		AdderB.setTarget(3);
		AdderC.setDesignation("C");
		AdderC.setWidth(100);
//		AdderC.setDepth(1);
//		AdderC.setTarget(3);
		AdderD.setDesignation("D");
		AdderD.setWidth(100);
//		AdderD.setDepth(1);
//		AdderD.setTarget(3);
		
		do
		{
			System.out.println("Hello, what would you like to do?");
			System.out.println("0) Exit.");
			System.out.println("1) Display variables.");
			System.out.println("2) Display variables as array.");
			System.out.println("3) Example string immutability.");
			System.out.println("4) Example StringBuilder mutability.");
			System.out.println("5) Example StringBuffer mutability.");
			System.out.println("7) Display tested variables as array.");
			System.out.println("8) Display tested variables.");
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
					DisplayTestVariables();
					break;
				case 2:
					DisplayTestVariablesAsArray();
					break;
				case 3:
					DisplayTestStrings();
					break;
				case 4:
					testStringBuilder2 = new StringBuilder("X");
//					DisplayTestStringBuilders();
					StartThreadsForStringBuilders();
					//wait
					try
					{
						Thread.sleep(3000);
					}
					catch(Exception e)
					{
						System.out.println("moo");
					}
					StopThreadsForStringBuilders();
					DisplayTestVariables2();
					break;
				case 5:
					testStringBuffer2 = new StringBuffer("X");
//					DisplayTestStringBuffers();
					StartThreadsForStringBuffers();
					//wait
					try
					{
						Thread.sleep(3000);
					}
					catch(Exception e)
					{
						System.out.println("moo");
					}
					StopThreadsForStringBuffers();
					DisplayTestVariables2();	
					break;
				case 7:
					DisplayTestVariablesAsArray2();
					break;
				case 8:
					DisplayTestVariables2();
					break;
				case 9:
					testString         =                   "Penguins";
					testString2        =                   "Penguins";
					testStringBuilder  = new StringBuilder("Penguins");
					testStringBuilder2 = new StringBuilder("Penguins");
					testStringBuffer   = new StringBuffer( "Penguins");
					testStringBuffer2  = new StringBuffer( "Penguins");
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
	
	public static void DisplayTestVariables()
	{
		System.out.println("Test String:        " + testString);
		System.out.println("Test StringBuilder: " + testStringBuilder);
		System.out.println("Test StringBuffer:  " + testStringBuffer);
	}
	
	public static void DisplayTestVariables2()
	{
		System.out.println("Test String:        " + testString2);
		System.out.println("Test StringBuilder: " + testStringBuilder2);
		System.out.println("Test StringBuffer:  " + testStringBuffer2);
	}
	
	public static void DisplayTestVariablesAsArray()
	{
		testStringArray = testString.toCharArray();
		testStringBuilderArray = testStringBuilder.toString().toCharArray();
		testStringBufferArray = testStringBuffer.toString().toCharArray();

		System.out.println("Test String:        ");
		for(int x = 0; x < testStringArray.length; x++)
		{
			System.out.print("[" + testStringArray[x] + "] ");
		}
		System.out.println("");
		System.out.println("Test StringBuilder: ");
		for(int x = 0; x < testStringBuilderArray.length; x++)
		{
			System.out.print("[" + testStringBuilderArray[x] + "] ");
		}
		System.out.println("");
		System.out.println("Test StringBuffer:  ");
		for(int x = 0; x < testStringBufferArray.length; x++)
		{
			System.out.print("[" + testStringBufferArray[x] + "] ");
		}
	}
	
	public static void DisplayTestVariablesAsArray2()
	{
		testStringArray2 = testString2.toCharArray();
		testStringBuilderArray2 = testStringBuilder2.toString().toCharArray();
		testStringBufferArray2 = testStringBuffer2.toString().toCharArray();
		
		System.out.println("Test String:        ");
		for(int x = 0; x < testStringArray2.length; x++)
		{
			System.out.print("[" + testStringArray2[x] + "] ");
		}
		System.out.println("");
		System.out.println("Test StringBuilder: ");
		for(int x = 0; x < testStringBuilderArray2.length; x++)
		{
			System.out.print("[" + testStringBuilderArray2[x] + "] ");
		}
		System.out.println("");
		System.out.println("Test StringBuffer:  ");
		for(int x = 0; x < testStringBufferArray2.length; x++)
		{
			System.out.print("[" + testStringBufferArray2[x] + "] ");
		}
	}
	
	public static void DisplayTestStrings()
	{
		//Display original values
		System.out.println("Test String 1: " + testString);
		System.out.println("Test String 2: " + testString2);
		//start displayed changes
		System.out.print("Changing " + testString + " to ");
		//change second string
		testString2 = "Ostrich";
		System.out.println(testString2);
		//Display altered values
		System.out.println("Test String 1: " + testString);
		System.out.println("Test String 2: " + testString2);
	
	}
	
	public static void DisplayTestStringBuilders()
	{
		//Display original values
		System.out.println("Test StringBuilder 1: " + testStringBuilder);
		System.out.println("Test StringBuilder 2: " + testStringBuilder2);
		//start displayed changes
		System.out.print("Changing " + testStringBuilder + " to ");
		//change second string
		testStringBuilder2.replace(0, 7, "Ostrich");
		System.out.println(testStringBuilder2);
		//Display altered values
		System.out.println("Test StringBuilder 1: " + testStringBuilder);
		System.out.println("Test StringBuilder 2: " + testStringBuilder2);
		System.out.println("");
		//Display original values
		System.out.println("Test StringBuilder 1: " + testStringBuilder);
		System.out.println("Test StringBuilder 2: " + testStringBuilder2);
		//start displayed changes
		System.out.print("Changing " + testStringBuilder + " to ");
		//change second string
		testStringBuilder2.append("es");
		System.out.println(testStringBuilder2);
		//Display altered values
		System.out.println("Test StringBuilder 1: " + testStringBuilder);
		System.out.println("Test StringBuilder 2: " + testStringBuilder2);
		
	}
	
	public static void DisplayTestStringBuffers()
	{
		//Display original values
		System.out.println("Test StringBuffer 1: " + testStringBuffer);
		System.out.println("Test StringBuffer 2: " + testStringBuffer2);
		//start displayed changes
		System.out.print("Changing " + testStringBuffer + " to ");
		//change second string
		testStringBuffer2.replace(0, 7, "Ostrich");
		System.out.println(testStringBuffer2);
		//Display altered values
		System.out.println("Test StringBuffer 1: " + testStringBuffer);
		System.out.println("Test StringBuffer 2: " + testStringBuffer2);
		System.out.println("");
		//Display original values
		System.out.println("Test StringBuffer 1: " + testStringBuffer);
		System.out.println("Test StringBuffer 2: " + testStringBuffer2);
		//start displayed changes
		System.out.print("Changing " + testStringBuffer + " to ");
		//change second string
		testStringBuffer2.append("es");
		System.out.println(testStringBuffer2);
		//Display altered values
		System.out.println("Test StringBuffer 1: " + testStringBuffer);
		System.out.println("Test StringBuffer 2: " + testStringBuffer2);
	}
	
	public static void StartThreadsForStringBuilders()
	{
		if(AdderAStarted)
		{
			AdderA.setRunning(true);
			System.out.println("Continuing Thread A");
		}
		else
		{
			AdderA.start();
			System.out.println("Starting Thread A");
			AdderAStarted = true;
		}
		
		if(AdderBStarted)
		{
			AdderB.setRunning(true);
			System.out.println("Continuing Thread B");
		}
		else
		{
			AdderB.start();
			System.out.println("Starting Thread B");
			AdderBStarted = true;
		}
	}
	
	public static void StopThreadsForStringBuilders()
	{
		AdderA.setRunning(false);
		AdderB.setRunning(false);
		System.out.println("Pausing Thread A");
		System.out.println("Pausing Thread B");
		
	}
	
	public static void StartThreadsForStringBuffers()
	{
		if(AdderCStarted)
		{
			AdderC.setRunning(true);
			System.out.println("Continuing Thread C");
		}
		else
		{
			AdderC.start();
			System.out.println("Starting Thread C");
			AdderCStarted = true;
		}
		
		if(AdderDStarted)
		{
			AdderD.setRunning(true);
			System.out.println("Continuing Thread D");
		}
		else
		{
			AdderD.start();
			System.out.println("Starting Thread D");
			AdderDStarted = true;
		}
	}
	
	public static void StopThreadsForStringBuffers()
	{
		AdderC.setRunning(false);
		AdderD.setRunning(false);
		System.out.println("Pausing Thread C");
		System.out.println("Pausing Thread D");
		
	}

}

