package com.company;

import org.junit.Test;

public class SortedArrayAbs {
    /**
     * 头条面试题
     *
     * @author newcaoguo
     * @date 2018-10-14
     * 给出一个有序数组，可以是 正数 负数 和 零
     * 返回一个数，这个数是，这个数组所有数的平方值
     *
     * @return
     */
    public int fun1(int[] mData) {
        if (mData == null || mData.length == 0)
            return 0;
        HashSet<Integer> mHashSet = new HashSet<>();
        for (int a : mData) {
            mHashSet.add(a * a);
        }
        return mHashSet.size();
    }

    public int fun2(int[] mData) {
        if (mData == null || mData.length == 0) return 0;
        int start = 0;
        int end = mData.length - 1;
        int count = 0;
        while (start <= end) {
            if (start == end ||
                    Math.abs(mData[start]) == Math.abs(mData[end])) {
                start++;
                end--;
            } else if (Math.abs(mData[start])
                    <= Math.abs(mData[end])) {
                end--;
            } else if (Math.abs(mData[start])
                    >= Math.abs(mData[end])) {
                start++;
            }
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(fun2(new int[]{-10, -5, -3, 0, 3, 5, 9, 13}));
    }
}
