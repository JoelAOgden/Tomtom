package dungeon.controller.input;

import dungeon.game.PlayerAction;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTextInputParserTest {

    @Test
    public void parseDirectionInput() {

        PlayerTextInputParser textInputParser = new PlayerTextInputParser();
        String inputText = "nsew";
        List<PlayerAction> expectedActions = List.of(
                PlayerAction.NORTH,
                PlayerAction.SOUTH,
                PlayerAction.EAST,
                PlayerAction.WEST
        );

        List<PlayerAction> responseActions = textInputParser.parseInput(inputText, false);

        assertArrayEquals(expectedActions.toArray(), responseActions.toArray());
    }

    @Test
    public void parseExitInput() {

        PlayerTextInputParser textInputParser = new PlayerTextInputParser();
        String inputText = "exit";
        List<PlayerAction> expectedActions = List.of(
                PlayerAction.TERMINATE_GAME
        );

        List<PlayerAction> responseActions = textInputParser.parseInput(inputText, false);

        assertArrayEquals(expectedActions.toArray(), responseActions.toArray());

    }

    @Test
    public void parseBrokenInput() {

        PlayerTextInputParser textInputParser = new PlayerTextInputParser();
        String inputText = "ad";
        List<PlayerAction> expectedActions = List.of();

        List<PlayerAction> responseActions = textInputParser.parseInput(inputText, true);

        assertArrayEquals(expectedActions.toArray(), responseActions.toArray());
    }

}
