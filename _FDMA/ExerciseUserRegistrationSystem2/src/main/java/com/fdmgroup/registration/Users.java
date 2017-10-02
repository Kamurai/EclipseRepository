package com.fdmgroup.registration;

import java.util.List;

public interface Users 
{
	void addUser (User user);
	User getUser (String username);
	void removeUser(String username);
	void updateUser (User user);
	List<User> listUsers();

}
