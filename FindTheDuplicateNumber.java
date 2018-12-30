package com.company;

import org.junit.Test;

public class FindTheDuplicateNumber {
    /**
     * Input: [1,3,4,2,2]
     * Output: 2
     */
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    @Test
    public void test() {
        findDuplicate(new int[]{1, 3, 4, 2, 2});
    }
}
