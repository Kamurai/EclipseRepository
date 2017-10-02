package DAO;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.IssueUpdateDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.IssueUpdate;
import com.fdmgroup.Entity.User;

public class TestIssueUpdateDAO 
{
	DBSetup dBSetup;
	IssueUpdateDAO issueUpdateDAO;
	IssueUpdate issueUpdate;
	
	@Before
	public void SetUp()
	{
		dBSetup = new DBSetup();
//		dBSetup.setupDB();
//		dBSetup.stubDBwithHeroes();
		issueUpdateDAO = new IssueUpdateDAO();		
	}
	
	@After
	public void TearDown()
	{
//		dBSetup.tearDownDB();
	}
	
	
	@Test
	public void test_GetIssueUpdateById()
	{
		int suppliedId = 0;
		issueUpdate = issueUpdateDAO.getIssueUpdateById(suppliedId);
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//System.out.println(dateFormat.format(issueUpdate.getUpdateDate()));
		
		assertEquals(issueUpdate.getIssueUpdateId(), suppliedId);
	}
	
	@Test
	public void test_GetIssueUpdates()
	{
		int suppliedCount = 3; //get manually
		
		assertEquals(suppliedCount, issueUpdateDAO.getIssueUpdates().size());
	}
	
	@Test
	public void test_GetIssueUpdatesByIssueId()
	{
		int suppliedCount = 2; //get manually
		int targetId = 0; //issueId
		
		assertEquals(suppliedCount, issueUpdateDAO.getIssueUpdatesByIssueId(targetId).size());
	}
	
	@Test
	public void test_AddIssueUpdate()
	{
		int issuId = 0;
		int submittedBy = 0;		
		String submittedByUsername = "Steve.Rogers";
		Date updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		String updateComment = "Blarg!";
		
		issueUpdate = new IssueUpdate(issuId, submittedBy, submittedByUsername, updateDate, updateComment);
		
		int issueUpdateCount = issueUpdateDAO.getIssueUpdates().size();
		
		issueUpdateDAO.addIssueUpdate(issueUpdate);
		
		assertEquals(issueUpdateCount+1, issueUpdateDAO.getIssueUpdates().size());
	}
	
	@Test
	public void test_RemoveUser()
	{
		int userCount = issueUpdateDAO.getIssueUpdates().size();
		
		issueUpdateDAO.removeIssueUpdate(issueUpdateDAO.getIssueUpdates().size()-1);
		
		assertEquals(userCount-1, issueUpdateDAO.getIssueUpdates().size());
	}
	
	@Test
	public void test_UpdateUser()
	{
		int suppliedId = issueUpdateDAO.getIssueUpdates().size()-1; //get last user
		String suppliedUpdateComment = "Blarg blarg, honk honk.";
		String submittedByUsername = "Freckles";
		
		
		IssueUpdate savedIssueUpdate = issueUpdateDAO.getIssueUpdateById(suppliedId);
		
		Date updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		
		issueUpdate = new IssueUpdate(suppliedId, 0, 0, submittedByUsername, updateDate, suppliedUpdateComment);
		
		issueUpdateDAO.updateIssueUpdate(issueUpdate);
		
		String fetchedUpdateComment = issueUpdateDAO.getIssueUpdateById(suppliedId).getUpdateComment();
		
		issueUpdateDAO.updateIssueUpdate(savedIssueUpdate);
		
		assertEquals(suppliedUpdateComment, fetchedUpdateComment);
	}
}
