package com.fdmgroup.Utility;

import javax.servlet.http.HttpSession;

import com.fdmgroup.Entity.Cart;

public final class Constant 
{
	static int invalidId;
	
	public static int invalidId()
	{
		invalidId = -1;
		
		return invalidId;
	}
}
