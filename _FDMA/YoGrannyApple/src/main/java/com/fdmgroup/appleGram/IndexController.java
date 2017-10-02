package com.fdmgroup.appleGram;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public String goToRootPage(HttpServletRequest request , HttpSession session){
		
		return "index";
	}
	
	@RequestMapping(value="/index")
	public String goToIndex(HttpServletRequest request , HttpSession session){
		return "index";
	}
}
