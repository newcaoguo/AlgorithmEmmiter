package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class FindNumbersWithSum {
    //输入一个递增排序的数组和一个数字S，
    // 在数组中查找两个数，
    // 使得他们的和正好是S，
    // 如果有多对数字的和等于S，
    // 输出两个数的乘积最小的。
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> mArrayList = new ArrayList<>();
        if (array == null || array.length == 0) return mArrayList;
        int left = 0;
        int right = array.length - 1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int temp = array[left] + array[right];
            if (temp < sum) left++;
            if (temp > sum) right--;
            if (temp == sum) {
                if (min > array[left] * array[right]) {
                    mArrayList.clear();
                    min = array[left] * array[right];
                    mArrayList.add(array[left]);
                    mArrayList.add(array[right]);
                }
                left++;
            }
        }
        return mArrayList;
    }

    @Test
    public void test() {
        FindNumbersWithSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
    }
}
