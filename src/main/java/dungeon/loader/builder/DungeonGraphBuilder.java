package dungeon.loader.builder;

import dungeon.graph.DungeonGraph;
import dungeon.graph.IDungeonGraph;
import dungeon.loader.primitives.RoomPrimitive;
import dungeon.room.DungeonDoor;
import dungeon.room.DungeonRoom;
import java.util.List;

public class DungeonGraphBuilder implements IDungeonGraphBuilder {

    public final RoomBuilder roomBuilder;
    public final DoorBuilder doorBuilder;

    public DungeonGraphBuilder(RoomBuilder roomBuilder, DoorBuilder doorBuilder) {
        this.roomBuilder = roomBuilder;
        this.doorBuilder = doorBuilder;
    }

    @Override
    public IDungeonGraph buildFromPrimitives(List<RoomPrimitive> roomPrimitiveList) {

        DungeonGraph graph = new DungeonGraph();

        List<DungeonRoom> rooms = roomBuilder.buildRoomsFromPrimitives(roomPrimitiveList);
        List<DungeonDoor> doors = doorBuilder.buildDoors(rooms, roomPrimitiveList);

        addRoomsToGraph(graph, rooms);
        addDoorsToGraph(graph, doors);

        return graph;
    }

    private void addRoomsToGraph(DungeonGraph graph,  List<DungeonRoom> rooms) {
        rooms.forEach(graph::addRoom);
    }

    private void addDoorsToGraph(DungeonGraph graph, List<DungeonDoor> doors) {
        doors.forEach(it -> graph.addDoorConnection(it.entrance, it.direction, it));
    }



}
