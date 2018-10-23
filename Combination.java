package com.company;

import org.junit.Test;

import java.util.*;

//字符串的组合问题
public class Combination {

    // 从 abcdee 中选 3 个字符 有几种组合方式
    public ArrayList<String> Permutation(String str, int targetNum) {
        if (str.length() == 0) {
            return null;
        }
        int len = str.length();
        int n = 1 << len;
        //从1循环到2^len-1
        for (int i = 1; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            //查看第一层循环里面的任意一种取值当中的哪一位是1[比如ab,011]，
            // 如果是1，对应的字符就存在，打印当前组合。
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) // 对应位上为1，则输出对应的字符
                {
                    sb.append(str.charAt(j));
                }
            }
            if (sb.length() == targetNum)
                System.out.print(sb + " ");
        }
        return null;
    }

    @Test
    public void test() {
        Permutation("aac", 1);
    }
}
