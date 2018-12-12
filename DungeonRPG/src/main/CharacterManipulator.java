package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import characters.Player;
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
		while (lvlPoints > 0) {
			try {
				applyPoints();
			}
			catch(InputMismatchException e) {
				System.out.println("invalid input");
			}
		}
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

	private void applyPoints() throws InputMismatchException{
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		int res = 0;
		while (lvlPoints > 0 && exit == false) {
			System.out.println("you have " + lvlPoints + " level points remaining");
			System.out.println("apply # to dexterity");
			res = sc.nextInt();
			if (res <= lvlPoints) {

				applyDex(res);
			}
			else {
				System.out.println("you do not have that many points remaining");
			}
			System.out.println("you have " + lvlPoints + " level points remaining");
			System.out.println("apply # to strength");
			res = sc.nextInt();
			if (res <= lvlPoints) {
				applyStr(res);
			}
			else {
				System.out.println("you do not have that many points remaining");
			}
			System.out.println("you have " + lvlPoints + " level points remaining");
			System.out.println("apply # to wisdom");
			res = sc.nextInt();
			if (res <= lvlPoints) {
				applyWis(res);
			}
			else {
				System.out.println("you do not have that many points remaining");
			}

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
