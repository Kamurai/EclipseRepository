package com.fdmgroup.registration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriteCommand implements WriteCommand {
	private String filename;
	LoggingObject loggingObject = new LoggingObject();
	
	public FileWriteCommand(String filename) {
		this.filename = filename;
		new File(filename);
	}

	public void writeUser(User user) throws UserNotWrittenException{

		try(FileOutputStream fos = new FileOutputStream(filename, true);
			ObjectOutputStream oos = 
				(new File(filename).length()>0) //if there is stuff in the file... 
				? new ObjectOutputStream(fos){
					@Override
					protected void writeStreamHeader() throws IOException {
						reset();
					}//...initialise oos to an anonymous class that doesn't write a header for each object...
				  }//(this avoids StreamCorruptionException when reading objects past the first one)
				: new ObjectOutputStream(fos) ) {//...otherwise write the header normally
			
			// Serialize object
			oos.writeObject(user);
			LoggingObject.log("info: wrote user: " + user.getUsername() + " to file.", 2);

		} catch (IOException e) {
			LoggingObject.log("info: thre exception: " + e + ".", 2);
			throw new UserNotWrittenException(e);
		}
	}

	@Override
	public void removeUser(String username) throws UserNotRemovedException 
	{
		// TODO Auto-generated method stub
			//I have no idea how to start this
		
		LoggingObject.log("info: [DID NOT] removed user: " + username + " from file.", 2);
		
	}

}
