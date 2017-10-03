package com.fdmgroup.DAO;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.Entity.Item;

import oracle.jdbc.OracleTypes;

public class ItemDAO 
{
	private DBInfo dBInfo;
	private Connection connection ;
	private CallableStatement callableStatement;
	
	public ItemDAO()
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

	public void addItem(Item item, int quantityAvailable) 
	{
		int id = item.getId();
		String name = item.getName();
		BigDecimal price = item.getPrice();
		String description = item.getDescription();
		
		String query = "{call ADD_ITEM(?,?,?,?)}";
		
		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
			callableStatement = connection.prepareCall(query);

			callableStatement.setString(1, name);
			callableStatement.setInt(2, quantityAvailable);
			callableStatement.setBigDecimal(3, price);
			callableStatement.setString(4, description);

			callableStatement.executeUpdate();

			connection.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	public Item getItemByName(String targetName) 
	{
		Item result = null;
		String query = "{call GET_ITEM_BY_NAME( ?,?,?,?,?,? )}";

		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
			
	        callableStatement.setString(1, targetName);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //id number
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); //Name varchar
	        callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC); //QuantityAvailable number
	        callableStatement.registerOutParameter(5, java.sql.Types.NUMERIC); //Price number
	        callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR); //Description varchar
	        
	        
	        callableStatement.execute();
	        
	        int id;
	        String name;
	        int quantityAvailable;
	        BigDecimal price;
	        String description;
	        	        
	        id = callableStatement.getInt(2);
	        if( callableStatement.wasNull() )
			{
	        	id = -1;
			}
			name = callableStatement.getString(3);
			quantityAvailable = callableStatement.getInt(4);
			price = callableStatement.getBigDecimal(5);
			description = callableStatement.getString(6);
	        
	        result = new Item(id, name, quantityAvailable, price, description);
	        connection.close();
		}  
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Item getItemById(int targetId) 
	{
		Item result = null;
		String query = "{call GET_ITEM_BY_ID( ?,?,?,?,?,? )}";

		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
			
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //id number
	        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR); //Name varchar
	        callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC); //QuantityAvailable number
	        callableStatement.registerOutParameter(5, java.sql.Types.NUMERIC); //Price number
	        callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR); //Description varchar
	        
	        callableStatement.execute();
	        
	        int id;
	        String name;
	        int quantityAvailable;
	        BigDecimal price;
	        String description;
	        	        
	        id = callableStatement.getInt(2);
	        if( callableStatement.wasNull() )
			{
	        	id = -1;
			}
			name = callableStatement.getString(3);
			quantityAvailable = callableStatement.getInt(4);
			price = callableStatement.getBigDecimal(5);
			description = callableStatement.getString(6);
	        
	        result = new Item(id, name, quantityAvailable, price, description);
	        connection.close();
		}  
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Item> getItems() 
	{
		List<Item> result = new ArrayList<Item>();
	    ResultSet resultSet;
	    
	    String query = "{call GET_ITEMS( ? )}";
	    int id;
	    String name;
	    int quantityAvailable;
	    BigDecimal price;
		String description;
        
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
	        	id = resultSet.getInt(1);
	        	if( resultSet.wasNull() )
				{
	        		id = -1;
				}
	        	name = resultSet.getString(2);
				quantityAvailable = resultSet.getInt(3);
	            price = resultSet.getBigDecimal(4);
	            description = resultSet.getString(5);

		        result.add( new Item(id, name, quantityAvailable, price, description) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public void updateItem(Item newItem) 
	{
		int id = newItem.getId();
        String name = newItem.getName();
		int quantityAvailable = newItem.getQuantityAvailable();
        BigDecimal price = newItem.getPrice();
		String description = newItem.getDescription();
		
		String query = "{call UPDATE_ITEM ( ?, ?, ?, ?, ? )}";

		try
		{

			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
			callableStatement = connection.prepareCall(query);

			if( id == -1)
				callableStatement.setNull(1, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(1, id);
			callableStatement.setString(2, name);
			callableStatement.setInt(3, quantityAvailable);
			callableStatement.setBigDecimal(4, price);
			callableStatement.setString(5, description);

			callableStatement.executeUpdate();

			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	public void removeItem(int targetId) 
	{
		String query = "{call REMOVE_ITEM( ? )}";

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
