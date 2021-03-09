package dungeon.viewer.location;

import dungeon.graph.room.DungeonRoom;

public class CurrentLocationTextViewer implements ICurrentLocationViewer {

    @Override
    public void drawCurrentLocation(DungeonRoom currentLocation) {
        System.out.println("you are in room " + currentLocation.roomNameRef);
    }
}
