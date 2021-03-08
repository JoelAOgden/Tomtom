package dungeon.game;

import dungeon.graph.DoorDirection;
import dungeon.graph.DungeonGraph;
import dungeon.graph.IDungeonGraph;
import exceptions.RoomNotFoundException;
import dungeon.room.DungeonRoom;

public class DungeonGame implements IGame {

    private DungeonRoom currentLocation;
    public final IDungeonGraph graph;

    public DungeonGame(IDungeonGraph graph) {
        this.graph = graph;
        currentLocation = this.graph.getRooms().stream().findFirst().get(); // todo: this is unsafe
    }

    @Override
    public void takeMove(DoorDirection movementDirection) throws RoomNotFoundException {
        currentLocation = graph.getRoomFromDirection(currentLocation, movementDirection);
    }

    @Override
    public DungeonRoom getCurrentRoom() {
        return currentLocation;
    }

    @Override
    public IDungeonGraph getGraph() {
        return graph;
    }

}
