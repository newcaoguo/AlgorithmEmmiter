package com.company;

import org.junit.Test;

public class Add {

    //写一个函数，求两个整数之和，
    // 要求在函数体内不得使用+、-、*、/四则运算符号。
    public int Add(int num1, int num2) {
        int temp;
        int left = num1;
        int right = num2;
        while (right != 0) {
            temp = left ^ right;
            right = (left & right) << 1;
            left = temp;
        }
        return left;
    }

    @Test
    public void test() {
        System.out.println(Add(5, 9));
    }

}
