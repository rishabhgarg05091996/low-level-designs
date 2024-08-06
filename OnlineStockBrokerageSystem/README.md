# Online Stock Brokerage System

This is a scalable, extensible, and modular online stock brokerage system. The system follows object-oriented design principles, SOLID principles, and utilizes design patterns such as the Observer pattern.

## Structure

The project is organized into the following packages:

- `account`: Models and services related to user accounts.
- `order`: Models and services for handling buy and sell orders.
- `stock`: Models and services for managing stocks.
- `service`: Core services for the stock broker.
- `demo`: The main demo class to run the system.

## Features

- **User Account Management**: Create and manage user accounts with initial balances.
- **Stock Management**: Add, update, and manage stocks.
- **Order Handling**: Place and process buy and sell orders.
- **Portfolio Management**: Maintain and update user portfolios.
- **Real-time Updates**: Observer pattern implementation for real-time stock price updates.

## Getting Started

## Usage

1. **Run the demo class** to see the system in action:
    ```sh
    mvn exec:java -Dexec.mainClass="onlinestockbrokeragesystem.demo.StockBrokerageSystemDemo"
    ```

2. **Demo Highlights**:
    - Create a user account.
    - Add stocks to the stock broker.
    - Place buy and sell orders.
    - Update stock prices and observe changes.

## Contributing

Contributions are welcome! Please fork the repository, make your changes, and submit a pull request. Ensure your code follows the coding guidelines and includes tests for any new features.

## Contact

For any questions or suggestions, please contact [rishabhgarg6257@gmail.com](mailto:rishabhgarg6257@gmail.com).
