package viewbase;

import javax.servlet.http.HttpSession;

public class CartUtilities {
	public static Cart getSessionCart(HttpSession session){
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null){
			cart = new Cart();
			session.setAttribute("cart", cart);
			
		}
		return cart;
		
	}

}
