package dungeons;

import java.util.ArrayList;

import dungeons.parts.Room;

public abstract class Dungeon {
	protected ArrayList<Room> rooms;
	protected Room currentRoom;
	protected Room previousRoom;//for a retreat

	public Dungeon() {
		this.currentRoom = new Room();
		this.previousRoom = new Room();
		this.rooms = new ArrayList<Room>();
	}
	public Dungeon (Room currentRoom){
		this.currentRoom = currentRoom;
		this.previousRoom = null;
		this.rooms = new ArrayList<Room>();
	}

	/**
	 * 
	 * @param dir - the direction the player is moving
	 * @return - true if the player is still in the dungeon
	 */
	public boolean move(String dir) {
		if (currentRoom.isStart() && dir.equalsIgnoreCase("N")) {
			System.out.println("you left the dungeon");
			return false;
		}
		else if (dir.equalsIgnoreCase("N") && currentRoom.getN() != null) {
			System.out.println("you moved North");
			previousRoom = currentRoom;
			currentRoom = currentRoom.getN();
		}
		else if (dir.equalsIgnoreCase("S") && currentRoom.getS() != null) {
			System.out.println("you moved South");
			previousRoom = currentRoom;
			currentRoom = currentRoom.getS();
		}
		else if (dir.equalsIgnoreCase("E") && currentRoom.getE() != null) {
			System.out.println("you moved East");
			previousRoom = currentRoom;
			currentRoom = currentRoom.getE();
		}
		else if (dir.equalsIgnoreCase("W") && currentRoom.getW() != null) {
			System.out.println("you moved West");
			previousRoom = currentRoom;
			currentRoom = currentRoom.getW();
		}
		else {
			System.out.println("a wall is blocking your way");
		}
		if (currentRoom.isEnd()) {
			System.out.println("you have made it to the end of the dungeon");
			return false;
		}
		return true;
	}
	/**
	 * set the start and ending rooms of the dungeon
	 * @param start - the first room in the dungeon
	 * @param end - the final room in the dungeon
	 */
	public void setEnds(int start, int end) {
		try {
			rooms.get(start).setStart(true);
			rooms.get(end).setEnd(true);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	//accessors and mutators
	public Room getPreviousRoom() {
		return previousRoom;
	}
	public void setPreviousRoom(Room previousRoom) {
		this.previousRoom = previousRoom;
	}
	public void addRoom(Room room) {
		this.rooms.add(room);
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	}
