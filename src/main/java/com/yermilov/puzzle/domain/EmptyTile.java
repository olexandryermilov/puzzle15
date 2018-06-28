package com.yermilov.puzzle.domain;

public class EmptyTile extends Tile {
    public EmptyTile(int size) {
        super(-1, size * size - 1, size * size - 1);
    }

    public EmptyTile(int currentPosition, int size) {
        super(-1, currentPosition, size * size - 1);
    }
}
