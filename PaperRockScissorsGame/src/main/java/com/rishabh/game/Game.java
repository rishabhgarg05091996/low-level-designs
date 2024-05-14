package com.rishabh.game;

import com.rishabh.moves.Move;
import com.rishabh.players.Player;

public class Game {
	private final Player player1;
	private final Player player2;
	private final WinningStrategy winningStrategy;
	
	public Game(Player player1, Player player2, WinningStrategy winningStrategy) {
		this.player1 = player1;
		this.player2 = player2;
		this.winningStrategy = winningStrategy;
	}
	
	public String play() {
		Move movePlayer1 = player1.chooseMove();
		Move movePlayer2 = player2.chooseMove();
		
		return winningStrategy.determineWinner(movePlayer1, movePlayer2);
	}
}
