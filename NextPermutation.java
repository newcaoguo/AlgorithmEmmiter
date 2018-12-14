package com.company;

import java.util.Arrays;

public class NextPermutation {

    /**
     * 很直观的思路。找 next permutation 先找哪里可以下手，
     * 也就是从后到前数第一个 nums[j-1] < nums[j] 的地方，
     * 比如 1243 找到 2 那里，next permutation 就是1324.
     * 找到 2 的 index 也就是代码里的 first.
     * 然后再找 2 后面最小的数这里是 3，把它跟 2 交换，
     * 再把 3 后面的 sort 一下就好。
     * 注意一下 edge case，比如第一次求 first 求出来是 -1，
     * 那说明整个已经最大了，都是降序，
     * 那返回一个最低排列就是正常升序就好了。
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return;
        int first = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                first = i - 1;
                break;
            }
        }
        if (first == -1) {
            Arrays.sort(nums);
            return;
        }
        int nextMin = Integer.MAX_VALUE;
        int nextMinIndex = -1;
        for (int j = first + 1; j < nums.length; j++) {
            if (nums[j] <= nums[first]) continue;
            if (nums[j] < nextMin) {
                nextMin = nums[j];
                nextMinIndex = j;
            }
        }
        if (first != nextMinIndex)
            swap(nums, first, nextMinIndex);
        Arrays.sort(nums, first + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
