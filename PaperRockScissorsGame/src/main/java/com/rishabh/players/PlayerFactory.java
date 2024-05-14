package com.rishabh.players;

import com.rishabh.moves.Move;
import com.rishabh.moves.Paper;
import com.rishabh.moves.Rock;
import com.rishabh.moves.Scissors;
import com.rishabh.utils.PlayerType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class PlayerFactory {
	private final Scanner scanner;
	private final Map<PlayerType, Supplier<Player>> playerConstructors;
	private final Map<String, Supplier<Move>> moveConstructors;
	
	public PlayerFactory(Scanner scanner) {
		this.scanner = scanner;
		this.playerConstructors = new HashMap<>();
		this.moveConstructors = new HashMap<>();
		initializePlayerConstructors();
		initializeMoveConstructors();
	}
	
	private void initializeMoveConstructors() {
		addMoveConstructor(new Rock());
		addMoveConstructor(new Paper());
		addMoveConstructor(new Scissors());
	}
	
	private void addMoveConstructor(Move move) {
		moveConstructors.put(move.toString(), () -> move);
	}
	
	private void initializePlayerConstructors() {
		playerConstructors.put(PlayerType.HUMAN, () -> new HumanPlayer(scanner, moveConstructors));
		playerConstructors.put(PlayerType.COMPUTER, () -> new ComputerPlayer(moveConstructors));
	}
	
	public Player createPlayer(PlayerType playerType) {
		return playerConstructors.get(playerType).get();
	}
}