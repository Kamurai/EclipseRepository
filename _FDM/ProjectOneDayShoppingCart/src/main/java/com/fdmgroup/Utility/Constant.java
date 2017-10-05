package com.fdmgroup.Utility;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import com.fdmgroup.Entity.Cart;
import com.fdmgroup.Entity.CartRecord;
import com.fdmgroup.Entity.Item;

/*
 * This class retains constants used throughout the program so that they can be referenced as if globally
 */
public final class Constant 
{
	static int invalidId;
	static String invalidName;
	static int minimumAmount;
	static BigDecimal minimumDollar;
	static int maximumShortString;
	static int maximumEmail;
	static int maximumDescription;
	static Item emptyItem;
	static CartRecord emptyRecord;
	static int maximumPictureURL;
	
	public static int invalidId()
	{
		invalidId = -1;
		
		return invalidId;
	}
	
	public static String invalidName()
	{
		invalidName = "-1";
		
		return invalidName;
	}
	
	public static int minimumAmount()
	{
		minimumAmount = 0;
		
		return minimumAmount;
	}
	
	public static BigDecimal minimumDollar()
	{
		minimumDollar = new BigDecimal("0.00");
		
		return minimumDollar;
	}
	
	public static int maximumShortString()
	{
		maximumShortString = 30;
		
		return maximumShortString;
	}
	
	public static int maximumEmail()
	{
		maximumEmail = 50;
		
		return maximumEmail;
	}
	
	public static int maximumDescription()
	{
		maximumDescription = 300;
		
		return maximumDescription;
	}
	
	public static Item emptyItem()
	{
		emptyItem = new Item();
		emptyItem.setId(invalidId());
		emptyItem.setName(invalidName());
		
		return emptyItem;
	}
	public static CartRecord emptyRecord()
	{
		emptyRecord = new CartRecord();
		emptyRecord.setId(invalidId());
		emptyRecord.setCartId(invalidId());
		
		return emptyRecord;
	}
	
	public static int maximumPictureURL()
	{
		maximumPictureURL = 100;
		
		return maximumPictureURL;
	}
	
}
