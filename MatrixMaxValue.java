package com.company;

import org.junit.Test;

public class MatrixMaxValue {
    public int[][] matrix = new int[5][5];

    public void initData() {
        matrix[0][0] = 10;
        matrix[0][1] = 20;
        matrix[0][2] = 5;
        matrix[0][3] = 90;
        matrix[0][4] = 2;
        matrix[1][0] = 8;
        matrix[1][1] = 30;
        matrix[1][2] = 11;
        matrix[1][3] = 80;
        matrix[1][4] = 10;
        matrix[2][0] = 5;
        matrix[2][1] = 50;
        matrix[2][2] = 20;
        matrix[2][3] = 70;
        matrix[2][4] = 8;
        matrix[3][0] = 8;
        matrix[3][1] = 11;
        matrix[3][2] = 21;
        matrix[3][3] = 37;
        matrix[3][4] = 2;
        matrix[4][0] = 20;
        matrix[4][1] = 13;
        matrix[4][2] = 25;
        matrix[4][3] = 53;
        matrix[4][4] = 1;
    }


    public static int getMaxValue(int[][] mMatrix) {
        // write code here
        int[][] arr = new int[mMatrix.length][mMatrix[0].length];
        for (int i = 0; i < mMatrix.length; i++) {
            for (int j = 0; j < mMatrix[0].length; j++) {
                int b = mMatrix[i][j];
                if (i == 0 && j == 0) {
                    arr[i][j] = b;
                } else if (i == 0) {
                    arr[i][j] = arr[i][j - 1] + b;
                } else if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + b;
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]) + b;
                }
                System.out.println("arr[" + i + "][" + j + "]: " + arr[i][j]);
            }
        }
        return arr[mMatrix.length - 1][mMatrix[0].length - 1];
    }

    @Test
    public void test() {
        initData();
        System.out.println(getMaxValue(matrix));
    }
}
