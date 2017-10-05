package com.fdmgroup.Utility;

import javax.servlet.http.HttpSession;

import com.fdmgroup.DAO.CartRecordDAO;
import com.fdmgroup.Entity.Cart;
import com.fdmgroup.Entity.MessageBean;

//this creates a Cart object in the session if it does not exit
	//it returns either the newly made cart or the previously existing cart
public class SessionUtility 
{
	public static Cart getSessionCart(HttpSession session)
	{
		Cart cart = (Cart) session.getAttribute("cart");
		CartRecordDAO cartRecordDAO = new CartRecordDAO();
		
		if(cart == null)
		{
			cart = new Cart();
			cart.setId(cartRecordDAO.determineLowestAvailableCartId());
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	
	public static MessageBean getSessionMessage(HttpSession session)
	{
		MessageBean messageBean = (MessageBean) session.getAttribute("errorbean");
		
		if(messageBean == null)
		{
			messageBean = new MessageBean();
			session.setAttribute("errorbean", messageBean);
		}
		return messageBean;
	}
}
