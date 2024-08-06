package onlinestockbrokeragesystem.stock.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Stock {
	private final String symbol;
	private final String name;
	private double price;
	private final List<Consumer<Double>> observers = new ArrayList<>();
	
	public Stock(String symbol, String name, double price) {
		this.symbol = symbol;
		this.name = name;
		this.price = price;
	}
	
	public synchronized void updatePrice(double newPrice) {
		price = newPrice;
		notifyObservers(newPrice);
	}
	
	public void addObserver(Consumer<Double> observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(double newPrice) {
		observers.forEach(observer -> observer.accept(newPrice));
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}