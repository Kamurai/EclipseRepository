package com.fdmgroup.Entity;

public class Role {

	private int roleId;
	private String roleName;
	
	//no args constructor
	public Role()
	{
		this.roleId = -1;
		this.roleName=null;
	}

	//New Roles
	public Role(String roleName){
		this.roleId=-1;
		this.roleName=restrictRoleName(roleName);
	}

	//Existing Roles
	public Role(int role, String roleName)
	{
		this.roleId=restrictRoleId(role);
		this.roleName=restrictRoleName(roleName);
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int role) {
		this.roleId = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	private int restrictRoleId(int roleId)
	{
		int result = roleId;
		result=restrictRoleIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictRoleIdAboveNegativeTwo(int roleId)
	{
		int result = roleId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private String restrictRoleName(String roleName)
	{
		String result = roleName;
		
		result=restrictRoleNameLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictRoleNameLessThanThirtyCharacters(String roleName)
	{
		String result = roleName;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
}
