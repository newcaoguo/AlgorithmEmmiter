package com.company;

import org.junit.Test;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[] recordrow = new int[row];
        int[] recordcol = new int[col];

        //一，记录到底哪一行，哪一列应该被置零
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    recordrow[i] = 1;
                    recordcol[j] = 1;
                }
            }
        }
        //二，根据对相应 recordrow 置零该行
        for (int i = 0; i < row; i++) {
            if (recordrow[i] == 1) {
                for (int j = 0; j < col; j++)
                    matrix[i][j] = 0;
            }
        }
        //三，根据对相应recordcol置零该列
        for (int i = 0; i < col; i++) {
            if (recordcol[i] == 1) {
                for (int j = 0; j < row; j++)
                    matrix[j][i] = 0;
            }
        }
    }

    @Test
    public void test() {

    }
}
