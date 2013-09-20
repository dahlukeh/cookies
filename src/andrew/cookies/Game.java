package andrew.cookies;
public class Game {
	private boolean ready, frenzy;
	private int cookies, cookiesEarned, cookiesPs,cookiesReset;
	private int frenzyPower, clickFrenzy;
	private int cookieClicks, goldenClicks;
		
	public int getReady() {
		return ready;
	}
	public Game() {
		ready = false;
		cookiesEarned = 0;
		cookies = 0;
		cookiesPs = 1;
		cookiesReset = 0;
		frenzy = false;
		frenzyPower = 1;
		clickFrenzy = 1;
		cookieClicks = 0;
		goldenClicks = 0;
		missedGoldenClicks = 0;
		handmadeCookies = 0;
	}
}