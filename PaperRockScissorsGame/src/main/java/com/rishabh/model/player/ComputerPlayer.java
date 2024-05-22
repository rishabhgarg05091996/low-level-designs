package com.rishabh.model.player;

import com.rishabh.model.move.Move;

import java.util.Random;

public class ComputerPlayer implements Player {
	private final Random random = new Random();
	
	@Override
	public Move chooseMove() {
		Move[] moves = Move.values();
		Move chosenMove = moves[random.nextInt(moves.length)];
		System.out.println("Computer chose: " + chosenMove);
		return chosenMove;
	}
}
