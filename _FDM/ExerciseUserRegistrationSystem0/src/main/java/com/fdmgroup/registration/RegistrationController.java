package com.fdmgroup.registration;

public class RegistrationController {
	ReadCommand readCommand;
	WriteCommand writeCommand;
	UserFactory factory;

	public RegistrationController(ReadCommand reader, WriteCommand writer, UserFactory factory) {
		this.readCommand = reader;
		this.writeCommand = writer;
		this.factory = factory;
	}

	public void registerNewUser(String username, String password, String role) throws UserNotWrittenException, UserNotReadException, UsernameIsTakenException {
		
		if (readCommand.readUser(username) == null) {//if the username is not taken
			User newUser = factory.createUser(username, password, role);
			writeCommand.writeUser(newUser);
		}
		else{//the username is taken
			throw new UsernameIsTakenException();
		}
		
	}

}
