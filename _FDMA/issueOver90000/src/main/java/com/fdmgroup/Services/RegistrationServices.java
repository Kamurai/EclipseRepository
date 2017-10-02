package com.fdmgroup.Services;

import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Entity.User;

public class RegistrationServices {
	private UserDAO userDAO;
//	private UserFactory userFactory;
	
	public Boolean register(User user, String confirmPassword){
		userDAO = new UserDAO();
		Boolean registrationSuccess = false;
		if(user.getPassword().equals(confirmPassword)){


			if(userDAO.getUserByUsername(user.getUsername()) == null){
				userDAO.addUser(user);
				registrationSuccess= true;
				
			}	
			
		}
		return registrationSuccess;
	}

	public RegistrationServices(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}




}
