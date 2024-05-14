package com.rishabh.game;

import com.rishabh.moves.Move;
import com.rishabh.moves.Paper;
import com.rishabh.moves.Rock;
import com.rishabh.moves.Scissors;
import com.rishabh.players.Player;
import com.rishabh.players.PlayerFactory;
import com.rishabh.utils.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

class GameTest {
	
	@Mock
	private PlayerFactory playerFactory;
	
	@Mock
	private Player player1;
	
	@Mock
	private Player player2;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	private GameBuilder createGameBuilderWithStrategy(WinningStrategy strategy) {
		return new GameBuilder(playerFactory).withWinningStrategy(strategy);
	}
	
	private void mockPlayerCreation() {
		when(playerFactory.createPlayer(PlayerType.HUMAN)).thenReturn(player1);
		when(playerFactory.createPlayer(PlayerType.COMPUTER)).thenReturn(player2);
	}
	
	private void mockPlayerMoves(Move movePlayer1, Move movePlayer2) {
		given(player1.chooseMove()).willReturn(movePlayer1);
		given(player2.chooseMove()).willReturn(movePlayer2);
	}
	
	@Test
	void testGamePlay_Player1Wins() {
		// Given
		GameBuilder gameBuilder = createGameBuilderWithStrategy(new PaperRockScissorsStrategy());
		mockPlayerCreation();
		mockPlayerMoves(new Rock(), new Scissors());
		
		// When
		Game game = gameBuilder.build(PlayerType.HUMAN, PlayerType.COMPUTER);
		String result = game.play();
		
		// Then
		assertEquals("Player 1 wins (You win)!!", result);
	}
	
	@Test
	void testGamePlay_Player2Wins() {
		// Given
		GameBuilder gameBuilder = createGameBuilderWithStrategy(new PaperRockScissorsStrategy());
		mockPlayerCreation();
		mockPlayerMoves(new Paper(), new Scissors());
		
		// When
		Game game = gameBuilder.build(PlayerType.HUMAN, PlayerType.COMPUTER);
		String result = game.play();
		
		// Then
		assertEquals("Player 2 wins (Computer wins)!!", result);
	}
	
	@Test
	void testGamePlay_Draw() {
		// Given
		GameBuilder gameBuilder = createGameBuilderWithStrategy(new PaperRockScissorsStrategy());
		mockPlayerCreation();
		mockPlayerMoves(new Rock(), new Rock());
		
		// When
		Game game = gameBuilder.build(PlayerType.HUMAN, PlayerType.COMPUTER);
		String result = game.play();
		
		// Then
		assertEquals("Draw", result);
	}
}