package dungeons;

import dungeons.parts.Room;
import characters.Player;

public abstract class Dungeon {
	protected Room currentRoom;
	protected Player player;
	
	public Dungeon(final Player player) {
		this.player = player;
		this.currentRoom = new Room(null, null, null, null);
	}
}
