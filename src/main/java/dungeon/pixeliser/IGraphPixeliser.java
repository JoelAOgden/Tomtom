package dungeon.pixeliser;

import dungeon.graph.IDungeonGraph;
import dungeon.graph.room.DungeonRoom;

public interface IGraphPixeliser {

    GraphPixel[][] createPixelGrid(DungeonRoom currentLocation, IDungeonGraph graph);

}
