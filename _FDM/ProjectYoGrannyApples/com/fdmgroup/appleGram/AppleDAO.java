package com.fdmgroup.appleGram;

import java.math.BigDecimal;
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

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

public class AppleDAO implements ProductDAO
{
	//private DBInfo dBInfo;
	
	InitialContext context;
	DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private EntityManagerFactory entityManagerFactory;
	
	public AppleDAO()
	{
		//dBInfo = new DBInfo();
		
		try
		{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
//		try {
//			context = new InitialContext();
//			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/connection");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		entityManagerFactory = Persistence.createEntityManagerFactory("productDAOEMFactory");
		
	}
	
	
	public Apple getProduct(int id) {
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
		Apple product = null;
		
		product = entityManager.find(Apple.class, id);
			
		entityManager.close();
		return product;
	}
	
	public List<Apple> getProducts() 
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
			
		List<Apple> appleList = new ArrayList<Apple>();
		
		Query query = entityManager.createQuery("select id, name, price, picurl from Apple");
		
		List<Object[]> rows = query.getResultList();
		//List<Apple> result = new ArrayList<>();
		for (Object[] row: rows)
		{
			appleList.add( new Apple( (Integer) row[0], (String) row[1], (BigDecimal) row[2], (String) row[3] ) );
		}
		
		//appleList = query.getResultList();
		
		//System.out.println(appleList.get(1));
		
		
		entityManager.close();
		return appleList;
	}
	
}
