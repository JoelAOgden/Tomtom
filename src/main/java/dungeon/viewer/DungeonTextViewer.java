package dungeon.viewer;

import dungeon.graph.DoorDirection;
import dungeon.graph.IDungeonGraph;
import dungeon.graph.room.DungeonRoom;
import dungeon.viewer.location.ICurrentLocationViewer;
import dungeon.viewer.map.IMapViewer;
import dungeon.viewer.possiblemove.IPossibleMoveViewer;
import java.util.List;

public class DungeonTextViewer implements IDungeonViewer {

    private final ICurrentLocationViewer locationViewer;
    private final IPossibleMoveViewer possibleMoveViewer;
    private final IMapViewer mapViewer;

    public DungeonTextViewer(ICurrentLocationViewer locationViewer, IPossibleMoveViewer possibleMoveViewer, IMapViewer mapViewer) {
        this.locationViewer = locationViewer;
        this.possibleMoveViewer = possibleMoveViewer;
        this.mapViewer = mapViewer;
    }

    @Override
    public void drawIntroduction() {
        System.out.println("------------------------------------------");
        System.out.println("Welcome to joel's barely average graph runner");
        System.out.println("this is still a work in progress, so please bare with me if you see this");
        System.out.println("------------------------------------------");
    }

    @Override
    public void drawGameState(DungeonRoom currentRoom, List<DoorDirection> possibleMoves, IDungeonGraph graph) {
        System.out.println("-----------------------");
        System.out.println("Dungeon Map");
        mapViewer.drawMap(currentRoom, graph);
        System.out.println("-----------------------");
        locationViewer.drawCurrentLocation(currentRoom);
        possibleMoveViewer.drawPossibleMoves(possibleMoves);
    }


}
