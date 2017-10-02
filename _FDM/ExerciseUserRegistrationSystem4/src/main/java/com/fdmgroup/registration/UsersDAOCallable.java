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

public class UsersDAOCallable implements Users
{
	private DBInfo dBInfo;
	//private DriverManager driverManager;
	private Connection connection;
	private Statement statement;
	private CallableStatement callableStatement;
	private EntityManagerFactory entityManagerFactory;
	
	public UsersDAOCallable()
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
	
	public void addUser(User user) 
	{
		String uname = user.getUsername();
		String passcode = user.getPassword();
		String role = user.getRole();
		
		String query = "{call ADD_USER( ?, ?, ? )}";
		
	    try
	    {
	        String url = dBInfo.getUrl();
	        String dbUname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, dbUname, pword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        //resultSet = statement.executeQuery(query);
	        
	        callableStatement.setString(1, uname);
	        callableStatement.setString(2, passcode);
	        callableStatement.setString(3, role);
	        
	        callableStatement.executeUpdate();
	        
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
		User result = null;
	    ResultSet resultSet;
	    String query = "{call GET_USER( ? )}";
		
	    try
	    {
	        String url = dBInfo.getUrl();
	        String uname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, uname, pword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        //resultSet = statement.executeQuery(query);
	        
	        callableStatement.setString(1, p_username);
	        
	        callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
	        
	        resultSet = callableStatement.executeQuery();//callableStatement.getResultSet();
	        
	        String username = null;
	        String passcode = null;
	        String role = null;
	        
	        username = resultSet.getString(1);
            passcode = resultSet.getString(2);
            role = resultSet.getString(3);
            
            result = new User(username, passcode, role);
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
	
	public List<User> listUsers() 
	{
		List<User> result = null;
	    ResultSet resultSet;
	    String query = "{call GET_USERS()}";
		String username = null;
        String passcode = null;
        String role = null;
	        
	    try
	    {
	        String url = dBInfo.getUrl();
	        String uname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, uname, pword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);
//	        callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
//	        callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
//	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
	        
	        resultSet = (ResultSet) callableStatement.getObject(1);//getResultSet();
	        
	        while( resultSet.next() )
	        {
	        	username = resultSet.getString(1);
	            passcode = resultSet.getString(2);
	            role = resultSet.getString(3);
	            
	            result.add( new User(username, passcode, role) );
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
	
	public void updateUser(User user) 
	{
		String uname = user.getUsername();
		String passcode = user.getPassword();
		String role = user.getRole();
		
		String query = "{call UPDATE_USER ( ?, ?, ? )}";
		
		try
	    {
	        String url = dBInfo.getUrl();
	        String dbUname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, dbUname, pword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        //resultSet = statement.executeQuery(query);
	        
	        callableStatement.setString(1, uname);
	        callableStatement.setString(2, passcode);
	        callableStatement.setString(3, role);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	LoggingObject.log("info: [DID NOT] execute query: " + query + ": .", 2);
			e.printStackTrace();
	    }
		
		LoggingObject.log("info: executed query: " + query + ".", 2);
	}
	
	public void removeUser(String p_username) 
	{
		String query = "{call REMOVE_USER( ? )}";
				
		try
	    {
	        String url = dBInfo.getUrl();
	        String dbUname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, dbUname, pword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        //resultSet = statement.executeQuery(query);
	        
	        callableStatement.setString(1, p_username);
	        
	        callableStatement.execute();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	LoggingObject.log("info: [DID NOT] execute query: " + query + ": .", 2);
			e.printStackTrace();
	    }
		
		LoggingObject.log("info: executed query: " + query + ".", 2);
	}
}
