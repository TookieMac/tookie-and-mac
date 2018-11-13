package main;

import java.util.Scanner;

import characters.Character;
import characters.Player;
import dungeons.Dungeon;
import items.weapons.GodSet;

public class MainInteraction {
	private Player player;
	private Dungeon dungeon;
	private Character enemy;
	private Scanner s;
	private boolean playing;
	private boolean coward;
	private String res;

	public MainInteraction() {
		player = new CharacterManipulator("tookie").getPlayer();
		player.setOffHand(new GodSet());
		dungeon = new DungeonManipulator("tookie").getDungeon();
		s = new Scanner(System.in);
		playing = true;
		coward = false;
		res = "";
		player.displayDetails();
	}

	public void play() {
		while (playing) {
			res = "";
			System.out.println("------------------------------------------");
			System.out.println("what will you do?");
			System.out.println("walk (n)orth, (s)outh, (e)ast, or (w)est?");
			System.out.println("(u)se an item");
			System.out.println("or (v)iew your inventory?");
			System.out.println("------------------------------------------");
			res = s.nextLine();
			move(res);
			enemy = dungeon.getCurrentFloor().getCurrentRoom().getEnemy();
			if (dungeon.getCurrentFloor().getCurrentRoom().getEnemy() != null) {
				while (enemy.getHp() > 0 && player.getHp() > 0 && coward == false) {
					res = "";
					System.out.println("you see an enemy " + enemy.getClass().getSimpleName() + " (name: " + enemy.getName() + ")");
					System.out.println("what will you do?");
					System.out.println("(a)ttack " + enemy.getName() + ", (u)se an item from your inventory, or (r)etreat from battle");
					res = s.nextLine();
					battle(res);
				}
				System.out.println("the battle is over");
				if (coward) {
					System.out.println("you retreated from battle");
					dungeon.getCurrentFloor().setCurrentRoom(dungeon.getCurrentFloor().getPreviousRoom());
					coward = false;
				}
				else if (player.getHp() > 0) {
					System.out.println(player.getName() + " wins this battle");
				}
				else {
					System.out.println("you lose");
					playing = false;
					//TODO delete character from saves when dead (perma death)
				}
				dungeon.getCurrentFloor().getCurrentRoom().setEnemy(null);//delete the enemy once killed
			}
			if (dungeon.getCurrentFloor().getCurrentRoom().getItem() != null) {
				pickup();
			}

		}
	}
	/**
	 * 
	 * @param nxt - the next direction to move
	 * @return - true if room is not empty
	 */
	private void move(String nxt) {
		if (nxt.equalsIgnoreCase("n") || nxt.equalsIgnoreCase("s") || nxt.equalsIgnoreCase("e") || nxt.equalsIgnoreCase("w")) {
			playing = dungeon.move(nxt);
		}
		else if (nxt.equalsIgnoreCase("U")) {
			System.out.println("use item");
			player.UseItem();
		}
		else if (nxt.equalsIgnoreCase("V")) {
			System.out.println("view inventory");
			player.displayInventory();
		}
	}

	/**
	 * simulate a battle between the player and the rooms enemy
	 * @param nxt - next command to execute
	 */
	private void battle(String nxt) {

		if (nxt.equalsIgnoreCase("a")) {
			attack();
		}
		else if (nxt.equalsIgnoreCase("u")) {
			player.UseItem();
		}
		else if (nxt.equalsIgnoreCase("r")) {
			coward = true;
		}
		else {
			System.out.println("invalid");
		}

	}

	private void attack() {
		//start with player attack
		System.out.println(player.getName() + " attacks");
		player.attack(enemy);

		if (enemy.getHp() > 0) {//if the enemy survives the attack he can attack back
			System.out.println(enemy.getName() + " survives and retaliates (remaining HP: " + enemy.getHp() + ")");
			enemy.attack(player);
			System.out.println("your remaining HP: " + player.getHp());
		}
	}

	private void pickup() {
		if (dungeon.getCurrentFloor().getCurrentRoom().getItem() != null) {
			System.out.println(player.getName() +" found a " + dungeon.getCurrentFloor().getCurrentRoom().getItem().getName());
			player.pickup(dungeon.getCurrentFloor().getCurrentRoom().getItem());
			dungeon.getCurrentFloor().getCurrentRoom().setItem(null);//delete the item once picked up
		}
	}
}
//should there be a method to load previous characters (and therefore also save a character)?
