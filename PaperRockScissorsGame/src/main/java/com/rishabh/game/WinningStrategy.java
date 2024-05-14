package com.rishabh.game;

import com.rishabh.moves.Move;

public interface WinningStrategy {
	String determineWinner(Move movePlayer1, Move movePlayer2);
}
