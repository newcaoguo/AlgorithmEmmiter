package com.company;

import org.junit.Test;

public class Sum_Solution {

    public int Sum_Solution(int n) {
        return (1 + n) * n / 2;
    }

    @Test
    public void test() {
        System.out.println(Sum_Solution(10));
    }
}
