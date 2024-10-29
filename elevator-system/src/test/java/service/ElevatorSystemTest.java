package service;

import controller.ElevatorController;
import model.Elevator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.ProximitySchedulingStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorSystemTest {
	private ElevatorController controller;
	private ElevatorSystem elevatorSystem;
	
	@BeforeEach
	public void setUp() {
		this.controller = new ElevatorController(3, 5);
		this.elevatorSystem = new ElevatorSystem(3, 5, new ProximitySchedulingStrategy());
	}
	
	@Test
	public void testElevatorRequest() {
		controller.handleRequest(1, 5);
		controller.run();
		List<Elevator> elevators = controller.getElevators();
		
		// Test if any elevator has moved to floor 5
		assertTrue(elevators.stream().anyMatch(elevator -> elevator.getCurrentFloor() == 5));
	}
	
	@Test
	public void testElevatorAvailability() {
		controller.handleRequest(1, 5);
		controller.handleRequest(2, 6);
		controller.run();
		
		List<Elevator> elevators = controller.getElevators();
		for (Elevator elevator : elevators) {
			assertTrue(elevator.isAvailable(), "Elevator should be available after stopping.");
		}
	}
	
	@Test
	public void testProximityScheduling() {
		elevatorSystem.requestElevator(2, 10);
		Elevator selectedElevator = elevatorSystem.getElevators().stream()
				.filter(elevator -> elevator.getCurrentFloor() == 2 || elevator.getCurrentFloor() == 10)
				.findFirst().orElse(null);
		
		assertNotNull(selectedElevator, "An elevator should have been assigned for proximity scheduling.");
	}
	
	@Test
	public void testDirectionScheduling() {
		ElevatorSystem directionSystem = new ElevatorSystem(3, 5, new ProximitySchedulingStrategy());
		directionSystem.requestElevator(0, 4);
		
		assertTrue(directionSystem.getElevators().get(0).isMovingUp(), "Elevator should be moving up for upward requests.");
	}
}