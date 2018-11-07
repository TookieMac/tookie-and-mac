package main;

import java.util.Random;

import characters.*;
import dungeons.*;
import dungeons.parts.*;
import items.weapons.*;
import items.consumables.*;
import items.*;

public class DungeonManipulator {
	private Dungeon dungeon;

	/**
	 * manipulate and exisitng dungeon
	 * @param dungeon - existing dungeon
	 */
	public DungeonManipulator(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	/**
	 * create a new tungone of the given type
	 * @param type - the type of dungeon to create
	 */
	public DungeonManipulator(String type) {
		if (type == "basic") {
			dungeon = new BasicDungeon();
		}
		else if (type == "magic"){
			dungeon = new MagicDungeon();
		}
		else if (type == "tookie") {
			createTookieDungeon();
		}
	}
	/**
	 * load a dungeon
	 * @param location - the name and location of the dungeon
	 */
	public void loadDungeon(String location) {

	}
	/**
	 * save the dungeon
	 * @param location - where to save
	 * @param dungeon - dungeon to save
	 */
	public void saveDungeon(String location, Dungeon dungeon) {

	}
	/**
	 * debug dungeon
	 */
	public DungeonManipulator() {
		dungeon = new BasicDungeon();
		dungeon.getCurrentRoom().setN(new Room(dungeon.getCurrentRoom(), 'N'));
		dungeon.getCurrentRoom().setS(new Room(dungeon.getCurrentRoom(), 'S'));
		dungeon.getCurrentRoom().setE(new Room(dungeon.getCurrentRoom(), 'E'));
		dungeon.getCurrentRoom().setW(new Room(dungeon.getCurrentRoom(), 'W'));
		
		dungeon.getCurrentRoom().getE().setEnemy(new Goblin());
		dungeon.getCurrentRoom().getS().setItem(new Teleporter());
		
		
	}
	
//	private void addToRoom() {
//		Random rand = new Random();
//		int res = rand.nextInt(2);
//		
//		if (res == 1) {
//			//add enemy
//		}
//		else if (res == 2) {
//			//add item
//		}
//	}
	
	/**
	 * tookies dungeon
	 */
	private void createTookieDungeon() {
		dungeon = new BasicDungeon();
		Room room = new Room();
		//0
		room.setEnemy(new WereWolf());
		room.setItem(null);
		dungeon.addRoom(room);
		//1
		room = new Room();
		room.setW(dungeon.getRooms().get(0));
		dungeon.getRooms().get(0).setE(room);
		dungeon.addRoom(room);
		dungeon.setCurrentRoom(dungeon.getRooms().get(1));
		//2
		room = new Room();
		room.setEnemy(null);
		room.setItem(new GodSet());
		dungeon.addRoom(room);
		//3
		room = new Room();
		room.setEnemy(new Goblin());
		room.setItem(new BattleAxe());
		dungeon.addRoom(room);
		//4
		room = new Room();
		room.setEnemy(new Goblin());
		room.setItem(new HealthPotion());
		room.setW(dungeon.getRooms().get(3));
		room.setN(dungeon.getRooms().get(1));
		dungeon.getRooms().get(1).setS(room);
		dungeon.getRooms().get(3).setE(room);
		dungeon.addRoom(room);
		//5
		room = new Room();
		room.setEnemy(null);
		room.setItem(null);
		room.setN(dungeon.getRooms().get(2));
		room.setW(dungeon.getRooms().get(4));
		dungeon.getRooms().get(4).setE(room);
		dungeon.getRooms().get(2).setS(room);
		dungeon.addRoom(room);
		//6
		room = new Room();
		room.setEnemy(null);
		room.setItem(new ShortSword());
		room.setN(dungeon.getRooms().get(3));
		dungeon.getRooms().get(3).setS(room);
		dungeon.addRoom(room);
		//7
		room = new Room();
		room.setEnemy(null);
		room.setItem(null);
		room.setW(dungeon.getRooms().get(6));
		room.setN(dungeon.getRooms().get(4));
		dungeon.getRooms().get(6).setE(room);
		dungeon.getRooms().get(4).setS(room);
		dungeon.addRoom(room);
		//8
		room = new Room();
		room.setEnemy(null);
		room.setItem(null);
		room.setN(dungeon.getRooms().get(5));
		dungeon.getRooms().get(5).setS(room);
		dungeon.addRoom(room);
		//9
		room = new Room();
		room.setEnemy(null);
		room.setItem(null);
		room.setN(dungeon.getRooms().get(6));
		dungeon.getRooms().get(6).setS(room);
		dungeon.addRoom(room);
		//10
		room = new Room();
		room.setEnemy(new WereWolf());
		room.setItem(new Teleporter());
		room.setN(dungeon.getRooms().get(7));
		dungeon.getRooms().get(7).setS(room);
		dungeon.addRoom(room);
		//11
		room = new Room();
		room.setEnemy(null);
		room.setItem(null);
		room.setW(dungeon.getRooms().get(10));
		dungeon.getRooms().get(10).setE(room);
		dungeon.addRoom(room);
	}

	public Dungeon getDungeon() {
		return dungeon;
	}
}
