package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class LastRemaining_Solution {

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) return -1;
        ArrayList<Integer> mArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) mArrayList.add(i);
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) index++;
            index = index % mArrayList.size();
            mArrayList.remove(index);
            index = index % mArrayList.size();
            index--;
        }
        return mArrayList.iterator().next();
    }

    @Test
    public void test() {
        System.out.println(LastRemaining_Solution(5, 6));
    }
}
