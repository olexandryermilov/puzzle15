package com.yermilov.puzzle.view;

import com.yermilov.puzzle.model.GameState;

public class ConsoleView implements View {

    String getGameStatePresentation(GameState gameState) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < gameState.getSize(); i++) {
            for (int j = 0; j < gameState.getSize(); j++) {
                String tilePresentation = gameState.getTable()[i][j] + ((j + 1 < gameState.getSize()) ? " " : "");
                if (gameState.getTable()[i][j].toString().length() == 1) {
                    tilePresentation = " " + tilePresentation;
                }
                stringBuilder.append(tilePresentation);
            }
            if (i + 1 < gameState.getSize()) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void drawGameState(GameState gameState) {
        System.out.println(getGameStatePresentation(gameState));
    }

}
