package com.company;

import org.junit.Test;

public class ReverseSentence {
    /**
     * 将data中start到end之间的数字反转
     */
    public void reverse(char[] data, int start, int end) {
        if (data == null || data.length < 1 || start < 0 || end > data.length || start > end) {
            return;
        }
        while (start < end) {
            char tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;
            start++;
            end--;
        }
    }

    public String ReverseSentence(String str) {
        char[] data = str.toCharArray();
        String res = "";
        if (data == null || data.length < 1) {
            return res;
        }
        reverse(data, 0, data.length - 1);
        int start = 0;
        int end = 0;
        while (start < data.length) {
            if (data[start] == ' ') {
                start++;
                end++;
            } else if (end == data.length || data[end] == ' ') {
                reverse(data, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        for (char c : data) res += c;
        return res;
    }

    @Test
    public void test() {
        System.out.println(ReverseSentence("student. a am I"));
    }
}
