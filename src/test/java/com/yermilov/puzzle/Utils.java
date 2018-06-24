package com.yermilov.puzzle;

import com.yermilov.puzzle.domain.EmptyTile;
import com.yermilov.puzzle.domain.Tile;

public class Utils {
    public static Tile[][] intTableToTileTable(int[][] intTable) {
        Tile[][] result = new Tile[intTable.length][intTable[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (intTable[i][j] != -1) {
                    result[i][j] = new Tile(intTable[i][j], i * result.length + j, intTable[i][j]-1);
                } else {
                    result[i][j] = new EmptyTile(i * result.length + j, result.length);
                }
            }
        }
        return result;
    }
}
