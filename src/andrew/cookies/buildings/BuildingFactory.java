package andrew.cookies.buildings;

import andrew.cookies.game.Definitions;

public class BuildingFactory {

	public Building[] getAllBuilding() {
		Building[] b = new Building[Definitions.AMOUNT_BUILDINGS];
		b[0] = new Cursor();
		return b;
	}
	
}
