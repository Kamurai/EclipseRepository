package com.fdmgroup.demos.serialization2;

public class Resume {

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
