package com.rishabh.moves;

public class Scissors implements Move {
	
	public static final String SCISSORS_NAME = "scissors";
	
	@Override
	public boolean beats(Move other) {
		return other instanceof Paper;
	}
	
	@Override
	public String toString() {
		return SCISSORS_NAME;
	}
}