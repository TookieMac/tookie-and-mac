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
	 * @param dir
	 */
	public void move(String dir) {
			if (dir.equalsIgnoreCase("N") && currentRoom.getN() != null) {
				previousRoom = currentRoom;
				currentRoom = currentRoom.getN();
			}
			else if (dir.equalsIgnoreCase("S") && currentRoom.getS() != null) {
				previousRoom = currentRoom;
				currentRoom = currentRoom.getS();
			}
			else if (dir.equalsIgnoreCase("E") && currentRoom.getE() != null) {
				previousRoom = currentRoom;
				currentRoom = currentRoom.getE();
			}
			else if (dir.equalsIgnoreCase("W") && currentRoom.getW() != null) {
				previousRoom = currentRoom;
				currentRoom = currentRoom.getW();
			}
			else {
				System.out.println("a wall is blocking your way");
		}
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}


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
}
