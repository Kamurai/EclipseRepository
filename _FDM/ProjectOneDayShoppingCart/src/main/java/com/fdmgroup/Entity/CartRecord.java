package com.fdmgroup.Entity;

import java.math.BigDecimal;

import com.fdmgroup.Utility.Constant;

public class CartRecord 
{
	int id;
	int cartId;
	Item item;
	int quantityRequested;
	
	
	//bean constructor
	public CartRecord() 
	{
		this.id = Constant.invalidId();
		this.cartId = Constant.invalidId();
		this.item = new Item();
		this.quantityRequested = Constant.minimumAmount();
	}
	
	//new constructor
	public CartRecord(int cartId, Item item, int quantityRequested) 
	{
		this.id = Constant.invalidId();
		this.cartId = restrictCartId(cartId);
		this.item = item;
		this.quantityRequested = restrictQuantityRequested(quantityRequested);
	}
	
	//existing constructor
	public CartRecord(int id, int cartId, Item item, int quantityRequested) 
	{
		this.id = restrictId(id);
		this.cartId = restrictCartId(cartId);
		this.item = item;
		this.quantityRequested = restrictQuantityRequested(quantityRequested);
	}
	
	public int restrictId(int id)
	{
		int result = id;
		
		if(result < Constant.invalidId())
			result = Constant.invalidId();
		
		return result;
	}
	
	public int restrictCartId(int cartId)
	{
		int result = cartId;
		
		if(result < Constant.invalidId())
			result = Constant.invalidId();
		
		return result;
	}
	
	public int restrictQuantityRequested(int quantityRequested)
	{
		int result = quantityRequested;
		
		if(result < Constant.minimumAmount())
			result = Constant.minimumAmount();
		
		return result;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(int quantityRequested) {
		this.quantityRequested = quantityRequested;
	}
	
}
