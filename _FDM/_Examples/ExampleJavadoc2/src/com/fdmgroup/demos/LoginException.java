package com.fdmgroup.demos;

/**
 * Generated when login credentials are invalid. A meaningful message is
 * provided.
 * 
 * <p>
 * HTML can be embedded into Javadoc comments:
 * <ul>
 * <li>Here is the first important bullet point
 * <li>Here is the second
 * <li>Running out of ideas
 * <li>And we're done
 * </ul>
 * <p>
 * 
 * @author shoshana.kesselman
 * 
 */
public class LoginException extends Exception {
	private static final long serialVersionUID = 1L;

	public LoginException() {
		super();
	}

	public LoginException(String message) {
		super(message);
	}
}