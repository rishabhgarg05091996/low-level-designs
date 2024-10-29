package strategy;

import model.Elevator;
import model.ElevatorRequest;

import java.util.List;

public interface ElevatorSchedulingStrategy {
	Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request);
}
