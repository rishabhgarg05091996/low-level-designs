package com.rishabh.service.game;

import com.rishabh.model.move.Move;

public interface WinningStrategy {
	String determineWinner(Move movePlayer1, Move movePlayer2);
}
