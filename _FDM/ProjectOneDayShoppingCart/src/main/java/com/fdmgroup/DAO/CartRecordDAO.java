package com.fdmgroup.DAO;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.Entity.CartRecord;
import com.fdmgroup.Entity.Item;

import oracle.jdbc.OracleTypes;

public class CartRecordDAO 
{
	private DBInfo dBInfo;
	private Connection connection ;
	private CallableStatement callableStatement;
	
	public CartRecordDAO()
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
	
	public void addRecord(CartRecord record) 
	{
		int cartId = record.getCartId();
		int itemId = record.getItem().getId();
		int quantityRequested = record.getQuantityRequested();
		
		String query = "{call ADD_RECORD(?,?,?)}";
		
		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
			callableStatement = connection.prepareCall(query);

			callableStatement.setInt(1, cartId);
			callableStatement.setInt(2, itemId);
			callableStatement.setInt(3, quantityRequested);
			
			callableStatement.executeUpdate();

			connection.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	public void addRecords(List<CartRecord> recordList)
	{
		for(int x = 0; x < recordList.size(); x++)
		{
			addRecord(recordList.get(x));
		}
	}
	
	public CartRecord getRecordById(int targetId) 
	{
		CartRecord result = null;
		String query = "{call GET_RECORD_BY_ID( ?,?,?,?,?,?,?,?,? )}";

		try
		{
			String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query);
			
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, java.sql.Types.NUMERIC); //id number
	        callableStatement.registerOutParameter(3, java.sql.Types.NUMERIC); //cartId number
	        callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC); //itemId number
	        callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR); //itemName VARCHAR2
	        callableStatement.registerOutParameter(6, java.sql.Types.NUMERIC); //quantityAvailable number
	        callableStatement.registerOutParameter(7, java.sql.Types.NUMERIC); //price number
	        callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR); //description VARCHAR2
	        callableStatement.registerOutParameter(9, java.sql.Types.NUMERIC); //quantityRequested number
	        
	        callableStatement.execute();
	        
	        int id;
	        int cartId;
	        int itemId;
	        String itemName;
	        int quantityAvailable;
	        BigDecimal price;
	        String description;
	        int quantityRequested;
	        	        
	        id = callableStatement.getInt(2);
	        if( callableStatement.wasNull() )
			{
	        	id = -1;
			}
	        cartId = callableStatement.getInt(3);
	        if( callableStatement.wasNull() )
			{
	        	cartId = -1;
			}
	        itemId = callableStatement.getInt(4);
	        if( callableStatement.wasNull() )
			{
	        	itemId = -1;
			}
	        itemName = callableStatement.getString(5);
			quantityAvailable = callableStatement.getInt(6);
			price = callableStatement.getBigDecimal(7);
			description = callableStatement.getString(8);
			quantityRequested = callableStatement.getInt(9);
			
			Item item = new Item(itemId, itemName, quantityAvailable, price, description);
			
	        result = new CartRecord(id, cartId, item, quantityRequested);
	        connection.close();
		}  
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<CartRecord> getRecords() 
	{
		List<CartRecord> result = new ArrayList<CartRecord>();
	    ResultSet resultSet;
	    
	    String query = "{call GET_RECORDS( ? )}";
	    int id;
	    int cartId;
	    int itemId;
	    String itemName;
	    int quantityAvailable;
	    BigDecimal price;
	    String description;
	    
	    Item item;
	    int quantityRequested;
	    
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
	        	cartId = resultSet.getInt(2);
	        	if( resultSet.wasNull() )
				{
	        		cartId = -1;
				}
	        	itemId = resultSet.getInt(3);
	        	if( resultSet.wasNull() )
				{
	        		itemId = -1;
				}
	        	itemName = resultSet.getString(4);
				quantityAvailable = resultSet.getInt(5);
	            price = resultSet.getBigDecimal(6);
	            description = resultSet.getString(7);
	            
	            item = new Item(itemId, itemName, quantityAvailable, price, description);
	            
	            quantityRequested = resultSet.getInt(8);

		        result.add( new CartRecord(id, cartId, item, quantityRequested) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public List<CartRecord> getRecordsByCartId(int targetId) 
	{
		List<CartRecord> result = new ArrayList<CartRecord>();
	    ResultSet resultSet;
	    
	    String query = "{call GET_RECORDS_BY_CARTID( ?,? )}";
	    int id;
	    int cartId;
	    int itemId;
	    String itemName;
	    int quantityAvailable;
	    BigDecimal price;
	    String description;
	    
	    Item item;
	    int quantityRequested;
	    
        try
	    {
        	String dBurl = dBInfo.getUrl();
	        String dBusername = dBInfo.getUsername();
	        String dBpassword = dBInfo.getPassword();
	        connection = DriverManager.getConnection(dBurl, dBusername, dBpassword);
		    
	        callableStatement = connection.prepareCall(query); //createStatement();
	        
	        callableStatement.setInt(1, targetId);
	        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
	        
	        callableStatement.execute();
	        
	        resultSet = (ResultSet) callableStatement.getObject(2);
	        
	        while( resultSet.next() )
	        {
	        	id = resultSet.getInt(1);
	        	if( resultSet.wasNull() )
				{
	        		id = -1;
				}
	        	cartId = resultSet.getInt(2);
	        	if( resultSet.wasNull() )
				{
	        		cartId = -1;
				}
	        	itemId = resultSet.getInt(3);
	        	if( resultSet.wasNull() )
				{
	        		itemId = -1;
				}
	        	itemName = resultSet.getString(4);
				quantityAvailable = resultSet.getInt(5);
	            price = resultSet.getBigDecimal(6);
	            description = resultSet.getString(7);
	            
	            item = new Item(itemId, itemName, quantityAvailable, price, description);
	            
	            quantityRequested = resultSet.getInt(8);

		        result.add( new CartRecord(id, cartId, item, quantityRequested) );
	        }
	        
            connection.close();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
        
        return result;
	}
	
	public void updateRecord(CartRecord newRecord) 
	{
		int id = newRecord.getId();
		int cartId = newRecord.getCartId();
		int itemId = newRecord.getItem().getId();
        int quantityRequested = newRecord.getQuantityRequested();
		
		String query = "{call UPDATE_RECORD ( ?,?,?,? )}";

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
			if( id == -1)
				callableStatement.setNull(2, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(2, cartId);
			if( id == -1)
				callableStatement.setNull(3, java.sql.Types.NUMERIC);
			else
				callableStatement.setInt(3, itemId);
				callableStatement.setInt(4, quantityRequested);
			
			callableStatement.executeUpdate();

			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	public void removeRecord(int targetId) 
	{
		String query = "{call REMOVE_RECORD( ? )}";

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
	
	public void removeRecordsByCartId(int targetId) 
	{
		String query = "{call REMOVE_RECORDS_BY_CARTID( ? )}";

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
