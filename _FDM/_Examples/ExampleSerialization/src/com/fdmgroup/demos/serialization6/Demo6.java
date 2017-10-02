package com.fdmgroup.demos.serialization6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo6 {

	/* Demonstrates successful serialization of Trainee. 
	 * 
	 * Resume is NOT Serializable, but marked transient.
	 * Resume data is saved using custom serialization.
	 * 
	 * Trainee now has a nonserializable super class.
	 * Employee data is not saved.
	 */
	
	public static void main(String[] args) {

		Resume resume = new Resume();
		resume.setGraduationDate("2015");
		
		Trainee traineeToSerialize = new Trainee(1067,"John Smith", resume);
		
		serializeTrainee("trainee.ser", traineeToSerialize);

		Trainee deserializedTrainee = deserializeTrainee("trainee.ser");

		System.out.println("Deserialized trainee: " + deserializedTrainee);
	}

	private static void serializeTrainee(String filename,
			Trainee traineeToSerialize) {

		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			// Serialize object
			fileOutputStream = new FileOutputStream(filename);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(traineeToSerialize);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static Trainee deserializeTrainee(String filename) {

		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		Object deserializedObject = null;
		
		try {
			
			// Deserialize object
			fileInputStream = new FileInputStream(filename);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			deserializedObject = objectInputStream.readObject(); 

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if(deserializedObject instanceof Trainee)
			return (Trainee)deserializedObject;
		
		return null;
	}

}
