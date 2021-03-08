package dungeon.loader.builder;

import dungeon.graph.IDungeonGraph;
import dungeon.loader.primitives.RoomPrimitive;
import java.util.List;

public interface IDungeonGraphBuilder {

    IDungeonGraph buildFromPrimitives(List<RoomPrimitive> roomPrimitiveList);

}
