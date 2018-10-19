package com.company;

import org.junit.Test;

import java.util.ArrayList;

public class Permutation {
    /**
     * 字符串的全排列，可以分三个部分依次分析：
     * 1、没有重复字符字符的全排列问题；
     * 2、有重复字符字符的全排列问题；
     * 3、全排列问题的非递归算法。
     */

    ArrayList<String> res = new ArrayList<>();
    String tmp = "";

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] charArray = str.toCharArray();
        Permutation(charArray, 0, charArray.length - 1);
        return res;
    }


    public void Permutation(char[] charArray, int from, int to) {
        if (to <= 0) {
            return;
        }
        if (from == to) {
            for (int i = 0; i <= to; i++)
                tmp += charArray[i];
            res.add(tmp);
            tmp = "";
        } else {
            for (int i = from; i <= to; i++) {
                if (!isSwap(charArray, from, i)) continue;
                swap(charArray, i, from);
                Permutation(charArray, from + 1, to);
                swap(charArray, i, from);
            }
        }
    }

    public boolean isSwap(char[] charArray, int from, int to) {
        for (int i = from; i < to; i++) {
            if (charArray[to] == charArray[i]) return false;
        }
        return true;
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }


    @Test
    public void test() {
        ArrayList<String> mList = Permutation("aa");
        for (String a : mList) {
            System.out.println(a);
        }
    }
}
