package com.fdmgroup.demos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIODemo {
	public static void main(String[] args) {

		String filename = "chocolate_file.txt";

		writeDataToFile(filename);
		readDataFromFile(filename);
		
		// Now try switching the order in which the data
		// is read back in.  For example, switch the 
		// readDouble() and readInt() calls below.

	}

	private static void writeDataToFile(String filename) {

		String manufacturer1 = "Cadbury";
		String product1 = "Cream Egg";
		double price1 = 0.50;
		int rating1 = 6;

		String manufacturer2 = "Mars";
		String product2 = "Bounty";
		double price2 = 0.35;
		int rating2 = 9;

		// Write data to file

		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(filename);

			dataOutputStream = new DataOutputStream(fileOutputStream);

			dataOutputStream.writeUTF(manufacturer1);
			dataOutputStream.writeUTF(product1);
			dataOutputStream.writeDouble(price1);
			dataOutputStream.writeInt(rating1);

			dataOutputStream.writeUTF(manufacturer2);
			dataOutputStream.writeUTF(product2);
			dataOutputStream.writeDouble(price2);
			dataOutputStream.writeInt(rating2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataOutputStream.flush();
				dataOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void readDataFromFile(String filename) {
		
		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
		
		try {

			// read from file
			fileInputStream = new FileInputStream(filename);
			dataInputStream = new DataInputStream(fileInputStream);

			String manufacturer1 = dataInputStream.readUTF();
			String product1 = dataInputStream.readUTF();
			double price1 = dataInputStream.readDouble();
			int rating1 = dataInputStream.readInt();

			String manufacturer2 = dataInputStream.readUTF();
			String product2 = dataInputStream.readUTF();
			double price2 = dataInputStream.readDouble();
			int rating2 = dataInputStream.readInt();

			
			System.out.println("Manufacturer1: " + manufacturer1);
			System.out.println("Product1: " + product1);
			System.out.println("Price1: " + price1);
			System.out.println("Rating1: " + rating1);

			System.out.println("Manufacturer2: " + manufacturer2);
			System.out.println("Product2: " + product2);
			System.out.println("Price2: " + price2);
			System.out.println("Rating2: " + rating2);


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
