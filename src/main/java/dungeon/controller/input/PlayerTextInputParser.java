package dungeon.controller.input;

import dungeon.game.PlayerAction;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerTextInputParser implements ITextInputParser {

    @Override
    public List<PlayerAction> parseInput(String input, boolean filterUnknownPlayerActions) {

        if (input.equals("exit")) {
            return List.of(PlayerAction.TERMINATE_GAME);
        }

        List<PlayerAction> playerActions = input.chars()
                .mapToObj(this::parseChar)
                .collect(Collectors.toList());

        if (filterUnknownPlayerActions) {
            return playerActions.stream()
                    .filter(it -> it != PlayerAction.UNKNOWN)
                    .collect(Collectors.toList());
        }

        return playerActions;

    }

    private PlayerAction parseChar(int in) {
        switch (in) {
            case ('n'):
                return PlayerAction.NORTH;
            case ('e'):
                return PlayerAction.EAST;
            case ('s'):
                return PlayerAction.SOUTH;
            case ('w'):
                return PlayerAction.WEST;
            default:
                return PlayerAction.UNKNOWN;
        }
    }

}
