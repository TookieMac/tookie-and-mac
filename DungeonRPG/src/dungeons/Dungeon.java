package dungeons;

import java.util.ArrayList;

import dungeons.parts.Floor;

public abstract class Dungeon {
	protected ArrayList<Floor> floors;
	protected Floor currentFloor;

	public Dungeon() {
		this.currentFloor = new Floor();
		this.floors = new ArrayList<Floor>();
	}
	/**
	 * 
	 * @return - true if still in dungeon
	 */
	private boolean progressFloor() {
		
		try {
			if (!currentFloor.isEnd()) {
			currentFloor = floors.get(floors.indexOf(currentFloor)+1);
			return true;
			}
			else {
				System.out.println("you escaped the dungeon");
				return false;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("the floor you are trying to enter has not been made");
			return false;
		}
	}
	/**
	 * 
	 * @param dir - the direction the player is moving
	 * @return - true if the player is still in the dungeon
	 */
	public boolean move(String dir) {
		if (currentFloor.getCurrentRoom().isStart() && dir.equalsIgnoreCase("N")) {
			System.out.println("you left the dungeon");
			return false;
		}
		else if (dir.equalsIgnoreCase("N") && currentFloor.getCurrentRoom().getN() != null) {
			System.out.println("you moved North");
			currentFloor.setPreviousRoom(currentFloor.getPreviousRoom());
			currentFloor.setCurrentRoom(currentFloor.getCurrentRoom().getN());
		}
		else if (dir.equalsIgnoreCase("S") && currentFloor.getCurrentRoom().getS() != null) {
			System.out.println("you moved South");
			currentFloor.setPreviousRoom(currentFloor.getPreviousRoom());
			currentFloor.setCurrentRoom(currentFloor.getCurrentRoom().getS());
		}
		else if (dir.equalsIgnoreCase("E") && currentFloor.getCurrentRoom().getE() != null) {
			System.out.println("you moved East");
			currentFloor.setPreviousRoom(currentFloor.getPreviousRoom());
			currentFloor.setCurrentRoom(currentFloor.getCurrentRoom().getE());
		}
		else if (dir.equalsIgnoreCase("W") && currentFloor.getCurrentRoom().getW() != null) {
			System.out.println("you moved West");
			currentFloor.setPreviousRoom(currentFloor.getPreviousRoom());
			currentFloor.setCurrentRoom(currentFloor.getCurrentRoom().getW());
		}
		else {
			System.out.println("a wall is blocking your way");
		}
		if (currentFloor.getCurrentRoom().isEnd()) {
			if (!progressFloor()) {//if player hsa left the dungeon
				return false;
			}
		}
		return true;
	}

	//accessors and mutators
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	public void setFloors(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	public Floor getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(Floor currentFloor) {
		this.currentFloor = currentFloor;
	}
	public Floor getFloor(int floor) {
		return this.floors.get(floor);
	}
	public void addFloor(Floor floor) {
		this.floors.add(floor);
	}

	
	}
