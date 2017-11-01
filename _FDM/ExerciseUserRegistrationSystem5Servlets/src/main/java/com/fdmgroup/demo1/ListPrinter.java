package com.fdmgroup.demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListPrinter
 */
public class ListPrinter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPrinter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<?> list = (List<?>) request.getAttribute("list");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Form Servlet Page</title></head>");
		out.println("<body>");
			out.println("<ol>");
			for(int x = 0; x < list.size(); x++)
			{
				out.println("<li>");
					out.println(list.get(x));
				out.println("</li>");
			}
				
				
			out.println("</ol>");
		out.println("</body>");
		
		
	}

}
