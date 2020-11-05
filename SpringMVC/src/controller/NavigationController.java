package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//This handles routing / mapping
@Controller
public class NavigationController {
	@RequestMapping("/")
	public String navigateToMain(HttpServletRequest request, HttpSession session) {
		return "Index";
	}

	@RequestMapping("/Index")
	public String navigateToMainIndex(HttpServletRequest request, HttpSession session) {
		return "Index";
	}
	
	@RequestMapping("/Picture")
	public String navigateToLogo(HttpServletRequest request, HttpSession session) {
		return "Pictures/logoHTKB";
	}

	@RequestMapping("/AboutUs")
	public String navigateToMainAboutUs(HttpServletRequest request, HttpSession session) {
		return "AboutUs";
	}

	@RequestMapping(value = "/Media")
	public String navigateToMainMedia(HttpServletRequest request, HttpSession session) {
		return "Media";
	}

	@RequestMapping(value = "/GitHubs")
	public String navigateToMainGitHubs(HttpServletRequest request, HttpSession session) {
		return "GitHubs";
	}

	@RequestMapping(value = "/WebApps")
	public String navigateToMainWebApps(HttpServletRequest request, HttpSession session) {
		return "WebApps";
	}

	@RequestMapping(value = "/Division1/Index")
	public String navigateToDivision1Index(HttpServletRequest request, HttpSession session) {
		return "Division1/Index";
	}

	@RequestMapping(value = "/Division1/Project1")
	public String navigateToDivision1Project1(HttpServletRequest request, HttpSession session) {
		return "Division1/Project1";
	}

	@RequestMapping(value = "/Division1/Project2")
	public String navigateToDivision1Project2(HttpServletRequest request, HttpSession session) {
		return "Division1/Project2";
	}

	@RequestMapping(value = "/Division1/Project3")
	public String navigateToDivision1Project3(HttpServletRequest request, HttpSession session) {
		return "Division1/Project3";
	}

	@RequestMapping(value = "/Division1/Project4")
	public String navigateToDivision1Project4(HttpServletRequest request, HttpSession session) {
		return "Division1/Project4";
	}

	@RequestMapping(value = "/Division1/Project5")
	public String navigateToDivision1Project5(HttpServletRequest request, HttpSession session) {
		return "Division1/Project5";
	}

	@RequestMapping(value = "/Division1/Project6")
	public String navigateToDivision1Project6(HttpServletRequest request, HttpSession session) {
		return "Division1/Project6";
	}

	@RequestMapping(value = "/Division1/Project7")
	public String navigateToDivision1Project7(HttpServletRequest request, HttpSession session) {
		return "Division1/Project7";
	}

	@RequestMapping(value = "/Division1/Project8")
	public String navigateToDivision1Project8(HttpServletRequest request, HttpSession session) {
		return "Division1/Project8";
	}

	@RequestMapping(value = "/Division1/Project9")
	public String navigateToDivision1Project9(HttpServletRequest request, HttpSession session) {
		return "Division1/Project9";
	}

	@RequestMapping(value = "/Division1/Project10")
	public String navigateToDivision1Project10(HttpServletRequest request, HttpSession session) {
		return "Division1/Project10";
	}

	@RequestMapping(value = "/Division1/Project11")
	public String navigateToDivision1Project11(HttpServletRequest request, HttpSession session) {
		return "Division1/Project11";
	}

	@RequestMapping(value = "/Division1/Project12")
	public String navigateToDivision1Project12(HttpServletRequest request, HttpSession session) {
		return "Division1/Project12";
	}

	@RequestMapping(value = "/Division1/Project13")
	public String navigateToDivision1Project13(HttpServletRequest request, HttpSession session) {
		return "Division1/Project13";
	}

	@RequestMapping(value = "/Division1/Project14")
	public String navigateToDivision1Project14(HttpServletRequest request, HttpSession session) {
		return "Division1/Project14";
	}

	@RequestMapping(value = "/Division1/Project15")
	public String navigateToDivision1Project15(HttpServletRequest request, HttpSession session) {
		return "Division1/Project15";
	}

	@RequestMapping(value = "/Division1/Project16")
	public String navigateToDivision1Project16(HttpServletRequest request, HttpSession session) {
		return "Division1/Project16";
	}

	@RequestMapping(value = "/Division1/Project17")
	public String navigateToDivision1Project17(HttpServletRequest request, HttpSession session) {
		return "Division1/Project17";
	}

	@RequestMapping(value = "/Division1/Project18")
	public String navigateToDivision1Project18(HttpServletRequest request, HttpSession session) {
		return "Division1/Project18";
	}
	
	@RequestMapping(value = "/Division2/Index")
	public String navigateToDivision2Index(HttpServletRequest request, HttpSession session) {
		return "Division2/Index";
	}

	@RequestMapping(value = "/Division2/Project1")
	public String navigateToDivision2Project1(HttpServletRequest request, HttpSession session) {
		return "Division2/Project1";
	}

	@RequestMapping(value = "/Division2/Project2")
	public String navigateToDivision2Project2(HttpServletRequest request, HttpSession session) {
		return "Division2/Project2";
	}

	@RequestMapping(value = "/Division2/Project3")
	public String navigateToDivision2Project3(HttpServletRequest request, HttpSession session) {
		return "Division2/Project3";
	}
	
	@RequestMapping(value = "/Division2/Section1/Index")
	public String navigateToDivision2_1Index(HttpServletRequest request, HttpSession session) {
		return "Division2/Section1/Index";
	}

	@RequestMapping(value = "/Division2/Section1/Project1")
	public String navigateToDivision2_1Project1(HttpServletRequest request, HttpSession session) {
		return "Division2/Section1/Project1";
	}

	@RequestMapping(value = "/Division2/Section1/Project2")
	public String navigateToDivision2_1Project2(HttpServletRequest request, HttpSession session) {
		return "Division2/Section1/Project2";
	}

	@RequestMapping(value = "/Division3/Index")
	public String navigateToDivision3Index(HttpServletRequest request, HttpSession session) {
		return "Division3/Index";
	}

	@RequestMapping(value = "/Division3/Project1")
	public String navigateToDivision3Project1(HttpServletRequest request, HttpSession session) {
		return "Division3/Project1";
	}

	@RequestMapping(value = "/Division3/Project2")
	public String navigateToDivision3Project2(HttpServletRequest request, HttpSession session) {
		return "Division3/Project2";
	}

	@RequestMapping(value = "/Division3/Project3")
	public String navigateToDivision3Project3(HttpServletRequest request, HttpSession session) {
		return "Division3/Project3";
	}

	@RequestMapping(value = "/Division3/Project4")
	public String navigateToDivision3Project4(HttpServletRequest request, HttpSession session) {
		return "Division3/Project4";
	}

	@RequestMapping(value = "/Division3/Project5")
	public String navigateToDivision3Project5(HttpServletRequest request, HttpSession session) {
		return "Division3/Project5";
	}
	
	@RequestMapping(value = "/Division3/Section1/Index")
	public String navigateToDivision3_1Index(HttpServletRequest request, HttpSession session) {
		return "Division3/Section1/Index";
	}

	@RequestMapping(value = "/Division3/Section1/Project1")
	public String navigateToDivision3_1Project1(HttpServletRequest request, HttpSession session) {
		return "Division3/Section1/Project1";
	}

	@RequestMapping(value = "/Division3/Section1/Project2")
	public String navigateToDivision3_1Project2(HttpServletRequest request, HttpSession session) {
		return "Division3/Section1/Project2";
	}

	@RequestMapping(value = "/Division3/Section1/Project3")
	public String navigateToDivision3_1Project3(HttpServletRequest request, HttpSession session) {
		return "Division3/Section1/Project3";
	}

	@RequestMapping(value = "/Division3/Section1/Project4")
	public String navigateToDivision3_1Project4(HttpServletRequest request, HttpSession session) {
		return "Division3/Section1/Project4";
	}

	@RequestMapping(value = "/Division3/Section1/Project5")
	public String navigateToDivision3_1Project5(HttpServletRequest request, HttpSession session) {
		return "Division3/Section1/Project5";
	}
	
	@RequestMapping(value = "/Division3/Section2/Index")
	public String navigateToDivision3_2Index(HttpServletRequest request, HttpSession session) {
		return "Division3/Section2/Index";
	}

	@RequestMapping(value = "/Division3/Section2/Project1")
	public String navigateToDivision3_2Project1(HttpServletRequest request, HttpSession session) {
		return "Division3/Section2/Project1";
	}

	@RequestMapping(value = "/Division3/Section2/Project2")
	public String navigateToDivision3_2Project2(HttpServletRequest request, HttpSession session) {
		return "Division3/Section2/Project2";
	}
	
	@RequestMapping(value = "/Division4/Index")
	public String navigateToDivision4Index(HttpServletRequest request, HttpSession session) {
		return "Division4/Index";
	}

	@RequestMapping(value = "/Division4/Project1")
	public String navigateToDivision4Project1(HttpServletRequest request, HttpSession session) {
		return "Division4/Project1";
	}

	@RequestMapping(value = "/Division4/Project2")
	public String navigateToDivision4Project2(HttpServletRequest request, HttpSession session) {
		return "Division4/Project2";
	}

	@RequestMapping(value = "/Division4/Project3")
	public String navigateToDivision4Project3(HttpServletRequest request, HttpSession session) {
		return "Division4/Project3";
	}

	@RequestMapping(value = "/Division4/Project4")
	public String navigateToDivision4Project4(HttpServletRequest request, HttpSession session) {
		return "Division4/Project4";
	}

	@RequestMapping(value = "/Division4/Project5")
	public String navigateToDivision4Project5(HttpServletRequest request, HttpSession session) {
		return "Division4/Project5";
	}
	
	@RequestMapping(value = "/Division5/Index")
	public String navigateToDivision5Index(HttpServletRequest request, HttpSession session) {
		return "Division5/Index";
	}

	@RequestMapping(value = "/Division5/Project1")
	public String navigateToDivision5Project1(HttpServletRequest request, HttpSession session) {
		return "Division5/Project1";
	}

	@RequestMapping(value = "/Division5/Project2")
	public String navigateToDivision5Project2(HttpServletRequest request, HttpSession session) {
		return "Division5/Project2";
	}

	@RequestMapping(value = "/Division5/Project3")
	public String navigateToDivision5Project3(HttpServletRequest request, HttpSession session) {
		return "Division5/Project3";
	}

	@RequestMapping(value = "/Division5/Project4")
	public String navigateToDivision5Project4(HttpServletRequest request, HttpSession session) {
		return "Division5/Project4";
	}

	@RequestMapping(value = "/Division5/Project5")
	public String navigateToDivision5Project5(HttpServletRequest request, HttpSession session) {
		return "Division5/Project5";
	}
	
	@RequestMapping(value = "")
	public String navigateToMainByEmpty(HttpServletRequest request, HttpSession session) {

		return "Index";
	}

	// @RequestMapping(value="/*")
	// public String navigateToMainByDefault(HttpServletRequest request ,
	// HttpSession session)
	// {
	//
	// return "Index";
	// }

}
