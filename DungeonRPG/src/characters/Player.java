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
	public Player(final int str, final int wis, final int dex) {
		super (str, wis, dex);
		this.hp = 50;
		this.lvlPoints = 6;
		this.primaryWeapon = new Fists();
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
