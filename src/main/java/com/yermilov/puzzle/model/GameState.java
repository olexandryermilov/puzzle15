package com.yermilov.puzzle.model;

import com.yermilov.puzzle.domain.EmptyTile;
import com.yermilov.puzzle.domain.Tile;

public class GameState {
    private int size;
    private Tile[][] table;
    private int emptyX, emptyY;

    public GameState(int size) {
        this.size = size;
        table = new Tile[size][size];
        emptyX = size - 1;
        emptyY = size - 1;
        GameStateGenerator gameStateGenerator = new GameStateGenerator();
        table = gameStateGenerator.setupTable(size);
    }

    public GameState(Tile[][] table) {
        this.table = table;
        size = table.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] instanceof EmptyTile) {
                    emptyX = i;
                    emptyY = j;
                    break;
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Tile[][] getTable() {
        return table;
    }

    public boolean isEndState() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!table[i][j].isAtPosition()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getEmptyX() {
        return emptyX;
    }

    public void setEmptyX(int emptyX) {
        this.emptyX = emptyX;
    }

    public int getEmptyY() {
        return emptyY;
    }

    public void setEmptyY(int emptyY) {
        this.emptyY = emptyY;
    }
}
