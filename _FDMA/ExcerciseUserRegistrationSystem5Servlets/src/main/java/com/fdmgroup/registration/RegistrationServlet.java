package com.fdmgroup.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	RegistrationController dbRegister;
	String username, firstname, lastname, email, password;
	
	ReadCommand dbReader;
	WriteCommand dbWriter;
	UserFactory factory;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() 
    {
        super();
        dbReader = new DBReadCommand();
		dbWriter = new DBWriteCommand();
		factory = new UserFactory();
		dbRegister = new RegistrationController(dbReader, dbWriter, factory);
		
		username = "";
		firstname = "";
		lastname = "";
		email = "";
		password = "";
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		username = request.getParameter("username");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		try 
		{
			dbRegister.registerNewUser(username, firstname, lastname, email, password);
		}
		catch (UserNotWrittenException e) 
		{
			//redirect to error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Error.jsp");
			//dispatcher.forward(request,  response);
		} 
		catch (UserNotReadException e) 
		{
			//redirect to error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Error.jsp");
			dispatcher.forward(request,  response);
		} 
		catch (UsernameIsTakenException e) 
		{
			//redirect to error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Error.jsp");
			dispatcher.forward(request,  response);
		}
		
		User testUser = new User();
		testUser = dbRegister.getUser(username);
		
		if( testUser == null )
		{
			//redirect to error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Error.jsp");
			dispatcher.forward(request,  response);
		}
		
		if( testUser.getUsername().equals(null) ||
			testUser.getFirstname().equals(null) ||
			testUser.getLastname().equals(null) ||
			testUser.getEmail().equals(null) ||
			testUser.getPassword().equals(null)
			)
		{
			//redirect to error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Error.jsp");
			dispatcher.forward(request,  response);
		}
			
		
		
		if( testUser.getUsername().equals(username) )
		{
			//redirect to success page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Success.jsp");
			request.setAttribute("newUser", testUser);
			dispatcher.forward(request,  response);
		}
		else
		{
			//redirect to error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Error.jsp");
			dispatcher.forward(request,  response);
		}
		
	}

}
