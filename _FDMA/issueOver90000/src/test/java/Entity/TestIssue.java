package Entity;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.IssueUpdate;
import com.fdmgroup.Entity.User;




public class TestIssue 
{
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
	private Issue issue;
	private int deptId;
	private String deptName;
	
	@Before
	public void SetUp()
	{
		issueId = 1;
		title = "title";
		userDescription = "userDescription1";
		adminComment = "adminComment1";
		assignedTo = 1;
		assignedToUsername = "Elektra.Nachios";
		submittedBy = 3;
		submittedByUsername = "Peter.Parker";
		statusId = 1;
		status = "In progress";
		priority = 1;
		dateSubmitted = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		dateResolved = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		List<IssueUpdate> issueUpdateList = new ArrayList<IssueUpdate>();
		deptId = 0;
		deptName = "Rangers";
		
		issue = new Issue(issueId, title, userDescription, adminComment, assignedTo, assignedToUsername, submittedBy, submittedByUsername, statusId, status, priority, dateSubmitted, dateResolved, issueUpdateList, deptId, deptName );
	}
	
	@After
	public void TearDown()
	{
	}
	
	
	@Test
	public void test_getAdminCommentReturnsNotNull()
	{
		assertNotNull(issue.getAdminComment());

	}
	@Test
	public void test_getAssignedToReturnsNotNull()
	{
		assertNotNull(issue.getAssignedTo());

	}
	@Test
	public void test_getDateResolvedReturnsNotNull()
	{
		assertNotNull(issue.getDateResolved());

	}
	@Test
	public void test_getDateSubmittedReturnsNotNull()
	{
		assertNotNull(issue.getDateSubmitted());

	}
	@Test
	public void test_getIssueIdReturnsNotNull()
	{
		assertNotNull(issue.getIssueId());

	}
	@Test
	public void test_getPriorityReturnsNotNull()
	{
		assertNotNull(issue.getPriority());

	}
	@Test
	public void test_getStatusIdReturnsNotNull()
	{
		assertNotNull(issue.getStatusId());

	}
	@Test
	public void test_getSubmittedByReturnsNotNull()
	{
		assertNotNull(issue.getSubmittedBy());

	}
	@Test
	public void test_getTitleByReturnsNotNull()
	{
		assertNotNull(issue.getTitle());

	}
	@Test
	public void test_getUserDescriptionByReturnsNotNull()
	{
		assertNotNull(issue.getUserDescription());

	}

}
