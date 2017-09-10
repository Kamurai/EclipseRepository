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

	static AThread AdderA = new AThread();
	static BThread AdderB = new BThread();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		stay = true;
		response = 0;
		
		testString =                                  "Penguin";
		testString2 =                                 "Penguin";
		testStringBuilder = new StringBuilder( "Penguin");
		testStringBuilder2 = new StringBuilder("Penguin");
		testStringBuffer = new StringBuffer(    "Penguin");
		testStringBuffer2 = new StringBuffer(   "Penguin");
		
		testStringArray = testString.toCharArray();
		testStringBuilderArray = testStringBuilder.toString().toCharArray();
		testStringBufferArray = testStringBuffer.toString().toCharArray();
		
		
		do
		{
			System.out.println("Hello, what would you like to do?");
			System.out.println("0) Exit.");
			System.out.println("1) Display variables.");
			System.out.println("2) Display variables as array.");
			System.out.println("3) Example string immutability.");
			System.out.println("4) Example StringBuilder mutability.");
			System.out.println("5) Example StringBuffer mutability.");
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
					DisplayTestVariables(testString, testStringBuilder, testStringBuffer);
					break;
				case 2:
					DisplayTestVariablesAsArray(testStringArray, testStringBuilderArray, testStringBufferArray);
					break;
				case 3:
					DisplayTestStrings(testString, testString2);
					break;
				case 4:
					DisplayTestStringBuilders(testStringBuilder, testStringBuilder2);
					DisplayThreadForStringBuilders(testStringBuilder, testStringBuilder2);
					break;
				case 5:
					DisplayTestStringBuffers(testStringBuffer, testStringBuffer2);	
					DisplayThreadForStringBuffers(testStringBuffer, testStringBuffer2);
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
	
	public static void DisplayTestVariables(String string1, StringBuilder builder1, StringBuffer buffer1)
	{
		System.out.println("Test String:        " + string1);
		System.out.println("Test StringBuilder: " + builder1);
		System.out.println("Test StringBuffer:  " + buffer1);
	}
	
	public static void DisplayTestVariablesAsArray(char[] stringArray1, char[] builderArray1, char[] bufferArray1)
	{
		System.out.println("Test String:        ");
		for(int x = 0; x < stringArray1.length; x++)
		{
			System.out.print("[" + stringArray1[x] + "] ");
		}
		System.out.println("");
		System.out.println("Test StringBuilder: ");
		for(int x = 0; x < builderArray1.length; x++)
		{
			System.out.print("[" + builderArray1[x] + "] ");
		}
		System.out.println("");
		System.out.println("Test StringBuffer:  ");
		for(int x = 0; x < bufferArray1.length; x++)
		{
			System.out.print("[" + bufferArray1[x] + "] ");
		}
	}
	
	public static void DisplayTestStrings(String one, String two)
	{
		//Display original values
		System.out.println("Test String 1: " + one);
		System.out.println("Test String 2: " + two);
		//start displayed changes
		System.out.print("Changing " + one + " to ");
		//change second string
		two = "Ostrich";
		System.out.println(two);
		//Display altered values
		System.out.println("Test String 1: " + one);
		System.out.println("Test String 2: " + two);
	
	}
	
	public static void DisplayTestStringBuilders(StringBuilder one, StringBuilder two)
	{
		//Display original values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
		//start displayed changes
		System.out.print("Changing " + one + " to ");
		//change second string
		two.replace(0, 7, "Ostrich");
		System.out.println(two);
		//Display altered values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
		System.out.println("");
		//Display original values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
		//start displayed changes
		System.out.print("Changing " + one + " to ");
		//change second string
		two.append("es");
		System.out.println(two);
		//Display altered values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
		
	}
	
	public static void DisplayTestStringBuffers(StringBuffer one, StringBuffer two)
	{
		//Display original values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
		//start displayed changes
		System.out.print("Changing " + one + " to ");
		//change second string
		two.replace(0, 7, "Ostrich");
		System.out.println(two);
		//Display altered values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
		System.out.println("");
		//Display original values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
		//start displayed changes
		System.out.print("Changing " + one + " to ");
		//change second string
		two.append("es");
		System.out.println(two);
		//Display altered values
		System.out.println("Test StringBuilder 1: " + one);
		System.out.println("Test StringBuilder 2: " + two);
	}
	
	public static void DisplayThreadForStringBuilders(StringBuilder one, StringBuilder two)
	{
		
		System.out.println("Starting Thread A");
		AdderA.start();
		System.out.println("Starting Thread B");
		AdderB.start();
		
		System.out.println("Starting Thread A");
		AdderA.interrupt();
		System.out.println("Starting Thread B");
		AdderB.interrupt();
	}
	
	public static void DisplayThreadForStringBuffers(StringBuffer one, StringBuffer two)
	{
		System.out.println("Starting Thread A");
		AdderA.start();
		System.out.println("Starting Thread B");
		AdderB.start();
		
		System.out.println("Interrupting Thread A");
		AdderA.interrupt();
		System.out.println("Interrupting Thread B");
		AdderB.interrupt();
	}

}

