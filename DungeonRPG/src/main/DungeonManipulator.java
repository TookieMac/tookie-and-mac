package main;

import characters.*;
import dungeons.*;
import dungeons.parts.*;
import items.weapons.*;
import items.consumables.*;

public class DungeonManipulator {
	private Dungeon dungeon;
	private Floor floor;
	/**
	 * manipulate and exisitng dungeon
	 * @param dungeon - existing dungeon
	 */
	public DungeonManipulator(Dungeon dungeon) {
		this.dungeon = dungeon;
		floor = new Floor();
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
			createTookiesFloor();
		}
	}
	/**
	 * load a dungeon
	 * @param location - the name and location of the dungeon
	 */
	public void loadDungeon(String location) {
		//TODO add dungeon loading
	}
	/**
	 * save the dungeon
	 * @param location - where to save
	 * @param dungeon - dungeon to save
	 */
	public void saveDungeon(String location, Dungeon dungeon) {
		//TODO add dungeon saving
	}
	/**
	 * debug dungeon
	 */
	public DungeonManipulator() {
		dungeon = new BasicDungeon();
		floor = new Floor();
		floor.getCurrentRoom().setN(new Room(floor.getCurrentRoom(), 'N'));
		floor.getCurrentRoom().setS(new Room(floor.getCurrentRoom(), 'S'));
		floor.getCurrentRoom().setE(new Room(floor.getCurrentRoom(), 'E'));
		floor.getCurrentRoom().setW(new Room(floor.getCurrentRoom(), 'W'));

		floor.getCurrentRoom().getE().setEnemy(new Goblin());
		floor.getCurrentRoom().getS().setItem(new Teleporter());
		dungeon.addFloor(floor);

	}



	/**
	 * the dev dungeon
	 */
	private void createTookiesFloor() {
		dungeon = new BasicDungeon();
		Room room = new Room();
		floor = new Floor();
		{//create tookies floor
			//0
			room.setEnemy(new WereWolf());
			floor.addRoom(room);
			//1
			room = new Room();
			room.setStart(true);
			room.setW(floor.getRooms().get(0));
			floor.getRooms().get(0).setE(room);
			floor.addRoom(room);
			floor.setCurrentRoom(floor.getRooms().get(1));
			//2
			room = new Room();
			room.setEnemy(null);
			room.setItem(new GodSet());
			floor.addRoom(room);
			//3
			room = new Room();
			room.setEnemy(new Goblin());
			room.setItem(new BattleAxe());
			floor.addRoom(room);
			//4
			room = new Room();
			room.setEnemy(new Goblin());
			room.setItem(new HealthPotion());
			room.setW(floor.getRooms().get(3));
			room.setN(floor.getRooms().get(1));
			floor.getRooms().get(1).setS(room);
			floor.getRooms().get(3).setE(room);
			floor.addRoom(room);
			//5
			room = new Room();
			room.setEnemy(null);
			room.setItem(null);
			room.setN(floor.getRooms().get(2));
			room.setW(floor.getRooms().get(4));
			floor.getRooms().get(4).setE(room);
			floor.getRooms().get(2).setS(room);
			floor.addRoom(room);
			//6
			room = new Room();
			room.setEnemy(null);
			room.setItem(new ShortSword());
			room.setN(floor.getRooms().get(3));
			floor.getRooms().get(3).setS(room);
			floor.addRoom(room);
			//7
			room = new Room();
			room.setEnemy(null);
			room.setItem(null);
			room.setW(floor.getRooms().get(6));
			room.setN(floor.getRooms().get(4));
			floor.getRooms().get(6).setE(room);
			floor.getRooms().get(4).setS(room);
			floor.addRoom(room);
			//8
			room = new Room();
			room.setEnemy(null);
			room.setItem(null);
			room.setN(floor.getRooms().get(5));
			floor.getRooms().get(5).setS(room);
			floor.addRoom(room);
			//9
			room = new Room();
			room.setEnemy(null);
			room.setItem(null);
			room.setN(floor.getRooms().get(6));
			floor.getRooms().get(6).setS(room);
			floor.addRoom(room);
			//10
			room = new Room();
			room.setEnemy(new WereWolf());
			room.setItem(new Teleporter());
			room.setN(floor.getRooms().get(7));
			floor.getRooms().get(7).setS(room);
			floor.addRoom(room);
			//11
			room = new Room();
			room.setEnemy(null);
			room.setItem(null);
			room.setW(floor.getRooms().get(10));
			floor.getRooms().get(10).setE(room);
			floor.addRoom(room);

			floor.setEnds(1, 11);
			dungeon.addFloor(floor);
			dungeon.setCurrentFloor(floor);
		}
		//AJ dungeon #1
		{
			floor = new Floor();
			//room 0
			room = new Room();
			room.setEnemy(new WereWolf());
			room.setItem(new GodSet());
			floor.addRoom(room);
			//room 1
			room = new Room();
			room.setW(floor.getRooms().get(0));
			floor.getRooms().get(0).setE(room);
			floor.addRoom(room);
			floor.setCurrentRoom(floor.getRooms().get(1));
			//2
			room = new Room();
			room.setEnemy(new EvilWizard());
			floor.addRoom(room);
			//3
			room = new Room();
			room.setEnemy(new Troll());
			room.setItem(new HealthPotion());
			room.setN(floor.getRooms().get(1));
			room.setW(floor.getRooms().get(2));
			floor.getRooms().get(1).setS(room);
			floor.getRooms().get(2).setE(room);
			floor.addRoom(room);
			//4
			room = new Room();
			room.setEnemy(new WereWolf());
			room.setItem(new Axe());
			room.setN(floor.getRooms().get(2));
			floor.getRooms().get(2).setS(room);
			floor.addRoom(room);
			//5
			room = new Room();
			room.setEnemy(new WereWolf());
			room.setN(floor.getRooms().get(3));
			floor.getRooms().get(3).setS(room);
			floor.addRoom(room);
			//6
			room = new Room();
			room.setEnemy(new EvilWizard("bob"));
			room.setN(floor.getRooms().get(5));
			floor.getRooms().get(5).setS(room);
			floor.addRoom(room);
			//7
			room = new Room();
			room.setW(floor.getRooms().get(6));
			floor.getRooms().get(6).setE(room);
			floor.addRoom(room);
			
			floor.setEnds(1, 7);
			floor.setEnd(true);//TODO move this line to the final floor of the dungeon when the rest are added
			dungeon.addFloor(floor);
		}
	}

	public Dungeon getDungeon() {
		return dungeon;
	}
}
