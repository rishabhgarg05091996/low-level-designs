# Paper-Rock-Scissors Game

Welcome to the Paper-Rock-Scissors game! This is a simple Java console application where players can play the classic game of Paper, Rock, Scissors against the computer.

## Overview

This project implements the Paper-Rock-Scissors game in Java, consisting of several key components:

- **Game**: Manages the game logic, including player moves and determining the winner based on a specified strategy.

- **GameBuilder**: Constructs instances of the Game class with different configurations, such as player types and winning strategies.

- **WinningStrategy**: Defines the interface for determining the winner of a round based on the moves chosen by two players.

- **Player**: Represents the interface for players in the game, providing a method to choose a move.

- **Move**: Represents the interface for moves in the game, such as Paper, Rock, or Scissors, each with its own beats move strategy.

## Extensibility

### Strategy Pattern

The Strategy pattern (`WinningStrategy`, `Move`) allows for easy extension of the game to support different winning criteria and moves.

### Factory Pattern

The Factory pattern (`PlayerFactory`) is used to create instances of players (`HumanPlayer` and `ComputerPlayer`), providing flexibility for adding new player types in the future.

### Builder Pattern

The Builder pattern (`GameBuilder`) constructs instances of the Game class with customizable configurations, enhancing flexibility and ease of use.

### Dependency Injection

Dependency injection is used to inject dependencies (such as `PlayerFactory` and `WinningStrategy`) into classes like `GameBuilder`, promoting loose coupling and testability.

## Implementation

- **Input and Output**: The game takes input from the user via the console and displays the results of each round.

- **Input Validation**: User input is validated to ensure it is a valid move (Paper, Rock, or Scissors). The game allows a limited number of retries for invalid input.

- **Player Interaction**: The HumanPlayer class allows interaction with the human player by reading moves from the console input. The ComputerPlayer class generates random moves for the computer opponent.

- **Game Logic**: The Game class orchestrates gameplay by coordinating player actions and determining the winner based on the provided strategies.

- **Winning Strategy**: The PaperRockScissorsStrategy class implements the WinningStrategy interface to define the logic for determining the winner based on player moves.

- **Move Strategy**: The Paper, Rock, and Scissors classes implement the Move interface to define the beats move strategy for each move.

## Usage

To play the game:
1. Run the PaperRockScissorsGameLauncher class.
2. Follow the prompts to specify the number of rounds to play and enter your moves when prompted.
3. The winner of each round will be displayed, and the overall winner will be determined at the end of the game.

## Best Practices

- **Encapsulation**: Each class encapsulates its own functionality, adhering to the principle of encapsulation in object-oriented design.

- **Single Responsibility Principle (SRP)**: Each class has a single responsibility, making the codebase easier to understand, test, and maintain.

- **Code Reusability**: By using design patterns like Factory, Builder, and Strategy, the code promotes reusability and modularity.

## Improvement

- **Configurable Retries**: The maximum number of retries for invalid user input is currently hardcoded to 3. It would be beneficial to make this value configurable, allowing for greater flexibility in different use cases.

- **Dependency Management**: If the project were to expand to include REST APIs for use in a UI, it would be advisable to utilize build automation tools such as Maven or Gradle for dependency management. This would streamline the integration of external libraries and simplify project maintenance.

- **Enhanced Exception Handling**: While the project currently includes basic exception handling, there is room for improvement in terms of providing more user-friendly error messages and handling specific error scenarios. Refining the exception handling mechanism would enhance the overall user experience and error reporting.

## Conclusion

The Paper-Rock-Scissors game project demonstrates the application of various design principles and patterns to create a flexible, extensible, and maintainable codebase. It provides a solid foundation for further development and expansion.

## Contributors

- Rishabh Garg (Author)