package com.company;

import org.junit.Test;

public class NQueensII {
    /**
     * This is a classic backtracking problem.
     * <p>
     * Start row by row, and loop through columns.
     * At each decision point, skip unsafe positions
     * by using three boolean arrays.
     * <p>
     * Start going back when we reach row n.
     * <p>
     * Just FYI, if using HashSet,
     * running time will be at least 3 times slower!
     */
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns
        boolean[] d1 = new boolean[2 * n];   // diagonals
        boolean[] d2 = new boolean[2 * n];   // diagonals
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, boolean[] cols,
                             boolean[] d1, boolean[] d2, int n) {
        if (row == n) count++;

        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = d1[id1] = d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = d1[id1] = d2[id2] = false;
        }
    }

    @Test
    public void test(){
        totalNQueens(4);
    }
}
