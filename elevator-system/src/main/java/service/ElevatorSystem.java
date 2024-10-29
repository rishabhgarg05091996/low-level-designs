package service;

import model.Elevator;
import model.ElevatorRequest;
import strategy.ElevatorSchedulingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ElevatorSystem {
	private final List<Elevator> elevators;
	private final ElevatorSchedulingStrategy schedulingStrategy;
	private final ReentrantLock lock = new ReentrantLock();
	
	public ElevatorSystem(int elevatorCount, int capacity, ElevatorSchedulingStrategy strategy) {
		this.elevators = new ArrayList<>();
		this.schedulingStrategy = strategy;
		for (int i = 0; i < elevatorCount; i++) {
			elevators.add(new Elevator(capacity));
		}
	}
	
	public void requestElevator(int requestFloor, int destinationFloor) {
		lock.lock();
		try {
			ElevatorRequest request = new ElevatorRequest(requestFloor, destinationFloor);
			Elevator assignedElevator = schedulingStrategy.selectElevator(elevators, request);
			if (assignedElevator != null) {
				assignedElevator.moveToFloor(requestFloor);
				assignedElevator.moveToFloor(destinationFloor);
			}
		} finally {
			lock.unlock();
		}
	}
	
	public List<Elevator> getElevators() {
		return elevators;
	}
	
	public void runSystem() {
		for (Elevator elevator : elevators) {
			if (!elevator.isAvailable()) {
				elevator.stop();
			}
		}
	}
}
