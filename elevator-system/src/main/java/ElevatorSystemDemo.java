import controller.ElevatorController;

public class ElevatorSystemDemo {
	public static void main(String[] args) {
		ElevatorController controller = new ElevatorController(3, 5);
		
		// Example requests
		controller.handleRequest(1, 5);
		controller.handleRequest(3, 10);
		
		// Display Elevator Status
		controller.displayStatus();
		
		// Run the system
		controller.run();
	}
}
