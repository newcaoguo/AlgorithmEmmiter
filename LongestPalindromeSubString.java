package com.company;

import org.junit.Test;

// 最长回文子串
public class LongestPalindromeSubString {

    public boolean isPalindrome(String mString) {
        for (int i = 0; i < mString.length(); i++) {
            if (mString.charAt(i) != mString.charAt(mString.length() - 1 - i))
                return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int windowSize = s.length();
        int end;
        int i;
        while (windowSize > 0) {
            for (i = 0; i + windowSize <= s.length(); i++) {
                end = windowSize + i - 1;
                if (isPalindrome(s.substring(i, end + 1))) {
                    return s.substring(i, end + 1);
                }
            }
            windowSize--;
        }
        return "";
    }

    @Test
    public void test() {
        String mString = "babaddtattarrattatddetartrateedredividerb";
        System.out.println(longestPalindrome(mString));
    }
}
