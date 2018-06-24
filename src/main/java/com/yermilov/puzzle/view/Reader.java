package com.yermilov.puzzle.view;

import com.yermilov.puzzle.domain.Direction;

import java.util.Scanner;

public class Reader {
    private Scanner scanner;

    public Reader() {
        scanner = new Scanner(System.in);
    }

    private String readMove() {
        return scanner.nextLine();
    }

    public Direction getMove() {
        String move = readMove();
        switch (move.toLowerCase()) {
            case "a":
                return Direction.LEFT;
            case "d":
                return Direction.RIGHT;
            case "w":
                return Direction.UP;
            case "s":
                return Direction.DOWN;
            default:
                return getMove();
        }
    }
}
