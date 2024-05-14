package com.rishabh.game;

import com.rishabh.moves.Move;

public class PaperRockScissorsStrategy implements WinningStrategy {
	private static final String DRAW = "Draw";
	private static final String PLAYER_1_WINS = "Player 1 wins (You win)!!";
	private static final String PLAYER_2_WINS = "Player 2 wins (Computer wins)!!";
	
	@Override
	public String determineWinner(Move movePlayer1, Move movePlayer2) {
		if (movePlayer1.toString().equals(movePlayer2.toString())) {
			return DRAW;
		} else {
			return movePlayer1.beats(movePlayer2) ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
	}
}

