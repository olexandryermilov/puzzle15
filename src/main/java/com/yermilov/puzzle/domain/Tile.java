package com.yermilov.puzzle.domain;

public class Tile {
    private String value;
    private int currentPosition;
    private int finalPosition;

    public Tile(int value, int currentPosition, int finalPosition) {
        this((value > 0) ? String.valueOf(value) : " ", currentPosition, finalPosition);
    }

    public Tile(String value, int currentPosition, int finalPosition) {
        this.value = value;
        this.currentPosition = currentPosition;
        this.finalPosition = finalPosition;
    }

    public boolean isAtPosition() {
        return currentPosition == finalPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return value.equals(tile.value);
    }
}
