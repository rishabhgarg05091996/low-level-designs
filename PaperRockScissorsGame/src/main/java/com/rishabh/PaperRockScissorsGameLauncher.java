package com.rishabh;

import com.rishabh.game.Game;
import com.rishabh.game.GameBuilder;
import com.rishabh.game.PaperRockScissorsStrategy;
import com.rishabh.players.PlayerFactory;
import com.rishabh.utils.PlayerType;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PaperRockScissorsGameLauncher {
	
	private static final int RETRIES = 3;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Paper-Rock-Scissors game!");
		
		int rounds = readRounds(scanner);
		
		GameBuilder gameBuilder = new GameBuilder(new PlayerFactory(scanner));
		
		// Single Player Game
		Game game = gameBuilder.withWinningStrategy(new PaperRockScissorsStrategy())
				.build(PlayerType.HUMAN, PlayerType.COMPUTER);
		
		playRounds(rounds, game);
		
		System.out.println("\nThanks for playing!");
		scanner.close();
	}
	
	protected static int readRounds(Scanner scanner) {
		int retries = RETRIES;
		while (retries > 0) {
			try {
				System.out.print("Enter the number of rounds to play: ");
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input. Please enter a valid integer.");
				scanner.next();
				retries--;
			}
		}
		throw new RuntimeException("Exceeded maximum retries for input.");
	}
	
	protected static void playRounds(int rounds, Game game) {
		IntStream.rangeClosed(1, rounds)
				.forEach(round -> {
					System.out.println("\nRound " + round);
					System.out.println("Winner: " + game.play());
				});
	}
}
