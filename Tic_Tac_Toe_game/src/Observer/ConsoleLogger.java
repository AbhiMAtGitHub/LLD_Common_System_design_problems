package Observer;

import model.Player;
import model.Position;

public class ConsoleLogger implements GameObserver {

	@Override
	public void onMakeMove(Player player, Position position) {
		System.out.println("[Observer] Player " + player.getName() + " placed move on (" + position.row + "-" + position.col + ")");
	}

	@Override
	public void onPlayerWin(Player player) {
		 System.out.println("[Observer] Game won by " + player.getName() + "!");
	}

	@Override
	public void onGameDraw() {
		System.out.println("[Observer] Game ended in a draw.");
	}
}

