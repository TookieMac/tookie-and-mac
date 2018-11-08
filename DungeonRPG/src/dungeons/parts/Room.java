package dungeons.parts;

import items.Item;
import characters.Character;

public class Room {
	private Room N,S, E, W;
	private Character enemy;
	private Item item;
	private boolean start;
	private boolean end;

	/**
	 * create a new room with all directions being set
	 * @param N - Room to the north
	 * @param S - Room to the south
	 * @param E - Room to the east
	 * @param W - Room to the west
	 */
	public Room (final Room N, final Room S, final Room E, final Room W) {
		this.N= N;
		this.S = S;
		this.E = E;
		this.W = W;
		enemy = null;
		item = null;
	}
	
	/**
	 * creates a new room that comes from a previous one
	 * @param previousRoom - the previous room
	 * @param direction - the direction the player needs to travel in order to reach this Room
	 */
	public Room (final Room previousRoom, final char direction) {
		if (direction == 'S') {
			this.N= previousRoom;
			S = null;
			E = null;
			W = null;
		}
		else if (direction == 'N') {
			this.S = previousRoom;
			N = null;
			E = null;
			W = null;
		}
		else if (direction == 'E') {
			this.W = previousRoom;
			N = null;
			S = null;
			E = null;
		}
		else if (direction == 'W') {
			this.E = previousRoom;
			N = null;
			W = null;
			S = null;
		}
		enemy = null;
		item = null;
	}

	/**
	 * create a new room
	 */
	public Room() {
		N = null;
		S = null;
		E = null;
		W = null;
		enemy = null;
		item = null;
	}
	

	//acessors and mutators
	public Room getN() {
		return N;
	}
	public void setN(Room n) {
		N = n;
	}
	public Room getS() {
		return S;
	}
	public void setS(Room s) {
		S = s;
	}
	public Room getE() {
		return E;
	}
	public void setE(Room e) {
		E = e;
	}
	public Room getW() {
		return W;
	}
	public void setW(Room w) {
		W = w;
	}
	public Character getEnemy() {
		return enemy;
	}
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

}
