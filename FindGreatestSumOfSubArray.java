package com.company;

import org.junit.Test;

public class FindGreatestSumOfSubArray {
    //-2,-8,-1,-5,-9
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
//保存当前和
        int curSum = 0;
        //最大和
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            //加入下一个元素是否会获得更大的结果，如果更大，子数组连续，否则寻找新数组
            curSum = (array[i] > array[i] + curSum) ? array[i] : array[i] + curSum;
            //保存最大结果
            maxSum = (maxSum > curSum) ? maxSum : curSum;
        }
        return maxSum;

    }

    @Test
    public void test() {
        System.out.println(FindGreatestSumOfSubArray(new int[]{-2, -8, -1, -5, -9}));
    }

}
