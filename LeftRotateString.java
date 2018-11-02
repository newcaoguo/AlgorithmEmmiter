package com.company;

import org.junit.Test;

public class LeftRotateString {

    public String LeftRotateString(String str, int n) {
        int len = str.length();
        if (str == null || n > len) return "";
        return str.substring(n, len) + str.substring(0, n);
    }

    @Test
    public void test() {
        System.out.println(LeftRotateString("abcdefg", 3));
    }
}
