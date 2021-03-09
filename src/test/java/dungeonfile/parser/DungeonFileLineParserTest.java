package dungeonfile.parser;

import dungeon.loader.primitives.RoomPrimitive;
import dungeon.loader.parser.DungeonFileLineParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DungeonFileLineParserTest {


    @Test
    public void testParseLine() {

        DungeonFileLineParser lineParser = new DungeonFileLineParser();

        String roomName = "a8";
        String northConnection = "a6";
        String eastConnection = "a9";
        String southConnection = "b6";
        String westConnection = null;
        String testLine = "a8 n:a6 e:a9 s:b6";

        RoomPrimitive room = lineParser.parseLine(testLine);

        assertEquals(roomName, room.roomName);
        assertEquals(northConnection, room.northDoor);
        assertEquals(eastConnection,  room.eastDoor);
        assertEquals(southConnection, room.southDoor);
        assertEquals(westConnection, room.westDoor);

    }
}
