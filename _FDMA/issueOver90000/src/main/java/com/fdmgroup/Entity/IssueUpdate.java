package com.fdmgroup.Entity;

import java.time.LocalDateTime;
import java.sql.Date;

public class IssueUpdate 
{
	private int issueUpdateId;
	private int issueId;
	private int submittedBy;
	private String submittedByUsername;
	private Date updateDate;
	private String updateComment;
	
	//no args constructor
	public IssueUpdate() 
	{
		this.issueUpdateId = -1; //invalid: will be created in database
		this.issueId = -1;
		this.submittedBy = -1;
		this.submittedByUsername = null;
		this.updateDate = null;
		this.updateComment = null;
	}
	
	//new IssueUpdates
	public IssueUpdate(int issueId, int submittedBy, String submittedByUsername, Date updateDate, String updateComment) 
	
	{
		this.issueUpdateId = -1; //invalid: will be created in database
		this.issueId = restrictIssueId(issueId);
		this.submittedBy = restrictSubmittedBy(submittedBy);
		this.submittedByUsername = restrictSubmittedByUsername(submittedByUsername);
		this.updateDate = updateDate;
		this.updateComment = restrictUpdateComment(updateComment);
	}
	
	//existing IssueUpdates
	public IssueUpdate(int issueUpdateId, int issueId, int submittedBy, String submittedByUsername, Date updateDate, String updateComment) 
	{
		this.issueUpdateId = restrictIssueUpdateId(issueUpdateId);
		this.issueId = restrictIssueId(issueId);
		this.submittedBy = restrictSubmittedBy(submittedBy);
		this.submittedByUsername = restrictSubmittedByUsername(submittedByUsername);
		this.updateDate = updateDate;
		this.updateComment = restrictUpdateComment(updateComment);
	}

	public int getIssueUpdateId() {
		return issueUpdateId;
	}

	public void setIssueUpdateId(int issueUpdateId) {
		this.issueUpdateId = issueUpdateId;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateComment() {
		return updateComment;
	}

	public void setUpdateComment(String updateComment) {
		this.updateComment = updateComment;
	}
	
	private int restrictIssueUpdateId(int issueUpdateId)
	{
		int result = issueUpdateId;
		result=restrictIssueUpdateIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictIssueUpdateIdAboveNegativeTwo(int issueUpdateId)
	{
		int result = issueUpdateId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private int restrictIssueId(int issueId)
	{
		int result = issueId;
		result=restrictIssueIdAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictIssueIdAboveNegativeTwo(int issueId)
	{
		int result = issueId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private int restrictSubmittedBy(int submittedBy)
	{
		int result = submittedBy;
		result=restrictSubmittedByAboveNegativeTwo(result);
		//Upper bound restricted by database
		
		return result;
	}
	
	private int restrictSubmittedByAboveNegativeTwo(int submittedBy)
	{
		int result = submittedBy;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	private String restrictSubmittedByUsername(String submittedByUsername)
	{
		String result = submittedByUsername;
		
		result=restrictSubmittedByUsernameLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictSubmittedByUsernameLessThanThirtyCharacters(String submittedByUsername)
	{
		String result = submittedByUsername;
		
		if(result.length() > 30)
			result = result.substring(0, 30);
		
		return result;
	}
	
	private String restrictUpdateComment(String updateComment)
	{
		String result = updateComment;
		
		result=restrictUpdateCommentLessThanThirtyCharacters(result);
		
		return result;
	}
	
	private String restrictUpdateCommentLessThanThirtyCharacters(String updateComment)
	{
		String result = updateComment;
		
		if(result.length() > 300)
			result = result.substring(0, 300);
		
		return result;
	}
	
}
