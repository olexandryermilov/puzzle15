package com.yermilov.puzzle.input;

import com.yermilov.puzzle.domain.Direction;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    private String readDirection() {
        return scanner.nextLine();
    }

    public Direction getDirection() {
        String move = readDirection();
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
                return getDirection();
        }
    }
}
