package com.fdmgroup.registration;

public class DBInfo 
{
	String url;
	String username;
	String password;
	
	public DBInfo()
	{
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		username = "trainee1";
		password = "!QAZSE4";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String connectionName) {
		this.url = connectionName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
