package model;

public class Board {
	char[][] grid = new char[3][3];
	
	public Board() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grid[i][j] = '-';
			}
		}
	}
	
	public boolean isCellEmpty(int row, int col) {
		return grid[row][col] == '-';
	}
	
	public void printBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean placeMove(Position position, char symbol) {
		if(isCellEmpty(position.row, position.col)) {
			grid[position.row][position.col] = symbol;
			return true;
		}
		return false;
	}
	
	public char[][] getGrid(){
		return grid;
	}
}
