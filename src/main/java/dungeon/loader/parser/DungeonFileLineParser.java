package dungeon.loader.parser;

import dungeon.loader.primitives.RoomPrimitive;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DungeonFileLineParser {

    public RoomPrimitive parseLine(String line) {

        String[] stringBlocks = line.split(" ");
        String[] DirectionStringBlocks = Arrays.copyOfRange(stringBlocks, 1, stringBlocks.length);

        Map<String, String> DirectionsToRoomNames = parseDirectionBlocks(DirectionStringBlocks);

        String roomName = stringBlocks[0];
        String northDoor = DirectionsToRoomNames.get("n");
        String eastDoor =  DirectionsToRoomNames.get("e");
        String southDoor = DirectionsToRoomNames.get("s");
        String westDoor =  DirectionsToRoomNames.get("w");

        return new RoomPrimitive(roomName, northDoor, eastDoor, southDoor, westDoor);
    }

    private Map<String, String> parseDirectionBlocks(String[] stringBlocks) {
        return Arrays.asList(stringBlocks)
                .stream()
                .map(it -> it.split(":"))
                .collect(Collectors.toMap(it -> it[0], it->it[1]));
    }

}
