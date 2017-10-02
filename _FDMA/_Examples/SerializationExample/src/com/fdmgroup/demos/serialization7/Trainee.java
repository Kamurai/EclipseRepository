package com.fdmgroup.demos.serialization7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Trainee extends Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private transient Resume resume;
	
	public Trainee(int id, String name, Resume resume){
		setId(id);
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
		
		return super.toString()+": "+name+", "+resume;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		
		oos.defaultWriteObject(); // Invoke default serialization
	
		// Do the rest manually:
		
		if(resume != null)
			oos.writeUTF(resume.getGraduationDate()); 
		
		oos.writeInt(getId());
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		
		ois.defaultReadObject();	// Invoke default deserialization

		// Do the rest manually:
		
		resume = new Resume();
		resume.setGraduationDate(ois.readUTF()); 
		
		setId(ois.readInt());
	}
}
