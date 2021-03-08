package dungeon.viewer.possiblemove;

import dungeon.graph.DoorDirection;
import dungeon.graph.DungeonGraph;
import dungeon.graph.IDungeonGraph;
import dungeon.room.DungeonDoor;
import dungeon.room.DungeonRoom;
import java.util.Map;

public class PossibleMoveViewer implements IPossibleMoveViewer {

    @Override
    public void drawPossibleMoves(DungeonRoom currentLocation, IDungeonGraph graph) {

        Map<DoorDirection, DungeonDoor> doorsAtRoom = graph.getDoorsForRoom(currentLocation);

        StringBuilder choicesBuilder = new StringBuilder("");

        // TODO: neaten this up
        if (doorsAtRoom.containsKey(DoorDirection.NORTH)) {
            choicesBuilder.append("n");
        }
        if (doorsAtRoom.containsKey(DoorDirection.EAST)) {
            choicesBuilder.append("e");
        }
        if (doorsAtRoom.containsKey(DoorDirection.SOUTH)) {
            choicesBuilder.append("s");
        }
        if (doorsAtRoom.containsKey(DoorDirection.WEST)) {
            choicesBuilder.append("w");
        }

        System.out.println("possible moves: " + choicesBuilder.toString());
    }
}
