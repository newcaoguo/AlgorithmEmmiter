package com.company;

import org.junit.Test;

public class LongestCommonSequence {
    public StringBuilder sb = new StringBuilder();


    public String getLongestCommonSequence(String mStringA, String mStringB) {
        int strLength = longestCommonSequence(0, mStringA, 0, mStringB);
        String mString = new String(sb);
        return mString.substring(
                strLength - longestCommonSequence(0, mStringA, 0, mStringB),
                strLength);
    }

    // 最长公共子序列
    public int longestCommonSequence(int i, String mStringA, int j, String mStringB) {
        if (i == mStringA.length() || j == mStringB.length()) {
            return 0;
        }
        if (mStringA.charAt(i) == mStringB.charAt(j)) {
            sb.append(mStringA.charAt(i));
            return longestCommonSequence(i + 1, mStringA, j + 1, mStringB) + 1;
        } else {
            return Math.max(longestCommonSequence(i + 1, mStringA, j, mStringB),
                    longestCommonSequence(i, mStringA, j + 1, mStringB));
        }
    }

    @Test
    public void test() {
        // 1111111111
        System.out.println(getLongestCommonSequence("abc11google11111111", "1111111141615"));
    }
}
