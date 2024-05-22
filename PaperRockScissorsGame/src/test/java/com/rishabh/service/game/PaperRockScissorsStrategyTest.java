package com.rishabh.service.game;

import com.rishabh.model.move.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperRockScissorsStrategyTest {
	private PaperRockScissorsStrategy strategy;
	
	@BeforeEach
	void setUp() {
		strategy = new PaperRockScissorsStrategy();
	}
	
	@Test
	void testDetermineWinner_Player1Wins() {
		assertEquals("Player 1 wins (You win)!!", strategy.determineWinner(Move.ROCK, Move.SCISSORS));
		assertEquals("Player 1 wins (You win)!!", strategy.determineWinner(Move.PAPER, Move.ROCK));
		assertEquals("Player 1 wins (You win)!!", strategy.determineWinner(Move.SCISSORS, Move.PAPER));
	}
	
	@Test
	void testDetermineWinner_Player2Wins() {
		assertEquals("Player 2 wins (Computer wins)!!", strategy.determineWinner(Move.ROCK, Move.PAPER));
		assertEquals("Player 2 wins (Computer wins)!!", strategy.determineWinner(Move.PAPER, Move.SCISSORS));
		assertEquals("Player 2 wins (Computer wins)!!", strategy.determineWinner(Move.SCISSORS, Move.ROCK));
	}
	
	@Test
	void testDetermineWinner_Draw() {
		assertEquals("Draw", strategy.determineWinner(Move.ROCK, Move.ROCK));
		assertEquals("Draw", strategy.determineWinner(Move.PAPER, Move.PAPER));
		assertEquals("Draw", strategy.determineWinner(Move.SCISSORS, Move.SCISSORS));
	}
}