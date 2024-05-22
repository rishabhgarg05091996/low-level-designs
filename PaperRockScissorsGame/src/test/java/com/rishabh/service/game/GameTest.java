package com.rishabh.service.game;

import com.rishabh.model.move.Move;
import com.rishabh.model.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameTest {
	@Mock
	private Player mockPlayer1;
	
	@Mock
	private Player mockPlayer2;
	
	@Mock
	private WinningStrategy mockStrategy;
	
	private Game game;
	
	@BeforeEach
	void setUp() {
		mockPlayer1 = mock(Player.class);
		mockPlayer2 = mock(Player.class);
		mockStrategy = mock(WinningStrategy.class);
		
		game = new Game(mockPlayer1, mockPlayer2, mockStrategy);
	}
	
	@Test
	void testPlay() {
		when(mockPlayer1.chooseMove()).thenReturn(Move.ROCK);
		when(mockPlayer2.chooseMove()).thenReturn(Move.SCISSORS);
		when(mockStrategy.determineWinner(Move.ROCK, Move.SCISSORS)).thenReturn("Player 1 wins");
		
		String result = game.play();
		assertEquals("Player 1 wins", result);
	}
}