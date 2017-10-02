package com.fdmgroup.registration;

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

import oracle.jdbc.OracleTypes;

public class UsersDAOem implements Users
{
	private DBInfo dBInfo;
	//private DriverManager driverManager;
	private Connection connection;
	private Statement statement;
	private CallableStatement callableStatement;
	private EntityManagerFactory entityManagerFactory;
	
	public UsersDAOem()
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
		entityManagerFactory = Persistence.createEntityManagerFactory("usersDAOEMFactory");
		
	}
	
	public void addUser(User user)
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			entityManager.getTransaction().begin();
			
			entityManager.persist(user);
					
			entityManager.getTransaction().commit();
			
		entityManager.close();
	}
	
	public User getUser(String username)
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			User user = null;
			
			user = entityManager.find(User.class, username);
			
		entityManager.close();
		return user;
	}
	
	public void updateUser(User user) 
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			User newUser = entityManager.find(User.class, user.getUsername());
			
			entityManager.getTransaction().begin();
			
			user.setUsername(user.getUsername());
			user.setPassword(user.getPassword());
			user.setRole(user.getRole());
			
			entityManager.getTransaction().commit();
			
		entityManager.close();
	}

	public void removeUser(String username) 
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		
			User newUser = null;
			
			try
			{
				newUser = entityManager.find(User.class, username);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			if(newUser != null)
			{
				entityManager.getTransaction().begin();
				
				entityManager.remove(newUser);
				
				entityManager.getTransaction().commit();
			}
		
		entityManager.close();
	}

	public List<User> readAll() 
	{
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
			
			List<User> userList = new ArrayList<User>();
			
			Query query = entityManager.createQuery("{call GET_USERS}");
			userList = query.getResultList();
			
		entityManager.close();
		return userList;
	}
	
	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
