package com.fdmgroup;

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

import oracle.jdbc.OracleTypes;

public class UsersDAO implements Users
{
	DBInfo dBInfo;
	//DriverManager driverManager;
	Connection connection;
	Statement statement;
	CallableStatement callableStatement;

	public UsersDAO()
	{
		dBInfo = new DBInfo();
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}
		catch(SQLException e)
		{
			System.out.println("DriverManager.registerDriver failed");
		}
	}
	
	
	public boolean stmtExecute(String query)
	{
		//query = addCommit(query);
		boolean result = false;
		
		try
		{
			connection = DriverManager.getConnection(dBInfo.getUrl(), dBInfo.getUsername(), dBInfo.getPassword());
		}
		catch(SQLException e)
		{
			System.out.println("DriverManager.getConnection failed");
		}
		try
		{
			statement = connection.createStatement();
		}
		catch(SQLException e)
		{
			System.out.println("DriverManager.getConnection failed");
		}
		try
		{
			statement.execute(query);
		}
		catch(SQLException e)
		{
			System.out.println("stmtExecute failed");
		}
		try
		{
			connection.close();
		}
		catch(SQLException e)
		{
			System.out.println("Close connection failed");
		}

		return result;
	}
	
	public boolean stmtExecuteUpdate(String query)
	{
		//query = addCommit(query);
		boolean result = false;
		
		try
		{
			connection = DriverManager.getConnection(dBInfo.getUrl(), dBInfo.getUsername(), dBInfo.getPassword());
		}
		catch(SQLException e)
		{
			System.out.println("DriverManager.getConnection failed");
		}
		try
		{
			statement = connection.createStatement();
		}
		catch(SQLException e)
		{
			System.out.println("DriverManager.getConnection failed");
		}
		try
		{
			statement.executeUpdate(query);
		}
		catch(SQLException e)
		{
			System.out.println("stmtExecuteUpdate failed");
		}
		try
		{
			connection.close();
		}
		catch(SQLException e)
		{
			System.out.println("Close connection failed");
		}

		return result;
	}
	
	public List<User> stmtExecuteQuery(String query)
	{
		//query = addCommit(query);
		
		ArrayList<User> result = new ArrayList<User>();
		ResultSet resultSet;
		
		try
		{
			String url = dBInfo.getUrl();
			String uname = dBInfo.getUsername();
			String pword = dBInfo.getPassword();
			
			connection = DriverManager.getConnection(url, uname, pword);
		}
		catch(SQLException e)
		{
			System.out.println("DriverManager.getConnection failed");
			
		}
		try
		{
			statement = connection.createStatement();
		}
		catch(SQLException e)
		{
			System.out.println("connection.createStatement failed");
			
		}
		try
		{
			resultSet = statement.executeQuery(query);
			
			Integer uid = null;
			String uname = null;
			String passcode = null;
			String fname = null;
			String lname = null;
			String email = null;
			String role = null;
			String status = null;			
			
			while( resultSet.next() )
			{
				uid = resultSet.getInt("USER_ID"); 
				uname = resultSet.getString("username");
				passcode = resultSet.getString("pword");
				fname = resultSet.getString("firstName");
				lname = resultSet.getString("lastName");
				email = resultSet.getString("email");
				role = resultSet.getString("prole");
				status = resultSet.getString("status");
				
				User newUser = new User(uid, uname, passcode, fname, lname, email,	role, status);
				
				result.add(newUser);
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			connection.close();
		}
		catch(SQLException e)
		{
			System.out.println("Close connection failed");
		}

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
	    
	    //String query = "{select GET_USERS_FUNCTION() from dual}";
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
	        
	        Integer uid = null;
	        String username = null;
	        String passcode = null;
	        String fname = null;
	        String lname = null;
	        String email = null;
	        String role = null;
	        String status = null;			
	        
	        while( resultSet.next() )
	        {
	            uid = resultSet.getInt("USER_ID"); 
	            username = resultSet.getString("username");
	            passcode = resultSet.getString("pword");
	            fname = resultSet.getString("firstName");
	            lname = resultSet.getString("lastName");
	            email = resultSet.getString("email");
	            role = resultSet.getString("prole");
	            status = resultSet.getString("status");
	            
	            User newUser = new User(uid, username, passcode, fname, lname, email,	role, status);
	            
	            result.add(newUser);
	            
	        }
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    
	    return result;
	}
	
	public User getUser(String p_username) 
	{
		String query = "SELECT * FROM USERS WHERE USERNAME = '" + p_username + "'";
		
		return stmtExecuteQuery(query).get(0);
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
	        
	        Integer uid = null;
	        String username = null;
	        String passcode = null;
	        String fname = null;
	        String lname = null;
	        String email = null;
	        String role = null;
	        String status = null;			
	        
	        uid = resultSet.getInt(1);//"USER_ID"); 
            username = resultSet.getString(2);//"username");
            passcode = resultSet.getString(3);//"pword");
            fname = resultSet.getString(4);//"firstName");
            lname = resultSet.getString(5);//"lastName");
            email = resultSet.getString(6);//"email");
            role = resultSet.getString(7);//"prole");
            status = resultSet.getString(8);//"status");
            
            result = new User(uid, username, passcode, fname, lname, email,	role, status);
            connection.close();
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    
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
	        e.printStackTrace();
	    }
	}
	
	public void addUser(User user) 
	{
		Integer uid = user.getUser_id();
		String uname = user.getUsername();
		String passcode = user.getPword();
		String fname = user.getFirstName();
		String lname = user.getLastName();
		String email = user.getEmail();
		String role = user.getProle();
		String status = user.getStatus();			
		
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
	        e.printStackTrace();
	    }
	}

	public void updateUser(User user) 
	{
		Integer uid = user.getUser_id();
		String uname = user.getUsername();
		String passcode = user.getPword();
		String fname = user.getFirstName();
		String lname = user.getLastName();
		String email = user.getEmail();
		String role = user.getProle();
		String status = user.getStatus();			
		
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
	        e.printStackTrace();
	    }
	}
	
	public void updateUser2(User user) 
	{
		Integer uid = user.getUser_id();
		String uname = user.getUsername();
		String passcode = user.getPword();
		String fname = user.getFirstName();
		String lname = user.getLastName();
		String email = user.getEmail();
		String role = user.getProle();
		String status = user.getStatus();			
		
		String query = "UPDATE_USER ("+uid+", '" +
				uname+"', '" +
				passcode+"', '" +
				fname+"', '" +
				lname+"', '" +
				email+"', '" +
				role+"', '" +
				status+"'); ";
		
		stmtExecuteUpdate( query );
	}
	
	private String addCommit(String query)
	{
		 return query += " Commit;";
	}


	
}
