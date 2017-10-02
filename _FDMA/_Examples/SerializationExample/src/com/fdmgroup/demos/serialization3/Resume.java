package com.fdmgroup.demos.serialization3;

import java.io.Serializable;

public class Resume implements Serializable {

private static final long serialVersionUID = 1L;

	private String graduationDate;

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	@Override
	public String toString() {
		return graduationDate;
	}
}
