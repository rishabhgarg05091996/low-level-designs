package com.rishabh;

import com.rishabh.game.Game;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaperRockScissorsGameLauncherTest {
	@Mock
	private Game mockGame;
	
	@BeforeEach
	void setUp() {
		mockGame = mock(Game.class);
	}
	
	@AfterEach
	void tearDown() {
		mockGame = null;
	}
	
	@Test
	void testReadRounds_ValidInput() {
		// Prepare input for the scanner
		InputStream inputStream = new ByteArrayInputStream("3\n".getBytes());
		System.setIn(inputStream);
		
		// Test the readRounds method
		Scanner scanner = new Scanner(System.in);
		int rounds = PaperRockScissorsGameLauncher.readRounds(scanner);
		assertEquals(3, rounds);
		
		// Clean up
		System.setIn(System.in);
	}
	
	@Test
	void testReadRounds_InvalidInput() {
		// Prepare input for the scanner
		InputStream inputStream = new ByteArrayInputStream("invalid\n3\n".getBytes());
		System.setIn(inputStream);
		
		// Test the readRounds method
		Scanner scanner = new Scanner(System.in);
		int rounds = PaperRockScissorsGameLauncher.readRounds(scanner);
		assertEquals(3, rounds);
		
		// Clean up
		System.setIn(System.in);
	}
	
	@Test
	void testReadRounds_RetriesExceeded() {
		// Prepare input for the scanner
		InputStream inputStream = new ByteArrayInputStream("invalid\ninvalid\ninvalid\n".getBytes());
		System.setIn(inputStream);
		
		// Test the readRounds method
		Scanner scanner = new Scanner(System.in);
		assertThrows(RuntimeException.class, () -> PaperRockScissorsGameLauncher.readRounds(scanner));
		
		// Clean up
		System.setIn(System.in);
	}
	
	@Test
	void testPlayRounds() {
		// Redirect standard output to capture printed messages
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		// Mock the Game object
		when(mockGame.play()).thenReturn("Player 1");
		
		// Test the playRounds method
		PaperRockScissorsGameLauncher.playRounds(1, mockGame);
		
		// Verify the output
		String expectedOutput = "\nRound 1\nWinner: Player 1\n";
		assertEquals(expectedOutput, outputStream.toString());
		
		// Clean up
		System.setOut(System.out);
	}
	
	@Test
	void testMain() {
		// Prepare input for the scanner
		InputStream inputStream = new ByteArrayInputStream("1\npaper".getBytes());
		System.setIn(inputStream);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		
		// Call the main method
		PaperRockScissorsGameLauncher.main(new String[0]);
		
		// Verify the output
		String expectedOutput = "\nThanks for playing!\n";
		assertContains(expectedOutput, outputStream.toString());
		
		// Clean up
		System.setIn(System.in);
		System.setOut(System.out);
	}
	
	public static void assertContains(String expectedSubstring, String actualString) {
		if (!actualString.contains(expectedSubstring)) {
			throw new AssertionError("Expected substring '" + expectedSubstring + "' not found in actual string:\n" + actualString);
		}
	}
}