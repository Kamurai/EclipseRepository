package com.fdmgroup.Utility;

import javax.servlet.http.HttpSession;

import com.fdmgroup.Entity.Cart;

//this creates a Cart object in the session if it does not exit
	//it returns either the newly made cart or the previously existing cart
public class CartUtility 
{
	public static Cart getSessionCart(HttpSession session)
	{
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}
}
