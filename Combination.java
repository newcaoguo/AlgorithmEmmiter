package com.company;

import org.junit.Test;

import java.util.*;

//字符串的组合问题
public class Combination {

    public static void combination(char[] chars) {
        char[] subchars = new char[chars.length]; //存储子组合数据的数组
        //全组合问题就是所有元素(记为n)中选1个元素的组合, 加上选2个元素的组合...加上选n个元素的组合的和
        //此for循环就是完成1个元素，2个元素，...n个元素选取问题
        for (int i = 0; i < chars.length; ++i) {
            int m = i + 1;
            //combination函数就是完成n中取m个元素组合问题
            combination(chars, chars.length, m, subchars, m);
        }
    }

    //n表示还剩下多少元素可以被用来组合，m表示还需要多少元素来组合。subn表示存放待打印的元素个数
    public static void combination(char[] chars, int n, int m, char[] subchars, int subn) {
        if (m == 0) { //出口
            for (int i = 0; i < subn; ++i) {
                System.out.print(subchars[i]);
            }
            System.out.println();
        } else {
            for (int i = n; i >= m; i--) { // 从后往前依次选定一个
                subchars[m - 1] = chars[i - 1]; // 选定一个后
                combination(chars, i - 1, m - 1, subchars, subn); // 从前i-1个里面选取m-1个进行递归
            }
        }
    }

    @Test
    public void test() {
        char[] ch = {'a','b','c'};
        combination(ch);
    }
}
