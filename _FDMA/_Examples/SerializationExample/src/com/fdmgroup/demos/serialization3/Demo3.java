package com.fdmgroup.demos.serialization3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo3 {

	/* Demonstrates successful serialization of Trainee. 
	 * 
	 * Resume is now Serializable, both objects get saved.
	 */
	
	public static void main(String[] args) {

		Resume resume = new Resume();
		resume.setGraduationDate("2015");
		
		Trainee traineeToSerialize = new Trainee("John Smith", resume);

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
