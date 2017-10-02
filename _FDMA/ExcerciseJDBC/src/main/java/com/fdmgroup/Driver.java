package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class Driver 
{

	public static void main(String[] args) 
	{
		List<User> superHeroes = new ArrayList<User>();
		
		UsersDAO usersDAO = new UsersDAO();
		superHeroes = usersDAO.stmtExecuteQuery("SELECT * FROM USERS");
		
		for( int x = 0; x < superHeroes.size(); x++ )
		{
			superHeroes.get(x).printUser();
		}
	}

}
