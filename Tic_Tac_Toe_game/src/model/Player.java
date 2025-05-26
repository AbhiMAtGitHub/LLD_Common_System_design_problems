package model;

import Strategy.MoveStrategy;

public class Player {
	private String name;
	private char symbol;
	private MoveStrategy moveStrategy;
	
	public Player(String name, char symbol, MoveStrategy moveStrategy) {
		this.name = name;
		this.symbol = symbol;
		this.moveStrategy = moveStrategy;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public Position makeMove(Board board) {
		return moveStrategy.getMove(board);
	}
	
	public String getName() {
		return name;
	}
}
