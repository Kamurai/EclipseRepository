package com.fdmgroup.Entity;

public class Department 
{
	private  int deptId;
	private String deptName;

	//no args constructor
	public Department()
	{
		this.deptId = -1;
		this.deptName = null;
	}
	//new Departments
	public  Department(String deptName)
	{
		this.deptId=-1;
		this.deptName=restrictDeptName(deptName);;
	}
	
	//existing Departments
	public  Department(int deptid, String deptName)
	{
		this.deptId=restrictDeptId(deptId);
		this.deptName=restrictDeptName(deptName);
	}
	
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
}
