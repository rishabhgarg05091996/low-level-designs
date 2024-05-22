package com.rishabh;

import com.rishabh.model.move.Move;
import com.rishabh.model.player.Player;
import com.rishabh.service.game.Game;
import com.rishabh.service.game.PaperRockScissorsStrategy;
import com.rishabh.service.player.PlayerFactory;
import com.rishabh.service.game.Scoreboard;
import com.rishabh.model.player.PlayerType;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PaperRockScissorsGameLauncher {
	
	private static final int RETRIES = 3;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Paper-Rock-Scissors game!");
		
		int rounds = readRounds(scanner);
		
		PlayerFactory playerFactory = new PlayerFactory();
		
		Player player1 = playerFactory.createPlayer(PlayerType.HUMAN, () -> readMove(scanner));
		Player player2 = playerFactory.createPlayer(PlayerType.COMPUTER, null);
		
		Game game = new Game(player1, player2, new PaperRockScissorsStrategy());
		
		Scoreboard scoreboard = new Scoreboard();
		
		playRounds(rounds, game, scoreboard);
		
		System.out.println("\nFinal Scores:");
		System.out.println("Player 1: " + scoreboard.getPlayer1Score());
		System.out.println("Player 2: " + scoreboard.getPlayer2Score());
		
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
	
	protected static void playRounds(int rounds, Game game, Scoreboard scoreboard) {
		IntStream.rangeClosed(1, rounds).forEach(round -> {
			System.out.println("\nRound " + round);
			String result = game.play();
			System.out.println("Winner: " + result);
			scoreboard.updateScore(result);
		});
	}
	
	protected static Move readMove(Scanner scanner) {
		int retries = RETRIES;
		while (retries > 0) {
			System.out.print("Enter your move (rock/paper/scissors): ");
			String input = scanner.next().trim().toUpperCase();
			try {
				return Move.valueOf(input);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid move. Please enter a valid move.");
				retries--;
			}
		}
		throw new RuntimeException("Exceeded maximum retries for input.");
	}
}