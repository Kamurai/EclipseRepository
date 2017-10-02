package com.fdmgroup.patterns.objectpool;

public class Client {
	
	public static void main(String[] args){
		
		ConnectionPool pool = new ConnectionPool();
		
		Connection conn1 = pool.getConnection(); // New
		print(conn1);
		
		Connection conn2 = pool.getConnection(); // New
		print(conn2);
		
		Connection conn3 = pool.getConnection(); // New
		print(conn3);
		
		Connection conn4 = pool.getConnection(); // Fails - Limit exceeded
		print(conn4);
		
		pool.returnConnection(conn1);
		pool.returnConnection(conn2);
		
		Connection conn5 = pool.getConnection(); // Reused
		print(conn5);
		
		Connection conn6 = pool.getConnection(); // Reused
		print(conn6);
		
		Connection conn7 = pool.getConnection(); // Fails - Limit exceeded
		print(conn7);
	}

	
	private static void print(Connection conn){
		System.out.println(conn + "\n");
	}
}
