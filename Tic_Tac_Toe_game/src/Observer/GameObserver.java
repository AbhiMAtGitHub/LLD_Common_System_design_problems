package Observer;

import model.Player;
import model.Position;

public interface GameObserver {
	void onMakeMove(Player player, Position position);
	void onPlayerWin(Player player);
	void onGameDraw();
}
