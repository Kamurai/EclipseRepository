package com.fdmgroup.registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReadCommand implements ReadCommand {
	private String filename;
	LoggingObject loggingObject = new LoggingObject();
	
	public FileReadCommand(String filename) {
		this.filename = filename;
	}

	@Override
	public User readUser(String username) throws UserNotReadException{		
		if(new File(filename).length() == 0) //nothing in the file? 
		{
			LoggingObject.log("info: [DID NOT] read user: " + username + " from file: file not found.", 2);
			return null;//user can't be found, avoid FileNotFoundException
		}
		
		try(FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
		// Deserialize object
			while(fileInputStream.available()>0){
				User user = (User)objectInputStream.readObject();
				if (user != null && user.getUsername().equals(username)) 
				{
					LoggingObject.log("info: read user: " + username + " from file.", 2);
					return user;
				}
			}
		} catch (IOException e) {
			LoggingObject.log("info: [DID NOT] read user: " + username + " from file: user not found.", 2);
			throw new UserNotReadException(e);
		} catch (ClassNotFoundException e) {
			LoggingObject.log("info: [DID NOT] read user: " + username + " from file: class not found.", 2);
			throw new UserNotReadException(e);
		}
		return null; //user not found
	}

}
