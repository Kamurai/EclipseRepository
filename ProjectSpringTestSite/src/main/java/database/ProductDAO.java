package database;

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

import entity.Product;
import oracle.jdbc.OracleTypes;

public interface ProductDAO
{
	public Product getProduct(int id);
	public List<?> getProducts();
	
	/*
	 * public void updateProduct(int id);
	 * public void deleteProduct(int id);
	 */
	
}
