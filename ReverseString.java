package com.company;

import org.junit.Test;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
