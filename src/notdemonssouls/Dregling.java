package notdemonssouls;

public class Dregling implements Combatant {
	
	private int health;
	
	private int defense;
	private int attack;
	
	public static final int maxHealth = 100;
	public static final int soulsDropped = 20;
	
	private boolean isAlive;
	private boolean isStunned;
	
	public Dregling() {
		health = maxHealth;
		
		defense = 2;
		attack = 15;
		
		isAlive = true;
		isStunned = false;
	}

	public void takeDamage(int damage) {
		
		//Handle riposte stun
		if(isStunned) {
			//Deal double damage
			health -= (damage*2) - defense;
			
		} else if (damage > defense) {
			health -= (damage - defense);
			
		}
		
		if (health <= 0) {
			isAlive = false;
		}
	}
	
	public void riposte() {
		isStunned = true;
	}
	
	public int getAttack() {
		if(isStunned || !isAlive) {
			return 0;
		}
		return attack;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getSouls() {
		return soulsDropped;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public boolean isStunned() {
		return isStunned;
	}
}