package com.fdmgroup.patterns.command.demo2;

public class BuyStockOrder implements Order{

	private StockTrade stock;
	
	public BuyStockOrder(StockTrade stock){
		this.stock = stock;
	}
	
	public void execute(){
		stock.buy();
	}
	
}
