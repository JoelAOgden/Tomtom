package dungeon.game;

import dungeon.graph.DoorDirection;
import dungeon.graph.DungeonGraph;
import dungeon.graph.IDungeonGraph;
import dungeon.room.DungeonRoom;
import exceptions.RoomNotFoundException;

public interface IGame {
    void takeMove(DoorDirection movementDirection) throws RoomNotFoundException;
    DungeonRoom getCurrentRoom();
    IDungeonGraph getGraph();
}
