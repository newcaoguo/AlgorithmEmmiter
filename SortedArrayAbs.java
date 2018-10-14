package com.company;

import org.junit.Test;

import java.util.HashSet;

public class SortedArrayAbs {

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
            //去重
            while (start < end && mData[start] == mData[start + 1]) {
                start++;
            }
            //去重
            while (end >= 0 && mData[end] == mData[end - 1]) {
                end--;
            }
            if (start <= end && Math.abs(mData[start]) == Math.abs(mData[end])) {
                start++;
                end--;
            }
            if (start <= end && Math.abs(mData[start]) < Math.abs(mData[end])) {
                end--;
            }
            if (start <= end && Math.abs(mData[start]) > Math.abs(mData[end])) {
                start++;
            }
            count++;
        }
        return count;
    }


    @Test
    public void test() {
        System.out.println(fun2(new int[]{-1,1,1,1}));

        System.out.println(fun2(new int[]{-1,0,1,2,3}));
        System.out.println(fun2(new int[]{-2, -1, 0, 1, 1, 1}));
        System.out.println(fun2(new int[]{-1, 0, 1, 1}));
        System.out.println(fun2(new int[]{-1, 0}));
        System.out.println(fun2(new int[]{-1, 0, 1}));
        System.out.println(fun2(new int[]{-1, 0, 1, 2}));
        System.out.println(fun2(new int[]{-2, -1, 0, 1}));
        System.out.println(fun2(new int[]{-21, -1, 0, 1, 20}));
        System.out.println(fun2(new int[]{-2, -1, 0, 1, 2, 3}));
    }
}
