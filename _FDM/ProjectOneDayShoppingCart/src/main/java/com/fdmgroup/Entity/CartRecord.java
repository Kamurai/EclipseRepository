package com.fdmgroup.Entity;

import java.math.BigDecimal;

public class CartRecord 
{
	int id;
	int cartId;
	Item item;
	int quantityRequested;
	
	
	//bean constructor
	public CartRecord() 
	{
		this.id = -1;
		this.cartId = -1;
		this.item = new Item();
		this.quantityRequested = -1;
	}
	
	//new constructor
	public CartRecord(int cartId, Item item, int quantityRequested) 
	{
		this.id = -1;
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
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	public int restrictCartId(int cartId)
	{
		int result = cartId;
		
		if(result < -1)
			result = -1;
		
		return result;
	}
	
	public int restrictQuantityRequested(int quantityRequested)
	{
		int result = quantityRequested;
		
		if(result < 0)
			result = 0;
		
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
