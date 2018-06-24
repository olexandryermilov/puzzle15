package com.yermilov.puzzle.controller;

import com.yermilov.puzzle.Utils;
import com.yermilov.puzzle.domain.Direction;
import com.yermilov.puzzle.domain.Move;
import com.yermilov.puzzle.model.GameState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    @Test
    public void getMoveForDirectionTest() {
        Controller controller = new Controller();
        GameState gameState = new GameState(4);
        gameState.setEmptyY(2);
        gameState.setEmptyX(2);
        Direction[] directions = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
        Move[] moves = {new Move(-1, 0), new Move(1, 0), new Move(0, -1), new Move(0, 1)};
        for (int i = 0; i < directions.length; i++) {
            assertEquals(controller.getMove(directions[i], gameState), moves[i]);
        }
    }

    @Test
    public void proceedMoveTest() {
        final int[][] TABLE = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {-1, 13, 14, 15}};
        Controller controller = new Controller();
        GameState gameState = new GameState(Utils.intTableToTileTable(TABLE));
        gameState = controller.proceedMove(Direction.RIGHT, gameState);
        gameState = controller.proceedMove(Direction.RIGHT, gameState);
        gameState = controller.proceedMove(Direction.RIGHT, gameState);
        assertTrue(gameState.isEndState());
    }

}
