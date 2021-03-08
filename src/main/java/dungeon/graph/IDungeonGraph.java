package dungeon.graph;

import dungeon.room.DungeonDoor;
import dungeon.room.DungeonRoom;
import exceptions.RoomNotFoundException;
import java.util.Map;
import java.util.Set;

public interface IDungeonGraph {

    void addRoom(DungeonRoom room);
    void addDoorConnection(DungeonRoom room, DoorDirection direction, DungeonDoor newDoor);
    DungeonRoom getRoomFromDirection(DungeonRoom currentRoom, DoorDirection direction) throws RoomNotFoundException;

    Set<DungeonRoom> getRooms();
    Set<DungeonDoor> getDoors();
    Map<DoorDirection, DungeonDoor> getDoorsForRoom(DungeonRoom room);
}

