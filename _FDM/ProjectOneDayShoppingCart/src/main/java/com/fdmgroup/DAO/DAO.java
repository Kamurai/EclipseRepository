package com.fdmgroup.DAO;

import java.sql.CallableStatement;

abstract class DAO 
{
	protected DAOHelper dAOHelper;
	protected CallableStatement callableStatement;
	
	public DAO()
	{
		dAOHelper = new DAOHelper();
	}
	
}
