package notdemonssouls;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameScreen extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameScreen() {
		addKeyListener(this);
		this.setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint(); revalidate();
		
		//Framework
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Reference.width, Reference.height);
		
		g.setColor(Color.WHITE);
		g.drawLine(60, Reference.height-980, Reference.width-80, Reference.height-980);
		g.drawRoundRect(5, Reference.height - Reference.height/5, Reference.width-25, Reference.height/5 - 42, 5, 5);
		
		//Upper GUI
		g.setFont(new Font("arial", Font.BOLD, 40));
		g.drawString("HP", 70, 64);
		g.drawRect(140, 36, 200, 30);
		//Responsive fill for HP
		g.fillRect(140, 36, Reference.player.getHealth()*2, 30);
		
		//Amount of souls
		g.drawRect(1200, 36, 150, 30);
		g.setFont(new Font("arial", Font.PLAIN, 24));
		g.drawString(Integer.toString(Reference.player.getSouls()), 1210, 60);
		
		//Enemy health
		if(Reference.dregling != null && Reference.dregling.isAlive() && Reference.player.isAlive()) {
			g.drawRect(620, 320, 150, 16);
			g.fillRect(620, 320, (int) (Reference.dregling.getHealth()*1.5), 16);
		}
		
		//ASCII graphic
		g.setFont(new Font("monospaced", Font.PLAIN, 16));
		for(int i = 0; i < Reference.currentGraphic.getLength(); i++) {
			g.drawString(Reference.currentGraphic.getLine(i), 40, (135)+i*18);
		}
		
		//Flavor Text
		g.setFont(new Font("arial", Font.PLAIN, 24));
		for(int i = 0; i < Reference.currentFlavor.getLength(); i++) {
			g.drawString(Reference.currentFlavor.getLine(i), 20, (900)+i*26);
		}
		
		//Game Over Text
		if (!Reference.player.isAlive()) {
			g.drawLine(5, 550, Reference.width-20, 550);
			g.drawLine(5, 320, Reference.width-20, 320);
			g.setFont(new Font("timesroman", Font.PLAIN, 290));
			g.drawString("YOU DIED", 15, 530);
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if(Reference.isTitle) {
			
			//Handle the title screen
			Reference.currentGraphic.changeFile(1);
			Reference.currentFlavor.changeFile(1);
			
			Reference.isTitle = false;
			Reference.firstHall = true;
			
		} else if(Reference.firstHall) {
			
			//Handle the first hallway
			switch(arg0.getKeyCode()) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_W:
					Reference.currentGraphic.changeFile(2);
					Reference.currentFlavor.changeFile(2);
					
					Reference.dregling = new Dregling();
					
					Reference.firstHall = false;
					Reference.firstFight = true;
					Reference.inCombat = true;
					break;
			}
			
		} else if(Reference.firstFight) {
			
			//Handle teaching attacking
			switch(arg0.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					Reference.dregling.takeDamage(Reference.player.getAttack());
					
					Reference.currentGraphic.changeFile(3);
					Reference.currentFlavor.changeFile(3);
					
					Reference.firstFight = false;
					Reference.firstParry = true;
			}
			
		} else if (Reference.firstParry){
			
			//Handle teaching parrying
			switch(arg0.getKeyCode()) {
				case KeyEvent.VK_SHIFT:
					Reference.dregling.riposte();
					
					Reference.currentGraphic.changeFile(4);
					Reference.currentFlavor.changeFile(4);
					
					Reference.firstParry = false;
					break;
				case KeyEvent.VK_SPACE:
					Reference.dregling.takeDamage(Reference.player.getAttack());
					Reference.player.takeDamage(Reference.dregling.getAttack());
					
					if(!Reference.dregling.isAlive()) {
						Reference.firstParry = false;
						Reference.endCombat();
					}
			}
			
		} else if(Reference.inCombat) {
				
			if(Reference.dregling.isAlive()) {
					
				if(Reference.oneStep) {
					//Make the dregling wait 1 cycle before attacking
					switch(arg0.getKeyCode()) {
						case KeyEvent.VK_SPACE:
							Reference.dregling.takeDamage(Reference.player.getAttack());
							Reference.currentGraphic.changeFile(3);
					}
					Reference.oneStep = false;
						
				} else if(Reference.dregling.isStunned()) {
					//Stunlock dregling until death
					switch(arg0.getKeyCode()) {
						case KeyEvent.VK_SPACE:
							Reference.dregling.takeDamage(Reference.player.getAttack());
								
							if(!Reference.dregling.isAlive()) {
								Reference.endCombat();
							}
					}
						
				} else {
					
					//Dregling will attack unless parried
					switch(arg0.getKeyCode()) {
						case KeyEvent.VK_SHIFT:
							Reference.dregling.riposte();
							Reference.currentGraphic.changeFile(4);
							break;
						case KeyEvent.VK_SPACE:
							Reference.dregling.takeDamage(Reference.player.getAttack());
							Reference.player.takeDamage(Reference.dregling.getAttack());
							
							if(!Reference.dregling.isAlive()) {
								Reference.endCombat();
							}
						default:
							Reference.player.takeDamage(Reference.dregling.getAttack());
					}
				}
			}
		} else if (Reference.oneStep) {
				
			switch(arg0.getKeyCode()) {
				//Give an empty screen between encounters
				case KeyEvent.VK_UP:
				case KeyEvent.VK_W:
					Reference.currentFlavor.changeFile(6);
					Reference.oneStep = false;
					break;
			}
				
		} else {
				
			switch(arg0.getKeyCode()) {
				//Proceed to next event
				case KeyEvent.VK_UP:
				case KeyEvent.VK_W:
					Reference.currentGraphic.changeFile(2);
					Reference.currentFlavor.changeFile(7);
					
					Reference.dregling = new Dregling();
					
					Reference.inCombat = true;
						
					Reference.oneStep = true;
					break;
			}
			
			//Restart the game
			if(!Reference.player.isAlive()) {

				switch(arg0.getKeyCode()) {
					default:
						System.out.println("Initializing...");
						NotDemonsSouls.startGame();
				}
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	@Override
	public void keyReleased(KeyEvent arg0) {}
}
