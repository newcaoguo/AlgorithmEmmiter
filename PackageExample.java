package com.company;

import org.junit.Test;

public class PackageExample {
    int n = 4;
    int m = 10;
    int[] weight = new int[]{1, 3, 2, 6};
    int[] value = new int[]{5, 3, 8, 10};
    int[] nums = new int[]{3, 4, 2, 3};
    int[] dp = new int[1050];

    // 01背包问题
    public int zeroOnePackage() {
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[m];
    }

    //参数：剩余容量
    public int zeroOnePackage(int i, int lastWeight) {
        if (i >= n) return 0;
        if (lastWeight - weight[i] < 0 || i >= n) return 0;
        return Math.max(
                zeroOnePackage(i + 1, lastWeight),
                zeroOnePackage(i + 1, lastWeight - weight[i]) + value[i]
        );
    }

    //完全背包问题
    public int fullPackage() {
        for (int i = 0; i < n; i++) {
            for (int j = weight[i]; j <= m; j++) {
                dp[j] = Math.max(
                        dp[j],
                        dp[j - weight[i]] + value[i]
                );
            }
        }
        return dp[m];
    }

    //多重背包问题
    public int mutiPackage() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i]; j++) { //把重复物品拆开成多次
                for (int k = m; k >= weight[i]; k--) {
                    dp[k] = Math.max(
                            dp[k],
                            dp[k - weight[i]] + value[i]
                    );
                }
            }
        }
        return dp[m];
    }

    public void clear() {
        dp = new int[1050];
    }

    /**
     * 1.01背包：有n种物品与承重为m的背包。
     * 每种物品只有一件，
     * 每个物品都有对应的重量weight[i]与价值value[i]，
     * 求解如何装包使得价值最大。
     * <p>
     * 2.完全背包：
     * 有n种物品与承重为m的背包。
     * 每种物品有无限多件，
     * 每个物品都有对应的重量weight[i]与价值value[i]，
     * 求解如何装包使得价值最大。
     * <p>
     * 3.多重背包：
     * 有n种物品与承重为m的背包。
     * 每种物品有有限件num[i]，
     * 每个物品都有对应的重量weight[i]与价值value[i]，
     * 求解如何装包使得价值最大。
     */
    @Test
    public void test() {
        System.out.println("01背包问题: " + zeroOnePackage());
        clear();
        System.out.println("01背包问题(递归实现): " + zeroOnePackage(0, m));
        clear();
        System.out.println("完全背包问题: " + fullPackage());
        clear();
        System.out.println("多重背包问题: " + mutiPackage());
    }
}
