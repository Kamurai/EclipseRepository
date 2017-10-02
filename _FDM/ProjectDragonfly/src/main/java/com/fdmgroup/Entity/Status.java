package com.fdmgroup.Entity;

public class Status 
{

	private int statusId;
	private String statusName;
	
	//no args constructor
	public Status()
	{
		this.statusId = -1;
		this.statusName=null;
	}

	//New Statuss
	public Status(String statusName){
		this.statusId=-1;
		this.statusName=restrictStatusName(statusName);
	}

	//Existing Statuss
	public Status(int role, String statusName)
	{
		this.statusId=restrictStatusId(role);
		this.statusName=restrictStatusName(statusName);
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	private int restrictStatusId(int statusId)
	{
		int result = statusId;
		result=restrictStatusIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictStatusIdAboveNegativeTwo(int statusId)
	{
		int result = statusId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private String restrictStatusName(String statusName)
	{
		String result = statusName;
		
		result=restrictStatusNameLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictStatusNameLessThanThirtyCharacters(String statusName)
	{
		String result = statusName;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
}
