package com.fdmgroup.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Entity.User;

import oracle.jdbc.OracleTypes;

public class UserDAO {
	private DBInfo dBInfo;
	private Connection connection ;
	private CallableStatement callableStatement;
	
	public UserDAO (){
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
	
	public void addUser(User user) 
	{
		List<Department> deptList = user.getDeptList();
		int deptId = deptList.get(0).getDeptId();
		String userName = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();

		String query = "{call ADD_USER(?,?,?,?)}";

		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
			callableStatement = connection.prepareCall(query);

			if( deptId == -1)
	        	callableStatement.setNull(1, java.sql.Types.NUMERIC);
	        else
	        	callableStatement.setInt(1, deptId);
			callableStatement.setString(2,userName);
			callableStatement.setString(3, password);
			callableStatement.setString(4,email);

			callableStatement.executeUpdate();

			connection.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	

	}
	public User getUserByUsername(String targetUsername) 
	{
		User result = null;
		ResultSet resultSet;
		String query = "{call GET_USER_BY_USERNAME( ?,?,?,?,?,?,? )}";

		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
			
	        callableStatement.setString(1, targetUsername);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //userId number
	        callableStatement.registerOutParameter(3, java.sql.Types.NUMERIC); //deptId varchar
	        callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR); //deptName varchar
	        callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR); //username varchar
	        callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR); //password varchar
	        callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR); //email number
	        
	        callableStatement.execute();
	        
	        int userId;
	        int deptId;
	        String deptName;
	        Department dept;
	        List<Department> deptList = new ArrayList<Department>();
	        String username;
	        String password;
	        String email;
	        List<Role> roleList = new ArrayList<Role>();
	        	        
	        userId = callableStatement.getInt(2);
	        if( callableStatement.wasNull() )
			{
	        	userId = -1;
			}
			deptId = callableStatement.getInt(3);
			if( callableStatement.wasNull() )
			{
				deptId = -1;
			}
			deptName = callableStatement.getString(4);
			dept = new Department(deptId, deptName);
			deptList.add(dept);
	        
	        username = callableStatement.getString(5);
	        password = callableStatement.getString(6);
	        email = callableStatement.getString(7);
	        
	        RoleDAO roleDAO = new RoleDAO();
	        
	        roleList = roleDAO.getRolesByUserID(userId);

	        result = new User( userId, deptList, username, password, email, roleList);
	        connection.close();
		}  
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public User getUserById(int targetId) 
	{
		User result = null;
		String query = "{call GET_USER_BY_ID( ?,?,?,?,?,?,? )}";
		
		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
	        
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //userId number
	        callableStatement.registerOutParameter(3, java.sql.Types.NUMERIC); //deptId varchar
	        callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR); //deptName varchar
	        callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR); //username varchar
	        callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR); //password varchar
	        callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR); //email number
	        
	        callableStatement.execute();
	        
	        int userId;
	        int deptId;
	        String deptName;
	        Department dept;
	        List<Department> deptList = new ArrayList<Department>();
	        String username;
	        String password;
	        String email;
	        List<Role> roleList = new ArrayList<Role>();
	        	        
	        userId = callableStatement.getInt(2);
	        if( callableStatement.wasNull() )
			{
	        	userId = -1;
			}
			deptId = callableStatement.getInt(3);
			if( callableStatement.wasNull() )
			{
				deptId = -1;
			}
			deptName = callableStatement.getString(4);
			dept = new Department(deptId, deptName);
			deptList.add(dept);
	        
	        username = callableStatement.getString(5);
	        password = callableStatement.getString(6);
	        email = callableStatement.getString(7);
	        
	        RoleDAO roleDAO = new RoleDAO();
	        
	        roleList = roleDAO.getRolesByUserID(userId);

	        result = new User( userId, deptList, username, password, email, roleList);
	        connection.close();
		}  
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<User> getUsers() 
	{
		List<User> result = new ArrayList<User>();
	    ResultSet resultSet;
	    
	    String query = "{call GET_USERS( ? )}";
	    int userId;
	    int deptId;
        Department dept;
        List<Department> deptList = new ArrayList<Department>();
        String username;
        String password;
        String email;
        List<Role> roleList = new ArrayList<Role>();
        
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
	        	userId = resultSet.getInt(1);
	        	if( resultSet.wasNull() )
				{
	        		userId = -1;
				}
				deptId = resultSet.getInt(2);
				if( resultSet.wasNull() )
				{
					deptId = -1;
				}
				username = resultSet.getString(3);
	            password = resultSet.getString(4);
	            email = resultSet.getString(5);

		        DepartmentDAO deptDAO = new DepartmentDAO();
		        dept = deptDAO.getDepartmentById(deptId);
		        deptList.add(dept);
		        
		        RoleDAO roleDAO = new RoleDAO();
		        
		        roleList = roleDAO.getRolesByUserID(userId);

	            result.add( new User(userId, deptList, username, password, email, roleList) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	public void updateUser(User newUser) 
	{
		int userId = newUser.getUserId();
        List<Department> deptList = newUser.getDeptList();
        int deptId = deptList.get(0).getDeptId();
		String username = newUser.getUsername();
		String password = newUser.getPassword();
		String email = newUser.getEmail();
		List<Role> roleList = newUser.getRoleList();
		
		String query = "{call UPDATE_USER ( ?, ?, ?, ?, ? )}";

		try
		{

			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
			callableStatement = connection.prepareCall(query);

			if( userId == -1)
				callableStatement.setNull(1, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(1, userId);
			if( deptId == -1)
				callableStatement.setNull(2, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(2, deptId);
			callableStatement.setString(3, username);
			callableStatement.setString(4, password);
			callableStatement.setString(5, email);

			callableStatement.executeUpdate();

			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	public void removeUser(int targetId) 
	{
		String query = "{call REMOVE_USER( ? )}";

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
