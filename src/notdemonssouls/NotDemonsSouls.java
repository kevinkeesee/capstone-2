package notdemonssouls;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class NotDemonsSouls {
	
	private static JFrame window;
	private static GameScreen screen;
	
	private static ImageIcon icon = new ImageIcon("C:\\Users\\kevdo\\OneDrive\\Documents\\Coding Bootcamp\\Java\\capstone-2\\assets\\Luck.png");


	public static void main(String[] args) {
		
		createWindow();
		createGameScreen();
		startGame();
	}
	
	private static void createWindow() {
		window = new JFrame("Not Demon's Souls");
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setIconImage(icon.getImage());
		
		window.setBounds(300, 50, Reference.width, Reference.height);
	}
	
	private static void createGameScreen() {
		screen = new GameScreen();
		window.add(screen);
		screen.requestFocusInWindow();
	}
	
	public static void startGame() {
		Reference.currentGraphic = new Graphic(0);
		Reference.currentFlavor = new Flavor(0);
		
		Reference.isTitle = true;
		Reference.firstHall = false;
		Reference.firstFight = false;
		Reference.firstParry = false;
		
		Reference.inCombat = false;
		Reference.oneStep = false;
		
		Reference.player = new Player();
	}
}