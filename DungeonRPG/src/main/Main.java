package main;

import java.util.Scanner;

/**
 * 
 * @author tookie
 *
 */
public class Main {
	public static void main(String[] args) {
		GameRun game = new GameRun();
		Scanner s = new Scanner(System.in);
		game.setPlayer(new CharacterManipulator("tookie").getPlayer());
		game.setDungeon(new DungeonManipulator("tookie").getDungeon());
		System.out.println(game.getPlayer().getDetails());
		while (game.isPlaying()) {
			game.play();
		}
	}

}
