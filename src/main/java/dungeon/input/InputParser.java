package dungeon.input;

import dungeon.graph.DoorDirection;
import exceptions.UnknownInputException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputParser implements IInputParser {
    @Override
    public List<DoorDirection> parseInput(String input) throws UnknownInputException {
        return input.chars().mapToObj(it -> {
                    switch (it){
                        case('n'):
                            return DoorDirection.NORTH;
                        case('e'):
                            return DoorDirection.EAST;
                        case('s'):
                            return DoorDirection.SOUTH;
                        case('w'):
                            return DoorDirection.WEST;
                        default:
                            return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
