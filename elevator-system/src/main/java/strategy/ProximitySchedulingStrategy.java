package strategy;

import model.Elevator;
import model.ElevatorRequest;

import java.util.List;

public class ProximitySchedulingStrategy implements ElevatorSchedulingStrategy {
	
	@Override
	public Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request) {
		Elevator closestElevator = null;
		int minDistance = Integer.MAX_VALUE;
		
		for (Elevator elevator : elevators) {
			if (elevator.isAvailable()) {
				int distance = Math.abs(elevator.getCurrentFloor() - request.getRequestFloor());
				if (distance < minDistance) {
					minDistance = distance;
					closestElevator = elevator;
				}
			}
		}
		return closestElevator;
	}
}
