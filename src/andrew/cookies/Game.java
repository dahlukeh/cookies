package andrew.cookies;

import andrew.cookies.buildings.Building;
import andrew.cookies.buildings.BuildingFactory;
import andrew.cookies.game.Definitions;
import andrew.cookies.game.Definitions.Buildings;
import andrew.cookies.game.GameState;

public class Game implements GameState {
	private double cookiesCurrent, cookiesEarned;
	private int cookieClicks;

	private Building[] buildingBases;
	private int[] howManyBuildings;

	public Game() {
		cookiesCurrent = 0.0;
		cookiesEarned = 0.0;
		cookieClicks = 0;
		howManyBuildings = new int[Definitions.AMOUNT_BUILDINGS];
		for (int i = 0; i < Definitions.AMOUNT_BUILDINGS; i++) {
			howManyBuildings[i] = 0;
		}
		buildingBases = new BuildingFactory().getAllBuilding();
	}

	@Override
	public int howManyOfBuilding(Buildings b) {
		return howManyBuildings[b.getID()];
	}

	@Override
	public double getClickCookies() {
		return 1.0; // TODO: Change this
	}

	@Override
	public double getBaseCPS() {
		double sum = 0.0;
		for (int i = 0; i < Definitions.AMOUNT_BUILDINGS; i++) {
			sum += howManyBuildings[i] * buildingBases[i].getCPS(this);
		}
		return sum;
	}

	@Override
	public double getTotalCPS() {
		return getBaseCPS(); // TODO: Make it take multiplier into account
	}

	@Override
	public double getTotalCookies() {
		return cookiesEarned;
	}

	@Override
	public double getCurrentCookies() {
		return cookiesCurrent;
	}

	@Override
	public int getCookieClicks() {
		return cookieClicks;
	}

	@Override
	public double getCostOfBuilding(Buildings b) {
		Building bu = buildingBases[b.getID()];
		return bu.getBaseCost() * (Math.pow(1.15, howManyOfBuilding(b)));
	}

	@Override
	public void clickCookie() {
		cookieClicks++;
		cookiesEarned += getClickCookies();
		cookiesCurrent += getClickCookies();
	}

	@Override
	public void buyBuilding(Buildings b) {
		double cost = getCostOfBuilding(b);
		if (cost <= cookiesCurrent) {
			cookiesCurrent -= cost;
			howManyBuildings[b.getID()]++;
		}
	}

	@Override
	public void tick() {
		cookiesEarned += getTotalCPS() / 10.0;
		cookiesCurrent += getTotalCPS() / 10.0;
	}

}