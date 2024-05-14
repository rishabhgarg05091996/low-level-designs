package com.rishabh.game;

import com.rishabh.moves.Move;
import com.rishabh.moves.Paper;
import com.rishabh.moves.Rock;
import com.rishabh.moves.Scissors;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class WinningStrategyTest {
	
	@Test
	public void testDraw() {
		WinningStrategy strategy = new PaperRockScissorsStrategy();
		Move rock = new Rock();
		assertEquals("Draw", strategy.determineWinner(rock, rock));
	}
	
	@Test
	public void testPlayer1HumanWins() {
		WinningStrategy strategy = new PaperRockScissorsStrategy();
		Move paper = new Paper();
		Move rock = new Rock();
		assertEquals("Player 1 wins (You win)!!", strategy.determineWinner(paper, rock));
	}
	
	@Test
	public void testPlayer2ComputerWins() {
		WinningStrategy strategy = new PaperRockScissorsStrategy();
		Move scissors = new Scissors();
		Move rock = new Rock();
		assertEquals("Player 2 wins (Computer wins)!!", strategy.determineWinner(scissors, rock));
	}
}