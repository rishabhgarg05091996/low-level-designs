package com.rishabh.players;

import com.rishabh.moves.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class ComputerPlayer implements Player {
	private final Random random;
	private final Map<String, Supplier<Move>> moveConstructors;
	
	public ComputerPlayer(Map<String, Supplier<Move>> moveConstructors) {
		this.random = new Random();
		this.moveConstructors = moveConstructors;
	}
	
	@Override
	public Move chooseMove() {
		List<String> moveKeys = new ArrayList<>(moveConstructors.keySet());
		String randomMoveKey = moveKeys.get(random.nextInt(moveKeys.size()));
		System.out.println("Computer chose: " + randomMoveKey);
		return moveConstructors.get(randomMoveKey).get();
	}
}
