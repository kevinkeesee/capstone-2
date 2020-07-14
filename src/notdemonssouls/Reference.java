package notdemonssouls;

public class Reference {
	//Fixes the size of the window
	public static final int width = 1440;
	public static final int height = 1080;
	
	public static Graphic currentGraphic;
	public static Flavor currentFlavor;
	
	public static Player player;
	
	public static Dregling dregling;
	
	//Flags for scripting the opening
	public static boolean isTitle;
	public static boolean firstHall;
	public static boolean firstFight;
	public static boolean firstParry;
	
	//Flags for combat
	public static boolean inCombat;
	
	//Flag for allowing a space between inputs
	public static boolean oneStep;
	
	//To help end combat in less than 1 update
	public static void endCombat() {
		currentGraphic.changeFile(1);
		currentFlavor.changeFile(5);
			
		player.addSouls(dregling.getSouls());
			
		inCombat = false;
		oneStep = true;
	}
	
	//To help make the death screen appear in less than 1 update, and reset all flags
	public static void death() {
		
		isTitle = false;
		firstHall = false;
		firstFight = false;
		firstParry = false;
		
		inCombat = false;
		oneStep = false;
		
		dregling = null;
		
		currentFlavor.changeFile(99);
		currentGraphic.changeFile(99);
	}
}