package dungeon.viewer.location;

import dungeon.room.DungeonRoom;

public class CurrentLocationViewer implements ICurrentLocationViewer {

    @Override
    public void drawCurrentLocation(DungeonRoom currentLocation) {
        System.out.println("you are in room " + currentLocation.roomNameRef);
    }
}
