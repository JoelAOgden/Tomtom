package dungeon.loader.builder;

import dungeon.loader.primitives.RoomPrimitive;
import dungeon.graph.room.DungeonRoom;
import java.util.List;
import java.util.stream.Collectors;

//TODO: consider placing behind interface
public class RoomBuilder {

    public List<DungeonRoom> buildRoomsFromPrimitives(List<RoomPrimitive> roomPrimitives) {
        return roomPrimitives
                .stream()
                .map(it -> new DungeonRoom(it.roomName))
                .collect(Collectors.toList());
    }


}
