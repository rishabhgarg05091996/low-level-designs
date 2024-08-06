package onlinestockbrokeragesystem.order.service;

import onlinestockbrokeragesystem.order.model.Order;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrderService {
	private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();
	
	public void placeOrder(Order order) {
		orderQueue.offer(order);
		processOrders();
	}
	
	private void processOrders() {
		Order order;
		while ((order = orderQueue.poll()) != null) {
			order.execute();
		}
	}
}
