package onlinestockbrokeragesystem;

import onlinestockbrokeragesystem.account.model.Account;
import onlinestockbrokeragesystem.account.model.User;
import onlinestockbrokeragesystem.account.service.AccountService;
import onlinestockbrokeragesystem.order.service.OrderService;
import onlinestockbrokeragesystem.service.StockBroker;
import onlinestockbrokeragesystem.stock.model.Stock;
import onlinestockbrokeragesystem.stock.service.StockService;

public class StockBrokerageSystemDemo {
	public static void main(String[] args) {
		AccountService accountService = new AccountService();
		StockService stockService = new StockService();
		OrderService orderService = new OrderService();
		StockBroker stockBroker = new StockBroker(accountService, stockService, orderService);
		
		User user = new User("U001", "John Doe", "john.doe@example.com");
		Account account = stockBroker.createAccount(user, 10000);
		
		Stock appleStock = stockBroker.addStock("AAPL", "Apple Inc.", 150);
		Stock googleStock = stockBroker.addStock("GOOG", "Google LLC", 2800);
		
		// Add an observer to Apple stock
		appleStock.addObserver(newPrice -> System.out.println("Apple stock price updated to: " + newPrice));
		
		stockBroker.placeBuyOrder("AAPL", account, appleStock, 10, 150);
		stockBroker.placeBuyOrder("GOOG", account, googleStock, 2, 2800);
		stockBroker.placeSellOrder("AAPL", account, appleStock, 5, 500);
		
		System.out.println("Account balance: " + account.getBalance());
		System.out.println("Portfolio holdings: " + account.getPortfolio().getHoldings());
		
		// Simulate a price update
		appleStock.updatePrice(155);
	}
}