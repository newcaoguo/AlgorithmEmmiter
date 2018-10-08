package com.company;

import org.junit.Test;

import java.util.HashMap;

public class CoinChange {

    public static final int maxValue = 10000000;

    public static HashMap<HashMap<Integer, Integer>, Integer> cache =
            new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int res = search(0, amount, coins);
        if (res < maxValue) {
            return res;
        } else {
            return -1;
        }
    }

    public int search(int index, int mAmount, int[] mCoins) {
        if (mAmount == 0) return 0;
        if (mAmount < 0) return maxValue;
        if (index >= mCoins.length) return maxValue;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(index, mAmount);
        if (cache.containsKey(hashMap)) {
            return cache.get(hashMap);
        }
        int a = 1 + search(index, mAmount - mCoins[index], mCoins);
        int b = search(index + 1, mAmount, mCoins);
        cache.put(hashMap, Math.min(a, b));
        return Math.min(a, b);
    }

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
