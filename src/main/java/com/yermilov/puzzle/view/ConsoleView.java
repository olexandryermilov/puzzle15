package com.yermilov.puzzle.view;

import com.yermilov.puzzle.model.GameState;

public class ConsoleView implements View {

    public void drawGameState(GameState gameState) {
        for (int i = 0; i < gameState.getSize(); i++) {
            for (int j = 0; j < gameState.getSize(); j++) {
                String toPrint = gameState.getTable()[i][j] + " ";
                if (toPrint.length() == 2) {
                    toPrint = " " + toPrint;
                }
                System.out.print(toPrint);
            }
            System.out.println();
        }
    }

}
