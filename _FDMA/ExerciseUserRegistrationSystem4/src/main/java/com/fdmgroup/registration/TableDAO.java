package com.fdmgroup.registration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oracle.jdbc.OracleTypes;

public class TableDAO
{
	private DBInfo dBInfo;
	//private DriverManager driverManager;
	private Connection connection;
	private Statement statement;
	
	public TableDAO()
	{
		dBInfo = new DBInfo();
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean stmtExecute(String query)
	{
		//query = addCommit(query);
		boolean result = false;
		
		try
		{
			connection = DriverManager.getConnection(dBInfo.getUrl(), dBInfo.getUsername(), dBInfo.getPassword());
			statement = connection.createStatement();
			statement.execute(query);
			connection.close();
		}
		catch(SQLException e)
		{
			LoggingObject.log("info: [DID NOT] execute query: " + query + ": ?.", 2);
			e.printStackTrace();
		}

		LoggingObject.log("info: executed query: " + query + ".", 2);
		return result;
	}
	
	public boolean stmtExecuteUpdate(String query)
	{
		//query = addCommit(query);
		boolean result = false;
		
		try
		{
			connection = DriverManager.getConnection(dBInfo.getUrl(), dBInfo.getUsername(), dBInfo.getPassword());
			statement = connection.createStatement();
			statement.executeUpdate(query);
			connection.close();
		}
		catch(SQLException e)
		{
			LoggingObject.log("info: [DID NOT] execute query: " + query + ": .", 2);
			e.printStackTrace();
		}

		LoggingObject.log("info: executed query: " + query + ".", 2);
		return result;
	}
	
	public List<User> stmtExecuteQuery(String query)
	{
		//query = addCommit(query);
		
		ArrayList<User> result = new ArrayList<User>();
		ResultSet resultSet;
		
		try
		{
			String dburl = dBInfo.getUrl();
			String dbuname = dBInfo.getUsername();
			String dbpword = dBInfo.getPassword();
			
			connection = DriverManager.getConnection(dburl, dbuname, dbpword);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			String uname = null;
			String passcode = null;
			String role = null;
			
			while( resultSet.next() )
			{
				uname = resultSet.getString("username");
				passcode = resultSet.getString("pword");
				role = resultSet.getString("prole");
				
				User newUser = new User(uname, passcode, role);
				
				result.add(newUser);
				
			}
			connection.close();
		}
		catch(SQLException e)
		{
			LoggingObject.log("info: [DID NOT] execute query: " + query + ": .", 2);
			e.printStackTrace();
		}

		LoggingObject.log("info: executed query: " + query + ".", 2);
		return result;
	}
}
