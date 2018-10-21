package com.company;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char val) {
            this.val = val;
        }
    }

    public int minDepth(TreeNode mTreeNode) {
        if (mTreeNode == null) return 0;
        int level = 0; //深度
        int nextLevelNumber = 0; //下一层要打印的结点数目
        int toBePrint = 0;// 要打印的剩余数

        Queue<TreeNode> mQueue = new LinkedList<>();
        mQueue.add(mTreeNode);
        level++;
        toBePrint++;
        while (!mQueue.isEmpty()) {
            TreeNode node = mQueue.poll();
            toBePrint--;
            //如果找到了叶子节点了，就直接返回
            if (node.left == null || node.right == null) {
                return level;
            }
            if (node.left != null) {
                mQueue.add(node.left);
                nextLevelNumber++;
            }
            if (node.right != null) {
                mQueue.add(node.right);
                nextLevelNumber++;
            }
            if (toBePrint == 0) {
                toBePrint = nextLevelNumber;
                nextLevelNumber = 0;
                level++;
            }
        }
        return level;
    }

    @Test
    public void test() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode I = new TreeNode('I');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;

        D.right = I;
        /**
         *      A
         *    B    C
         *  D  E F   G
         *   I
         */
        System.out.println(minDepth(A));
    }
}
