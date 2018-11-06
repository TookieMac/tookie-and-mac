package main;

import characters.Player;
import dungeons.BasicDungeon;
import dungeons.Dungeon;

/**
 * 
 * @author tookie
 *
 */
public class Main {
	private static Player player;
	private static Dungeon dungeon;

	public static void main(String[] args) {
		player = new CharacterManipulator("tookie").getPlayer();
		dungeon = new BasicDungeon(player);
		player.displayDetails();

	}

}
