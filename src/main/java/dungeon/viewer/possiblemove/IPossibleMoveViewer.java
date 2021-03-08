package dungeon.viewer.possiblemove;

import dungeon.graph.DungeonGraph;
import dungeon.graph.IDungeonGraph;
import dungeon.room.DungeonRoom;

public interface IPossibleMoveViewer {

    void drawPossibleMoves(DungeonRoom currentLocation, IDungeonGraph graph);

}
