package com.company;

public class FirstAppearingOnce {
    /**
     * 模拟创建一个hash数组 ，
     * 我们只需遍历一遍自己定义的hash数组
     * 就可以找到第一个只出现一次的字符
     * 时间复杂度为o(n);
     */
    int[] hash = new int[256];
    StringBuffer s = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch) {
        s.append(ch);
        hash[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] str = s.toString().toCharArray();
        for (char c : str) {
            if (hash[c] == 1)
                return c;
        }
        return '#';
    }


}
