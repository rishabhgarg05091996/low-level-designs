package com.rishabh.players;

import com.rishabh.moves.Move;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class HumanPlayer implements Player {
	private static final int RETRIES = 3;
	private final Scanner scanner;
	private final Map<String, Supplier<Move>> moveConstructors;
	
	public HumanPlayer(Scanner scanner, Map<String, Supplier<Move>> moveConstructors) {
		this.scanner = scanner;
		this.moveConstructors = moveConstructors;
	}
	
	@Override
	public Move chooseMove() {
		int retries = RETRIES;
		while (retries > 0) {
			System.out.print("Enter your move (rock/paper/scissors): ");
			String input = scanner.next().trim().toLowerCase();
			if (moveConstructors.containsKey(input)) {
				return moveConstructors.get(input).get();
			} else {
				System.out.println("Invalid move. Please enter a valid move.");
				retries--;
			}
		}
		throw new RuntimeException("Exceeded maximum retries for input.");
	}
}
