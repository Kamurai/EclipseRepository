package com.fdmgroup.patterns.command.demo2;

public class Client {
	
	public static void main(String[] args){
		
		StockTrade stock1 = new StockTrade();
		StockTrade stock2 = new StockTrade();
		
		BuyStockOrder order1 = new BuyStockOrder(stock1);
		SellStockOrder order2 = new SellStockOrder(stock2);
		
		Agent agent = new Agent();
		agent.placeOrder(order1);
		agent.placeOrder(order2);
	}

}
