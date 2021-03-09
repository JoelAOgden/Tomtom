package dungeon.game;

import dungeon.controller.IGameController;
import dungeon.graph.DoorDirection;
import dungeon.graph.IDungeonGraph;
import dungeon.graph.room.DungeonDoor;
import dungeon.graph.room.DungeonRoom;
import dungeon.viewer.IDungeonViewer;
import exceptions.RoomNotFoundException;
import exceptions.UnknownInputException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dungeon.game.PlayerAction.NORTH;
import static dungeon.game.PlayerAction.TERMINATE_GAME;

public class DungeonGame implements IGame {

    private DungeonRoom currentLocation; // TODO: consider moving to a game state class
    public final IDungeonGraph graph;
    IDungeonViewer dungeonViewer;
    IGameController gameController;

    boolean isGameRunning = false;

    public DungeonGame(IDungeonGraph graph, IDungeonViewer dungeonViewer, IGameController gameController) {
        this.graph = graph;
        this.dungeonViewer = dungeonViewer;
        this.gameController = gameController;

        currentLocation = this.graph.getRooms().stream().findFirst().get(); // todo: this is unsafe
    }

    @Override
    public void start() throws IOException, UnknownInputException {
        isGameRunning = true;
        dungeonViewer.drawIntroduction();

        while(isGameRunning) {
            tick();
        }

    }

    private void tick() throws IOException, UnknownInputException {
        drawGame();

        List<PlayerAction> playerActions = this.gameController.getPlayerInput();
        playerActions.forEach(it -> {
            // todo: fix with proper error handling
            try {
                takeMove(it);
            } catch (RoomNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    private void drawGame() {
        // TODO: move to a separate game state class
        List<DoorDirection> possibleMoves = new ArrayList<>(graph.getDoorsForRoom(currentLocation).keySet());

        dungeonViewer.drawGameState(currentLocation, possibleMoves, graph);
    }

    private void takeMove(PlayerAction action) throws RoomNotFoundException {

        // todo: find a better location for this
        if (action == TERMINATE_GAME) {
            isGameRunning = false;
            return;
        }

        DoorDirection movementDirection = actionToDoorDirection(action);
        currentLocation = this.graph.getRoomFromDirection(currentLocation, movementDirection);
    }

    // todo: again, move to a seperate class
    private DoorDirection actionToDoorDirection(PlayerAction action) {
        switch (action) {
            case NORTH:
                return DoorDirection.NORTH;
            case EAST:
                return DoorDirection.EAST;
            case SOUTH:
                return DoorDirection.SOUTH;
            case WEST:
                return DoorDirection.WEST;
            default:
                return null;
        }
    }

}
