package com.company;

import org.junit.Test;

public class TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        System.out.println(TreeDepth(new TreeNode(1)));
    }
}
