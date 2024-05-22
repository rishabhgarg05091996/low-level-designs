package com.rishabh.model.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveTest {
	
	@Test
	void testBeats() {
		assertTrue(Move.ROCK.beats(Move.SCISSORS));
		assertTrue(Move.PAPER.beats(Move.ROCK));
		assertTrue(Move.SCISSORS.beats(Move.PAPER));
		
		assertFalse(Move.ROCK.beats(Move.PAPER));
		assertFalse(Move.PAPER.beats(Move.SCISSORS));
		assertFalse(Move.SCISSORS.beats(Move.ROCK));
	}
	
	@Test
	void testDraws() {
		assertFalse(Move.ROCK.beats(Move.ROCK));
		assertFalse(Move.PAPER.beats(Move.PAPER));
		assertFalse(Move.SCISSORS.beats(Move.SCISSORS));
	}
}