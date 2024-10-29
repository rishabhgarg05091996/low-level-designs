package strategy;

import model.Elevator;
import model.ElevatorRequest;

import java.util.List;

public class DirectionSchedulingStrategy implements ElevatorSchedulingStrategy {
	
	@Override
	public Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request) {
		for (Elevator elevator : elevators) {
			if (elevator.isAvailable() && elevator.isMovingUp() == request.isUpwardRequest()) {
				return elevator;
			}
		}
		return null;
	}
}
