package andrew.cookies.game;

public class Definitions {

	public static final int AMOUNT_BUILDINGS = 1;
	
	public enum Buildings {
		CURSOR(0, "Cursor");
		
		private int id;
		private String name;
		
		private Buildings(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public int getID() {
			return id;
		}
	}
	
	
}
