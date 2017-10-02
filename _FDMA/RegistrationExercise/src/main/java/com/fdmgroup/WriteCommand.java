package com.fdmgroup;

import java.util.List;

/**
 * Sets methods for Writing Users to a file
 * @author Christopher Kemerait
 */

public interface WriteCommand 
{
	/**
	 * Writes a User to a file
	 * @author Christopher Kemerait
	 */
	boolean writeUser(User user);
	/**
	 * Writes Users to a file
	 * @author Christopher Kemerait
	 */
	boolean writeUsers(List<User> userList);
}
