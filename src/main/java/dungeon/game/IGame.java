package dungeon.game;

import exceptions.UnknownInputException;
import java.io.IOException;

public interface IGame {
    void start() throws IOException, UnknownInputException;
}
