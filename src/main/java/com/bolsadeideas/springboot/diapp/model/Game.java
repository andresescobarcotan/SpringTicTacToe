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
		String userResult = this.myBoard.putToBoard(mv);
		Movement machineMovement = this.myBoard.computeMovement(mv);
		String computerResult = this.myBoard.putToBoard(machineMovement);
		String finalResult = userResult+ "\n ---- Computer turn ---- \n "+computerResult;
		return finalResult;
	}
	

	public String getID() {
		return this.ID;
	}
}
