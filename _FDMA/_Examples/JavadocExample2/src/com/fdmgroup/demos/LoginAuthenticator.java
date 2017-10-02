package com.fdmgroup.demos;

import java.util.Collection;

/**
 * LoginAuthenticator contains methods to verify the authenticity of a user
 * attempting to log into the Trading Platform.
 * 
 * @author shoshana.kesselman
 */
public class LoginAuthenticator {
	/**
	 * Returns true if the provided password matches the password of the given
	 * user and false otherwise.
	 * 
	 * @param user
	 *            A valid user of the the system.
	 * @param password
	 *            Typed by the person currently attempting to log in
	 * @return Returns true if the password String matches the password of the
	 *         given user.
	 */
	private boolean passwordMatches(User user, String password) {

		if (user == null)
			return false;

		if (user.getPassword().equals(password))
			return true;

		return false;
	}

	/**
	 * Returns true if the provided username matches the username of the given
	 * user and false otherwise.
	 * 
	 * @param user
	 *            A valid user of the the system.
	 * @param username
	 *            Typed by the person currently attempting to log in
	 * @return Returns true if the username String matches the username of the
	 *         given user.
	 */
	private boolean usernameMatches(User user, String username) {

		if (user == null)
			return false;

		if (user.getUsername().equals(username))
			return true;

		return false;
	}

	/**
	 * Returns a User object matching the provided login details, if a match is
	 * found.
	 * 
	 * @param users
	 *            Collection of users for the Trading Platform.
	 * @param userName
	 *            Username that was typed in by the current user attempting to
	 *            log in.
	 * @param password
	 *            Password that was typed in by the current user attempting to
	 *            log in.
	 * @return the user whose username and password matches those passed into
	 *         the method.
	 * @throws LoginException
	 *             Thrown if a matching user was not found.
	 * @see LoginException
	 */
	public User returnMatchedUser(Collection<User> users, String username,
			String password) throws LoginException {

		if (users == null)
			return null;

		for (User aUser : users)
			if (usernameMatches(aUser, username))
				if (passwordMatches(aUser, password))
					return aUser;
				else
					throw new LoginException("Password does not match.");

		throw new LoginException("No matching user found.");
	}

	/** Logs a user's details */
	public void logUserActivity(User user, String extra) {
		user.printUserDetails(extra);
	}
}
