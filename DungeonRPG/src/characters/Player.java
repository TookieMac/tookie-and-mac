package characters;

import items.weapons.Fists;

public class Player extends Character{
	private int lvlPoints;
	/**
	 * create a new player
	 * @param str - player strength
	 * @param wis - player wisdom
	 * @param dex - player dexterity
	 */
	public Player() {
		super (1, 1, 1);
		this.hp = 50;
		this.MAX_HP = 50;
		this.lvlPoints = 6;
		this.primaryWeapon = new Fists();
		offHand = null;
	}
	
	public int getLvlPoints() {
		return lvlPoints;
	}
	public void setLvlPoints(int lvlPoints) {
		this.lvlPoints = lvlPoints;
	}
	
	@Override
	public String toString() {
		return "name: " + name + ", hp: " + hp + "\nstr: " + str + ", wis: " + wis + ", dex: " + dex;
	}
}
