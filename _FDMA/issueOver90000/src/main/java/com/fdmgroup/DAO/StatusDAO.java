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
import com.fdmgroup.Entity.Status;

public class StatusDAO 
{
	private DBInfo dBInfo;
	private Connection connection;
	private CallableStatement callableStatement;
	
	
	public StatusDAO ()
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

	public void addStatus(Status newStatus) 
	{
		String statusName = newStatus.getStatusName();
		
		String query = "{call ADD_STATUS( ? )}";
		
	    try
	    {
	        String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setString(1, statusName);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
			e.printStackTrace();
	    }
		
	}

	public Status getStatusById(int targetId) 
	{
		Status result = null;
	    String query = "{call GET_STATUS_BY_ID( ?, ?, ? )}";
		
	    try
	    {
	    	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //statusId number
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); //roleName varchar
	        
	        callableStatement.execute();
	        
	        int statusId;
	        String statusName;
	        
	        statusId = callableStatement.getInt(2);
	        statusName = callableStatement.getString(3);
	        
            result = new Status(statusId, statusName);
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return result;
	}
	
	public List<Status> getStatuss() 
	{
		List<Status> result = new ArrayList<Status>();
		ResultSet resultSet;
	    String query = "{call GET_STATUSS( ? )}";
	    
	    int statusId;
        String statusName;
	    
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
	        	statusId = resultSet.getInt(1);
	        	statusName = resultSet.getString(2);
	            
	            result.add( new Status(statusId, statusName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public void updateStatus(Status newStatus)
	{
		int statusId = newStatus.getStatusId();
		String statusName = newStatus.getStatusName();
		
		String query = "{call UPDATE_STATUS ( ?, ? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, statusId);
	        callableStatement.setString(2, statusName);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void removeStatus(int targetId) 
	{
		String query = "{call REMOVE_STATUS( ? )}";
		
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
