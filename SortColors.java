package com.company;

import org.junit.Test;

public class SortColors {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int a : nums) System.out.print(a + " ");
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int x = nums[i];
        while (i < j) {
            while ((i < j) && (x < nums[j])) j--;
            if (i < j) nums[i++] = nums[j];
            while ((i < j) && (x > nums[i])) i++;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = x;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    @Test
    public void test() {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});

    }

}
