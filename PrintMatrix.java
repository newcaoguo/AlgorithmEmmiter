package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class PrintMatrix {
    /**
     * 题目描述
     * 输入一个矩阵，
     * 按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，
     * 如果输入如下4 X 4矩阵：
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字
     * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */
    //1. 起始状态，向右走
    //2. 向右走到顶了，就向下走
    //3. 向下走到顶了，就向左走
    //4. 向左走到顶了，就向上走
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> mIntegerArrayList = new ArrayList<>();
        if (matrix == null) return null;
        mIntegerArrayList.add(matrix[0][0]);
        for (int i = 0, j = 0; (mIntegerArrayList.size() < matrix.length * matrix[0].length); ) {
            // 向右走
            for (j = j + 1; j < matrix[0].length; ++j) {
                if (saveMatrixValueToArrayList(mIntegerArrayList, i, j, matrix[i])) break;
            }
            j--;
            //向下走
            for (i = i + 1; i < matrix.length; ++i) {
                if (saveMatrixValueToArrayList(mIntegerArrayList, i, j, matrix[i])) break;
            }
            i--;
            //向左走
            for (j = j - 1; j >= 0; --j) {
                if (saveMatrixValueToArrayList(mIntegerArrayList, i, j, matrix[i])) break;
            }
            j++;
            //向上走
            for (i = i - 1; i > 0; --i) {
                if (saveMatrixValueToArrayList(mIntegerArrayList, i, j, matrix[i])) break;
            }
            i++;
        }
        return mIntegerArrayList;
    }

    private boolean saveMatrixValueToArrayList(ArrayList<Integer> mIntegerArrayList, int mI, int mJ, int[] mMMatrix) {
        if (mMMatrix[mJ] != -1) {
            mIntegerArrayList.add(mMMatrix[mJ]);
        } else {
            return true;
        }
        mMMatrix[mJ] = -1;
        return false;
    }


    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        ArrayList<Integer> mIntegerArrayList = printMatrix(matrix);
        for (Integer a : mIntegerArrayList) {
            System.out.print(a + " ");
        }
    }

}
