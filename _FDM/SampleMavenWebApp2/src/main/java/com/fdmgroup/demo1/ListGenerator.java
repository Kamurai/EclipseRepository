package com.fdmgroup.demo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListGenerator
 */
public class ListGenerator extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<?> list;
		
		if(new Random().nextBoolean())
		{
			List<String> strings = new ArrayList<>();
			strings.add("bean");
			strings.add("string");
			strings.add("corn");
			strings.add("lima");
			strings.add("black eyed peas");
			strings.add("Chandan");
			list = strings;
		}
		else
		{
			List<Boolean> booleans = new LinkedList<>();
			booleans.add(true);
			booleans.add(true);
			booleans.add(true);
			booleans.add(false);
			booleans.add(false);
			booleans.add(false);
			
			list = booleans;
		}
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listPrinter");
		dispatcher.forward(request,  response);

	}

}
