package com.fdmgroup.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOHelper 
{
	private DBInfo dBInfo;
	private Connection connection;
	private String dBurl;
	private String dBusername;
	private String dBpassword;
    
	
	public DAOHelper()
	{
		dBInfo = new DBInfo();
		
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			dBurl = dBInfo.getUrl();
	        dBusername = dBInfo.getUsername();
	        dBpassword = dBInfo.getPassword();
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void OpenConnection()
	{
		dBInfo = new DBInfo();
		
		try
		{
			connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void CloseConnection()
	{
		try
		{
			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
}
