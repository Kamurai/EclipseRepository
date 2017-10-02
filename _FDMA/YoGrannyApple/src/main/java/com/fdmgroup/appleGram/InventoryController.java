package com.fdmgroup.appleGram;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class InventoryController {
	
	
	@RequestMapping(value="/Inventory", method=GET)
	public String inventoryHandler(HttpSession session , Model model){
		ProductDAO pdao = new AppleDAO();
		List<Product> productList = (List<Product>)pdao.getProducts();
		
		Cart cart = CartUtilities.getSessionCart(session);
		session.setAttribute("cart" , cart);
		model.addAttribute("pageResults", productList);
		return "Inventory";
	}
	
	@RequestMapping(value="/Product", method=GET)
	public String productHandler(Model model, @RequestParam String id){
		
		Product productForProductPage = new Product();
		
		ProductDAO pdao = new AppleDAO();
		List<Product> productList = (List<Product>)pdao.getProducts();
		for(Product p : productList){
			if(p.getId() == Integer.parseInt(id)){
				productForProductPage = p;
			}
		}
		
		model.addAttribute("product",productForProductPage);
		
		return "Product";
	}
	
	@RequestMapping(value="/addToCart", method=POST)
	public ModelAndView addToCartHandler(HttpSession session , Model model, @RequestParam String id, @RequestParam int quantity){
		
		Product addProduct = new Product();
		
		ProductDAO pdao = new AppleDAO();
		List<Product> productList = (List<Product>)pdao.getProducts();
		
		for(Product p : productList){
			if(p.getId() == Integer.parseInt(id)){
				addProduct = p;
			}
		}
		
		Cart cart = CartUtilities.getSessionCart(session);
		
		if(cart.getProductMap().containsKey(addProduct)){
			quantity += cart.getProductMap().get(addProduct);
			cart.getProductMap().replace(addProduct, quantity);
		}
		else{
			cart.addProduct(addProduct, quantity);
		}
		session.setAttribute("cart", cart);
		return new ModelAndView("redirect:/Inventory");
	}
	
	
	

}
