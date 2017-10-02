package com.fdmgroup;

import java.util.List;

public class User 
{
	int user_id; 
	String username;
	String pword;
	String firstName;
	String lastName;
	String email;
	String prole;
	String status;
	
	public User(int user_id, 
			String username, 
			String pword, 
			String firstName, 
			String lastName, 
			String email, 
			String prole,
			String status) 
	{
		this.user_id = user_id; 
		this.username = username;
		this.pword = pword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.prole = prole;
		this.status = status;
		
	}

	public void printUser() 
	{
		System.out.print(	"ID: " + user_id + 
							" Username: " + username + 
							" Password: " + pword +
							" First: " + firstName +
							" Last: " + lastName +
							" Email: " + email +
							" Role: " + prole +
							" Status: " + status +
							"\n");
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProle() {
		return prole;
	}

	public void setProle(String prole) {
		this.prole = prole;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
