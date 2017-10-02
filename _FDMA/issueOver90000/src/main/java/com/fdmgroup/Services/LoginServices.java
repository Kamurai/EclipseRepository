package com.fdmgroup.Services;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Entity.User;

public class LoginServices {
	private UserDAO userDAO;
	
	public Boolean login(String username, String password){
		userDAO = new UserDAO();
		User user = userDAO.getUserByUsername(username);
		Boolean verified = false;
		if(user != null){
			if(user.getPassword().equals(password)){
				verified = true;
			}else{
				return verified;
			}
	
		}else if(user == null){
			return verified;
			
		}
		return verified;
		
		
	}

	public LoginServices(UserDAO user2DAO) {
		super();
		this.userDAO = userDAO;
	}


}
