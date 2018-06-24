package com.yermilov.puzzle.model;

import com.yermilov.puzzle.domain.EmptyTile;
import com.yermilov.puzzle.domain.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {
    private int size;
    private Tile[][] table;
    private int emptyX, emptyY;

    public GameState(int size) {
        this.size = size;
        table = new Tile[size][size];
        setupTable();
    }

    public GameState(Tile[][] table){
        setTable(table);
        this.size=table.length;
    }

    public int getSize() {
        return size;
    }

    public Tile[][] getTable() {
        return table;
    }

    private void setTable(Tile[][] table) {
        this.table = table;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] instanceof EmptyTile) {
                    emptyX = i;
                    emptyY = j;
                    break;
                }
            }
        }
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

    private void setupTable() {
        table = generateTable(size);
        while (!isValid()) {
            table = generateTable(size);
        }
    }

    boolean isValid() {
        int inversions = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inversions += getInversions(i, j);
            }
        }
        return inversions % 2 == 0;
    }

    int getInversions(int x, int y) {
        int inversions = 0;
        for (int i = x; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == x && y >= j) continue;
                if (table[i][j].getFinalPosition() < table[x][y].getFinalPosition()
                        && table[i][j].getFinalPosition() != -1) inversions++;
            }
        }
        return inversions;
    }

    private List<Integer> generateRepresentingList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size * size - 1; i++) {
            list.add(i);
        }
        list.add(-1);
        Collections.shuffle(list);
        return list;
    }

    private Tile[][] generateTable(int size) {
        List<Integer> representingList = generateRepresentingList(size);
        Tile[][] newTable = new Tile[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int currPos = i * size + j;
                int value = representingList.get(currPos);
                if (value == -1) {
                    emptyX = i;
                    emptyY = j;
                    newTable[i][j] = new EmptyTile(currPos, size);
                } else {
                    newTable[i][j] = new Tile(value, currPos, value - 1);
                }
            }
        }
        return newTable;
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
