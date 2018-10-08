package com.company;

public class Solder {
    /**
     * 一个士兵走棋盘
     * n * m 的棋盘
     * 只能向上走或者向下走，问有多少种走法
     *
     * @param n
     * @param m
     */
    public int solder(int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (n == 1 && m == 1) return 1;
        return solder(n - 1, m) + solder(n, m - 1);
    }
}
