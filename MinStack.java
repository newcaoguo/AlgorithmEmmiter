package com.company;

import org.junit.Test;

import java.util.Arrays;

public class MinStack {
    /**
     * 题目描述
     * 定义栈的数据结构，
     * 请在该类型中实现一个能够得到栈中所含最小元素的min函数
     * （时间复杂度应为O（1））。
     *
     * @param node
     */
    public static final int DEFAULT_SIZE = 18;
    public int[] data = new int[DEFAULT_SIZE];
    public int index = -1;
    public int min = Integer.MAX_VALUE;

    public void push(int node) {
        if (index < data.length - 1) {
            if (node < min) min = node;
            data[++index] = node;
        } else {
            resize();//扩容
            data[++index] = node - min;
        }

    }

    private void resize() {
        data = Arrays.copyOf(data, data.length << 1);
    }

    // return data[index--] + min;
    public void pop() {
        if (index >= 0) {
            // 如果弹出的数是最小数
            //那么，需要再重新找最小数
            if (data[index] == min) {
                min = data[index - 1];
                for (int i = 0; i < index; i++) {
                    if (data[i] <= min) min = data[i];
                }
            }
            data[index--] = Integer.MAX_VALUE;
        } else {
            throw new IllegalArgumentException("The stack is empty.");
        }
    }

    public int top() {
        return data[index];
    }

    // 时间复杂度应为 O(1)
    public int min() {
        return min;
    }
    //["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
    @Test
    public void test() {
    }
}
