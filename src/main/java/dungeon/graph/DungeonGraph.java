package dungeon.graph;

import dungeon.room.DungeonDoor;
import dungeon.room.DungeonRoom;
import exceptions.RoomNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DungeonGraph implements IDungeonGraph {

    private final Set<DungeonRoom> rooms = new HashSet<>();
    private final Set<DungeonDoor> doors = new HashSet<>();
    private final Map<DungeonRoom, Map<DoorDirection, DungeonDoor>> dungeonRoomDoorConnectionMap = new HashMap<>(); // TODO: add some abstraction from easier reading

    @Override
    public void addRoom(DungeonRoom newRoom) {
        rooms.add(newRoom);
    }

    @Override
    public void addDoorConnection(DungeonRoom room, DoorDirection direction, DungeonDoor newDoor) {
        if (!dungeonRoomDoorConnectionMap.containsKey(room)) {
            dungeonRoomDoorConnectionMap.put(room, new HashMap<>());
        }

        doors.add(newDoor);

        Map<DoorDirection, DungeonDoor> doors = dungeonRoomDoorConnectionMap.get(room);
        doors.put(direction, newDoor);
    }

    @Override
    public DungeonRoom getRoomFromDirection(DungeonRoom currentRoom, DoorDirection direction) throws RoomNotFoundException {
        Map<DoorDirection, DungeonDoor> directionDoorMap = dungeonRoomDoorConnectionMap.get(currentRoom);
        DungeonDoor correctDoor = directionDoorMap.get(direction);

        if (correctDoor == null ) {
            throw new RoomNotFoundException("Unable to find room in direction: " + direction);
        }

        return correctDoor.exit;
    }

    @Override
    public Set<DungeonRoom> getRooms() {
        return rooms;
    }

    @Override
    public Set<DungeonDoor> getDoors() {
        return doors;
    }

    @Override
    public Map<DoorDirection, DungeonDoor> getDoorsForRoom(DungeonRoom room) {
        return this.dungeonRoomDoorConnectionMap.get(room);
    }
}
