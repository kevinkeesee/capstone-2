package notdemonssouls;

public class Player implements Combatant {
	
	private int health;
	private int souls;
	
	private int defense;
	private int attack;
	
	public static final int maxHealth = 100;
	
	private boolean isAlive;
	
	public Player() {
		health = maxHealth;
		souls = 0;
		
		defense = 5;
		attack = 20;
		
		isAlive = true;
	}
	
	public void takeDamage(int damage) {
		if(damage > defense) {
			health -= (damage - defense);
			
			if(health <= 0) {
				isAlive = false;
				Reference.death();
			}
		}
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void addSouls(int soul) {
		if (soul > 0) {
			souls += soul;
		}
	}
	
	public int getSouls() {
		return souls;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
}