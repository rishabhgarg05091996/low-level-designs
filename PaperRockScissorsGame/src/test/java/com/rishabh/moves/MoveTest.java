package com.rishabh.moves;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveTest {
	
	private Move rock;
	private Move paper;
	private Move scissors;
	
	@BeforeEach
	void setUp() {
		rock = new Rock();
		paper = new Paper();
		scissors = new Scissors();
	}
	
	@Test
	void testRockBeatsScissors() {
		assertTrue(rock.beats(scissors));
	}
	
	@Test
	void testPaperBeatsRock() {
		assertTrue(paper.beats(rock));
	}
	
	@Test
	void testScissorsBeatsPaper() {
		assertTrue(scissors.beats(paper));
	}
	
	@Test
	void testRockDoesNotBeatPaper() {
		assertFalse(rock.beats(paper));
	}
	
	@Test
	void testPaperDoesNotBeatScissors() {
		assertFalse(paper.beats(scissors));
	}
	
	@Test
	void testScissorsDoesNotBeatRock() {
		assertFalse(scissors.beats(rock));
	}
	
	@Test
	void testRockToString() {
		assertEquals("rock", rock.toString());
	}
	
	@Test
	void testPaperToString() {
		assertEquals("paper", paper.toString());
	}
	
	@Test
	void testScissorsToString() {
		assertEquals("scissors", scissors.toString());
	}
}