package onlinestockbrokeragesystem.order.model;

import onlinestockbrokeragesystem.account.model.Account;
import onlinestockbrokeragesystem.stock.model.Stock;

public class SellOrder extends Order {
	public SellOrder(String orderId, Account account, Stock stock, int quantity, double price) {
		super(orderId, account, stock, quantity, price);
	}
	
	@Override
	public void execute() {
		account.getPortfolio().removeStock(stock, quantity);
		double totalProceeds = quantity * price;
		account.deposit(totalProceeds);
		status = OrderStatus.EXECUTED;
	}
}