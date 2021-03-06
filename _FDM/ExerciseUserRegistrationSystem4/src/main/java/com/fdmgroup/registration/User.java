package com.fdmgroup.registration;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4805961129737578684L;
	@Id
	private String username;
	private String password;
	private String role;

	public User()
	{
		
	}
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
