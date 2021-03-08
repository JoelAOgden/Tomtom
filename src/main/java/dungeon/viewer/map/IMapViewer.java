package dungeon.viewer.map;

import dungeon.graph.DungeonGraph;
import dungeon.room.DungeonRoom;

public interface IMapViewer {

    void drawMap(DungeonRoom room, DungeonGraph graph);

}
