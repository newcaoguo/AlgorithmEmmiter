package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        //初始化棋盘
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        //递归
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' &&
                        (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

    /**
     * 构建棋盘
     */
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    @Test
    public void test() {

    }
}
