package com.fdmgroup.registration;

public class RegistrationController {
	ReadCommand readCommand;
	WriteCommand writeCommand;
	UserFactory factory;
	DBSetupCommand dBSetupCommand;

	public RegistrationController(ReadCommand reader, WriteCommand writer, UserFactory factory) 
	{
		this.readCommand = reader;
		this.writeCommand = writer;
		this.factory = factory;
		this.dBSetupCommand = new DBSetupCommand();
	}

	public void registerNewUser(String username, String password, String role) throws UserNotWrittenException, UserNotReadException, UsernameIsTakenException 
	{
		//if the username is not taken
		if (readCommand.readUser(username) == null) 
		{
			User newUser = factory.createUser(username, password, role);
			writeCommand.writeUser(newUser);
		}
		//the username is taken
		else
		{
			throw new UsernameIsTakenException();
		}		
	}

	public User getUser(String username) 
	{
		try {
			return readCommand.readUser(username);
		} catch (UserNotReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	public void removeUser(String username) 
	{
		try {
			writeCommand.removeUser(username);
		} catch (UserNotRemovedException e) {
			e.printStackTrace();
		}		
	}

	public void setUpDB() 
	{
		dBSetupCommand.setUpDB();		
	}
	
	public void tearDownDB() 
	{
		dBSetupCommand.tearDownDB();		
	}


}
