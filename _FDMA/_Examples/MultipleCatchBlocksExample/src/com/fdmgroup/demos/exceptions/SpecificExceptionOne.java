package com.fdmgroup.demos.exceptions;

public class SpecificExceptionOne extends GeneralException {

	private static final long serialVersionUID = 1L;

	public SpecificExceptionOne() {
		super();
	}
	
	public SpecificExceptionOne(String message) {
		super(message);
	}

	public SpecificExceptionOne(Throwable cause) {
		super(cause);
	}

	public SpecificExceptionOne(String message, Throwable cause) {
		super(message, cause);
	}

}
