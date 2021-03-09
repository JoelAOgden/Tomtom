package dungeon.loader.builder;


import dungeon.graph.DoorDirection;
import dungeon.loader.primitives.RoomPrimitive;
import dungeon.graph.room.DungeonDoor;
import dungeon.graph.room.DungeonRoom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// todo: hide behind interface
public class DoorBuilder {


    public List<DungeonDoor> buildDoors(List<DungeonRoom> rooms, List<RoomPrimitive> primitives) {

        Map<String, DungeonRoom> roomMap = mapRoomToNames(rooms);

        return primitives.stream()
                .flatMap(it -> primitiveToDoorList(roomMap, it).stream())
                .collect(Collectors.toList());
    }

    private Map<String, DungeonRoom> mapRoomToNames(List<DungeonRoom> rooms) {
        return rooms.stream().collect(Collectors.toMap(it -> it.roomNameRef, it -> it));
    }

    private List<DungeonDoor> primitiveToDoorList(Map<String, DungeonRoom> roomMap, RoomPrimitive roomPrimitive) {

        DungeonRoom entrance = roomMap.get(roomPrimitive.roomName);

        // TODO: this can be made nicer to look at
        List<DungeonDoor> dungeonDoorList = new ArrayList<>();
        buildDoorAndAddToList(dungeonDoorList, entrance, DoorDirection.NORTH, roomMap.get(roomPrimitive.northDoor));
        buildDoorAndAddToList(dungeonDoorList, entrance, DoorDirection.EAST,  roomMap.get(roomPrimitive.eastDoor ));
        buildDoorAndAddToList(dungeonDoorList, entrance, DoorDirection.SOUTH, roomMap.get(roomPrimitive.southDoor));
        buildDoorAndAddToList(dungeonDoorList, entrance, DoorDirection.WEST,  roomMap.get(roomPrimitive.westDoor ));

        return dungeonDoorList;
    }

    // will only add if a connection exists
    private void buildDoorAndAddToList(List<DungeonDoor> doorList, DungeonRoom entrance, DoorDirection direction, DungeonRoom exit) {
        if (exit == null) {
            return;
        }

        DungeonDoor door = new DungeonDoor(entrance, direction, exit);
        doorList.add(door);
    }

}
