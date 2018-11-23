package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class MaxInWindows {
    /**
     * 给定一个数组和滑动窗口的大小，
     * 找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，
     * 他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
     * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     * {2,3,4,2,[6,2,5],1}，{2,3,4,2,6,[2,5,1]}。
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> mList = new ArrayList<>();
        if (num == null || num.length == 0) return mList;

        for (int i = 0; i < num.length; i++) {
            int left = i;
            int right = i + size - 1;
            int max = Integer.MIN_VALUE;
            if (right < num.length)
                for (int j = left; j <= right; j++)
                    if (num[j] >= max) max = num[j];
            if (max != Integer.MIN_VALUE)
                mList.add(max);
        }
        return mList;
    }

    @Test
    public void test() {
        maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
    }
}
