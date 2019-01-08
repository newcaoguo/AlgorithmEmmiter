package com.company;

import org.junit.Test;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < grid[0].length - 1; i++)
            dp[0][i + 1] = dp[0][i] + grid[0][i + 1];

        for (int i = 0; i < grid.length - 1; i++)
            dp[i + 1][0] = dp[i][0] + grid[i + 1][0];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (dp[i - 1][j] + grid[i][j] <=
                        dp[i][j - 1] + grid[i][j]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test() {
        minPathSum(new int[][]{{1, 2}, {5, 6}, {1, 1}});
    }
}
