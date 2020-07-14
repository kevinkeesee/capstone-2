package notdemonssouls;

public interface Combatant {
	public void takeDamage(int damage);
	
	public int getAttack();
	public int getHealth();
	public int getSouls();
	
	public boolean isAlive();
}