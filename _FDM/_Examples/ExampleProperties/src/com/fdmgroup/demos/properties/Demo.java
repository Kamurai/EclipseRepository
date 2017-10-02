package com.fdmgroup.demos.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Demo {
	public static void main(String[] args) {

		demoLoadingFromFile("demo.properties");
		demoLoadingFromFile("demo.xml");
		demoStoringToFile("stored.properties");
		demoStoringToFile("stored.xml");

	}


	private static void demoLoadingFromFile(String filename) {

		Properties props = new Properties();
		InputStream in;

		try {
			in = new FileInputStream(filename);
			
			if(filename.endsWith(".xml"))
				props.loadFromXML(in); 
			if(filename.endsWith(".properties"))
				props.load(in);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String usernameValue = props.getProperty("username");
		String passwordValue = props.getProperty("password");
		String urlValue = props.getProperty("url");
		String messageValue = props.getProperty("message");

		System.out.println("Username: " + usernameValue);
		System.out.println("Password: " + passwordValue);
		System.out.println("URL: " + urlValue);
		System.out.println("Message: " + messageValue);
	}

	private static void demoStoringToFile(String filename) {
		
		Properties props = new Properties();
		
		props.setProperty("dinner", "Steak");
		props.setProperty("beverage", "Diet Coke");
		props.setProperty("dessert", "chocolate mousse");
		
		OutputStream writer;

		try {
			writer = new FileOutputStream(filename);
			
			if(filename.endsWith(".xml"))
				props.storeToXML(writer,  "Storing properties into XML file...");
			if(filename.endsWith(".properties"))
				props.store(writer, "Storing properties into properties file...");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
