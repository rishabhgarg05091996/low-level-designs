package onlinestockbrokeragesystem.stock.service;

import onlinestockbrokeragesystem.stock.model.Stock;

import java.util.concurrent.ConcurrentHashMap;

public class StockService {
	private final ConcurrentHashMap<String, Stock> stocks = new ConcurrentHashMap<>();
	
	public Stock addStock(String symbol, String name, double initialPrice) {
		Stock stock = new Stock(symbol, name, initialPrice);
		stocks.put(symbol, stock);
		return stock;
	}
	
	public Stock getStock(String symbol) {
		return stocks.get(symbol);
	}
	
	public void updateStockPrice(String symbol, double newPrice) {
		Stock stock = stocks.get(symbol);
		if (stock != null) {
			stock.updatePrice(newPrice);
		}
	}
}