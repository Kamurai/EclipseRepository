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

import com.fdmgroup.Entity.Department;

public class DepartmentDAO 
{
	private DBInfo dBInfo;
	private Connection connection;
	private CallableStatement callableStatement;
	
	
	public DepartmentDAO ()
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

	public void addDepartment(Department newDepartment) 
	{
		int deptId = newDepartment.getDeptId();
		String deptName = newDepartment.getDeptName();
		
		String query = "{call ADD_DEPARTMENT( ? )}";
		
	    try
	    {
	        String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setString(1, deptName);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
			e.printStackTrace();
	    }
		
	}

	public Department getDepartmentById(int targetId) 
	{
		Department result = null;
	    ResultSet resultSet;
	    String query = "{call GET_DEPARTMENT_BY_ID( ?, ?, ? )}";
		
	    try
	    {
	    	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //deptId number
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); //deptName varchar
	        
	        callableStatement.execute();
	        
	        int deptid;
	        String deptName;
	        
	        deptid = callableStatement.getInt(2);
	        deptName = callableStatement.getString(3);
	        
            result = new Department(deptid, deptName);
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return result;
	}

	public List<Department> getDepartments() 
	{
		List<Department> result = new ArrayList<Department>();
		ResultSet resultSet;
	    String query = "{call GET_DEPARTMENTS( ? )}";
	    
	    int deptId;
        String deptName;
	    
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
	        	deptId = resultSet.getInt(1);
	        	deptName = resultSet.getString(2);
	            
	            result.add( new Department(deptId, deptName) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public void updateDepartment(Department newDepartment)
	{
		int deptId = newDepartment.getDeptId();
		String deptName = newDepartment.getDeptName();
		
		String query = "{call UPDATE_DEPARTMENT ( ?, ? )}";
		
		try
	    {
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, deptId);
	        callableStatement.setString(2, deptName);
	        
	        callableStatement.executeUpdate();
	        
	        connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void removeDepartment(int targetId) 
	{
		String query = "{call REMOVE_DEPARTMENT( ? )}";
		
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
