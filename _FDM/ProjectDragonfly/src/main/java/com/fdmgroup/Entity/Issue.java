package com.fdmgroup.Entity;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Issue 
{
	private static final long serialVersionUID = -4805965468921578684L;
	
	private int issueId;
	private String title;
	private String userDescription;
	private String adminComment;
	private int assignedTo;
	private String assignedToUsername;
	private int submittedBy;
	private String submittedByUsername;
	private int statusId;
	private String status;
	private int priority;
	private Date dateSubmitted;
	private Date dateResolved;
	private List<IssueUpdate> updateList;
	private int deptId;
	private String deptName;
	
	//No args constructor
	public Issue()
	{
		this.issueId=-1; //invalid: will be created in database
		this.title=null;
		this.userDescription=null;
		this.adminComment=null;
		this.assignedTo=-1; //none
		this.assignedToUsername=null;
		this.submittedBy=-1;
		this.submittedByUsername=null;
		this.statusId=-1;
		this.status=null;
		this.priority=-1;
		this.dateSubmitted=null;
		this.dateResolved=null; //none
		this.updateList = new ArrayList<IssueUpdate>();
		this.deptId=-1;
		this.deptName=null;
		
	}
	
	//new Issues
	public Issue(String title, String userDescription, int submittedBy, int priority, Date dateSubmitted, int deptId, String deptName )
	{
		this.issueId=-1; //invalid: will be created in database
		this.title=restrictTitle(title);
		this.userDescription=restrictUserDescription(userDescription);
		this.adminComment=null;
		this.assignedTo=-1; //none
		this.assignedToUsername=null;
		this.submittedBy=restrictSubmittedBy(submittedBy);
		this.submittedByUsername=null;
		this.statusId=0;  //new
		this.status="New";  //new
		this.priority=restrictPriority(priority);
		this.dateSubmitted=dateSubmitted;
		this.dateResolved=null; //none
		this.updateList = new ArrayList<IssueUpdate>();
		this.deptId=restrictDeptId(deptId);
		this.deptName=restrictDeptName(deptName);
	}
	
	//existing Issues
	public Issue(int issueId, String title, String userDescription, String adminComment, int assignedTo, String assignedToUsername, int submittedBy, String submittedByUsername, int statusId, String status, int priority, Date dateSubmitted, Date dateResolved, List<IssueUpdate> updateList, int deptId, String deptName )
	{
		this.issueId=restrictIssueId(issueId);
		this.title=restrictTitle(title);
		this.userDescription=restrictUserDescription(userDescription);
		this.adminComment=restrictAdminComment(adminComment);
		this.assignedTo=restrictAssignedTo(assignedTo);
		this.assignedToUsername=restrictedAssignedToUsername(assignedToUsername);
		this.submittedBy=restrictSubmittedBy(submittedBy);
		this.submittedByUsername=restrictSubmittedByUsername(submittedByUsername);
		this.statusId=restrictStatusId(statusId);
		this.status=restrictStatus(status);
		this.priority=restrictPriority(priority);
		this.dateSubmitted=dateSubmitted;
		this.dateResolved=dateResolved;
		this.updateList = updateList;
		this.deptId=restrictDeptId(deptId);
		this.deptName=restrictDeptName(deptName);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedToUsername() {
		return assignedToUsername;
	}

	public void setAssignedToUsername(String assignedToUsername) {
		this.assignedToUsername = assignedToUsername;
	}

	public int getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(int submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSubmittedByUsername() {
		return submittedByUsername;
	}

	public void setSubmittedByUsername(String submittedByUsername) {
		this.submittedByUsername = submittedByUsername;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	public List<IssueUpdate> getUpdateList() {
		return updateList;
	}

	public void setUpdateList(List<IssueUpdate> updateList) {
		this.updateList = updateList;
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
	
	private int restrictIssueId(int issueId)
	{
		int result = issueId;
		result=restrictUserIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictUserIdAboveNegativeTwo(int issueId)
	{
		int result = issueId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private int restrictAssignedTo(int userId)
	{
		int result = userId;
		result=restrictAssignedToAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictAssignedToAboveNegativeTwo(int userId)
	{
		int result = userId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private int restrictSubmittedBy(int userId)
	{
		int result = userId;
		result=restrictSubmittedByAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictSubmittedByAboveNegativeTwo(int userId)
	{
		int result = userId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	//To Do
	private int restrictPriority(int userId)
	{
		return userId;
	}
	public String restrictTitle(String title)
	{
		return title;
	}
	
	public String restrictUserDescription(String userDescription)
	{
		return title;
	}
	private int restrictDeptId(int userId)
	{
		return userId;
	}
	public String restrictDeptName(String userDescription)
	{
		return title;
	}
	private int restrictStatusId(int userId)
	{
		return userId;
	}
	
	
	public String restrictAdminComment(String userDescription)
	{
		return title;
	}
	
	
	public String restrictedAssignedToUsername(String userDescription)
	{
		return title;
	}
	
	
	public String restrictSubmittedByUsername(String userDescription)
	{
		return title;
	}
	
	
	public String restrictStatus(String userDescription)
	{
		return title;
	}
	
}
