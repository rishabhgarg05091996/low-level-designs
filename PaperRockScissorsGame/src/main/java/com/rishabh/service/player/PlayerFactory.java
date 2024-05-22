package com.rishabh.service.player;

import com.rishabh.model.move.Move;
import com.rishabh.model.player.ComputerPlayer;
import com.rishabh.model.player.HumanPlayer;
import com.rishabh.model.player.Player;
import com.rishabh.model.player.PlayerType;

import java.util.function.Supplier;

public class PlayerFactory {
	public Player createPlayer(PlayerType playerType, Supplier<Move> moveSupplier) {
		return switch (playerType) {
			case HUMAN -> new HumanPlayer(moveSupplier);
			case COMPUTER -> new ComputerPlayer();
		};
	}
}