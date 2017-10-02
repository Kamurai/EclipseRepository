package com.fdmgroup.demos.serialization2;

import java.io.Serializable;

public class Trainee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Resume resume;
	
	public Trainee(String name, Resume resume){
		setName(name);
		setResume(resume);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		
		return name+", "+resume;
	}
}
