package com.fdmgroup.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.User;

import oracle.jdbc.OracleTypes;

import com.fdmgroup.Entity.Role;

public class RoleDAO 
{
	private DBInfo dBInfo;
	private Connection connection;
	private CallableStatement callableStatement;
	
	
	public RoleDAO ()
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

	public void addRole(Role newRole) 
	{
		int roleId = newRole.getRoleId();
		String roleName = newRole.getRoleName();
		
		String query = "{call ADD_ROLE( ? )}";
		
	    try
	    {
	        String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setString(1, roleName);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
			e.printStackTrace();
	    }
		
	}

	public Role getRoleById(int targetId) 
	{
		Role result = null;
	    ResultSet resultSet;
	    String query = "{call GET_ROLE_BY_ID( ?, ?, ? )}";
		
	    try
	    {
	    	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //roleId number
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); //roleName varchar
	        
	        callableStatement.execute();
	        
	        int roleid;
	        String roleName;
	        
	        roleid = callableStatement.getInt(2);
	        roleName = callableStatement.getString(3);
	        
            result = new Role(roleid, roleName);
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return result;
	}
	
	public List<Role> getRolesByUserID(int userID)
	{
		ResultSet resultSet;
		List<Role> result = new ArrayList<Role>();
	    String query = "{call GET_ROLES_BY_USERID( ?, ?)}";
	    int roleId;
        String roleName;
	    try
	    {
        	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, userID);
	        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
	        
	        callableStatement.execute();
	        
	        resultSet = (ResultSet) callableStatement.getObject(2);
	        
	        while( resultSet.next() )
	        {
	        	roleId = resultSet.getInt(1);
	        	roleName = resultSet.getString(2);
	            
	            result.add( new Role(roleId, roleName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
		
	}

	public List<Role> getRoles() 
	{
		List<Role> result = new ArrayList<Role>();
		ResultSet resultSet;
	    String query = "{call GET_ROLES( ? )}";
	    
	    int roleId;
        String roleName;
	    
        try
	    {
        	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
	        
	        callableStatement.execute();
	        
	        resultSet = (ResultSet) callableStatement.getObject(1);
	        
	        while( resultSet.next() )
	        {
	        	roleId = resultSet.getInt(1);
	        	roleName = resultSet.getString(2);
	            
	            result.add( new Role(roleId, roleName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public void updateRole(Role newRole)
	{
		int roleId = newRole.getRoleId();
		String roleName = newRole.getRoleName();
		
		String query = "{call UPDATE_ROLE ( ?, ? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, roleId);
	        callableStatement.setString(2, roleName);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void removeRole(int targetId) 
	{
		String query = "{call REMOVE_ROLE( ? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, targetId);
	        
	        callableStatement.execute();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}

	
	
}
