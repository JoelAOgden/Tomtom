package dungeon.viewer.possiblemove;

import dungeon.graph.DoorDirection;
import java.util.List;

public class PossibleMoveTextViewer implements IPossibleMoveViewer {

    @Override
    public void drawPossibleMoves(List<DoorDirection> possibleMoves) {
        StringBuilder choicesBuilder = new StringBuilder("");

        // TODO: neaten this up
        if (possibleMoves.contains(DoorDirection.NORTH)) {
            choicesBuilder.append("n");
        }
        if (possibleMoves.contains(DoorDirection.EAST)) {
            choicesBuilder.append("e");
        }
        if (possibleMoves.contains(DoorDirection.SOUTH)) {
            choicesBuilder.append("s");
        }
        if (possibleMoves.contains(DoorDirection.WEST)) {
            choicesBuilder.append("w");
        }

        System.out.println("possible moves: " + choicesBuilder.toString());

    }
}
