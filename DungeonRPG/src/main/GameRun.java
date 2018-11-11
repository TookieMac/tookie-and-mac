package main;

import java.util.Scanner;

import characters.Character;
import characters.Player;
import dungeons.Dungeon;

public class GameRun {
	private Player player;
	private Dungeon dungeon;
	private Character enemy;
	private Scanner s = new Scanner(System.in);
	private boolean playing = true;

	public GameRun() {

	}
	
	public String normalChoices() {
		String res = "";
		res += "what will you do?\n";
		res += "walk (n)orth, (s)outh, (e)ast, or (w)est?\n";
		res += "(u)se an item\n";
		res += "or (v)iew your inventory?\n";
		return res;
	}
	
	public void play() {
		String res = "";
		System.out.println(normalChoices());
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

	/**
	 * simulate a battle between the player and the rooms enemy
	 */
	public void battle() {
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
		if (dungeon.getCurrentRoom().getItem() != null) {
			System.out.println("you found a " + dungeon.getCurrentRoom().getItem().getName());
			player.pickup(dungeon.getCurrentRoom().getItem());
		}
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}
	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	public boolean isPlaying() {
		return playing;
	}
}
