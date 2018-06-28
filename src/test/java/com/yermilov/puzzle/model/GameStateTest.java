package com.yermilov.puzzle.model;

import com.yermilov.puzzle.Utils;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;

public class GameStateTest {

    @Test
    public void isValid_ReturnsTrue_WhenValidTable() {
        final int[][] VALID_TABLE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
        GameStateGenerator gameStateGenerator = new GameStateGenerator();
        assertTrue("Recognizes end-state table as valid",
                gameStateGenerator.isValid(Utils.intTableToTileTable(VALID_TABLE)));

    }

    @Test
    public void isValid_ReturnsFalse_WhenInvalidTable() {
        final int[][] INVALID_TABLE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 15, 14, -1}};
        GameStateGenerator gameStateGenerator = new GameStateGenerator();
        assertFalse("Recognizes 15-14 table as invalid",
                gameStateGenerator.isValid(Utils.intTableToTileTable(INVALID_TABLE)));
    }

    @Test
    public void isEndState_Recognizes_WhenInEndState() {
        final int[][] END_STATE_TABLE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
        GameState gameState = new GameState(Utils.intTableToTileTable(END_STATE_TABLE));
        assertTrue("Recognizes end-state table", gameState.isEndState());
    }

    @Test
    public void isEndState_Recognizes_WhenNotInEndState() {
        final int[][] NOT_END_STATE_TABLE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {-1, 13, 14, 15}};
        GameState gameState = new GameState(Utils.intTableToTileTable(NOT_END_STATE_TABLE));
        assertFalse("Returns false for not end-state table", gameState.isEndState());
    }

    @Test
    public void invertionsCountedRight() {
        final int[][] TABLE = {{1, 2, 4, 3}, {5, 6, 8, 7}, {9, 10, 15, 12}, {13, 11, 14, -1}};
        final int[] RIGHT_INVERTIONS = {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 4, 1, 1, 0, 0, 0};
        GameStateGenerator gameStateGenerator = new GameStateGenerator();
        int[] invertions = new int[RIGHT_INVERTIONS.length];
        for (int i = 0; i < TABLE.length; i++) {
            for (int j = 0; j < TABLE[i].length; j++) {
                invertions[i * TABLE.length + j] = gameStateGenerator.getInversions(Utils.intTableToTileTable(TABLE), i, j);
            }
        }
        assertArrayEquals("Right amount of invertions for each cell", RIGHT_INVERTIONS, invertions);
    }

}
