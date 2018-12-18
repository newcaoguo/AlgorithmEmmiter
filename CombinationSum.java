package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resLists = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return resLists;
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(resLists, list, candidates, target, 0);
        return resLists;
    }

    private void dfs(List<List<Integer>> res,
                     ArrayList<Integer> list,
                     int[] candidates,
                     int target, int start) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                return;
            if (i > 0 && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            dfs(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
    }
}
