
package com.fdmgroup.appleGram;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	@RequestMapping(value="/updateQtyCart", method=POST)
	public ModelAndView changeQtyInCart(HttpSession session , Model model, @RequestParam String id, @RequestParam int quantity){
Product addProduct = new Product();
		
		ProductDAO pdao = new AppleDAO();
		List<Product> productList = (List<Product>)pdao.getProducts();
		
		for(Product p : productList){
			if(p.getId() == Integer.parseInt(id)){
				addProduct = p;
			}
		}
		
		Cart cart = CartUtilities.getSessionCart(session);

		
		cart.getProductMap().replace(addProduct, quantity);
		session.setAttribute("cart", cart);
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping(value="/removeFromCart" , method=POST)
	public ModelAndView removeProductFromCart(Model model, HttpServletRequest request , HttpSession session){
		Cart cart = CartUtilities.getSessionCart(session);
		Product product = (Product) request.getAttribute("product");
		cart.removeProduct(product);
		BigDecimal cartTotal = cart.calculateTotal();
		session.setAttribute("cart", cart);
		model.addAttribute("total", cartTotal);
		model.addAttribute("items", cart.getProductMap().entrySet() );
		

		return new ModelAndView("redirect:/cart");		
	}
	
	@RequestMapping(value="/cart", method=GET)
	public String cartHandler( Model model, HttpSession session){
		Cart cart = CartUtilities.getSessionCart(session);
		BigDecimal cartTotal = cart.calculateTotal();
		model.addAttribute("total", cartTotal);
		model.addAttribute("items", cart.getProductMap().entrySet() );
		
		return "Cart";
	}
//	@RequestMapping(value="/checkout", method=POST)
	
	

	

}
