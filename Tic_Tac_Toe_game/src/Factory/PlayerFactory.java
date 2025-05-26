package Factory;

import Strategy.PlayerMoveStrategy;
import model.Player;

public class PlayerFactory {
	public static Player createPlayer(String name, char symbol) {
		return new Player(name, symbol, new PlayerMoveStrategy());
	}
}
