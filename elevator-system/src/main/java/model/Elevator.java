package model;

public class Elevator {
	private int currentFloor;
	private final int capacity;
	private boolean movingUp;
	private boolean available;
	
	public Elevator(int capacity) {
		this.currentFloor = 0;
		this.capacity = capacity;
		this.available = true;
		this.movingUp = true;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public boolean isMovingUp() {
		return movingUp;
	}
	
	public void setMovingDirection(boolean up) {
		this.movingUp = up;
	}
	
	public void setAvailability(boolean availability) {
		this.available = availability;
	}
	
	public void moveToFloor(int floor) {
		currentFloor = floor;
		available = false;
	}
	
	public void stop() {
		available = true;
	}
}
