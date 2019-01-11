package com.company;

import org.junit.Test;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word)) return true;
            }
        }
        return false;
    }

    // check whether can find word, start at (i,j) position
    public boolean dfs(char[][] board, int i, int j, String word) {
        // all the characters are checked
        if (word.length() == 0) return true;

        if ((i < 0 || i >= board.length) ||
                (j < 0 || j >= board[0].length) ||
                (word.charAt(0) != board[i][j]))
            return false;
        char tmp = board[i][j];
        board[i][j] = '#'; //avoid visit agian
        //check whether can find "word" along one direction
        boolean res = dfs(board, i + 1, j, word.substring(1, word.length())) ||
                dfs(board, i - 1, j, word.substring(1, word.length())) ||
                dfs(board, i, j + 1, word.substring(1, word.length())) ||
                dfs(board, i, j - 1, word.substring(1, word.length()));
        board[i][j] = tmp;
        return res;
    }

    @Test
    public void test() {

    }
}
