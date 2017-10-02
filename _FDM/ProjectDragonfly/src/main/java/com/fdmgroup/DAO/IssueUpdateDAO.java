package com.fdmgroup.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.IssueUpdate;
import com.fdmgroup.Entity.User;

import oracle.jdbc.OracleTypes;

public class IssueUpdateDAO 
{
	private DBInfo dBInfo;
	private Connection connection;
	private CallableStatement callableStatement;
	
	
	public IssueUpdateDAO ()
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

	public void addIssueUpdate(IssueUpdate newIssueUpdate) 
	{
		int issueId = newIssueUpdate.getIssueId();
		int submittedBy = newIssueUpdate.getSubmittedBy();
		Date updateDate = newIssueUpdate.getUpdateDate();
		String updateComment = newIssueUpdate.getUpdateComment();
		
		String query = "{call ADD_ISSUEUPDATE( ?, ?, ?, ? )}";
		
	    try
	    {
	        String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, issueId);
	        callableStatement.setInt(2, submittedBy);
	        callableStatement.setDate(3, updateDate);
	        callableStatement.setString(4, updateComment);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
			e.printStackTrace();
	    }
		
	}

	public IssueUpdate getIssueUpdateById(int targetId) 
	{
		IssueUpdate result = null;
	    ResultSet resultSet;
	    String query = "{call GET_ISSUEUPDATE_BY_ID( ?,?,?,?,?,?,? )}";
		
	    try
	    {
	    	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	         
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //issueUpdateId number
	        callableStatement.registerOutParameter(3, java.sql.Types.NUMERIC); //issueId number
	        callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC); //SubmittedBy number
	        callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR); //SubmittedBy username
	        callableStatement.registerOutParameter(6, java.sql.Types.DATE); //UpdateDate Date
	        callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR); //UpdateComment String
	        
	        callableStatement.execute();
	        
	        int issueUpdateId;
	        int issueId;
	        int submittedBy;
	        String submittedByUsername;
	        Date updateDate = null;
	        String updateComment;
	        
	        issueUpdateId = callableStatement.getInt(2);
	        issueId = callableStatement.getInt(3);
	        submittedBy = callableStatement.getInt(4);
	        submittedByUsername = callableStatement.getString(5);
	        
	        Timestamp timestamp = callableStatement.getTimestamp(6);
	        if (timestamp != null)
	        	updateDate = new java.sql.Date(timestamp.getTime());
	            
	        updateComment = callableStatement.getString(7);
	        
            result = new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment);
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return result;
	}

	public List<IssueUpdate> getIssueUpdates() 
	{
		List<IssueUpdate> result = new ArrayList<IssueUpdate>();
	    ResultSet resultSet;
	    String query = "{call GET_ISSUEUPDATES( ? )}";
	    int issueUpdateId;
	    int issueId;
        int submittedBy;
        String submittedByUsername;
        Date updateDate;
        String updateComment;
        
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
	        	issueUpdateId = resultSet.getInt(1);
	        	issueId = resultSet.getInt(2);
	            submittedBy = resultSet.getInt(3);
	            submittedByUsername = resultSet.getString(4);
		        updateDate = resultSet.getDate(5);
	            updateComment = resultSet.getString(6);
	            
	            result.add( new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public List<IssueUpdate> getIssueUpdatesByIssueId(int targetId) 
	{
		List<IssueUpdate> result = new ArrayList<IssueUpdate>();
	    ResultSet resultSet;
	    String query = "{call GET_ISSUEUPDATES_BY_ISSUEID( ?, ? )}";
	    int issueUpdateId;
	    int issueId;
        int submittedBy;
        String submittedByUsername;
        Date updateDate;
        String updateComment;
        
        try
	    {
        	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
	        
	        callableStatement.execute();
	        
	        resultSet = (ResultSet) callableStatement.getObject(2);
	        
	        while( resultSet.next() )
	        {
	        	issueUpdateId = resultSet.getInt(1);
	        	issueId = resultSet.getInt(2);
	            submittedBy = resultSet.getInt(3);
	            submittedByUsername = resultSet.getString(4);
		        updateDate = resultSet.getDate(5);
	            updateComment = resultSet.getString(6);
	            
	            result.add( new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	
	public void updateIssueUpdate(IssueUpdate newIssueUpdate)
	{
		int issueUpdateId = newIssueUpdate.getIssueUpdateId();
		int issueId = newIssueUpdate.getIssueId();
		int submittedBy = newIssueUpdate.getSubmittedBy();
		Date updateDate = newIssueUpdate.getUpdateDate();
		String updateComment = newIssueUpdate.getUpdateComment();
		
		String query = "{call UPDATE_ISSUEUPDATE ( ?, ?, ?, ?, ? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.setInt(1, issueUpdateId);
	        callableStatement.setInt(2, issueId);
	        callableStatement.setInt(3, submittedBy);
	        callableStatement.setDate(4, (java.sql.Date) updateDate);
	        callableStatement.setString(5, updateComment);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void removeIssueUpdate(int targetId) 
	{
		String query = "{call REMOVE_ISSUEUPDATE( ? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.setInt(1, targetId);
	        
	        callableStatement.execute();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}

	public void removeIssueUpdateByIssueId(int targetId) 
	{
		String query = "{call REMOVE_ISSUEUPDATE_BY_ISSUEID( ? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
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
