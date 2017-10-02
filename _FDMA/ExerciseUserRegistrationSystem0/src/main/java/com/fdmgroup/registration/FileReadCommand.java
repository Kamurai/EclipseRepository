package com.fdmgroup.registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReadCommand implements ReadCommand {
	private String filename;

	public FileReadCommand(String filename) {
		this.filename = filename;
	}

	@Override
	public User readUser(String username) throws UserNotReadException{		
		if(new File(filename).length() == 0) //nothing in the file? 
			return null;//user can't be found, avoid FileNotFoundException
		
		try(FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
		// Deserialize object
			while(fileInputStream.available()>0){
				User user = (User)objectInputStream.readObject();
				if (user != null && user.getUsername().equals(username)) 
					return user;
			}
		} catch (IOException e) {
			throw new UserNotReadException(e);
		} catch (ClassNotFoundException e) {
			throw new UserNotReadException(e);
		}
		return null; //user not found
	}

}
