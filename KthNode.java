package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KthNode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如 5，3，7，2，4，6，8 中，
     * 按结点数值大小顺序第三小结点的值为4。
     */

    List<TreeNode> mList = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        // 先序遍历找到二叉搜索树增序数列
        preNode(pRoot);
        for (int i = 1; i <= mList.size(); i++) {
            if (i == k)
                return mList.get(i - 1);
        }
        return null;
    }


    public void preNode(TreeNode pRoot) {
        if (pRoot == null) return;
        if (pRoot.left != null)
            preNode(pRoot.left);
        mList.add(pRoot);
        if (pRoot.right != null)
            preNode(pRoot.right);
    }


    @Test
    public void test() {
        //8,6,10,5,7,9,11
        TreeNode pRoot = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);
        pRoot.left = node6;
        pRoot.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;
        TreeNode treeNode = KthNode(pRoot, 1);
        System.out.println(treeNode.val);
    }
}
