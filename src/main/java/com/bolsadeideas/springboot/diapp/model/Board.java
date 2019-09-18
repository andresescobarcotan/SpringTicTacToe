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
			int y = i/COLUMNS;
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
			int y = i/COLUMNS;
			if(i==0) { boardPrinted += printLine(); }
			if(this.trueBoard[x][y]== EMPTY_POSITION) boardPrinted += "| ";
			else if (this.trueBoard[x][y]== CIRCLE) boardPrinted += "|O";
			else if (this.trueBoard[x][y]== CROSS) boardPrinted += "|X";
			if( x == nextLine) {
				boardPrinted +="|\n";
				boardPrinted += printLine();
			}
			
			
		}
		return boardPrinted;
	}
	
	private String printLine() {
		String line="";
		for(int i=0; i< COLUMNS*2 +1 ; i++) {
			line+="=";
		}
		line+="\n";
		return line;
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
	
	public Movement computeMovement(Movement playerMovement) {
		/* AI: Calculates the machine next turn */
		Movement machineMovement = new Movement();
		machineMovement.setX(0);
		machineMovement.setY(0);
		machineMovement.setCharacter(CROSS);
		if(isValid(playerMovement)) {
			int px = playerMovement.getX();
			int py = playerMovement.getY();
			// Left position
			if((px > 0)&&(this.trueBoard[px-1][py] ==EMPTY_POSITION)) {
				machineMovement.setX(px-1);
				machineMovement.setY(py);
			}
			// Right Position
			else if((px < COLUMNS)&&(this.trueBoard[px+1][py])== EMPTY_POSITION) {
				machineMovement.setX(px+1);
				machineMovement.setY(py);
			}
			// Up Position
			else if((py > 0)&&(this.trueBoard[px][py-1])== EMPTY_POSITION) {
				machineMovement.setX(px);
				machineMovement.setY(py-1);
			}
			// Down Position
			else if((py < COLUMNS)&&(this.trueBoard[px][py+1])== EMPTY_POSITION) {
				machineMovement.setX(px);
				machineMovement.setY(py+1);
			}
			else {
				// Find out the very first position free
				machineMovement = findPositionFree();
			}
		}
		return machineMovement;
	}
	
	private Movement findPositionFree() {
		
		Movement freeMv = new Movement();
		freeMv.setX(-1);
		freeMv.setY(-1);
		freeMv.setCharacter(CROSS);
		int size = ROWS*COLUMNS;
		boolean boolFreeFound = false;
		for(int i=0; i < size&&!boolFreeFound;i++) {
			int x = i%COLUMNS;
			int y = i/COLUMNS;
			if(this.trueBoard[x][y] == EMPTY_POSITION) {
				freeMv.setX(x);
				freeMv.setY(x);
				boolFreeFound = true;
			}
		}
		
		return freeMv;
	}
}
