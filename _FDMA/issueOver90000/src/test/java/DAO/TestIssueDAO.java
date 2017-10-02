package DAO;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.IssueDAO;
import com.fdmgroup.DAO.IssueDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.IssueUpdate;
import com.fdmgroup.Entity.User;

public class TestIssueDAO 
{
	DBSetup dBSetup;
	IssueDAO issueDAO = new IssueDAO();
	Issue issue;
	
	@Before
	public void SetUp()
	{
		dBSetup = new DBSetup();
//		dBSetup.setupDB();
//		dBSetup.stubDBwithHeroes();
		issueDAO = new IssueDAO();
	}
	
	@After
	public void TearDown()
	{
//		dBSetup.tearDownDB();
	}
	
	@Test
	public void test_GetIssueById()
	{
		int suppliedId = 8;
		issue = issueDAO.getIssueById(suppliedId);
		
		assertEquals(issue.getIssueId(), suppliedId);
	}
	
	@Test
	public void test_GetIssueByTitle()
	{
		String suppliedTitle = "Need Unobtainium";
		issue = issueDAO.getIssueByTitle(suppliedTitle);
		
		assertEquals(issue.getTitle(), suppliedTitle);
	}
	
	@Test
	public void test_GetIssues()
	{
		int suppliedCount = 2; //get manually
		
		assertEquals(suppliedCount, issueDAO.getIssues().size());
	}
	
	@Test
	public void test_GetIssuesBySubmitted()
	{
		int suppliedUserId = 8;
		int suppliedCount = 1; //get manually
		
		assertEquals(suppliedCount, issueDAO.getIssuesBySubmittedBy(suppliedUserId).size());
	}
	
	
	@Test
	public void test_GetIssuesByAssignedTo()
	{
		int suppliedUserId = 1;
		int suppliedCount = 1; //get manually
		
		int foundCount = issueDAO.getIssuesByAssignedTo(suppliedUserId).size();
		
		assertEquals(suppliedCount, foundCount);
	}
	
	@Test
	public void test_GetIssuesByUnassigned()
	{
		int suppliedCount = 1; //get manually
		
		assertEquals(suppliedCount, issueDAO.getIssuesByUnassigned().size());
	}
	
	@Test
	public void test_AddIssue()
	{
		issue = new Issue("Costume too tight", "Costume is too form fitting and makes it hard to breathe.", 4, 4, new Date(new Timestamp(System.currentTimeMillis()).getTime()), 0 , "Monkeys");
		
		int issueCount = issueDAO.getIssues().size();
		
		issueDAO.addIssue(issue);
		
		assertEquals(issueCount+1, issueDAO.getIssues().size());
	}
	
	@Test
	public void test_RemoveIssue()
	{
		int userCount = issueDAO.getIssues().size();
		
		issueDAO.removeIssue(issueDAO.getIssues().size()-1);
		
		assertEquals(userCount-1, issueDAO.getIssues().size());
	}
	
	@Test
	public void test_UpdateUser() //failing: Invalid column type: getInt not implemented for class oracle.jdbc.driver.T4CDateAccessor
	{
		int suppliedId = issueDAO.getIssues().size()-1; //get last user
		String suppliedTitle = "Yes, we have no bananas.";
		
		Issue savedIssue = issueDAO.getIssueById(suppliedId);
		
		
		UserDAO userDAO = new UserDAO();
		
		String adminComment = null;
		
		int assignedTo = 1;
		String assignedToUsername = userDAO.getUserById(assignedTo).getUsername();
		
		int submittedBy = 0;
		String submittedByUsername = userDAO.getUserById(submittedBy).getUsername();
		
		Date dateResolved = null;
		
		List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
		
		issue = new Issue(suppliedId, suppliedTitle, "Man, I need a banana.", adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, 0, "New", 2, new Date(new Timestamp(System.currentTimeMillis()).getTime()), dateResolved, issueUpdateList, 0, "Monkeys");
		
		issueDAO.updateIssue(issue);
		
		String fetchedTitle = issueDAO.getIssueById(suppliedId).getTitle();
		
		issueDAO.updateIssue(savedIssue);
		
		assertEquals(suppliedTitle, fetchedTitle);
	}
	
	
}
