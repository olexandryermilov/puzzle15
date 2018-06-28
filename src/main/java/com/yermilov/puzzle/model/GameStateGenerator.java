package com.yermilov.puzzle.model;

import com.yermilov.puzzle.domain.EmptyTile;
import com.yermilov.puzzle.domain.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GameStateGenerator {

    Tile[][] setupTable(int size) {
        Tile[][] table = generateTable(size);
        while (!isValid(table)) {
            table = generateTable(size);
        }
        return table;
    }

    boolean isValid(Tile[][] table) {
        int inversions = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                inversions += getInversions(table, i, j);
            }
        }
        return inversions % 2 == 0;
    }

    int getInversions(Tile[][] table, int x, int y) {
        int inversions = 0;
        for (int i = x; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (i == x && y >= j) continue;
                if (table[i][j].getFinalPosition() < table[x][y].getFinalPosition()) inversions++;
            }
        }
        return inversions;
    }

    private List<Integer> generateRepresentingList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size * size - 1; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    private Tile[][] generateTable(int size) {
        List<Integer> representingList = generateRepresentingList(size);
        Tile[][] newTable = new Tile[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) continue;
                int currPos = i * size + j;
                int value = representingList.get(currPos);
                newTable[i][j] = new Tile(value, currPos, value - 1);
            }
        }
        newTable[size-1][size-1] = new EmptyTile(size);
        return newTable;
    }


}
