package dungeon.controller;

import dungeon.controller.input.ITextInputParser;
import dungeon.game.PlayerAction;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class PlayerConsoleController implements IGameController {

    private final ITextInputParser inputParser;
    private final BufferedReader reader;

    public PlayerConsoleController(ITextInputParser inputParser, BufferedReader reader) {
        this.inputParser = inputParser;
        this.reader = reader;
    }

    @Override
    public List<PlayerAction> getPlayerInput() throws IOException {
        String playerInput = requestInputString();
        return inputParser.parseInput(playerInput, true);
    }

    private String requestInputString() throws IOException {
        System.out.println("please type your movement selection (type 'exit' to terminate)...");
        return reader.readLine();
    }
}
