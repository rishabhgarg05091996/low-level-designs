package controller;

import model.Elevator;
import service.ElevatorSystem;
import strategy.ProximitySchedulingStrategy;

import java.util.List;

public class ElevatorController {
	private final ElevatorSystem elevatorSystem;
	
	public ElevatorController(int elevatorCount, int capacity) {
		this.elevatorSystem = new ElevatorSystem(elevatorCount, capacity, new ProximitySchedulingStrategy());
	}
	
	public void handleRequest(int requestFloor, int destinationFloor) {
		elevatorSystem.requestElevator(requestFloor, destinationFloor);
	}
	
	public void displayStatus() {
		for (Elevator elevator : elevatorSystem.getElevators()) {
			System.out.println("Elevator at floor: " + elevator.getCurrentFloor() + ", Available: " + elevator.isAvailable());
		}
	}
	
	public void run() {
		elevatorSystem.runSystem();
	}
	
	public List<Elevator> getElevators() {
		return elevatorSystem.getElevators();
	}
}
