package com.fdmgroup.demos.exceptions;

public class SpecificExceptionTwo extends GeneralException {

	private static final long serialVersionUID = 1L;

	public SpecificExceptionTwo() {
		super();
	}
	
	public SpecificExceptionTwo(String message) {
		super(message);
	}

	public SpecificExceptionTwo(Throwable cause) {
		super(cause);
	}

	public SpecificExceptionTwo(String message, Throwable cause) {
		super(message, cause);
	}

}
