package com.fdmgroup.DAO;

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

import com.fdmgroup.DAO.DBInfo;


import oracle.jdbc.OracleTypes;

public class GenericDAO
{
	private DBInfo dBInfo;
	private Connection connection;
	private Statement statement;
	
	public GenericDAO()
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
	
	public boolean stmtExecute(String query)
	{
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
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean stmtExecuteUpdate(String query)
	{
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
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	
}
