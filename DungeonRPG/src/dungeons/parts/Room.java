package dungeons.parts;

import items.Item;
import characters.Character;

public class Room {
	private RoomBorder N,S, E, W;
	private Character enemy;
	private Item item;
	
	/**
	 * 
	 * @param N - Room border to the north
	 * @param S - Room border to the south
	 * @param E - Room border to the east
	 * @param W - Room border to the west
	 */
	public Room (final RoomBorder N, final RoomBorder S, final RoomBorder E, final RoomBorder W) {
	this.N= N;
	this.S = S;
	this.E = E;
	this.W = W;
	}
	
	public Room move(final RoomBorder direction) {
		
		return null;
	}

}
