package dungeon.controller.input;

import dungeon.game.PlayerAction;
import exceptions.UnknownInputException;
import java.util.List;

public interface ITextInputParser {

    List<PlayerAction> parseInput(String input, boolean filterUnknowns);

}
