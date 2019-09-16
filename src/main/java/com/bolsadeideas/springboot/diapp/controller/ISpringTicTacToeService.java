package com.bolsadeideas.springboot.diapp.controller;

public interface ISpringTicTacToeService {
	
	public String createGame();
	public String getGame(String idGame);
	public String nextMovement(String nm);
}
