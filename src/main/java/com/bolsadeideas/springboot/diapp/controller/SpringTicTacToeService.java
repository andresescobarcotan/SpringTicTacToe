package com.bolsadeideas.springboot.diapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.diapp.model.Game;
import com.bolsadeideas.springboot.diapp.model.Movement;

@Service
public class SpringTicTacToeService implements ISpringTicTacToeService{

	List<Game> currentGames;
	
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
		// TODO: Change this for another more convinient iterator method
		String strGameBoard ="";
		for(Game game: currentGames) {
			if(game.getID().equals(idGame)) {
				strGameBoard = game.getCurrentStateOfGame();
			}
		}
		return strGameBoard;
	}

	@Override
	public String nextMovement(String idGame, Movement nm) {
		String strGameBoard ="";
		for(Game game: currentGames) {
			if(game.getID().equals(idGame)) {
				strGameBoard = game.putToBoard(nm);
			}
		}
		return strGameBoard;
	}
	

	public SpringTicTacToeService() {
		this.currentGames = new ArrayList<Game>();
	}
	
	
}
