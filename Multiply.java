package com.company;

import org.junit.Test;

public class Multiply {
    /**
     * 给定一个数组A[0,1,...,n-1],
     * 请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return null;
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = 1;
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j)
                    B[i] *= A[j];
            }
        }
        return B;
    }

    @Test
    public void test() {
        int[] mMultiply = multiply(new int[]{1, 2, 3, 4, 5});
        for (int a : mMultiply) {
            System.out.print(a + " ");
        }
    }
}
