package com.fdmgroup;

import java.util.List;

/**
 * Sets methods for Reading Users from a file
 * @author Christopher Kemerait
 */

public interface ReadCommand 
{
	/**
	 * Reads a User to a file
	 * @author Christopher Kemerait
	 */
	User readFirstUser();
	/**
	 * Reading Users to a file
	 * @author Christopher Kemerait
	 */
	List<User> readUsers();
}
