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

public class UsersDAOBasic //implements Users
{
	/*
	private DBInfo dBInfo;
	//private DriverManager driverManager;
	private Connection connection;
	private Statement statement;
	private CallableStatement callableStatement;
	private EntityManagerFactory entityManagerFactory;
	
	public UsersDAOBasic()
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
		entityManagerFactory = Persistence.createEntityManagerFactory("usersDAOEMFactory");
		
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
			LoggingObject.log("info: [DID NOT] execute query: " + query + ": .", 2);
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

	public void addUser(User user) 
	{
		String uname = user.getUsername();
		String passcode = user.getPassword();
		String role = user.getRole();
		ResultSet resultSet;
		
		String query = "call ADD_USER( '" + uname + "', '" + passcode + "', '" + role + ")";
		
	    try
	    {
	        String url = dBInfo.getUrl();
	        String dbUname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, dbUname, pword);
		    
	        statement.executeUpdate(query);
	        
	        connection.close();
	        
	    }
	    catch(SQLException e)
	    {
	    	LoggingObject.log("info: [DID NOT] execute query: " + query + ": .", 2);
			e.printStackTrace();
	    }	
	    
	    LoggingObject.log("info: executed query: " + query + ".", 2);		
	}
	
	public User getUser(String p_username) 
	{
		String query = "SELECT * FROM USERS WHERE USERNAME = '" + p_username + "'";
		List<User> resultList = stmtExecuteQuery(query);
		User result = null;
		
		if(resultList.size() != 0)
		{
			result = stmtExecuteQuery(query).get(0);
		}
		
		return result;
	}
	
	public List<User> listUsers() 
	{
		String query = "SELECT * from USERS";
		
		return stmtExecuteQuery(query);
	}
	
	public void updateUser(User user) 
	{
		String uname = user.getUsername();
		String passcode = user.getPassword();
		String role = user.getRole();
		
		String query = "UPDATE_USER (" +
				uname+"', '" +
				passcode+"', '" +
				role+"');";
		
		stmtExecuteUpdate( query );
	}
	
	public void removeUser(String username) 
	{
		String query = "REMOVE_USER (" + username + ")";
				
		stmtExecuteUpdate( query );
	}
	
	private void Commit()
	{
		 String query = " Commit;";
		 stmtExecute( query );
	}
	*/
}
