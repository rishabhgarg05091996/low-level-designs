# Paper-Rock-Scissors Game

Welcome to the Paper-Rock-Scissors game! This is a simple Java console application where players can play the classic game of Paper, Rock, Scissors against the computer.

## Overview

This project implements the Paper-Rock-Scissors game in Java, consisting of several key components:

- **Game**: Manages the game logic, including player moves and determining the winner based on a specified strategy.
- **WinningStrategy**: Interface for determining the winner of a round based on player moves.
- **Player**: Interface for players in the game, with `HumanPlayer` and `ComputerPlayer` implementations.
- **Move**: Enumeration representing the moves (Rock, Paper, Scissors) with logic to determine winning moves.
- **PaperRockScissorsGameLauncher**: Main class to launch the game, handle user input, and manage the game flow.
- **Scoreboard**: Tracks and displays the score of the game.

## Design Patterns

- **Strategy Pattern**: For defining different winning strategies.
- **Factory Pattern**: For creating player instances.

## Usage

To play the game:
1. Run the `PaperRockScissorsGameLauncher` class.
2. Follow the prompts to specify the number of rounds and enter your moves when prompted.
3. The winner of each round and the overall winner will be displayed at the end of the game.

## Key Classes

- **PaperRockScissorsGameLauncher**: Handles user input and controls the game flow.
- **Game**: Orchestrates the gameplay between two players.
- **Scoreboard**: Manages and displays the scores.
- **PaperRockScissorsStrategy**: Implements the logic to determine the winner based on moves.
- **PlayerFactory**: Creates instances of `HumanPlayer` and `ComputerPlayer`.
- **Move**: Enum representing Rock, Paper, Scissors moves.

## Example

Here's a brief example of how the game operates:

1. Launch the game.
2. Enter the number of rounds.
3. Enter your move (rock/paper/scissors) when prompted.
4. The game will display the winner of each round and update the scoreboard.
5. At the end of all rounds, the final scores and the overall winner will be displayed.

## Conclusion

The Paper-Rock-Scissors game project demonstrates the application of various design patterns and principles to create a flexible, extensible, and maintainable codebase. Enjoy playing!

## Contributors

- Rishabh Garg (Author)