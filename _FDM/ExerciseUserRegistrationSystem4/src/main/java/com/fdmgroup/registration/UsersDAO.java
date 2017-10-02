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

public class UsersDAO implements Users
{
	private DBInfo dBInfo;
	//private DriverManager driverManager;
	private Connection connection;
	private Statement statement;
	private CallableStatement callableStatement;
	private EntityManagerFactory entityManagerFactory;
	
	public UsersDAO()
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
	
	public void create(User user)
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			entityManager.getTransaction().begin();
			
			entityManager.persist(user);
					
			entityManager.getTransaction().commit();
			
		entityManager.close();
	}
	
	public User read(String username)
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			User user = null;
			
			user = entityManager.find(User.class, username);
			
		entityManager.close();
		return user;
	}
	
	public void update(User user) 
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			User newUser = entityManager.find(User.class, user.getUsername());
			
			entityManager.getTransaction().begin();
			
			user.setUsername(user.getUsername());
			user.setPassword(user.getPassword());
			user.setRole(user.getRole());
			
			entityManager.getTransaction().commit();
			
		entityManager.close();
	}

	public void delete(String username) 
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			User newUser = null;
			
			try
			{
				newUser = entityManager.find(User.class, username);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			if(newUser != null)
			{
				entityManager.getTransaction().begin();
				
				entityManager.remove(newUser);
				
				entityManager.getTransaction().commit();
			}
		
		entityManager.close();
	}

	public List<User> readAll() 
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
			
			List<User> userList = new ArrayList<User>();
			
			Query query = entityManager.createQuery("SELECT * FROM USERS");
			userList = query.getResultList();
			
		entityManager.close();
		return userList;
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

	public List<User> listUsers() 
	{
		String query = "SELECT * from USERS";
		
		return stmtExecuteQuery(query);
	}
	
	public List<User> listUsers2() 
	{
		ArrayList<User> result = new ArrayList<User>();
	    ResultSet resultSet;
	    
	    String query = "{call GET_USERS()}";
	    
	    try
	    {
	        String url = dBInfo.getUrl();
	        String uname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, uname, pword);
	    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        //resultSet = statement.executeQuery(query);
	        
	        callableStatement.registerOutParameter(1, Types.REF_CURSOR);
	        
	        
	        resultSet = callableStatement.executeQuery();//callableStatement.getResultSet();
	        
	        String username = null;
	        String passcode = null;
	        String role = null;
	        
	        while( resultSet.next() )
	        {
	            username = resultSet.getString("username");
	            passcode = resultSet.getString("pword");
	            role = resultSet.getString("prole");
	            
	            User newUser = new User(username, passcode, role);
	            
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
	
	public User getUser2(String p_username) 
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
	        
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC);
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
	        callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);
	        
	        
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

	public void removeUser2(String username) 
	{
		String query = "REMOVE_USER (" + username + ")";
				
		stmtExecuteUpdate( query );
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
	
	public void addUser(User user) 
	{
		Integer uid = -1;//user.getUser_id();
		String uname = user.getUsername();
		String passcode = user.getPassword();
		String fname = "";//user.getFirstName();
		String lname = "";//user.getLastName();
		String email = "";//user.getEmail();
		String role = user.getRole();
		String status = "";//user.getStatus();			
		
		String query = "{call ADD_USER( ?, ?, ?, ?, ?, ?, ?, ? )}";
		
	    try
	    {
	        String url = dBInfo.getUrl();
	        String dbUname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, dbUname, pword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        //resultSet = statement.executeQuery(query);
	        
	        callableStatement.setInt(1, uid);
	        callableStatement.setString(2, uname);
	        callableStatement.setString(3, passcode);
	        callableStatement.setString(4, fname);
	        callableStatement.setString(5, lname);
	        callableStatement.setString(6, email);
	        callableStatement.setString(7, role);
	        callableStatement.setString(8, status);
	        
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

	public void updateUser(User user) 
	{
		Integer uid = -1;//user.getUser_id();
		String uname = user.getUsername();
		String passcode = user.getPassword();
		String fname = "";//user.getFirstName();
		String lname = "";//user.getLastName();
		String email = "";//user.getEmail();
		String role = user.getRole();
		String status = "";//user.getStatus();			
		
		String query = "{call UPDATE_USER ( ?, ?, ?, ?, ?, ?, ?, ? )}";
		
		try
	    {
	        String url = dBInfo.getUrl();
	        String dbUname = dBInfo.getUsername();
	        String pword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(url, dbUname, pword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        //resultSet = statement.executeQuery(query);
	        
	        callableStatement.setInt(1, uid);
	        callableStatement.setString(2, uname);
	        callableStatement.setString(3, passcode);
	        callableStatement.setString(4, fname);
	        callableStatement.setString(5, lname);
	        callableStatement.setString(6, email);
	        callableStatement.setString(7, role);
	        callableStatement.setString(8, status);
	        
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
	
	public void updateUser2(User user) 
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
	
	private void Commit()
	{
		 String query = " Commit;";
		 stmtExecute( query );
	}
}
