package com.company;

import org.junit.Test;

public class GetNumberOfK {

    //统计一个数字在排序数组中出现的次数。
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;
        int count = 0;
        if (left - right == 0 && array[left] == k) return 1;
        while (left <= mid - 1 || right >= mid + 1) {
            mid = (left + right) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            }
            if (array[mid] > k) {
                right = mid - 1;
            }
            if (array[mid] == k) {
                ++count;
                while (left <= mid - 1 || right >= mid + 1) {
                    if (left <= mid - 1 && array[left] == k) ++count;
                    if (right >= mid + 1 && array[right] == k) ++count;
                    left++;
                    right--;
                }
                break;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(GetNumberOfK(new int[]{3, 3}, 3));
    }
}
