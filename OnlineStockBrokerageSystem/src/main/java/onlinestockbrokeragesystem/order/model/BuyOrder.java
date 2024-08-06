package onlinestockbrokeragesystem.order.model;

import onlinestockbrokeragesystem.account.model.Account;
import onlinestockbrokeragesystem.exceptions.InsufficientFundsException;
import onlinestockbrokeragesystem.stock.model.Stock;

public class BuyOrder extends Order {
	public BuyOrder(String orderId, Account account, Stock stock, int quantity, double price) {
		super(orderId, account, stock, quantity, price);
	}
	
	@Override
	public void execute() {
		double totalCost = quantity * price;
		if (account.getBalance() >= totalCost) {
			account.withdraw(totalCost);
			account.getPortfolio().addStock(stock, quantity);
			status = OrderStatus.EXECUTED;
		} else {
			status = OrderStatus.REJECTED;
			throw new InsufficientFundsException("Insufficient funds to execute the buy order.");
		}
	}
}