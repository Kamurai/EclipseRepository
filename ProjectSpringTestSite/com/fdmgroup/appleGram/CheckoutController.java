package com.fdmgroup.appleGram;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CheckoutController {
	
	@RequestMapping(value="/checkout",method=RequestMethod.GET)
	public String goToRootPage(HttpServletRequest request , HttpSession session){
		return "Checkout";
	}
	
	
	
	@RequestMapping(value="/checkoutUser",method=RequestMethod.POST)
	public String checkoutHandler(Model model, HttpServletRequest request, HttpSession session){
		Checkout customer=new Checkout();
		customer.setFirstname(request.getParameter("firstname"));
		customer.setLastname(request.getParameter("lastname"));
		customer.setEmail(request.getParameter("email"));
		customer.setPhone(request.getParameter("phone"));
		customer.setCardNumber(request.getParameter("cardNumber"));
		customer.setExpDate(request.getParameter("expDate"));
		customer.setStreet(request.getParameter("street"));
		customer.setCity(request.getParameter("city"));
		customer.setState(request.getParameter("state"));
		customer.setZip(request.getParameter("zip"));
		customer.setCountry(request.getParameter("country"));
		
		model.addAttribute("customerReciept", customer);
		
		Cart cart = CartUtilities.getSessionCart(session);
		BigDecimal cartTotal = cart.calculateTotal();
		model.addAttribute("total", cartTotal);
		model.addAttribute("items", cart.getProductMap().entrySet() );
		
		return "Receipt";
	}

}
