package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> mCombinationSum2Lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return mCombinationSum2Lists;
        Arrays.sort(candidates);
        helper(candidates, mCombinationSum2Lists, new ArrayList<>(), target, 0);
        if (mCombinationSum2Lists == null || mCombinationSum2Lists.size() == 0)
            return mCombinationSum2Lists;
        return mCombinationSum2Lists;
    }

    public void helper(int[] candidates,
                       List<List<Integer>> mCombinationSum2Lists,
                       ArrayList<Integer> mList,
                       int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            mCombinationSum2Lists.add(new ArrayList<>(mList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                return;
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            mList.add(candidates[i]);
            helper(candidates, mCombinationSum2Lists, mList, target - candidates[i], i + 1);
            mList.remove(mList.size() - 1);
        }
    }


    @Test
    public void test() {
        List<List<Integer>> lists =
                combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : lists) {
            for (Integer a : list) System.out.print(a + " ");
            System.out.println();
        }
    }

}
