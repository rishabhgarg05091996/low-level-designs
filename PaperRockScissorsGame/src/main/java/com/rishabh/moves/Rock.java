package com.rishabh.moves;

public class Rock implements Move {
	
	private static final String ROCK_NAME = "rock";
	
	@Override
	public boolean beats(Move other) {
		return other instanceof Scissors;
	}
	
	@Override
	public String toString() {
		return ROCK_NAME;
	}
}