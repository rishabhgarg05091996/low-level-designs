package com.rishabh;

import com.rishabh.service.game.Game;
import com.rishabh.service.game.Scoreboard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaperRockScissorsGameLauncherTest {
	@Mock
	private Game mockGame;
	
	private final InputStream originalIn = System.in;
	private final PrintStream originalOut = System.out;
	
	@BeforeEach
	void setUp() {
		mockGame = mock(Game.class);
	}
	
	@AfterEach
	void tearDown() {
		System.setIn(originalIn);
		System.setOut(originalOut);
	}
	
	@Test
	void testReadRounds_ValidInput() {
		InputStream inputStream = new ByteArrayInputStream("3\n".getBytes());
		System.setIn(inputStream);
		
		Scanner scanner = new Scanner(System.in);
		int rounds = PaperRockScissorsGameLauncher.readRounds(scanner);
		assertEquals(3, rounds);
	}
	
	@Test
	void testReadRounds_InvalidInput() {
		InputStream inputStream = new ByteArrayInputStream("invalid\n3\n".getBytes());
		System.setIn(inputStream);
		
		Scanner scanner = new Scanner(System.in);
		int rounds = PaperRockScissorsGameLauncher.readRounds(scanner);
		assertEquals(3, rounds);
	}
	
	@Test
	void testReadRounds_RetriesExceeded() {
		InputStream inputStream = new ByteArrayInputStream("invalid\ninvalid\ninvalid\n".getBytes());
		System.setIn(inputStream);
		
		Scanner scanner = new Scanner(System.in);
		assertThrows(RuntimeException.class, () -> PaperRockScissorsGameLauncher.readRounds(scanner));
	}
	
	@Test
	void testReadMoves_RetriesExceeded() {
		InputStream inputStream = new ByteArrayInputStream("invalid\ninvalid\ninvalid\n".getBytes());
		System.setIn(inputStream);
		
		Scanner scanner = new Scanner(System.in);
		assertThrows(RuntimeException.class, () -> PaperRockScissorsGameLauncher.readMove(scanner));
	}
	
	@Test
	void testPlayRounds() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		when(mockGame.play()).thenReturn("Player 1 wins (You win)!!");
		
		Scoreboard scoreboard = new Scoreboard();
		
		PaperRockScissorsGameLauncher.playRounds(1, mockGame, scoreboard);
		
		String expectedOutput = "\nRound 1\nWinner: Player 1 wins (You win)!!\n";
		assertTrue(outputStream.toString().contains(expectedOutput));
	}
	
	@Test
	void testMain() {
		InputStream inputStream = new ByteArrayInputStream("1\nrock\n".getBytes());
		System.setIn(inputStream);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		PaperRockScissorsGameLauncher.main(new String[0]);
		
		String expectedOutput = "Thanks for playing!";
		assertTrue(outputStream.toString().contains(expectedOutput));
	}
}