package com.fdmgroup.demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Form Servlet Page</title></head>");
		out.println("<body>");
			out.println("<p>");
				out.println( "Your first name is: " + request.getParameter("firstName") );
			out.println("</p>");
			out.println("<p>");
				out.println( "Your last name is: " + request.getParameter("lastName") );
			out.println("</p>");
			out.println("<p>");
				out.println( "Your age is: " + request.getParameter("age") );
			out.println("</p>");
			out.println("<p>");
				out.println( "Your age in 20 years is: " + (Integer.parseInt(request.getParameter("age"))+20) );
			out.println("</p>");
		out.println("</body>");
			
	}

}
