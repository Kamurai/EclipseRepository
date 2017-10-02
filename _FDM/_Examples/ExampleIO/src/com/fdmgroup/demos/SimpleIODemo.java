package com.fdmgroup.demos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class SimpleIODemo {

	public static void main(String[] args) {

		writeMessageToFile("Buy milk");
		writeMessageToFile("Vacuum");
		writeMessageToFile("Get mail");

		readMessagesFromFile();
	}

	private static void writeMessageToFile(String message) {

		Writer writer = null;
		BufferedWriter bufferedWriter = null;

		try {

			/*
			 * Java will translate '/' to '\' for Windows paths. Paths can be
			 * relative, or absolute.
			 */

			writer = new FileWriter("./messages.txt", true); // setting second
																// arg to
																// true will
																// append to
																// existing file

			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(message+"\n");

		} catch (IOException e) {
			// TODO Handle the IOException
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Handle exception when calling flush()/close()
				e.printStackTrace();
			}

		}

		/*
		 * After running this code you will need to refresh your project in the
		 * Project Explorer to see the file it created.
		 */
	}

	private static void readMessagesFromFile() {

		/*
		 * Now, let's read from the file we just created and print its contents
		 * to the command line.
		 */

		Reader reader = null;
		BufferedReader bufferedReader = null;

		try {
			reader = new FileReader("messages.txt");
			bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();

			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Handle the file not being found
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Handle any other IOException
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Handle exception during close()
				e.printStackTrace();
			}
		}

	}

}
