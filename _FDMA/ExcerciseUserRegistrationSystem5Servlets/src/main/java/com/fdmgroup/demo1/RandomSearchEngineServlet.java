package com.fdmgroup.demo1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomSearchEngineServlet
 */
public class RandomSearchEngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final Set<String> searchEngines;
	
	{
		searchEngines = new HashSet<>();
		searchEngines.add("http://www.google.com");
		searchEngines.add("http://www.bing.com");
		searchEngines.add("http://www.yahoo.com");
		searchEngines.add("http://www.daum.net");
	}
	
	private final Random rand = new Random();
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RandomSearchEngineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String serachEngineURL;
		int randNum = rand.nextInt(4);
		String searchEngineURL = searchEngines.toArray(new String[4])[randNum];
		
		response.sendRedirect(searchEngineURL);
	}


}
