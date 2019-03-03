package com.company;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();
        // key: sum, value: frequency of sum.

        int n = A.length;
        int result = 0;

        // Get all possible two-sums between C and D.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Count the number of two-sums
        // between A and B that equals to
        // opposite of any two-sum between C and D
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(-sum))
                    result += map.get(-sum);
            }
        }

        return result;
    }
}
