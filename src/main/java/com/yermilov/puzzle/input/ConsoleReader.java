package com.yermilov.puzzle.input;

import com.yermilov.puzzle.domain.Direction;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    String readDirection() {
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
                System.out.println("err");
                return getDirection();
        }
    }
}
