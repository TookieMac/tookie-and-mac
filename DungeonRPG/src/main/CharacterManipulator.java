package main;

import characters.Player;
import items.Item;
import items.weapons.Weapon;

public class CharacterManipulator {
	private Player player;
	private int lvlPoints;

	/**
	 * create a new character
	 * @param name - characters name
	 */
	public CharacterManipulator(final String name) {
		this.player = new Player();
		this.player.setName(name);
		this.lvlPoints = player.getLvlPoints();
		applyPoints();
	}
	/**
	 * edit the current player
	 * @param player - the current player
	 */
	public CharacterManipulator(final Player player) {
		this.player = player;
		lvlPoints = player.getLvlPoints();
		applyPoints();
	}

	private void applyPoints() {
		boolean exit = false;
		//TODO allow for use input here
		while (lvlPoints > 0 && exit == false) {
			System.out.println("you have " + lvlPoints + " remaining");
			applyDex(1);
			System.out.println("you have " + lvlPoints + " remaining");
			applyStr(1);
			System.out.println("you have " + lvlPoints + " remaining");
			applyWis(1);
		}
		System.out.println("-------------------------------------------\n" + player.toString() + "\n-------------------------------------------");
	}

	private void applyDex(int points) {
		player.setDex(player.getDex() + points);
		lvlPoints -= points;
	}
	private void applyStr(int points) {
		player.setStr(player.getStr() + points);
		lvlPoints -= points;
	}
	private void applyWis(int points) {
		player.setWis(player.getWis() + points);
		lvlPoints -= points;
	}

	protected void setPrimaryWeapon(Weapon weapon) {
		player.setPrimaryWeapon(weapon);
	}
	protected void setOffHand(Weapon offHand) {
		player.setOffHand(offHand);
	}

	public Player getPlayer() {
		return player;
	}

}
