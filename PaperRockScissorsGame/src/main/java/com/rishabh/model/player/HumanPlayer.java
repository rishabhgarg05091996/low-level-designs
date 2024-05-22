package com.rishabh.model.player;

import com.rishabh.model.move.Move;

import java.util.function.Supplier;

public class HumanPlayer implements Player {
	private final Supplier<Move> moveSupplier;
	
	public HumanPlayer(Supplier<Move> moveSupplier) {
		this.moveSupplier = moveSupplier;
	}
	
	@Override
	public Move chooseMove() {
		return moveSupplier.get();
	}
}
