package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> mArrayLists = new ArrayList<>();
        // 高位指针和低位指针
        int pLow = 1;
        int pHigh = 2;

        // 终止条件是pHigh等于sum
        while (pHigh > pLow) {
            // 当前和，使用求和公式s = (a+b) * n / 2
            int curSum = (pLow + pHigh) * (pHigh - pLow + 1) >> 1;
            if (curSum < sum) pHigh++;
            if (curSum == sum) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = pLow; i <= pHigh; i++) {
                    temp.add(i);
                }
                mArrayLists.add(temp);
                pLow++;
            }
            if (curSum > sum) {
                pLow++;
            }
        }
        return mArrayLists;
    }

    @Test
    public void test() {
        FindContinuousSequence(100);
    }
}
