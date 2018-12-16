package com.company;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = 0;
        boolean isExit = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                i++;
                isExit = true;
                while (i < nums.length && nums[i] == target) i++;
                end = i - 1;
            }
        }
        if (!isExit) return new int[]{-1, -1};
        return new int[]{start, end};
    }
}
