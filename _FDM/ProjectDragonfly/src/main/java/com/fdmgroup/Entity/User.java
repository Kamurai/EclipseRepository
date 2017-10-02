package com.fdmgroup.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class User implements Serializable
{
	private static final long serialVersionUID = -4805961129737578684L;
		
	private String username;
	private String password;
	private List<Department> deptList;
	private int userId;
	private String email;
	private List<Role> roleList;
	
	
	//No arg constructor
	public User()
	{
		deptList = new ArrayList<Department>();
		this.username = null;
		this.password = null;
		this.userId=-1;
		this.email = null;
		roleList = new ArrayList<Role>();
	}

	//new users
	public User( List<Department> dept, String username, String password, String email) 
	{
		this.deptList = restrictDeptList(dept);
		this.username = restrictUsername(username);
		this.password = restrictPassword(password);
		this.email = restrictEmail(email);
		this.roleList = new ArrayList<Role>();
	}
	
	//existing users
	public User( int userId, List<Department> dept, String username, String password,   String email, List<Role> roleList) 
	{
		this.userId = restrictUserId(userId);
		this.deptList = restrictDeptList(dept);
		this.username = restrictUsername(username);
		this.password = restrictPassword(password);
		this.email = restrictEmail(email);
		this.roleList = restrictRoleList(roleList);
	}
	

	@Override
	public String toString() {
		return "User [Username=" + username + ", Password=" + password + ", dept=" + deptList + ", UserId=" + userId
				+ ", Email=" + email + ", Roles=" + roleList +"]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	private int restrictUserId(int userId)
	{
		int result = userId;
		result=restrictUserIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictUserIdAboveNegativeTwo(int userId)
	{
		int result = userId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private List<Department> restrictDeptList(List<Department> deptList)
	{
		List<Department> result = deptList;
		
		result=restrictDeptListLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private List<Department> restrictDeptListLessThanThirtyCharacters(List<Department> userName)
	{
		List<Department> result = userName;
		
		for(int x = 0; x < result.size(); x++)
		{
			result.get(x).setDeptId(restrictDeptId(result.get(x).getDeptId()));
			result.get(x).setDeptName(restrictDeptName(result.get(x).getDeptName()));
		}
		
		return result;
	}
	
	private int restrictDeptId(int deptId)
	{
		int result = deptId;
		result=restrictDeptIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictDeptIdAboveNegativeTwo(int deptId)
	{
		int result = deptId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private String restrictDeptName(String deptName)
	{
		String result = deptName;
		
		result=restrictDeptNameLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictDeptNameLessThanThirtyCharacters(String deptName)
	{
		String result = deptName;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
	
	private String restrictUsername(String userName)
	{
		String result = userName;
		
		result=restrictUsernameLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictUsernameLessThanThirtyCharacters(String userName)
	{
		String result = userName;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
	
	private String restrictPassword(String password)
	{
		String result = password;
		
		result=restrictPasswordLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictPasswordLessThanThirtyCharacters(String password)
	{
		String result = password;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
	
	private String restrictEmail(String email)
	{
		String result = email;
		
		result=restrictEmailLessThanFiftyCharacters(result);
		
		return result;
	}
	
	private String restrictEmailLessThanFiftyCharacters(String email)
	{
		String result = email;
		
		if(result.length() > 50)
			result = result.substring(0, 50);
		
		return result;
	}
	
	private List<Role> restrictRoleList(List<Role> roleList)
	{
		List<Role> result = roleList;
		
		result=restrictRoleListLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private List<Role> restrictRoleListLessThanThirtyCharacters(List<Role> userName)
	{
		List<Role> result = userName;
		
		for(int x = 0; x < result.size(); x++)
		{
			result.get(x).setRoleId(restrictRoleId(result.get(x).getRoleId()));
			result.get(x).setRoleName(restrictRoleName(result.get(x).getRoleName()));
		}
		
		return result;
	}
	
	private int restrictRoleId(int RoleId)
	{
		int result = RoleId;
		result=restrictRoleIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictRoleIdAboveNegativeTwo(int RoleId)
	{
		int result = RoleId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private String restrictRoleName(String RoleName)
	{
		String result = RoleName;
		
		result=restrictRoleNameLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictRoleNameLessThanThirtyCharacters(String RoleName)
	{
		String result = RoleName;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
	
	
}