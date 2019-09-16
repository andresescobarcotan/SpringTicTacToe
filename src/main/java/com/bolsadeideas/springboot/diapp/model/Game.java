package com.bolsadeideas.springboot.diapp.model;

public class Game {
	
	private String ID;
	private Board myBoard;
	
	
	public Game(String newID) {
		this.ID = newID;
		this.myBoard = new Board();	
	}
	
	public String getCurrentStateOfGame() {
		return this.myBoard.toString();
	}
	
	public String putToBoard(Movement mv) {
		return this.myBoard.putToBoard(mv);
	}
}
