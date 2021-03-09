package dungeon.pixeliser;

import dungeon.graph.DoorDirection;
import dungeon.graph.IDungeonGraph;
import dungeon.graph.room.DungeonDoor;
import dungeon.graph.room.DungeonRoom;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// TODO: this entire class makes me hate coding :'( haha
// this would be much easier in python
public class GraphPixeliser implements IGraphPixeliser {

    private Map<Integer, DungeonRoom> xRoomCoords;
    private Map<Integer, DungeonRoom> yRoomCoords;
    private Set<DungeonRoom> seenRooms;

    @Override
    public GraphPixel[][] createPixelGrid(DungeonRoom currentLocation, IDungeonGraph graph) {

        xRoomCoords = new HashMap<>();
        yRoomCoords = new HashMap<>();
        seenRooms = new HashSet<>();
        
        extractRoomCoords(graph, 0, 0, currentLocation);

        int xMax = xRoomCoords.keySet().stream().max(Comparator.comparingInt(i -> i)).get(); // todo: this is unsafe
        int xMin = xRoomCoords.keySet().stream().min(Comparator.comparingInt(i -> i)).get(); // todo: this is unsafe
        int xLength = xMax - xMin;

        int yMay = yRoomCoords.keySet().stream().max(Comparator.comparingInt(i -> i)).get(); // todo: this is unsafe
        int yMin = yRoomCoords.keySet().stream().min(Comparator.comparingInt(i -> i)).get(); // todo: this is unsafe
        int yLength = yMay - yMin;

        GraphPixel[][] pixelGrid = new GraphPixel[xLength][yLength];

        // TODO: complete the sodding pixel grid

        return pixelGrid;
    }

    private void extractRoomCoords(IDungeonGraph graph, int x, int y, DungeonRoom currentLocation) {
        if (seenRooms.contains(currentLocation)) {
            return;
        }

        xRoomCoords.put(x, currentLocation);
        yRoomCoords.put(y, currentLocation);
        seenRooms.add(currentLocation);

        Map<DoorDirection, DungeonDoor> doorMap = graph.getDoorsForRoom(currentLocation);

        if (doorMap.containsKey(DoorDirection.NORTH)) {
            extractRoomCoords(graph, x, y - 1, doorMap.get(DoorDirection.NORTH).exit);
        }
        if (doorMap.containsKey(DoorDirection.EAST)) {
            extractRoomCoords(graph, x + 1, y, doorMap.get(DoorDirection.EAST).exit);
        }
        if (doorMap.containsKey(DoorDirection.SOUTH)) {
            extractRoomCoords(graph, x, y + 1, doorMap.get(DoorDirection.SOUTH).exit);
        }
        if (doorMap.containsKey(DoorDirection.WEST)) {
            extractRoomCoords(graph, x - 1, y, doorMap.get(DoorDirection.WEST).exit);
        }
    }

}
