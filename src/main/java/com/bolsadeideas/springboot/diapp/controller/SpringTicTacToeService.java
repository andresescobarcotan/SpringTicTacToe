package com.bolsadeideas.springboot.diapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.bolsadeideas.springboot.diapp.model.Game;

public class SpringTicTacToeService implements ISpringTicTacToeService{

	List<Game> currentGames;
	
	private final static String NO_GAME_FOUND = "No game with that ID was found";
	@Override
	public String createGame() {
		// TODO Auto-generated method stub
		String newID = String.valueOf(this.currentGames.hashCode())+":"+String.valueOf(currentGames.size()+1);
		Game newGame = new Game(newID);
		currentGames.add(newGame);
		return newID;
	}

	@Override
	public String getGame(String idGame) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String nextMovement(String nm) {
		// TODO Auto-generated method stub
		return null;
	}

	public SpringTicTacToeService() {
		this.currentGames = new ArrayList<Game>();
	}
	
	
}
