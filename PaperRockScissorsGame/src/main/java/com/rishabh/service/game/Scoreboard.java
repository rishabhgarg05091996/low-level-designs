package com.rishabh.service.game;

public class Scoreboard {
	private static final String PLAYER_1_WINS = "Player 1 wins";
	private static final String PLAYER_2_WINS = "Player 2 wins";
	private int player1Score = 0;
	private int player2Score = 0;
	
	public void updateScore(String result) {
		if (result.contains(PLAYER_1_WINS)) {
			player1Score++;
		} else if (result.contains(PLAYER_2_WINS)) {
			player2Score++;
		}
	}
	
	public int getPlayer1Score() {
		return player1Score;
	}
	
	public int getPlayer2Score() {
		return player2Score;
	}
}
