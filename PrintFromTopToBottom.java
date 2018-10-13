package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 从上往下打印出二叉树的每个节点，
     * 同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> mIntegerArrayList = new ArrayList<>();
        if (root == null) return mIntegerArrayList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode mTreeNode = queue.poll();
            if (mTreeNode.left != null)
                queue.offer(mTreeNode.left);
            if (mTreeNode.right != null)
                queue.offer(mTreeNode.right);
            mIntegerArrayList.add(mTreeNode.val);
        }
        return mIntegerArrayList;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        ArrayList<Integer> mIntegerArrayList = PrintFromTopToBottom(root);
        for (Integer a : mIntegerArrayList) {
            System.out.print(a + " ");
        }
    }
}
