package andrew.cookies.buildings;

import andrew.cookies.game.Definitions.Buildings;
import andrew.cookies.game.GameState;

/*
 * Assumptions:
 * Double is good enough. We may need to use big numbers at some point
 * That each building of the same type has the same cps
 */
public interface Building {

	public Buildings getType();
	
	/*
	 * Returns the CPS of one instance of that building.
	 * Should not multiple by the percentage. Rather, just take into account the upgrades etc.
	 */
	public double getCPS(GameState g);
	
	/* 
	 * Get's the base cost of this building. Don't care about how many there are	 * 
	 */
	public double getBaseCost();
	
}
