package com.bolsadeideas.springboot.diapp.controller;

import com.bolsadeideas.springboot.diapp.model.Movement;

public interface ISpringTicTacToeService {
	
	public String createGame();
	public String getGame(String idGame);
	public String nextMovement(String idGame, Movement nm);
}
