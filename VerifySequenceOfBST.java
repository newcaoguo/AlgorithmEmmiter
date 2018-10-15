package com.company;

import org.junit.Test;

public class VerifySequenceOfBST {
    /**
     * 输入一个整数数组，
     * 判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     */

    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return VerifySequenceOfBST(sequence, sequence.length);
    }

    public boolean VerifySequenceOfBST(int[] sequence, int length) {
        if (sequence == null || sequence.length == 0) return false;
        int i = 0;
        int rootValue = sequence[length - 1];
        //查找左子树
        for (; i < length - 1; i++) {
            if (rootValue < sequence[i]) break;
        }
        int j = i;
        //查找右子树
        for (; j < length - 1; j++) {
            if (rootValue > sequence[j]) return false;
        }
        //验证，左子树是否为 BST
        boolean leftIsBST = true;
        if (i > 0) {
            leftIsBST = VerifySequenceOfBST(sequence, i);
        }
        //验证，右子树是否为 BST
        boolean rightIsBST = true;
        if (j < length - 1) {
            rightIsBST = VerifySequenceOfBST(sequence, length - i - 1);
        }
        return leftIsBST && rightIsBST;
    }

    @Test
    public void test() {

        System.out.println(VerifySequenceOfBST(new int[]{3, 1, 2}));

    }

}
