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
public class InventoryBeanTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		InventoryBean ibean = new InventoryBean();
		
		
		for(int x = 0; x < ibean.getProductList().size(); x++)
		{
			printApple( (Apple) ibean.getProductList().get(x));
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
