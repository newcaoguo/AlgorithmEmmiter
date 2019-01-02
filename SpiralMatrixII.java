package com.company;

import org.junit.Test;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int num = 1;
        while (true) {

            for (int i = left; i <= right; i++)
                res[top][i] = num++;
            top++;
            if (left > right || top > bottom) break;
            for (int i = top; i <= bottom; i++)
                res[i][right] = num++;
            right--;
            if (left > right || top > bottom) break;
            for (int i = right; i >= left; i--)
                res[bottom][i] = num++;
            bottom--;
            if (left > right || top > bottom) break;
            for (int i = bottom; i >= top; i--)
                res[i][left] = num++;
            left++;
            if (left > right || top > bottom) break;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = generateMatrix(4);
        for (int[] arr : matrix){
            for (int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
