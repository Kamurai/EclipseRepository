package com.fdmgroup.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.DAO.CartRecordDAO;
import com.fdmgroup.DAO.ItemDAO;
import com.fdmgroup.Entity.Cart;
import com.fdmgroup.Entity.MessageBean;
import com.fdmgroup.Entity.Item;
import com.fdmgroup.Utility.SessionUtility;


//This handles routing / mapping
@Controller
public class NavigationController 
{
	@RequestMapping(value="/")
	public String navigateToRoot(HttpServletRequest request, HttpSession session)
	{
		return "redirect:/Index";
	}
	
	@RequestMapping(value="/Index")
	public String navigateToIndex(HttpServletRequest request , HttpSession session, Model model)
	{
		ItemDAO itemDAO = new ItemDAO();
		CartRecordDAO cartRecordDAO = new CartRecordDAO();
		List<Item> itemList = itemDAO.getItems();
		Cart cart = SessionUtility.getSessionCart(session);
		
		//fill cart from database
		cart.setRecordList(cartRecordDAO.getRecordsByCartId(0));
		
		session.setAttribute("itemList", itemList);
		model.addAttribute("il", itemList );
		model.addAttribute("cart", cart );
				
		return "Index";
	}
	
	@RequestMapping(value="/Success")
	public String navigateToSuccess(HttpServletRequest request , HttpSession session, Model model)
	{
		MessageBean messageBean = SessionUtility.getSessionMessage(session);
		
		model.addAttribute("messageBean", messageBean );
		return "Success";
	}
	
	@RequestMapping(value="/Failure")
	public String navigateToFailure(HttpServletRequest request , HttpSession session, Model model)
	{
		MessageBean messageBean = SessionUtility.getSessionMessage(session);
		
		model.addAttribute("messageBean", messageBean );
		return "Failure";
	}
	
}
