package com.rishabh.service.game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreboardTest {
	private Scoreboard scoreboard;
	
	@BeforeEach
	void setUp() {
		scoreboard = new Scoreboard();
	}
	
	@Test
	void testUpdateScore_Player1Wins() {
		scoreboard.updateScore("Player 1 wins (You win)!!");
		scoreboard.updateScore("Player 1 wins (You win)!!");
		
		assertEquals(2, scoreboard.getPlayer1Score());
		assertEquals(0, scoreboard.getPlayer2Score());
	}
	
	@Test
	void testUpdateScore_Player2Wins() {
		scoreboard.updateScore("Player 2 wins (Computer wins)!!");
		
		assertEquals(0, scoreboard.getPlayer1Score());
		assertEquals(1, scoreboard.getPlayer2Score());
	}
	
	@Test
	void testUpdateScore_Draw() {
		scoreboard.updateScore("Draw");
		
		assertEquals(0, scoreboard.getPlayer1Score());
		assertEquals(0, scoreboard.getPlayer2Score());
	}
}