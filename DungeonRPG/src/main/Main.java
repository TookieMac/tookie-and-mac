package main;

import java.util.Scanner;
import characters.Player;
import characters.Character;
import dungeons.Dungeon;

/**
 * 
 * @author tookie
 *
 */
public class Main {
	private static Player player;
	private static Dungeon dungeon;
	private static Character enemy;
	private static Scanner s = new Scanner(System.in);
	private static boolean playing = true;

	public static void main(String[] args) {
		player = new CharacterManipulator("tookie").getPlayer();
		player.setOffHand(null);
		dungeon = new DungeonManipulator("tookie").getDungeon();
		player.displayDetails();
		String res = "";
		while (playing) {
			System.out.println("what will you do?");
			System.out.println("walk (n)orth, (s)outh, (e)ast, or (w)est?");
			System.out.println("(u)se an item");
			System.out.println("or (v)iew your inventory?");
			res = s.nextLine();
			if (res.equalsIgnoreCase("n") || res.equalsIgnoreCase("s") || res.equalsIgnoreCase("e") || res.equalsIgnoreCase("w")) {
				playing = dungeon.move(res);
				battle();
				if (playing){//if not dead from the battle
					pickup();
				}
			}
			else if (res.equalsIgnoreCase("U")) {
				System.out.println("use item");
				player.UseItem();
			}
			else if (res.equalsIgnoreCase("V")) {
				System.out.println("view inventory");
			}
		}
		
	}

	/**
	 * simulate a battle between the player and the rooms enemy
	 */
	public static void battle() {
		//TODO add use item option
		enemy = dungeon.getCurrentRoom().getEnemy();
		boolean coward = false;
		String res = "";
		if (enemy != null) {//make sure there is an enemy in the room
			System.out.println("you see an enemy " + enemy.getClass().getSimpleName() + " (name: " + enemy.getName() + ")");
			while (enemy.getHp() > 0 && player.getHp() > 0 && coward == false) {
				System.out.println("what will you do?");
				System.out.println("(a)ttack " + enemy.getName() + ", (u)se an item from your inventory, or (r)etreat from battle");
				res = s.nextLine();
				if (res.equalsIgnoreCase("a")) {
					attack();
				}
				else if (res.equalsIgnoreCase("r")) {
					coward = true;
				}
				else if (res.equalsIgnoreCase("u")) {
					player.UseItem();
				}
				else {
					System.out.println("invalid");
				}
			}

			System.out.println("the battle is over");
			if (player.getHp() > 0 && coward == false) {
				System.out.println(player.getName() + " wins this battle");
			}
			else if (coward) {
				System.out.println("you retreated from battle");
				dungeon.setCurrentRoom(dungeon.getPreviousRoom());
			}
			else {
				System.out.println("you lose");
				playing = false;
				//TODO delete character from saves when dead (perma death)
			}
		}


	}
	private static void attack() {
		//start with player attack
		System.out.println(player.getName() + " attacks");
		player.attack(enemy);

		if (enemy.getHp() > 0) {//if the enemy survives the attack he can attack back
			System.out.println(enemy.getName() + " survives and retaliates (remaining HP: " + enemy.getHp() + ")");
			enemy.attack(player);
			System.out.println("your remaining HP: " + player.getHp());
		}
	}
	private static void pickup() {
		if (dungeon.getCurrentRoom().getItem() != null) {
			System.out.println("you found a " + dungeon.getCurrentRoom().getItem().getName());
			player.pickup(dungeon.getCurrentRoom().getItem());
		}
	}
	//should there be a method to load previous characters (and therefore also save a character)?

}
