package onlinestockbrokeragesystem.service;

import onlinestockbrokeragesystem.account.model.Account;
import onlinestockbrokeragesystem.account.model.User;
import onlinestockbrokeragesystem.account.service.AccountService;
import onlinestockbrokeragesystem.order.model.BuyOrder;
import onlinestockbrokeragesystem.order.model.Order;
import onlinestockbrokeragesystem.order.model.SellOrder;
import onlinestockbrokeragesystem.order.service.OrderService;
import onlinestockbrokeragesystem.stock.model.Stock;
import onlinestockbrokeragesystem.stock.service.StockService;

public class StockBroker {
	private final AccountService accountService;
	private final StockService stockService;
	private final OrderService orderService;
	
	public StockBroker(AccountService accountService, StockService stockService, OrderService orderService) {
		this.accountService = accountService;
		this.stockService = stockService;
		this.orderService = orderService;
	}
	
	public Account createAccount(User user, double initialBalance) {
		return accountService.createAccount(user, initialBalance);
	}
	
	public Stock addStock(String symbol, String name, double initialPrice) {
		return stockService.addStock(symbol, name, initialPrice);
	}
	
	public void placeBuyOrder(String orderId, Account account, Stock stock, int quantity, double price) {
		Order buyOrder = new BuyOrder(orderId, account, stock, quantity, price);
		orderService.placeOrder(buyOrder);
	}
	
	public void placeSellOrder(String orderId, Account account, Stock stock, int quantity, double price) {
		Order sellOrder = new SellOrder(orderId, account, stock, quantity, price);
		orderService.placeOrder(sellOrder);
	}
}
