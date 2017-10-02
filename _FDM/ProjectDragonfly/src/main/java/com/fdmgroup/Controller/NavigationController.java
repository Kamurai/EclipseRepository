package com.fdmgroup.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.DAO.DepartmentDAO;
import com.fdmgroup.DAO.IssueDAO;
import com.fdmgroup.DAO.IssueUpdateDAO;
import com.fdmgroup.DAO.StatusDAO;
import com.fdmgroup.DAO.IssueDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.Issue;
import com.fdmgroup.Entity.IssueUpdate;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Services.IssueServices;
import com.fdmgroup.Services.LoginServices;
import com.fdmgroup.Services.RegistrationServices;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Controller
public class NavigationController {
	
	
	@RequestMapping(value="/")
	public String goToIndexPage(HttpServletRequest request,HttpSession session){
		return "Homepage";
	}
	
	
	
	@RequestMapping(value="/login", method=POST)
	public String navigateToViewIssueFromLogin(HttpSession session, HttpServletRequest request, Model model){
		UserDAO userDAO = new UserDAO();
		IssueDAO issueDAO = new IssueDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		LoginServices loginservices = new LoginServices(userDAO);
		if(loginservices.login(username, password) == true ){
			User sessionUser = userDAO.getUserByUsername(username);
			session.setAttribute("user", sessionUser);
			System.out.println(sessionUser.getUserId());
			model.addAttribute("basicIssueList", issueDAO.getIssuesBySubmittedBy(sessionUser.getUserId()) );

			return "ViewIssues";
		}else{
			return "LoginError";
		}
	}
	

	
	@RequestMapping(value="/register")
	public String navigateToRegister(HttpSession session, Model model){
		DepartmentDAO deptDAO = new DepartmentDAO();
		model.addAttribute("deptList", deptDAO.getDepartments());

		return "Register";
	}
	@RequestMapping(value="/register", method=POST)
	public String navigateToLoginFromRegister(HttpSession session, HttpServletRequest request, Model model){
		UserDAO userDAO = new UserDAO();
		RegistrationServices regServices = new RegistrationServices(userDAO);		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		String deptString =  request.getParameter("department");
		int deptID = Integer.parseInt(deptString);
		DepartmentDAO deptDAO = new DepartmentDAO();
		Department dept = deptDAO.getDepartmentById(deptID);
		List<Department> deptList = new ArrayList<Department>();
		deptList.add(dept);
		User user = new User(deptList, username, password, email);

		
		if(regServices.register(user, confirmPassword) == true){
			return "RegisterLogin";

		}
		else{
			return "RegisterError";
			
		}
		
	}
	@RequestMapping(value="/viewissues")
	public String navigateToBasicUsersViewIssuesPage(HttpSession session, Model model){
		IssueDAO issueDAO = new IssueDAO();
		User sessionUser = (User) session.getAttribute("user");
		model.addAttribute("basicIssueList", issueDAO.getIssuesBySubmittedBy(sessionUser.getUserId()) );
		List<Issue> listIssue = issueDAO.getIssuesBySubmittedBy(sessionUser.getUserId());
		System.out.println(sessionUser.getUserId());
		System.out.println(listIssue.toString());


		return "ViewIssues";
	}
	
	@RequestMapping(value="/deptissues")
	public String navigateToDeptAdminIssues(HttpSession session, Model model){
//		IssueServices issueServices = new IssueServices();
		User sessionUser = (User) session.getAttribute("user");
		IssueDAO issueDAO = new IssueDAO();

		model.addAttribute("deptIssueList", issueDAO.getIssuesByAssignedTo(sessionUser.getUserId()));

		return "DeptIssues";
	}
	
	@RequestMapping(value="/genissues")
	public String navigateToGenAdminIssues(HttpSession session, Model model){
		IssueServices issueServices = new IssueServices();
		User sessionUser = (User) session.getAttribute("user");
		IssueDAO issueDAO = new IssueDAO();
		List<Issue> issueListForNonGenAdmin = new ArrayList<Issue>();

		if(issueServices.checkIfGeneralAdmin(sessionUser)){
		model.addAttribute("genIssueList", issueDAO.getIssuesByUnassigned());
		
		}else{
			model.addAttribute("genIssueList", issueListForNonGenAdmin);

		}

		return "GenIssues";
	}
	@RequestMapping(value="/newissue")
	public String navigateToNewIssue(HttpSession session, Model model){
		DepartmentDAO deptDAO = new DepartmentDAO();
		model.addAttribute("deptList", deptDAO.getDepartments());
		

		return "NewIssue";
	}
//	This allows you to submit the page 
	@RequestMapping(value="/submitissue", method=POST)
	public String navigateFromNewIssueToSubmitIssueToBasicViewIssuesPage(HttpSession session, HttpServletRequest request, Model model){
		User sessionUser = (User) session.getAttribute("user");
		IssueDAO issueDAO = new IssueDAO();
		DepartmentDAO deptDAO = new DepartmentDAO();
		IssueServices issueServices = new IssueServices();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String priorityString = request.getParameter("priority");
		int priority = Integer.parseInt(priorityString);
		String deptString =  request.getParameter("department");
		int deptID = Integer.parseInt(deptString);
		Date issueDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());

		if(issueServices.checkIfDataIsValidForNewIssue(title, description, priority, deptID)==false){
			return "NewIssueError";
		}
		Issue newIssue = new Issue(title, description, sessionUser.getUserId(), priority, issueDate, deptID, deptDAO.getDepartmentById(deptID).getDeptName() );
		issueDAO.addIssue(newIssue);
		Department dept = deptDAO.getDepartmentById(deptID);
		List<Department> deptList = new ArrayList<Department>();
		deptList.add(dept);
		
//		Issue issue = new Issue(tbc...
		model.addAttribute("basicIssueList", issueDAO.getIssuesBySubmittedBy(sessionUser.getUserId()) );


		return "ViewIssues";
	}

//	work in progress below
//	This will take you to a corresponding page for the issue you are selecting to be updated
	@RequestMapping(value="/updateissue", method=GET)
	public String navigateToUpdateIssue(HttpSession session, HttpServletRequest request, Model model){
		Issue issueForUpdateIssuePage = new Issue();
		StatusDAO statusDAO = new StatusDAO();
		DepartmentDAO deptDAO = new DepartmentDAO();
		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
		User sessionUser = (User) session.getAttribute("user");
		String issueIdString =  request.getParameter("issueId");
		int issueId = Integer.parseInt(issueIdString);
		
		IssueDAO issueDAO = new IssueDAO();
		List<Issue> issueList = issueDAO.getIssuesBySubmittedBy(sessionUser.getUserId());
		
		for(Issue i : issueList){
			if(i.getIssueId()==issueId){
				issueForUpdateIssuePage = i;
			}
					
		}
		List<IssueUpdate> issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueForUpdateIssuePage.getIssueId());
		
		
		List<Integer> statusIDList = new ArrayList<Integer>();
		List<String> statusStringList = new ArrayList<String>();
		System.out.println(statusDAO.getStatuss());
		model.addAttribute("statusList", statusDAO.getStatuss());
		model.addAttribute("deptList", deptDAO.getDepartments());
		model.addAttribute("issue", issueForUpdateIssuePage);
		model.addAttribute("issueUpdateList", issueUpdateList);
		return "IssueUpdate";
	}
//	work in progress below
//	This redirects to the basic update issue page after a comment is submitted
//	@RequestMapping(value="/updateissuecomment", method=POST)
//	public ModelAndView addIssueUpdateCommentForBasicIssue(HttpSession session, HttpServletRequest request, Model model){
////		Making the needed DAO and Issue to be used for model for redirect
//		Issue issueForUpdateIssuePage = new Issue();
//		IssueDAO issueDAO = new IssueDAO();
//		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
////		Getting the parameters from the model to be used
//		User sessionUser = (User) session.getAttribute("user");
//		String issueUpdateComment =  request.getParameter("issueUpdateComment");
//		String issueIdString =  request.getParameter("issueId");
//		int issueId = Integer.parseInt(issueIdString);
//		int userID = sessionUser.getUserId();
//		String username = sessionUser.getUsername();
//		Date updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
////		Using Params to make the issueUpdate
//		IssueUpdate issueUpdateWithComment = new IssueUpdate(issueId, userID, username, updateDate, issueUpdateComment);
////		adding the issueUpdate and making the issue and update list to be used 
////		for model for redirect
//		issueUpdateDAO.addIssueUpdate(issueUpdateWithComment);
//		issueForUpdateIssuePage = issueDAO.getIssueById(issueId);
//		List<IssueUpdate> issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueForUpdateIssuePage.getIssueId());
////		Sending the stuff to the model for the redirect
//		model.addAttribute("issue", issueForUpdateIssuePage);
//		model.addAttribute("issueUpdateList", issueUpdateList);
////		returning the redirect
//		return new ModelAndView("redirect:/updateissue");
//	}
	@RequestMapping(value="/addcomment", method=POST)
	public String addIssueUpdateCommentForBasicIssue(HttpSession session, HttpServletRequest request, Model model){
//		Making the needed DAO and Issue to be used for model for redirect
		Issue issueForUpdateIssuePage = new Issue();
		IssueDAO issueDAO = new IssueDAO();
		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
//		Getting the parameters from the model to be used
		User sessionUser = (User) session.getAttribute("user");
		String issueUpdateComment =  request.getParameter("description");
		String issueIdString =  request.getParameter("issueId");
		System.out.println(issueIdString);
		int issueId = Integer.parseInt(issueIdString);
		System.out.println(issueId);
		int userID = sessionUser.getUserId();
		String username = sessionUser.getUsername();
		Date updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
//		Using Params to make the issueUpdate
		IssueUpdate issueUpdateWithComment = new IssueUpdate(issueId, userID, username, updateDate, issueUpdateComment);
//		adding the issueUpdate and making the issue and update list to be used 
//		for model for redirect
		System.out.println(issueUpdateWithComment);
		issueUpdateDAO.addIssueUpdate(issueUpdateWithComment);
		
		issueForUpdateIssuePage = issueDAO.getIssueById(issueId);
		List<IssueUpdate> issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueForUpdateIssuePage.getIssueId());
//		Sending the stuff to the model for the redirect
//		model.addAttribute("issue", issueForUpdateIssuePage);
//		model.addAttribute("issueUpdateList", issueUpdateList);
		model.addAttribute("basicIssueList", issueDAO.getIssuesBySubmittedBy(sessionUser.getUserId()) );
//		returning the redirect
		return "ViewIssues";
	}
//	This method is to direct to the basicviewIssues page for user after they approve a resolved comment
	@RequestMapping(value="/updateissue", method=POST)
	public String navigateToViewIssuesPageAfterYouApproveResolvedComments(HttpSession session, HttpServletRequest request, Model model){
		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
		IssueDAO issueDAO = new IssueDAO();
		User sessionUser = (User) session.getAttribute("user");
		String issueIdString = request.getParameter("issueId");
		int issueId = Integer.parseInt(issueIdString);
		
//		for the dept admin this needs to be changed to assignedto meth
		model.addAttribute("basicIssueList", issueDAO.getIssuesBySubmittedBy(issueId) );

		return "ViewIssues";
	}
//	@RequestMapping(value="/logout")
//	public String logoutAndGoToTheLogin(HttpServletRequest request,HttpSession session){
//		session.invalidate();
//		return "Homepage";
//	}
////	work in progress below
////	This redirects to the dept update issue page after a comment is submitted
//	@RequestMapping(value="/updateissuecomment", method=POST)
//	public ModelAndView addIssueUpdateCommentForDeptIssue(HttpSession session, HttpServletRequest request, Model model){
////		Making the needed DAO and Issue to be used for model for redirect
//		Issue issueForUpdateIssuePage = new Issue();
//		IssueDAO issueDAO = new IssueDAO();
//		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
////		Getting the parameters from the model to be used
//		User sessionUser = (User) session.getAttribute("user");
//		String issueUpdateComment =  request.getParameter("issueUpdateComment");
//		String issueIdString =  request.getParameter("issueId");
//		int issueId = Integer.parseInt(issueIdString);
//		int userID = sessionUser.getUserId();
//		String username = sessionUser.getUsername();
//		Date updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
////		Using Params to make the issueUpdate
//		IssueUpdate issueUpdateWithComment = new IssueUpdate(issueId, userID, username, updateDate, issueUpdateComment);
////		adding the issueUpdate and making the issue and update list to be used 
////		for model for redirect
//		issueUpdateDAO.addIssueUpdate(issueUpdateWithComment);
//		issueForUpdateIssuePage = issueDAO.getIssueById(issueId);
//		List<IssueUpdate> issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueForUpdateIssuePage.getIssueId());
////		Sending the stuff to the model for the redirect
//		model.addAttribute("issue", issueForUpdateIssuePage);
//		model.addAttribute("issueUpdateList", issueUpdateList);
////		returning the redirect
//		
//		
//		
////		HOLDER!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		return new ModelAndView("redirect:/deptissues");
//	}
//	
////	This method is to direct to the basicviewIssues page for user after they approve a resolved comment
//	
//	
//	
//	
////	HOLDER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	@RequestMapping(value="/deptupdateissue", method=POST)
//	public String navigateToDeptIssuesPageAfterYouApproveResolvedComments(HttpSession session, HttpServletRequest request, Model model){
//		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
//		IssueDAO issueDAO = new IssueDAO();
//		User sessionUser = (User) session.getAttribute("user");
//		String issueIdString = request.getParameter("issueId");
//		int issueId = Integer.parseInt(issueIdString);
//		
////		for the dept admin this needs to be changed to assignedto meth
//		model.addAttribute("deptIssueList", issueDAO.getIssuesByAssignedTo(issueId));
//		return "ViewIssues";
//	}
	@RequestMapping(value="/deptissueupdate", method=GET)
	public String navigateToUpdateIssueForDept(HttpSession session, HttpServletRequest request, Model model){
		Issue issueForUpdateIssuePage = new Issue();
		StatusDAO statusDAO = new StatusDAO();
		DepartmentDAO deptDAO = new DepartmentDAO();
		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
		User sessionUser = (User) session.getAttribute("user");
		String issueIdString =  request.getParameter("issueId");
		int issueId = Integer.parseInt(issueIdString);
		
		IssueDAO issueDAO = new IssueDAO();
		List<Issue> issueList = issueDAO.getIssuesByAssignedTo(sessionUser.getUserId());
		
		for(Issue i : issueList){
			if(i.getIssueId()==issueId){
				issueForUpdateIssuePage = i;
			}
					
		}
		List<IssueUpdate> issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueForUpdateIssuePage.getIssueId());
		
		
		List<Integer> statusIDList = new ArrayList<Integer>();
		List<String> statusStringList = new ArrayList<String>();
		System.out.println(statusDAO.getStatuss());
		model.addAttribute("statusList", statusDAO.getStatuss());
		model.addAttribute("deptList", deptDAO.getDepartments());
		model.addAttribute("issue", issueForUpdateIssuePage);
		model.addAttribute("issueUpdateList", issueUpdateList);
		return "IssueUpdate";
	}
	@RequestMapping(value="/addcommentdept", method=POST)
	public String addIssueUpdateCommentForDeptIssue(HttpSession session, HttpServletRequest request, Model model){
//		Making the needed DAO and Issue to be used for model for redirect
		Issue issueForUpdateIssuePage = new Issue();
		IssueDAO issueDAO = new IssueDAO();
		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
//		Getting the parameters from the model to be used
		User sessionUser = (User) session.getAttribute("user");
		String issueUpdateComment =  request.getParameter("description");
		String issueIdString =  request.getParameter("issueId");
		int issueId = Integer.parseInt(issueIdString);
		int userID = sessionUser.getUserId();
		String username = sessionUser.getUsername();
		Date updateDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
//		Using Params to make the issueUpdate
		IssueUpdate issueUpdateWithComment = new IssueUpdate(issueId, userID, username, updateDate, issueUpdateComment);
//		adding the issueUpdate and making the issue and update list to be used 
//		for model for redirect
		issueUpdateDAO.addIssueUpdate(issueUpdateWithComment);
		
		issueForUpdateIssuePage = issueDAO.getIssueById(issueId);
		List<IssueUpdate> issueUpdateList = issueUpdateDAO.getIssueUpdatesByIssueId(issueForUpdateIssuePage.getIssueId());
//		Sending the stuff to the model for the redirect
//		model.addAttribute("issue", issueForUpdateIssuePage);
//		model.addAttribute("issueUpdateList", issueUpdateList);
		model.addAttribute("deptIssueList", issueDAO.getIssuesByAssignedTo(sessionUser.getUserId()) );
//		returning the redirect
		return "DeptIssues";
	}
	@RequestMapping(value="/updateissuedept", method=POST)
	public String navigateToViewIssuesPageMarkResolvedCommentsDept(HttpSession session, HttpServletRequest request, Model model){
		IssueUpdateDAO issueUpdateDAO = new IssueUpdateDAO();
		IssueDAO issueDAO = new IssueDAO();
		User sessionUser = (User) session.getAttribute("user");
		String issueIdString = request.getParameter("issueId");
		int issueId = Integer.parseInt(issueIdString);
		
//		for the dept admin this needs to be changed to assignedto meth
		model.addAttribute("deptIssueList", issueDAO.getIssuesByAssignedTo(issueId) );

		return "DeptIssues";
	}
}
