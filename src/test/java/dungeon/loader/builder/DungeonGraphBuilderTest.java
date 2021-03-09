package dungeon.loader.builder;

import dungeon.graph.DoorDirection;
import dungeon.graph.DungeonGraph;
import dungeon.loader.primitives.RoomPrimitive;
import dungeon.graph.room.DungeonDoor;
import dungeon.graph.room.DungeonRoom;
import exceptions.RoomNotFoundException;
import java.util.List;
import java.util.Set;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DungeonGraphBuilderTest {

    @Test
    public void TestRoomAddition() {

        RoomBuilder roomBuilder = new RoomBuilder();
        DoorBuilder doorBuilder = new DoorBuilder();
        DungeonGraphBuilder builder = new DungeonGraphBuilder(roomBuilder, doorBuilder);

        String roomName1 = "a1";
        String roomName2 = "a2";
        String nonExistentName = "b2";
        List<RoomPrimitive> primitiveList = List.of(
                new RoomPrimitive(roomName1, null, null, null, null),
                new RoomPrimitive(roomName2, null, null, null, null)
        );

        DungeonGraph dungeonGraph = (DungeonGraph) builder.buildFromPrimitives(primitiveList);

        assertTrue(roomNameIsWithinRoomSet(dungeonGraph.getRooms(), roomName1));
        assertTrue(roomNameIsWithinRoomSet(dungeonGraph.getRooms(), roomName2));
        assertFalse(roomNameIsWithinRoomSet(dungeonGraph.getRooms(), nonExistentName));

    }

    @Test
    public void TestDoorAddition() {
        RoomBuilder roomBuilder = new RoomBuilder();
        DoorBuilder doorBuilder = new DoorBuilder();
        DungeonGraphBuilder builder = new DungeonGraphBuilder(roomBuilder, doorBuilder);

        String roomName1 = "a1";
        String roomName2 = "a2";
        List<RoomPrimitive> primitiveList = List.of(
                new RoomPrimitive(roomName1, "a2", null, null, null),
                new RoomPrimitive(roomName2, null, null, "a1", null)
        );

        DungeonGraph dungeonGraph = (DungeonGraph) builder.buildFromPrimitives(primitiveList);

        Set<DungeonDoor> doorSet = dungeonGraph.getDoors();

        assertTrue(doorSetContainsDoor(doorSet, roomName1, DoorDirection.NORTH, roomName2));
        assertTrue(doorSetContainsDoor(doorSet, roomName2, DoorDirection.SOUTH, roomName1));
        assertEquals(2, dungeonGraph.getDoors().size());

    }

    @Test
    public void TestDirectionGetting() throws RoomNotFoundException {
        RoomBuilder roomBuilder = new RoomBuilder();
        DoorBuilder doorBuilder = new DoorBuilder();
        DungeonGraphBuilder builder = new DungeonGraphBuilder(roomBuilder, doorBuilder);

        String roomName1 = "a1";
        String roomName2 = "a2";
        List<RoomPrimitive> primitiveList = List.of(
                new RoomPrimitive(roomName1, "a2", null, null, null),
                new RoomPrimitive(roomName2, null, null, "a1", null)
        );

        DungeonGraph dungeonGraph = (DungeonGraph) builder.buildFromPrimitives(primitiveList);

        // get rooms from graph for assertions
        Set<DungeonRoom> rooms = dungeonGraph.getRooms();
        DungeonRoom room1 = rooms.stream().filter (it -> it.roomNameRef.equals(roomName1)).findFirst().get(); // TODO: this get is unsafe -> fix
        DungeonRoom room2 = rooms.stream().filter (it -> it.roomNameRef.equals(roomName2)).findFirst().get();

        DungeonRoom northRoomFromRoom1 = dungeonGraph.getRoomFromDirection(room1, DoorDirection.NORTH);
        DungeonRoom southRoomFromRoom2 = dungeonGraph.getRoomFromDirection(room2, DoorDirection.SOUTH);

        assertEquals(room2, northRoomFromRoom1);
        assertEquals(room1, southRoomFromRoom2);

    }

    private boolean roomNameIsWithinRoomSet(Set<DungeonRoom> rooms, String roomName) {
        return rooms.stream().anyMatch(it -> it.roomNameRef.equals(roomName));
    }

    private boolean doorSetContainsDoor(Set<DungeonDoor> doors, String entrance, DoorDirection direction, String doorExitName) {
        return doors.stream().anyMatch(it ->
                it.exit.roomNameRef.equals(doorExitName) &&
                        it.direction == direction &&
                        it.entrance.roomNameRef.equals(entrance));
    }


}
