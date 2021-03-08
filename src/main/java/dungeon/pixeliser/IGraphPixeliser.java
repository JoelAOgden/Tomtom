package dungeon.pixeliser;

import dungeon.graph.IDungeonGraph;
import dungeon.room.DungeonRoom;
import java.util.List;

public interface IGraphPixeliser {

    GraphPixel[][] createPixelGrid(DungeonRoom currentLocation, IDungeonGraph graph);

}
