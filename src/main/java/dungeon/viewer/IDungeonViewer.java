package dungeon.viewer;

import dungeon.graph.DoorDirection;
import dungeon.graph.IDungeonGraph;
import dungeon.graph.room.DungeonRoom;
import java.util.List;

public interface IDungeonViewer {

    void drawIntroduction();
    void drawGameState(DungeonRoom currentRoom, List<DoorDirection> possibleMoves, IDungeonGraph graph);

}
