package com.rishabh.moves;

public class Paper implements Move {
	
	private static final String PAPER_NAME = "paper";
	
	@Override
	public boolean beats(Move other) {
		return other instanceof Rock;
	}
	
	@Override
	public String toString() {
		return PAPER_NAME;
	}
}
