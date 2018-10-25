package com.company;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    //在一个字符串(0<=字符串长度<=10000，全部由字母组成)中
    // 找到第一个只出现一次的字符,
    // 并返回它的位置,
    // 如果没有则返回 -1
    // （需要区分大小写）
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        Map<Character, Integer> mCache = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (mCache.containsKey(str.charAt(i))) {
                mCache.put(str.charAt(i),
                        mCache.get(str.charAt(i)) + 1);
            } else {
                mCache.put(str.charAt(i), 1);
            }
        }
        for (Character c : mCache.keySet()) {
            if (mCache.get(c) == 1) return str.indexOf(c);
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(FirstNotRepeatingChar("aabc"));
    }
}
