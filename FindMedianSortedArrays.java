package com.company;

import org.junit.Test;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        
        int[] tmp = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) tmp[k++] = nums1[i++];
            else tmp[k++] = nums2[j++];
        }
        while (i < nums1.length) tmp[k++] = nums1[i++];
        while (j < nums2.length) tmp[k++] = nums2[j++];
        if ((nums1.length + nums2.length) % 2 == 1)
            return tmp[(nums1.length + nums2.length) / 2];
        else
            return (double) (tmp[(nums1.length + nums2.length) / 2 - 1] +
                    tmp[(nums1.length + nums2.length) / 2]) / 2;
    }

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }
}
