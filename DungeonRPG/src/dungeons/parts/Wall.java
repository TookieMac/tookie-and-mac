package dungeons.parts;

public class Wall extends RoomBorder{
	
	
	@Override
	public Room move(Room currentRoom) {
		System.out.println("a blank wall blocks your path");
		return currentRoom;
	}

}
