package com.company;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) res.add(new LinkedList<>());
        res.get(height).add(root.val);
        if (root.left != null) levelHelper(res, root.left, height + 1);
        if (root.right != null) levelHelper(res, root.right, height + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
}
