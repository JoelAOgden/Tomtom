package dungeon.viewer;

import dungeon.game.IGame;
import dungeon.viewer.location.ICurrentLocationViewer;
import dungeon.viewer.possiblemove.IPossibleMoveViewer;

public class DungeonTextViewer implements IDungeonViewer {

    private final ICurrentLocationViewer locationViewer;
    private final IPossibleMoveViewer possibleMoveViewer;

    public DungeonTextViewer(ICurrentLocationViewer locationViewer, IPossibleMoveViewer possibleMoveViewer) {

        this.locationViewer = locationViewer;
        this.possibleMoveViewer = possibleMoveViewer;
    }

    @Override
    public void drawGame(IGame game) {
        System.out.println("-----------------------");
        locationViewer.drawCurrentLocation(game.getCurrentRoom());
        possibleMoveViewer.drawPossibleMoves(game.getCurrentRoom(), game.getGraph());
    }


}
