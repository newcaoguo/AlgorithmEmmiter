package com.company;

import org.junit.Test;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] rowFlag = new boolean[m][n];
        boolean[][] colFlag = new boolean[m][n];
        boolean[][] cellFlag = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int c = board[i][j] - '1'; // 4
                    if (rowFlag[i][c] || // row[0][4]
                            colFlag[c][j] || // col[4][0]
                            cellFlag[3 * (i / 3) + j / 3][c]) // cell[0][4]
                        return false;
                    rowFlag[i][c] = true;
                    colFlag[c][j] = true;
                    cellFlag[3 * (i / 3) + j / 3][c] = true;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {

    }
}
