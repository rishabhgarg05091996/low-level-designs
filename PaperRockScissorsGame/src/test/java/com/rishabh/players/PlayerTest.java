package com.rishabh.players;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rishabh.moves.Move;
import com.rishabh.moves.Paper;
import com.rishabh.moves.Rock;
import com.rishabh.moves.Scissors;

import com.rishabh.utils.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

import static org.mockito.Mockito.mock;

class PlayerTest {
	private Map<String, Supplier<Move>> moveConstructors;
	private PlayerFactory playerFactory;
	private Move rock;
	private Move paper;
	private Move scissors;
	
	@BeforeEach
	void setUp() {
		// Initialize move constructors
		moveConstructors = new HashMap<>();
		rock = new Rock();
		paper = new Paper();
		scissors = new Scissors();
		moveConstructors.put(rock.toString(), () -> rock);
		moveConstructors.put(paper.toString(), () -> paper);
		moveConstructors.put(scissors.toString(), () -> scissors);
		
		// Create a mock Scanner
		Scanner scannerMock = mock(Scanner.class);
		
		// Create PlayerFactory
		playerFactory = new PlayerFactory(scannerMock);
	}
	
	@Test
	void testHumanPlayerChooseMove_ValidInput() {
		// Prepare input for the scanner
		InputStream inputStream = new ByteArrayInputStream("rock\n".getBytes());
		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		
		// Create HumanPlayer
		Player humanPlayer = new HumanPlayer(scanner, moveConstructors);
		
		// Test chooseMove method
		Move move = humanPlayer.chooseMove();
		assertTrue(move instanceof Rock);
		
		// Clean up
		System.setIn(System.in);
	}
	
	@Test
	void testHumanPlayerChooseMove_InvalidInput() {
		// Prepare input for the scanner
		InputStream inputStream = new ByteArrayInputStream("invalid\nrock\n".getBytes());
		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		
		// Create HumanPlayer
		Player humanPlayer = new HumanPlayer(scanner, moveConstructors);
		
		// Test chooseMove method
		Move move = humanPlayer.chooseMove();
		assertTrue(move instanceof Rock);
		
		// Clean up
		System.setIn(System.in);
	}
	
	@Test
	void testChooseMove_MaxThreeRetriesExceeded() {
		// Prepare input for the scanner
		InputStream inputStream = new ByteArrayInputStream("invalid\ninvalid\ninvalid\n".getBytes());
		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		
		// Create HumanPlayer
		HumanPlayer humanPlayer = new HumanPlayer(scanner, moveConstructors);
		
		// Test chooseMove method for RuntimeException
		assertThrows(RuntimeException.class, humanPlayer::chooseMove);
		
		// Clean up
		System.setIn(System.in);
	}
	
	@Test
	void testComputerPlayerChooseMove() {
		// Create ComputerPlayer
		Player computerPlayer = new ComputerPlayer(moveConstructors);
		
		// Test chooseMove method
		Move move = computerPlayer.chooseMove();
		assertNotNull(move);
	}
	
	@Test
	void testPlayerFactoryCreatePlayer() {
		// Test creating HumanPlayer
		Player humanPlayer = playerFactory.createPlayer(PlayerType.HUMAN);
		assertTrue(humanPlayer instanceof HumanPlayer);
		
		// Test creating ComputerPlayer
		Player computerPlayer = playerFactory.createPlayer(PlayerType.COMPUTER);
		assertTrue(computerPlayer instanceof ComputerPlayer);
	}
}