package ClientCode;

import java.util.Scanner;

import Factory.PlayerFactory;
import GameManager.Game;
import Observer.ConsoleLogger;
import model.Player;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Player 1's name: ");
		String player1Name = sc.next();
		System.out.println("Enter Player 2's name: ");
		String player2Name = sc.next();
		Player p1 = PlayerFactory.createPlayer(player1Name, 'X');
		Player p2 = PlayerFactory.createPlayer(player2Name, 'O');
	
		
		Game game = new Game(p1, p2);
		game.addObserver(new ConsoleLogger());
		game.start();
		
	}
}
