package com.fdmgroup.patterns.objectpool;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private int limit = 3;
	private int released = 0;
	
	private List<Connection> connections = new ArrayList<Connection>();
	
	public Connection getConnection(){
		
		if(released == limit){
			System.out.println("Error: All connections are in use. Try again later.");
			return null;
		}
		
		released = released + 1;
		
		if(connections.size() > 0){
			System.out.println("Reusing a connection from pool");
			return connections.remove(0);
		}
		else{
			System.out.println("Creating new connection");
			return new Connection();	
		}
	}
	
	
	
	public void returnConnection(Connection conn){
		
		released = released - 1;
		connections.add(conn);
	}

}
