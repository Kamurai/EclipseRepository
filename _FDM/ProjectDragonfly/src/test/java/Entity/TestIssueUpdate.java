package Entity;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.IssueUpdate;
import com.fdmgroup.Entity.User;

public class TestIssueUpdate 
{
	int issueUpdateId;
	int issueId;
	int submittedBy;
	String submittedByUsername;
	Date updateDate;
	String updateComment;
	IssueUpdate issueUpdate;

	@Before
	public void SetUp()
	{
		issueUpdateId = -1;
		issueId = -1;
		submittedBy = -1;
		submittedByUsername = "Freckles";
		updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		updateComment = "Blarg!";
		issueUpdate = new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment);
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_IssueUpdateHasId()
	{
		assertNotNull(issueUpdate.getIssueUpdateId());
	}
	
	@Test
	public void test_IssueUpdateIdIsSetCorrectly()
	{
		assertEquals(issueUpdateId, issueUpdate.getIssueUpdateId());
	}
	
	@Test
	public void test_IssueUpdateIdIsSetGreaterThanNegative2()
	{
		issueUpdateId = -2;
		issueId = -1;
		submittedBy = -1;
		submittedByUsername = "Freckles";
		updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		updateComment = "Blarg!";
		issueUpdate = new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment);
		
		assertTrue(issueUpdate.getIssueUpdateId() > -2);
	}
	
	@Test
	public void test_IssueUpdateHasIssueId()
	{
	
		assertNotNull(issueUpdate.getIssueId());
	}
	
	@Test
	public void test_IssueIdIsSetCorrectly()
	{
		assertEquals(issueId, issueUpdate.getIssueId());
	}
	
	@Test
	public void test_IssueIdIsSetGreaterThanNegative2()
	{
		issueUpdateId = -1;
		issueId = -2;
		submittedBy = -1;
		submittedByUsername = "Freckles";
		updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		updateComment = "Blarg!";
		issueUpdate = new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment);
		
		assertTrue(issueUpdate.getIssueId() > -2);
	}
	
	@Test
	public void test_IssueUpdateHasSubmittedBy()
	{
	
		assertNotNull(issueUpdate.getSubmittedBy());
	}
	
	@Test
	public void test_SubmittedByIsSetCorrectly()
	{
		assertEquals(submittedBy, issueUpdate.getSubmittedBy());
	}
	
	@Test
	public void test_SubmittedByIsSetGreaterThanNegative2()
	{
		issueUpdateId = -1;
		issueId = -1;
		submittedBy = -2;
		submittedByUsername = "Freckles";
		updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		updateComment = "Blarg!";
		issueUpdate = new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment);
		
		assertTrue(issueUpdate.getSubmittedBy() > -2);
	}
	
	@Test
	public void test_IssueUpdateHasSubmittedByUsername()
	{
		assertNotNull(issueUpdate.getSubmittedByUsername());
	}
	
	@Test
	public void test_SubmittedByUsernameIsSetCorrectly()
	{
		assertEquals(submittedByUsername, issueUpdate.getSubmittedByUsername());
	}
	
	@Test
	public void test_SubmittedByUsernameIsThirtyCharactersOrLess()
	{
		issueUpdateId = -1;
		issueId = -1;
		submittedBy = -2;
		submittedByUsername = "ManagementIsTheBestIKnowRightYaYa";
		updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		updateComment = "Blarg!";
		issueUpdate = new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment);
		
		assertTrue(issueUpdate.getSubmittedByUsername().length() < 31);
	}
	
	@Test
	public void test_IssueUpdateHasUpdateDate()
	{
		
		assertNotNull(issueUpdate.getUpdateDate());
	}
	
	@Test
	public void test_UpdateDateIsSetCorrectly()
	{
		assertEquals(updateDate, issueUpdate.getUpdateDate());
	}
	
	@Test
	public void test_IssueUpdateHasUpdateComment()
	{
		
		assertNotNull(issueUpdate.getUpdateComment());
	}
	
	@Test
	public void test_UpdateCommentIsSetCorrectly()
	{
		assertEquals(updateComment, issueUpdate.getUpdateComment());
	}
	
	@Test
	public void test_UpdateCommentIsThreeHundredCharactersOrLess()
	{
		issueUpdateId = -1;
		issueId = -1;
		submittedBy = -2;
		submittedByUsername = "Freckles";
		updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		updateComment = "Blarg!";
		issueUpdate = new IssueUpdate(issueUpdateId, issueId, submittedBy, submittedByUsername, updateDate, updateComment);
		
		assertTrue(issueUpdate.getUpdateComment().length() < 301);
	}

	
	
	
	
}
