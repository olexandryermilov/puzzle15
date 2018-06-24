package com.yermilov.puzzle;

import com.yermilov.puzzle.controller.Controller;
import com.yermilov.puzzle.model.GameState;
import com.yermilov.puzzle.view.ConsoleView;
import com.yermilov.puzzle.view.Reader;
import com.yermilov.puzzle.view.View;

public class App {
    public static void main(String[] args) {
        GameState gameState = new GameState(4);
        View consoleView = new ConsoleView();
        Reader reader = new Reader();
        Controller controller = new Controller();
        while (!gameState.isEndState()) {
            consoleView.drawGameState(gameState);
            gameState = controller.proceedMove(reader.getMove(), gameState);
        }
    }
}
