package com.company;

import org.junit.Test;

public class IsPopOrder {
    /**
     * 输入两个整数序列，
     * 第一个序列表示栈的压入顺序，
     * 请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * （注意：这两个序列的长度是相等的）
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null
                || popA == null
                || pushA.length < 0
                || popA.length < 0) return false;
        //初始化 pop 和 push 的指针
        int popIndex = popA.length - 1;
        int pushIndex = 0;
        while (popIndex >= 0 && pushIndex >= 0) {
            //1. 找到 在 push 中与 pop 顶元素相等的指针
            int tmp = 0;//用于存放上下文
            while (popIndex < popA.length
                    && pushIndex >= 0
                    && popA[popIndex] != pushA[pushIndex]) {
                pushIndex--; //继续寻找相等的值得指针
                tmp = pushIndex;//更新上下文
            }
            //如果 pushIndex 小于 0 了，那么入栈后能够正确输出的序列中没有这个数，所以 false.
            if (pushIndex < 0) return false;
            //如果找到了与 popA 顶元素相等的值
            popIndex++;//更新 pop 序列的栈顶元素值
            if (pushIndex + 1 > pushA.length) {
                //如果入栈序列中的一部分出栈顺序完成后，那么回到上下文环境中
                pushIndex = tmp - 1;
            } else pushIndex++;//如果没完成，就继续往后查找
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
