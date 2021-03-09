package dungeon.loader.parser;

import dungeon.loader.primitives.RoomPrimitive;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DungeonFileParser {

    private final DungeonFileLineParser dungeonFileLineParser;

    public DungeonFileParser(DungeonFileLineParser dungeonFileLineParser) {
        this.dungeonFileLineParser = dungeonFileLineParser;
    }

    public List<RoomPrimitive> loadFileToRoomPrimitives(String fileURL) throws IOException {

        FileReader fileReader = new FileReader(fileURL);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // build dungeon.graph.room pool
        List<RoomPrimitive> primitiveRooms = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            RoomPrimitive newRoom = dungeonFileLineParser.parseLine(line);
            primitiveRooms.add(newRoom);
        }

        fileReader.close();
        bufferedReader.close();

        return primitiveRooms;

    }

}
