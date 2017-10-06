package com.fdmgroup.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.DAO.CartRecordDAO;
import com.fdmgroup.DAO.ItemDAO;
import com.fdmgroup.Entity.Cart;
import com.fdmgroup.Entity.CartRecord;
import com.fdmgroup.Entity.MessageBean;
import com.fdmgroup.Entity.Item;
import com.fdmgroup.Utility.Constant;
import com.fdmgroup.Utility.SessionUtility;


//This handles routing / mapping
@Controller
public class ActionController 
{
	@RequestMapping(value="/updateCart") //to do: make Post
	public String navigateToRoot(HttpServletRequest request, HttpSession session, Model model, @RequestParam Map<String, String> allRequestParams)
	{
		Cart cart = SessionUtility.getSessionCart(session);
		CartRecordDAO cartRecordDAO = new CartRecordDAO();
		ItemDAO itemDAO = new ItemDAO();
		MessageBean messageBean = SessionUtility.getSessionMessage(session);
		final String successPath = "redirect:/Success";
		final String failurePath = "redirect:/Failure";
		String result = failurePath;
		boolean successFlag = false;
		
		int quantityRequested = Constant.minimumAmount();
		int quantityAvailable = Constant.minimumAmount();
		int targetId = Constant.invalidId();
		List<Item> itemList = (ArrayList<Item>) session.getAttribute("itemList");
		
		System.out.println("allRequestParams Map " + allRequestParams);
		
		//build cart
			//walk through inventory
		for(int x = 0; x < itemList.size(); x++)
		{
			//if requestQuantity isn't 0
			System.out.println("Item by Name " + itemList.get(x).getName());
			System.out.println("Quantity by Name " + allRequestParams.get(itemList.get(x).getName()));
			if( Integer.parseInt(allRequestParams.get(itemList.get(x).getName())) != 0)
			{
				cart.addRecord(  new CartRecord( cart.getId(), itemList.get(x), Integer.parseInt(allRequestParams.get(itemList.get(x).getName())) ) );
			}
			
		}
		
		//check over cart
		for(int x = 0; x < cart.getRecordList().size(); x++)
		{
			quantityRequested = cart.getRecordList().get(x).getQuantityRequested();
			targetId = cart.getRecordList().get(x).getItem().getId();
			quantityAvailable = itemDAO.getItemById(targetId).getQuantityAvailable();
			if( quantityRequested > quantityAvailable )
			{
				successFlag = false;
			}
		}
		
		//Clear current records based on cartId
		cartRecordDAO.removeRecordsByCartId(cart.getId());
		
		//Attempt to addRecords, if any fail, then attempt should return false
		System.out.println("Record List " + cart.getRecordList());
		
		successFlag = cartRecordDAO.addRecords(cart.getRecordList());
		
		if(successFlag)
		{
			messageBean.setMessage("Congratulations, you updated the cart.");
			result = successPath;
		}
		else
		{
			messageBean.setMessage("We were unable to update the cart.");
			result = failurePath;
		}
		
		session.setAttribute("messageBean", messageBean );
		return result;
	}
}
