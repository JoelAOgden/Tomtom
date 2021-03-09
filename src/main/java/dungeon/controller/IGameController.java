package dungeon.controller;

import dungeon.game.PlayerAction;
import exceptions.UnknownInputException;
import java.io.IOException;
import java.util.List;

public interface IGameController {

    List<PlayerAction> getPlayerInput() throws IOException, UnknownInputException;

}
