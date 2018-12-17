package com.company;

import org.junit.Test;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxs = new int[9][9];

        for(int i = 0; i < board.length; ++ i)
            for(int j = 0; j < board[i].length; ++ j)
                if(board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if(rows[i][num]==1 || cols[j][num]==1 || boxs[k][num]==1)
                        return false;
                    rows[i][num] = cols[j][num] = boxs[k][num] = 1;
                }
        return true;
    }

    @Test
    public void test() {

    }
}
