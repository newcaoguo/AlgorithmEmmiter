package com.company;

import org.junit.Test;

public class HasPath {
    /**
     * a b c e
     * s f c s
     * a d e e
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols,
                        row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (pathLength >= str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 &&
                row < rows &&
                col >= 0 &&
                col < cols &&
                matrix[row * cols + col] == str[pathLength] &&
                !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    @Test
    public void test() {
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));
    }
}
