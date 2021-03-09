package dungeon.viewer.possiblemove;

import dungeon.graph.DoorDirection;
import java.util.List;

public interface IPossibleMoveViewer {

    void drawPossibleMoves(List<DoorDirection> possibleMoves);

}
