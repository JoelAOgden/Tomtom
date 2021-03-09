package dungeon.graph.room;

import dungeon.graph.DoorDirection;

// todo: hide behind interface
public class DungeonDoor {

    public final DungeonRoom entrance;
    public final DoorDirection direction;
    public final DungeonRoom exit;

    public DungeonDoor(DungeonRoom entrance, DoorDirection direction, DungeonRoom exit) {
        this.entrance = entrance;
        this.direction = direction;
        this.exit = exit;
    }
}
