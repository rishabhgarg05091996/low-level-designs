package model;

public class ElevatorRequest {
	private final int requestFloor;
	private final int destinationFloor;
	
	public ElevatorRequest(int requestFloor, int destinationFloor) {
		this.requestFloor = requestFloor;
		this.destinationFloor = destinationFloor;
	}
	
	public int getRequestFloor() {
		return requestFloor;
	}
	
	public int getDestinationFloor() {
		return destinationFloor;
	}
	
	public boolean isUpwardRequest() {
		return destinationFloor > requestFloor;
	}
}
