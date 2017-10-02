package com.fdmgroup.appleGram;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map <Product, Integer> productMap;
	
	public Cart(){
		productMap = new HashMap<Product, Integer>();
	}
	
	public Cart(Map<Product,Integer> newMap){
		
		this.productMap = newMap;
		
	}
	
	
	
	public Map<Product, Integer> getProductMap() {
		return productMap;
	}
	
	public void setProductMap(Map<Product, Integer> productMap) {
		this.productMap = productMap;
	}
	public void addProduct(Product newProduct , int newQuantity){
		
		this.productMap.put(newProduct, newQuantity);
		
	}
	public void removeProduct(Product removeProduct){
		this.productMap.remove(removeProduct);
	}
	public void updateProduct(Product updateProduct , int updateQuantity){
		
		if(this.productMap.containsKey(updateProduct)){
			this.productMap.put(updateProduct, updateQuantity);
		}
		
	}
	public BigDecimal calculateTotal() {
		// TODO Auto-generated method stub
		
		BigDecimal total = new BigDecimal("0");
		for(Map.Entry<Product, Integer> entry : productMap.entrySet()){
			BigDecimal priceHolder = entry.getKey().getPrice();
			Integer qtyHolder = entry.getValue();
			BigDecimal qty = new BigDecimal(qtyHolder);
			BigDecimal totalHolder = priceHolder.multiply(qty);
			total = total.add(totalHolder);
			
		}
		return total;
	}

}
