package com.yermilov.puzzle.controller;

import com.yermilov.puzzle.domain.Direction;
import com.yermilov.puzzle.domain.Move;
import com.yermilov.puzzle.domain.Tile;
import com.yermilov.puzzle.model.GameState;

public class Controller {

    Move getMove(Direction direction, GameState gameState) {
        switch (direction) {
            case DOWN:
                if (gameState.getEmptyX() < gameState.getSize() - 1) return new Move(1, 0);
                break;
            case UP:
                if (gameState.getEmptyX() > 0) return new Move(-1, 0);
                break;
            case RIGHT:
                if (gameState.getEmptyY() < gameState.getSize() - 1) return new Move(0, 1);
                break;
            case LEFT:
                if (gameState.getEmptyY() > 0) return new Move(0, -1);
                break;
        }
        return new Move(0, 0);
    }
    private GameState swapTiles(Move move, GameState gameState) {
        int emptyX = gameState.getEmptyX();
        int emptyY = gameState.getEmptyY();
        int newEmptyX = emptyX + move.getX();
        int newEmptyY = emptyY + move.getY();

        Tile temp = gameState.getTable()[emptyX][emptyY];
        gameState.getTable()[emptyX][emptyY] = gameState.getTable()[newEmptyX][newEmptyY];
        gameState.getTable()[newEmptyX][newEmptyY] = temp;

        gameState.getTable()[emptyX][emptyY].setCurrentPosition(emptyX * gameState.getSize() + emptyY);
        gameState.getTable()[newEmptyX][newEmptyY].setCurrentPosition(newEmptyX * gameState.getSize() + newEmptyY);

        gameState.setEmptyX(newEmptyX);
        gameState.setEmptyY(newEmptyY);
        return gameState;
    }

    public GameState proceedMove(Direction direction, GameState gameState) {
        Move move = getMove(direction, gameState);
        return swapTiles(move, gameState);
    }
}
