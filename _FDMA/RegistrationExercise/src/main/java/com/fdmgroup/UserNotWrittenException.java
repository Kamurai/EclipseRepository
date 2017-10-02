package com.fdmgroup;

/**
 * Not used in this demo at this time
 * @author Christopher Kemerait
 */

public class UserNotWrittenException extends Exception 
{
	public UserNotWrittenException()
	{
		super();
	}

	public UserNotWrittenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNotWrittenException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotWrittenException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotWrittenException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
