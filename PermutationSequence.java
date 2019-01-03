package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    StringBuilder res = new StringBuilder();
    int count = 0;

    public String getPermutation(int n, int k) {
        List<List<Integer>> mList = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        backtrack(mList, new ArrayList<>(), nums, new boolean[nums.length], k);
        return res.toString();
    }

    private void backtrack(List<List<Integer>> list,
                           List<Integer> tempList,
                           int[] nums,
                           boolean[] used, int k) {
        if (tempList.size() == nums.length) {
            if (k == ++count) {
                for (Integer a : tempList) res.append(a);
//                System.out.println(res);
                return;
            }
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0
                        && nums[i] == nums[i - 1]
                        && !used[i - 1]))
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used, k);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(getPermutation(9, 219601));
    }
}
