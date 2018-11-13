package dungeons.parts;

import java.util.ArrayList;

public class Floor {
	private ArrayList<Room> rooms;
	private Room currentRoom;
	private Room previousRoom;//for a retreat
	private boolean end;

	public Floor() {
		this.currentRoom = new Room();
		this.previousRoom = new Room();
		this.rooms = new ArrayList<Room>();
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
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
}
