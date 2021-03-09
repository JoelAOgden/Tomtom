package dungeon.viewer.map;

import dungeon.graph.IDungeonGraph;
import dungeon.graph.room.DungeonRoom;

public interface IMapViewer {

    void drawMap(DungeonRoom room, IDungeonGraph graph);

}
