package com.yermilov.puzzle;

import com.yermilov.puzzle.controller.Controller;
import com.yermilov.puzzle.input.Reader;
import com.yermilov.puzzle.model.GameState;
import com.yermilov.puzzle.view.ConsoleView;
import com.yermilov.puzzle.input.ConsoleReader;
import com.yermilov.puzzle.view.View;

public class App {
    private final static int DEFAULT_SIZE = 4;

    public static void main(String[] args) {
        GameState gameState = new GameState(DEFAULT_SIZE);
        View consoleView = new ConsoleView();
        Reader reader = new ConsoleReader();
        Controller controller = new Controller();
        while (!gameState.isEndState()) {
            consoleView.drawGameState(gameState);
            gameState = controller.proceedMove(reader.getDirection(), gameState);
        }
    }
}
