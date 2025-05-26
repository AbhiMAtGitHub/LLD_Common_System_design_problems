package Strategy;

import java.util.Scanner;

import model.Board;
import model.Position;

public class PlayerMoveStrategy implements MoveStrategy {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public Position getMove(Board board) {
		while(true) {
			System.out.println("Enter your move (row and column: 0-2)");
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			if(row >= 0 && row <=2 && col >= 0 && col <= 2 && board.isCellEmpty(row, col)) {
				return new Position(row, col);
			} else {
				System.out.println("Invalid Move! Try Again");
			}
		}
	}
}
