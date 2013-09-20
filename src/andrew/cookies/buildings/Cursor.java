package andrew.cookies.buildings;

import andrew.cookies.game.Definitions.Buildings;
import andrew.cookies.game.GameState;

public class Cursor implements Building {

	@Override
	public Buildings getType() {
		return Buildings.CURSOR;
	}

	@Override
	public double getCPS(GameState g) {
		return 0.1;
	}

	@Override
	public double getBaseCost() {
		return 15.0;
	}

}
