package com.yermilov.puzzle.view;

import com.yermilov.puzzle.Utils;
import com.yermilov.puzzle.model.GameState;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConsoleViewTest {
    @Test
    public void getGameStatePresentation_ReturnRightAnswer() {
        final int[][] TABLE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
        final String RIGHT_PRESENTATION = " 1  2  3  4\n" +
                                          " 5  6  7  8\n" +
                                          " 9 10 11 12\n" +
                                            "13 14 15   ";
        GameState gameState = new GameState(Utils.intTableToTileTable(TABLE));
        ConsoleView consoleView = new ConsoleView();
        assertEquals("Returns right presentation for table", RIGHT_PRESENTATION,
                consoleView.getGameStatePresentation(gameState));
    }
}
