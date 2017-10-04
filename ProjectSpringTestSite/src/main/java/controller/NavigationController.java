package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//This handles routing / mapping
@Controller
public class NavigationController 
{
	@RequestMapping(value="/")
	public String navigateToMain(HttpServletRequest request , HttpSession session)
	{
		
		return "Index";
	}
	
	@RequestMapping(value="/Index")
	public String navigateToMainIndex(HttpServletRequest request , HttpSession session)
	{
		return "Index";
	}
	
	@RequestMapping(value="/AboutUs")
	public String navigateToMainAboutUs(HttpServletRequest request , HttpSession session)
	{
		return "AboutUs";
	}
	
	@RequestMapping(value="/Media")
	public String navigateToMainMedia(HttpServletRequest request , HttpSession session)
	{
		return "Media";
	}
	
	@RequestMapping(value="/Minecraft")
	public String navigateToMainMinecraft(HttpServletRequest request , HttpSession session)
	{
		return "Minecraft";
	}
	
	@RequestMapping(value="/Section1/Index")
	public String navigateToSection1Index(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Index";
	}
	
	@RequestMapping(value="/Section1/Section2/Index")
	public String navigateToSection1_2Index(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section2/Index";
	}
	
	@RequestMapping(value="/Section1/Section4/Index")
	public String navigateToSection1_4Index(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section4/Index";
	}
	
	@RequestMapping(value="/Section1/Section5/Index")
	public String navigateToSection1_5Index(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section5/Index";
	}
	
	@RequestMapping(value="/Section1/Section6/Index")
	public String navigateToSection1_6Index(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section6/Index";
	}
	
	@RequestMapping(value="/Section1/Section6/Project1")
	public String navigateToSection1_6Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section6/Project1";
	}
	
	@RequestMapping(value="/Section1/Section6/Project2")
	public String navigateToSection1_6Project2(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section6/Project2";
	}
	
	@RequestMapping(value="/Section1/Section6/Project3")
	public String navigateToSection1_6Project3(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section6/Project3";
	}
	
	@RequestMapping(value="/Section1/Section6/Project4")
	public String navigateToSection1_6Project4(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section6/Project4";
	}
	
	@RequestMapping(value="/Section1/Section6/Project5")
	public String navigateToSection1_6Project5(HttpServletRequest request , HttpSession session)
	{
		return "Section1/Section6/Project5";
	}
	
	@RequestMapping(value="/Section2/Index")
	public String navigateToSection2Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Index";
	}
	
	@RequestMapping(value="/Section2/Project2")
	public String navigateToSection2Project2(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project2";
	}
	
	@RequestMapping(value="/Section2/Project3")
	public String navigateToSection2Project3(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project3";
	}
	
	@RequestMapping(value="/Section2/Project6")
	public String navigateToSection2Project6(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project6";
	}
	
	@RequestMapping(value="/Section2/Project7")
	public String navigateToSection2Project7(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project7";
	}
	
	@RequestMapping(value="/Section2/Project8")
	public String navigateToSection2Project8(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project8";
	}
	
	@RequestMapping(value="/Section2/Project9")
	public String navigateToSection2Project9(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project9";
	}
	
	@RequestMapping(value="/Section2/Project10")
	public String navigateToSection2Project10(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project10";
	}
	
	@RequestMapping(value="/Section2/Project11")
	public String navigateToSection2Project11(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project11";
	}
	
	@RequestMapping(value="/Section2/Project12")
	public String navigateToSection2Project12(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project12";
	}
	
	@RequestMapping(value="/Section2/Project13")
	public String navigateToSection2Project13(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project13";
	}
	
	@RequestMapping(value="/Section2/Project14")
	public String navigateToSection2Project14(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Project14";
	}
		
	@RequestMapping(value="/Section2/Section1/Index")
	public String navigateToSection2_1Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section1/Index";
	}
	
	@RequestMapping(value="/Section2/Section1/Project1")
	public String navigateToSection2_1Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section1/Project1";
	}
	
	@RequestMapping(value="/Section2/Section1/Project2")
	public String navigateToSection2_1Project2(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section1/Project2";
	}
	
	@RequestMapping(value="/Section2/Section1/Project3")
	public String navigateToSection2_1Project3(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section1/Project3";
	}
	
	@RequestMapping(value="/Section2/Section4/Index")
	public String navigateToSection2_4Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section4/Index";
	}
	
	@RequestMapping(value="/Section2/Section4/Project1")
	public String navigateToSection2_4Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section1/Project1";
	}
	
	@RequestMapping(value="/Section2/Section4/Project2")
	public String navigateToSection2_4Project2(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section4/Project2";
	}
	
	@RequestMapping(value="/Section2/Section5/Index")
	public String navigateToSection2_5Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Index";
	}
	
	@RequestMapping(value="/Section2/Section5/Section1/Index")
	public String navigateToSection2_5_1Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section1/Index";
	}
	
	@RequestMapping(value="/Section2/Section5/Section1/Project1")
	public String navigateToSection2_5_1Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section1/Project1";
	}
	
	@RequestMapping(value="/Section2/Section5/Section1/Project2")
	public String navigateToSection2_5_1Project2(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section1/Project2";
	}
	
	@RequestMapping(value="/Section2/Section5/Section1/Project3")
	public String navigateToSection2_5_1Project3(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section1/Project3";
	}
	
	@RequestMapping(value="/Section2/Section5/Section1/Project4")
	public String navigateToSection2_5_1Project4(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section1/Project4";
	}
	
	@RequestMapping(value="/Section2/Section5/Section1/Project5")
	public String navigateToSection2_5_1Project5(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section1/Project5";
	}
	
	@RequestMapping(value="/Section2/Section5/Section1/Project6")
	public String navigateToSection2_5_1Project6(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section1/Project6";
	}
	
	@RequestMapping(value="/Section2/Section5/Section2/Index")
	public String navigateToSection2_5_2Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section2/Index";
	}
	
	@RequestMapping(value="/Section2/Section5/Section2/Project1")
	public String navigateToSection2_5_2Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section2/Project1";
	}
	
	@RequestMapping(value="/Section2/Section5/Section2/Project2")
	public String navigateToSection2_5_2Project2(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section2/Project2";
	}
	
	@RequestMapping(value="/Section2/Section5/Section3/Index")
	public String navigateToSection2_5_3Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section3/Index";
	}
	
	@RequestMapping(value="/Section2/Section5/Section3/Project1")
	public String navigateToSection2_5_3Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section3/Project1";
	}
	
	@RequestMapping(value="/Section2/Section5/Section4/Index")
	public String navigateToSection2_5_4Index(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section4/Index";
	}
	
	@RequestMapping(value="/Section2/Section5/Section4/Project1")
	public String navigateToSection2_5_4Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section2/Section5/Section4/Project1";
	}
	
	@RequestMapping(value="/Section3/Index")
	public String navigateToSection3Index(HttpServletRequest request , HttpSession session)
	{
		return "Section3/Index";
	}
	
	@RequestMapping(value="/Section3/Project1")
	public String navigateToSection3Project1(HttpServletRequest request , HttpSession session)
	{
		return "Section3/Project1";
	}
	
	@RequestMapping(value="/Section3/Project2")
	public String navigateToSection3Project2(HttpServletRequest request , HttpSession session)
	{
		return "Section3/Project2";
	}
	
	@RequestMapping(value="/Section3/Project3")
	public String navigateToSection3Project3(HttpServletRequest request , HttpSession session)
	{
		return "Section3/Project3";
	}
	
	@RequestMapping(value="/Section3/Project4")
	public String navigateToSection3Project4(HttpServletRequest request , HttpSession session)
	{
		return "Section3/Project4";
	}
	
	@RequestMapping(value="/Section3/Project5")
	public String navigateToSection3Project5(HttpServletRequest request , HttpSession session)
	{
		return "Section3/Project5";
	}
	
	
	
}
