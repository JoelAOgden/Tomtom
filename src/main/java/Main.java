import dungeon.game.DungeonGame;
import dungeon.game.IGame;
import dungeon.graph.DoorDirection;
import dungeon.graph.IDungeonGraph;
import dungeon.input.IInputParser;
import dungeon.input.InputParser;
import dungeon.loader.builder.DoorBuilder;
import dungeon.loader.builder.DungeonGraphBuilder;
import dungeon.loader.builder.IDungeonGraphBuilder;
import dungeon.loader.builder.RoomBuilder;
import dungeon.loader.parser.DungeonFileLineParser;
import dungeon.loader.parser.DungeonFileParser;
import dungeon.loader.primitives.RoomPrimitive;
import dungeon.viewer.DungeonTextViewer;
import dungeon.viewer.IDungeonViewer;
import dungeon.viewer.location.CurrentLocationViewer;
import dungeon.viewer.location.ICurrentLocationViewer;
import dungeon.viewer.possiblemove.IPossibleMoveViewer;
import dungeon.viewer.possiblemove.PossibleMoveViewer;
import exceptions.RoomNotFoundException;
import exceptions.UnknownInputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static IInputParser inputParser = new InputParser();

    public static void main(String[] args) throws IOException, UnknownInputException, RoomNotFoundException {

        System.out.println("------------------------------------------");
        System.out.println("Welcome to joel's barely average graph runner");
        System.out.println("------------------------------------------");


        String file = Main.class.getResource("/dungeon_1.txt").getFile();

        IDungeonGraph graph = loadFileToGraph(file);
        IDungeonViewer dungeonViewer = buildViewer();

        IGame game = new DungeonGame(graph);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!input.equals("exit") ) {
            dungeonViewer.drawGame(game);



            System.out.println("Please enter your moves... (all invalid moves will be ignored)");
            input = reader.readLine();
            List<DoorDirection> moves = inputParser.parseInput(input);



            // use for loop to catch exception in correct thread
            for (DoorDirection move : moves) {
                game.takeMove(move);
            }

        }

    }

    private static IDungeonGraph loadFileToGraph(String file) throws IOException {
        System.out.println("loading file: " + file);

        DungeonFileLineParser dungeonFileLineParser = new DungeonFileLineParser();
        DungeonFileParser dungeonFileParser = new DungeonFileParser(dungeonFileLineParser);
        RoomBuilder roomBuilder = new RoomBuilder();
        DoorBuilder doorBuilder = new DoorBuilder();
        IDungeonGraphBuilder graphBuilder = new DungeonGraphBuilder(roomBuilder, doorBuilder);


        List<RoomPrimitive> primitives = dungeonFileParser.loadFileToRoomPrimitives(file);

        return graphBuilder.buildFromPrimitives(primitives);
    }

    // TODO: put behind a builder
    private static IDungeonViewer buildViewer() {

        ICurrentLocationViewer locationViewer = new CurrentLocationViewer();
        IPossibleMoveViewer possibleMoveViewer = new PossibleMoveViewer();
        return new DungeonTextViewer(locationViewer, possibleMoveViewer);
    }
}
