package dungeon.input;

import dungeon.graph.DoorDirection;
import exceptions.UnknownInputException;
import java.util.List;

public interface IInputParser {

    List<DoorDirection> parseInput(String input) throws UnknownInputException;

}
