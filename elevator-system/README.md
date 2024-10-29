# Elevator System

A Java-based elevator management system that efficiently handles user requests for multiple elevators across multiple floors. This system is designed with Object-Oriented principles, SOLID principles, and design patterns for scalability, extensibility, and optimal performance.

## Table of Contents
- [Functional Requirements](#functional-requirements)
- [Non-Functional Requirements](#non-functional-requirements)
- [Design Patterns and Best Practices](#design-patterns-and-best-practices)
- [Usage](#usage)
- [Contributors](#contributors)

---

## Functional Requirements

1. **Elevator Management**:
    - Multiple elevators are managed by a central controller.
    - Each elevator can move up or down and serve multiple floors.
    - Each elevator has a fixed capacity and cannot exceed it.

2. **Request Handling**:
    - Users can request an elevator from any floor.
    - Users can select a destination floor upon entering the elevator.
    - Requests are prioritized based on:
        - Direction of travel (up or down).
        - Proximity of the elevator to the request floor.

3. **Concurrent Requests**:
    - Elevators can handle multiple requests concurrently.
    - Requests are processed in an optimal order to minimize wait times.

## Non-Functional Requirements

1. **Scalability**:
    - New elevators or floors can be added with minimal code changes.
    - Support for additional scheduling strategies without modifying core logic.

2. **Performance**:
    - Efficient handling of requests to reduce wait and travel time.

3. **Thread Safety**:
    - Ensure thread safety when multiple threads interact with the elevators.
    - Prevent race conditions in concurrent request handling.

4. **Reliability**:
    - Fault-tolerant design with prioritized request handling.
    - Graceful degradation if an elevator is full or in maintenance.

---

## Design Patterns and Best Practices

- **Singleton Pattern**: Ensures only one instance of the Elevator System is running.
- **Strategy Pattern**: Allows flexibility in implementing various scheduling algorithms (e.g., proximity-based).
- **Open-Closed Principle**: System can be extended with new features (e.g., different scheduling strategies) without modifying existing code.
- **Thread Safety**: Synchronized methods within the Elevator class to prevent data races.
- **Separation of Concerns**: The controller manages requests, while the elevator class handles movement and request stops.

---

## Usage

1. To request an elevator:

    ```java
    ElevatorController controller = new ElevatorController(3, 5);

    // Example requests
    controller.handleRequest(1, 5);
	controller.handleRequest(3, 10);
        
    // Display Elevator Status
    controller.displayStatus();
        
	// Run the system
    controller.run();
    ```

---

## Contributors

- Rishabh Garg (Author)
