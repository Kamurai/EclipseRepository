/**
 * 
 */
package com.fdmgroup.appleGram;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.appleGram.*;

/**
 * @author Christopher.Kemerait
 *
 */
public class DAOTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		AppleDAO appleDAO = new AppleDAO();
		
		Apple apple;
		
		List<Apple> appleList = new ArrayList();
		
		apple = (Apple) appleDAO.getProduct(1);
		
		printApple(apple);
		
		appleList = appleDAO.getProducts();
		
		
		//printObjectToApple(appleList.get(1));
		
		
		System.out.println(appleList.get(1));
		
		
		for(int x = 0; x < appleList.size(); x++)
		{
			printApple( (Apple) appleList.get(x));
		}

	}
	
	public static void printApple(Apple apple)
	{
		System.out.println("Id: " + apple.getId());
		System.out.println("Name: " + apple.getName());
		System.out.println("Price: $" + apple.getPrice());
		System.out.println("Picture URL: " + apple.getPicurl());
		System.out.println();
	}
	
	public static void printObjectToApple(Object object)
	{
		Apple apple = (Apple) object;
		
		System.out.println("Id: " + apple.getId());
		System.out.println("Name: " + apple.getName());
		System.out.println("Price: $" + apple.getPrice());
		System.out.println("Picture URL: " + apple.getPicurl());
		System.out.println();
	}


}
