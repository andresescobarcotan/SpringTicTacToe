package com.bolsadeideas.springboot.diapp.model;

public class Board {
	private final static int ROWS = 3;
	private final static int COLUMNS = 3;
	private final static int EMPTY_POSITION = 0;
	private final static int CIRCLE = 1;
	private final static int CROSS = 2;
	private final static String INVALID_MOVEMENT = "This is an invalid movement, please try again!\n";
	private int[][] trueBoard;
	
	private void initBoard() {
		this.trueBoard = new int[ROWS][COLUMNS];
		int size = ROWS*COLUMNS;
		for(int i=0; i < size;i++) {
			int x = i%COLUMNS;
			int y = i - x;
			this.trueBoard[x][y] = EMPTY_POSITION;			
		}
	}
	
	@Override
	public String toString() {
		int size = ROWS*COLUMNS;
		int nextLine = COLUMNS -1;
		String boardPrinted = "";
		for(int i=0; i < size;i++) {
			int x = i%COLUMNS;
			int y = i - x;
			if(this.trueBoard[x][y]== EMPTY_POSITION) boardPrinted += "| |";
			else if (this.trueBoard[x][y]== CIRCLE) boardPrinted += "|O|";
			else if (this.trueBoard[x][y]== CROSS) boardPrinted += "|X|";
			if( y == nextLine) {
				boardPrinted +="\n";
			}

			
		}
		return boardPrinted;
	}
	
	public String putToBoard(Movement mv) {
		String resultBoard = "";
		if(!isValid(mv)) {
			resultBoard += INVALID_MOVEMENT;
		} else {
			int currentX = mv.getX();
			int currentY = mv.getY();
			if(this.trueBoard[currentX][currentY]== EMPTY_POSITION) {
				this.trueBoard[currentX][currentY] = mv.getCharacter();
				resultBoard += this.toString();
			}
			
		}
		return resultBoard;
	}
	
	public Board() {
		this.initBoard();
	}
	
	private boolean isValid(Movement mv) {
		boolean validMovement = true;
		int currentX = mv.getX();
		int currentY = mv.getY();
		int currentChar = mv.getCharacter();
		
		if(0 > currentX || currentX > ROWS) validMovement = false;
		if(0 > currentY || currentY > COLUMNS) validMovement = false;
		if(EMPTY_POSITION > currentChar || currentChar > CROSS ) validMovement = false;
		
			
		return validMovement;
	}
}
