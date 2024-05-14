package com.rishabh.game;

import com.rishabh.players.Player;
import com.rishabh.players.PlayerFactory;
import com.rishabh.utils.PlayerType;

public class GameBuilder {
	private final PlayerFactory playerFactory;
	private WinningStrategy winningStrategy;
	
	public GameBuilder(PlayerFactory playerFactory) {
		this.playerFactory = playerFactory;
	}
	
	public GameBuilder withWinningStrategy(WinningStrategy winningStrategy) {
		this.winningStrategy = winningStrategy;
		return this;
	}
	
	public Game build(PlayerType player1Type, PlayerType player2Type) {
		Player player1 = playerFactory.createPlayer(player1Type);
		Player player2 = playerFactory.createPlayer(player2Type);
		return new Game(player1, player2, winningStrategy);
	}
}
