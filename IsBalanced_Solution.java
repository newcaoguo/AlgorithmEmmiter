package com.company;

import org.junit.Test;

public class IsBalanced_Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            return false;
        return IsBalanced_Solution(root.left) &&
                IsBalanced_Solution(root.right);
    }

    public int treeDepth(TreeNode mTreeNode) {
        if (mTreeNode == null) return 0;
        int left = treeDepth(mTreeNode.left) + 1;
        int right = treeDepth(mTreeNode.right) + 1;
        return Math.max(left, right);
    }

    @Test
    public void test() {

    }
}
