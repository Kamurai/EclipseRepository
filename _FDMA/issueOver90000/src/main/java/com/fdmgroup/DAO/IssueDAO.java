package com.fdmgroup.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.IssueUpdate;

import oracle.jdbc.OracleTypes;

public class IssueDAO 
{
	private DBInfo dBInfo;
	private Connection connection;
	private CallableStatement callableStatement;
	
	
	public IssueDAO ()
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
	
	public void addIssue(Issue newIssue) 
	{
		String title = newIssue.getTitle();
		String userDescription = newIssue.getUserDescription();
		int submittedBy = newIssue.getSubmittedBy();
		int statusId = newIssue.getStatusId();
		int priority = newIssue.getPriority();
		Date dateSubmitted = newIssue.getDateSubmitted();
		int deptId = newIssue.getDeptId();
		
		String query = "{call ADD_ISSUE( ?,?,?,?,?,?,? )}";
		
	    try
	    {
	        String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.setString(1, title);
	        callableStatement.setString(2, userDescription);
	        if( submittedBy == -1)
	        	callableStatement.setNull(3, java.sql.Types.NUMERIC);
	        else
	        	callableStatement.setInt(3, submittedBy);
			if( statusId == -1)
				callableStatement.setNull(4, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(4, statusId);
			if( priority == -1)
				callableStatement.setNull(5, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(5, priority);
	        callableStatement.setDate(6, dateSubmitted);
	        if( deptId == -1)
	        	callableStatement.setNull(7, java.sql.Types.NUMERIC);
	        else
	        	callableStatement.setInt(7, deptId);
			
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
			e.printStackTrace();
	    }
		
	}
	public Issue getIssueByTitle(String targetTitle) 
	{
		Issue result = null;
	    ResultSet resultSet;
	    String query = "{call GET_ISSUE_BY_TITLE( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )}";
		
	    try
	    {
	    	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); 
	        
	        callableStatement.setString(1, targetTitle);
	        
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //issueId number
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); //Title varchar
	        callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR); //UserDescription varchar
	        callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR); //AdminComment varchar
	        callableStatement.registerOutParameter(6, java.sql.Types.NUMERIC); //AssignedTo number
	        callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR); //AssignedUsername varchar
	        callableStatement.registerOutParameter(8, java.sql.Types.NUMERIC); //SubmittedBy number
	        callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR); //SubmittedByUsername varchar
	        callableStatement.registerOutParameter(10, java.sql.Types.NUMERIC); //StatusId number
	        callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR); //Status varchar
	        callableStatement.registerOutParameter(12, java.sql.Types.NUMERIC); //Priority number
	        callableStatement.registerOutParameter(13, java.sql.Types.DATE); //DateSubmitted date
	        callableStatement.registerOutParameter(14, java.sql.Types.DATE); //DateResolved date
	        callableStatement.registerOutParameter(15, java.sql.Types.NUMERIC); //DeptId number
	        callableStatement.registerOutParameter(16, java.sql.Types.VARCHAR); //DeptName varchar
	        
	        callableStatement.executeQuery();
	        
	        int issueId;
	        String title;
	        String userDescription;
	        String adminComment;
	        int assignedTo;
	        String assignedToUsername;
	        int submittedBy;
	        String submittedByUsername;
	        int statusId;
	        String status;
	        int priority;
	        Date dateSubmitted = null;
	        Date dateResolved = null;
	        int deptId;
	        String deptName;
	        
	        issueId = callableStatement.getInt(2);
	        if( callableStatement.wasNull() )
			{
	        	issueId = -1;
			}
			title = callableStatement.getString(3);
	        userDescription = callableStatement.getString(4);
	        adminComment = callableStatement.getString(5);
	        assignedTo = callableStatement.getInt(6);
	        if( callableStatement.wasNull() )
			{
	        	assignedTo = -1;
			}
			assignedToUsername = callableStatement.getString(7);
	        submittedBy = callableStatement.getInt(8);
	        if( callableStatement.wasNull() )
			{
				submittedBy = -1;
			}
			submittedByUsername = callableStatement.getString(9);
	        statusId = callableStatement.getInt(10);
	        if( callableStatement.wasNull() )
			{
				statusId = -1;
			}
			status = callableStatement.getString(11);
	        priority = callableStatement.getInt(12);
	        if( callableStatement.wasNull() )
			{
				priority = -1;
			}
			Timestamp timestamp = callableStatement.getTimestamp(13);
	        if (timestamp != null)
	        	dateSubmitted = new Date(timestamp.getTime());
	        
	        timestamp = callableStatement.getTimestamp(14);
	        if (timestamp != null)
	        	dateResolved = new Date(timestamp.getTime());
	        
            
            List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
	        
	        IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
	        
	        issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueId);

	        deptId = callableStatement.getInt(15);
	        if( callableStatement.wasNull() )
			{
	        	deptId = -1;
			}
			deptName = callableStatement.getString(16);
	        
            result = new Issue(issueId, title, userDescription, adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, statusId, status, priority, dateSubmitted, dateResolved, issueUpdateList, deptId, deptName);
            
            connection.close();            
        }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return result;
	}
	
	public Issue getIssueById(int targetId) 
	{
		Issue result = null;
	    ResultSet resultSet;
	    String query = "{call GET_ISSUE_BY_ID( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )}";
		
	    try
	    {
	    	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	         
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //issueId number
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); //Title varchar
	        callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR); //UserDescription varchar
	        callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR); //AdminComment varchar
	        callableStatement.registerOutParameter(6, java.sql.Types.NUMERIC); //AssignedTo number
	        callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR); //AssignedUsername varchar
	        callableStatement.registerOutParameter(8, java.sql.Types.NUMERIC); //SubmittedBy number
	        callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR); //SubmittedByUsername varchar
	        callableStatement.registerOutParameter(10, java.sql.Types.NUMERIC); //StatusId number
	        callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR); //Status varchar
	        callableStatement.registerOutParameter(12, java.sql.Types.NUMERIC); //Priority number
	        callableStatement.registerOutParameter(13, java.sql.Types.DATE); //DateSubmitted date
	        callableStatement.registerOutParameter(14, java.sql.Types.DATE); //DateResolved date
	        callableStatement.registerOutParameter(15, java.sql.Types.NUMERIC); //DeptId number
	        callableStatement.registerOutParameter(16, java.sql.Types.VARCHAR); //DeptName varchar
	        
	        callableStatement.execute();
	        
	        int issueId;
	        String title;
	        String userDescription;
	        String adminComment;
	        int assignedTo;
	        String assignedToUsername;
	        int submittedBy;
	        String submittedByUsername;
	        int statusId;
	        String status;
	        int priority;
	        Date dateSubmitted = null;
	        Date dateResolved = null;
	        int deptId;
	        String deptName;
	        
	        issueId = callableStatement.getInt(2);
	        if( callableStatement.wasNull() )
			{
	        	issueId = -1;
			}
			title = callableStatement.getString(3);
	        userDescription = callableStatement.getString(4);
	        adminComment = callableStatement.getString(5);
	        assignedTo = callableStatement.getInt(6);
	        if( callableStatement.wasNull() )
			{
	        	assignedTo = -1;
			}
			assignedToUsername = callableStatement.getString(7);
	        submittedBy = callableStatement.getInt(8);
	        if( callableStatement.wasNull() )
			{
				submittedBy = -1;
			}
			submittedByUsername = callableStatement.getString(9);
	        statusId = callableStatement.getInt(10);
	        if( callableStatement.wasNull() )
			{
				statusId = -1;
			}
			status = callableStatement.getString(11);
	        priority = callableStatement.getInt(12);
	        if( callableStatement.wasNull() )
			{
				priority = -1;
			}
			Timestamp timestamp = callableStatement.getTimestamp(13);
	        if (timestamp != null)
	        	dateSubmitted = new Date(timestamp.getTime());
	        
	        timestamp = callableStatement.getTimestamp(14);
	        if (timestamp != null)
	        	dateResolved = new Date(timestamp.getTime());
	        
	        
	        List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
	        
	        IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
	        
	        issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueId);

	        deptId = callableStatement.getInt(15);
	        if( callableStatement.wasNull() )
			{
	        	deptId = -1;
			}
			deptName = callableStatement.getString(16);
	        
            result = new Issue(issueId, title, userDescription, adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, statusId, status, priority, dateSubmitted, dateResolved, issueUpdateList, deptId, deptName);
            
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return result;
	}

	public List<Issue> getIssues() 
	{
		List<Issue> result = new ArrayList<Issue>();
	    ResultSet resultSet;
	    String query = "{call GET_ISSUES(?)}";
	    int issueId;
        String title;
        String userDescription;
        String adminComment;
        int assignedTo;
        String assignedToUsername;
        int submittedBy;
        String submittedByUsername;
        int statusId;
        String status;
        int priority;
        Date dateSubmitted = null;
        Date dateResolved = null;
        List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
        int deptId;
        String deptName;
        
        IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
        
        try
	    {
        	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
	        
	        callableStatement.execute();
	        
	        resultSet = (ResultSet) callableStatement.getObject(1);
	        
	        while( resultSet.next() )
	        {
	        	issueId = resultSet.getInt(1);
	        	if( resultSet.wasNull() )
				{
	        		issueId = -1;
				}
				title = resultSet.getString(2);
	            userDescription = resultSet.getString(3);
	            adminComment = resultSet.getString(4);
	            assignedTo = resultSet.getInt(5);
	            if( resultSet.wasNull() )
				{
	            	assignedTo = -1;
				}
				assignedToUsername = resultSet.getString(6);
	            submittedBy = resultSet.getInt(7);
	            if( resultSet.wasNull() )
				{
					submittedBy = -1;
				}
				submittedByUsername = resultSet.getString(8);
	            statusId = resultSet.getInt(9);
	            if( resultSet.wasNull() )
				{
					statusId = -1;
				}
				status = resultSet.getString(10);
	            priority = resultSet.getInt(11);
	            if( resultSet.wasNull() )
				{
					priority = -1;
				}
				Timestamp timestamp = resultSet.getTimestamp(12);
		        if (timestamp != null)
		        	dateSubmitted = new Date(timestamp.getTime());
		        
		        timestamp = resultSet.getTimestamp(13);
		        if (timestamp != null)
		        	dateResolved = new Date(timestamp.getTime());
		        
		        issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueId);

		        deptId = resultSet.getInt(14);
		        if( resultSet.wasNull() )
				{
		        	deptId = -1;
				}
				deptName = resultSet.getString(15);
		        
		        result.add( new Issue(issueId, title, userDescription, adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, statusId, status, priority, dateSubmitted, dateResolved, issueUpdateList, deptId, deptName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public List<Issue> getIssuesBySubmittedBy(int targetId)
	{
		List<Issue> result = new ArrayList<Issue>();
	    ResultSet resultSet;
	    String query = "{call GET_ISSUES_BY_SUBMITTEDBY( ?,? )}";
	    int issueId;
        String title;
        String userDescription;
        String adminComment;
        int assignedTo;
        String assignedToUsername;
        int submittedBy;
        String submittedByUsername;
        int statusId;
        String status;
        int priority;
        Date dateSubmitted = null;
        Date dateResolved = null;
        List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
        int deptId;
        String deptName;
        
        IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
        
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
	        	issueId = resultSet.getInt(1);
	        	if( resultSet.wasNull() )
				{
	        		issueId = -1;
				}
				title = resultSet.getString(2);
	            userDescription = resultSet.getString(3);
	            adminComment = resultSet.getString(4);
	            assignedTo = resultSet.getInt(5);
	            if( resultSet.wasNull() )
				{
	            	assignedTo = -1;
				}
				assignedToUsername = resultSet.getString(6);
	            submittedBy = resultSet.getInt(7);
	            if( resultSet.wasNull() )
				{
					submittedBy = -1;
				}
				submittedByUsername = resultSet.getString(8);
	            statusId = resultSet.getInt(9);
	            if( resultSet.wasNull() )
				{
					statusId = -1;
				}
				status = resultSet.getString(10);
	            priority = resultSet.getInt(11);
	            if( resultSet.wasNull() )
				{
					priority = -1;
				}
				Timestamp timestamp = resultSet.getTimestamp(12);
		        if (timestamp != null)
		        	dateSubmitted = new Date(timestamp.getTime());
		        
		        timestamp = resultSet.getTimestamp(13);
		        if (timestamp != null)
		        	dateResolved = new Date(timestamp.getTime());
		        
		        issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueId);

		        deptId = resultSet.getInt(14);
		        if( resultSet.wasNull() )
				{
		        	deptId = -1;
				}
				deptName = resultSet.getString(15);
		        
		        result.add( new Issue(issueId, title, userDescription, adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, statusId, status, priority, dateSubmitted, dateResolved, issueUpdateList, deptId, deptName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public List<Issue> getIssuesByAssignedTo(int targetId)
	{
		List<Issue> result = new ArrayList<Issue>();
	    ResultSet resultSet;
	    String query = "{call GET_ISSUES_BY_ASSIGNEDTO( ?,? )}";
	    int issueId;
        String title;
        String userDescription;
        String adminComment;
        int assignedTo;
        String assignedToUsername;
        int submittedBy;
        String submittedByUsername;
        int statusId;
        String status;
        int priority;
        Date dateSubmitted = null;
        Date dateResolved = null;
        List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
        int deptId;
        String deptName;
        
        IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
        
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
	        	issueId = resultSet.getInt(1);
	        	if( resultSet.wasNull() )
				{
	        		issueId = -1;
				}
				title = resultSet.getString(2);
	            userDescription = resultSet.getString(3);
	            adminComment = resultSet.getString(4);
	            assignedTo = resultSet.getInt(5);
	            if( resultSet.wasNull() )
				{
	            	assignedTo = -1;
				}
				assignedToUsername = resultSet.getString(6);
	            submittedBy = resultSet.getInt(7);
	            if( resultSet.wasNull() )
				{
					submittedBy = -1;
				}
				submittedByUsername = resultSet.getString(8);
	            statusId = resultSet.getInt(9);
	            if( resultSet.wasNull() )
				{
					statusId = -1;
				}
				status = resultSet.getString(10);
	            priority = resultSet.getInt(11);
	            if( resultSet.wasNull() )
				{
					priority = -1;
				}
				Timestamp timestamp = resultSet.getTimestamp(12);
		        if (timestamp != null)
		        	dateSubmitted = new Date(timestamp.getTime());
		        
		        timestamp = resultSet.getTimestamp(13);
		        if (timestamp != null)
		        	dateResolved = new Date(timestamp.getTime());
		        
		        issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueId);

		        deptId = resultSet.getInt(14);
		        if( resultSet.wasNull() )
				{
		        	deptId = -1;
				}
				deptName = resultSet.getString(15);
		        
		        result.add( new Issue(issueId, title, userDescription, adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, statusId, status, priority, dateSubmitted, dateResolved, issueUpdateList, deptId, deptName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public List<Issue> getIssuesByUnassigned()
	{
		List<Issue> result = new ArrayList<Issue>();
	    ResultSet resultSet;
	    String query = "{call GET_ISSUES_UNASSIGNED(?)}";
	    int issueId;
        String title;
        String userDescription;
        String adminComment;
        int assignedTo;
        String assignedToUsername;
        int submittedBy;
        String submittedByUsername;
        int statusId;
        String status;
        int priority;
        Date dateSubmitted = null;
        Date dateResolved = null;
        List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
        int deptId;
        String deptName;
        
        IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
        
        try
	    {
        	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
	        
	        callableStatement.execute();
	        
	        resultSet = (ResultSet) callableStatement.getObject(1);
	        
	        while( resultSet.next() )
	        {
	        	issueId = resultSet.getInt(1);
	        	if( resultSet.wasNull() )
				{
	        		issueId = -1;
				}
				title = resultSet.getString(2);
	            userDescription = resultSet.getString(3);
	            adminComment = resultSet.getString(4);
	            assignedTo = resultSet.getInt(5);
	            if( resultSet.wasNull() )
				{
	            	assignedTo = -1;
				}
				assignedToUsername = resultSet.getString(6);
	            submittedBy = resultSet.getInt(7);
	            if( resultSet.wasNull() )
				{
					submittedBy = -1;
				}
				submittedByUsername = resultSet.getString(8);
	            statusId = resultSet.getInt(9);
	            if( resultSet.wasNull() )
				{
					statusId = -1;
				}
				status = resultSet.getString(10);
	            priority = resultSet.getInt(11);
	            if( resultSet.wasNull() )
				{
					priority = -1;
				}
				Timestamp timestamp = resultSet.getTimestamp(12);
		        if (timestamp != null)
		        	dateSubmitted = new Date(timestamp.getTime());
		        
		        timestamp = resultSet.getTimestamp(13);
		        if (timestamp != null)
		        	dateResolved = new Date(timestamp.getTime());
		        
		        issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueId);

		        deptId = resultSet.getInt(14);
		        if( resultSet.wasNull() )
				{
		        	deptId = -1;
				}
				deptName = resultSet.getString(15);
		        
		        result.add( new Issue(issueId, title, userDescription, adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, statusId, status, priority, dateSubmitted, dateResolved, issueUpdateList, deptId, deptName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public void updateIssue(Issue newIssue)
	{
		int issueId = newIssue.getIssueId();
		String title = newIssue.getTitle();
		String userDescription = newIssue.getUserDescription();
		String adminComment = newIssue.getAdminComment();
		int assignedTo = newIssue.getAssignedTo();
		int submittedBy = newIssue.getSubmittedBy();
		int statusId = newIssue.getStatusId();
		int priority = newIssue.getPriority();
		Date dateSubmitted = newIssue.getDateSubmitted();
		Date dateResolved = newIssue.getDateResolved();
		int deptId = newIssue.getDeptId();
		
		String query = "{call UPDATE_ISSUE ( ?,?,?,?,?,?,?,?,?,?,? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        if( issueId == -1)
				callableStatement.setNull(1, java.sql.Types.NUMERIC);
			else
	        	callableStatement.setInt(1, issueId);
	        callableStatement.setString(2, title);
	        callableStatement.setString(3, userDescription);
	        callableStatement.setString(4, adminComment);
	        if( assignedTo == -1)
				callableStatement.setNull(5, java.sql.Types.NUMERIC);
			else
	        	callableStatement.setInt(5, assignedTo);
	        if( submittedBy == -1)
	        	callableStatement.setNull(6, java.sql.Types.NUMERIC);
	        else
	        	callableStatement.setInt(6, submittedBy);
	        if( statusId == -1)
				callableStatement.setNull(7, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(7, statusId);
	        if( priority == -1)
				callableStatement.setNull(8, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(8, priority);
	        callableStatement.setDate(9, dateSubmitted);
	        callableStatement.setDate(10, dateResolved);
	        if( priority == -1)
				callableStatement.setNull(11, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(11, deptId);
	        
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void removeIssue(int targetId) 
	{
		String query = "{call REMOVE_ISSUE( ? )}";
		
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
