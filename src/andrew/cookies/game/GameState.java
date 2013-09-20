package andrew.cookies.game;

import andrew.cookies.game.Definitions.Buildings;

public interface GameState {

	public int howManyOfBuilding(Buildings b);
	
	public double getCostOfBuilding(Buildings b);
	
	public double getClickCookies();
	
	public double getBaseCPS();
	
	public double getTotalCPS();
	
	public double getTotalCookies();
	
	public double getCurrentCookies();
	
	public int getCookieClicks();
	
	public void clickCookie();
	
	public void buyBuilding(Buildings b);
	
	// 1/10ths of a second tick
	public void tick();
}
