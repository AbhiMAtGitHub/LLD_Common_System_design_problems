package Strategy;

import model.Board;
import model.Position;

public interface MoveStrategy {
	Position getMove(Board board);
}
