import dungeon.controller.IGameController;
import dungeon.controller.PlayerConsoleController;
import dungeon.game.DungeonGame;
import dungeon.game.IGame;
import dungeon.graph.IDungeonGraph;
import dungeon.controller.input.ITextInputParser;
import dungeon.controller.input.PlayerTextInputParser;
import dungeon.loader.builder.DoorBuilder;
import dungeon.loader.builder.DungeonGraphBuilder;
import dungeon.loader.builder.IDungeonGraphBuilder;
import dungeon.loader.builder.RoomBuilder;
import dungeon.loader.parser.DungeonFileLineParser;
import dungeon.loader.parser.DungeonFileParser;
import dungeon.loader.primitives.RoomPrimitive;
import dungeon.viewer.DungeonTextViewer;
import dungeon.viewer.IDungeonViewer;
import dungeon.viewer.location.CurrentLocationTextViewer;
import dungeon.viewer.location.ICurrentLocationViewer;
import dungeon.viewer.map.IMapViewer;
import dungeon.viewer.map.MapTextViewer;
import dungeon.viewer.possiblemove.IPossibleMoveViewer;
import dungeon.viewer.possiblemove.PossibleMoveTextViewer;
import exceptions.RoomNotFoundException;
import exceptions.UnknownInputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, UnknownInputException {


        String file = Main.class.getResource("/dungeon_1.txt").getFile();

        IDungeonGraph graph = loadFileToGraph(file);
        IDungeonViewer dungeonViewer = buildViewer();
        IGameController gameController = buildGameController();

        IGame game = new DungeonGame(graph, dungeonViewer, gameController);

        game.start();


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

        ICurrentLocationViewer locationViewer = new CurrentLocationTextViewer();
        IPossibleMoveViewer possibleMoveViewer = new PossibleMoveTextViewer();
        IMapViewer mapViewer = new MapTextViewer();
        return new DungeonTextViewer(locationViewer, possibleMoveViewer, mapViewer);
    }

    // TODO: put behind a builder
    private static IGameController buildGameController() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ITextInputParser inputParser = new PlayerTextInputParser();
        return new PlayerConsoleController(inputParser, reader);
    }
}
