package com.fdmgroup.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//This handles routing / mapping
@Controller
public class NavigationController 
{
	@RequestMapping(value="/")
	public String navigateToRoot(HttpServletRequest request , HttpSession session)
	{
		return "Index";
	}
	
	@RequestMapping(value="/Index")
	public String navigateToIndex(HttpServletRequest request , HttpSession session)
	{
		return "Index";
	}
	
	@RequestMapping(value="/Success")
	public String navigateToSuccess(HttpServletRequest request , HttpSession session)
	{
		return "Success";
	}
	
	@RequestMapping(value="/Failure")
	public String navigateToFailure(HttpServletRequest request , HttpSession session)
	{
		return "Failure";
	}
	
}
