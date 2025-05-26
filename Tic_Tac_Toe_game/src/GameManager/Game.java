package GameManager;

import model.Board;
import model.Player;
import model.Position;

import java.util.ArrayList;
import java.util.List;

import Observer.GameObserver;

public class Game {
	private Board board;
	private Player[] players;
	private int currentPlayerIndex;
	private List<GameObserver> observers = new ArrayList<>();
	
	public Game(Player p1, Player p2) {
		this.board = new Board();
		this.players = new Player[] {p1, p2};
		this.currentPlayerIndex = 0;
	}
	
	public void start() {
		while(true) {
			board.printBoard();
			Player current = players[currentPlayerIndex];
			System.out.println("Player " + current.getSymbol() + "'s move");
			
			Position pos = current.makeMove(board);
			board.placeMove(pos, current.getSymbol());
			notifyMove(current, pos);
			
			if(checkWin(current.getSymbol())) {
				board.printBoard();
				System.out.println("Player " + current.getSymbol() + " wins!");
				notifyWin(current);
				break;
			} else if(checkDraw()) {
				board.printBoard();
				System.out.println("It's a draw!");
				notifyDraw();
				break;
			}
			currentPlayerIndex = 1 - currentPlayerIndex;
		}
	}
	
	public boolean checkWin(char symbol) {
		char[][] grid = board.getGrid();
		for(int i = 0; i < 3; i++) {
			if(grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
			if(grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
		}
		return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) || 
				(grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
	}
	
	public boolean checkDraw() {
		char[][] grid = board.getGrid();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] == '-') return false;
			}
		}
		return true;
	}
	
	public void addObserver(GameObserver observer) {
		observers.add(observer);
	}
	
	private void notifyMove(Player player, Position position) {
	    for (GameObserver observer : observers) {
	        observer.onMakeMove(player, position);
	    }
	}

	private void notifyWin(Player player) {
	    for (GameObserver observer : observers) {
	        observer.onPlayerWin(player);
	    }
	}

	private void notifyDraw() {
	    for (GameObserver observer : observers) {
	        observer.onGameDraw();
	    }
	}
}
