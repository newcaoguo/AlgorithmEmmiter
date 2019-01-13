package com.company;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> mList = new ArrayList<>();
        if (root == null) return mList;
        helper(mList, root);
        return mList;
    }

    public void helper(List<Integer> mList, TreeNode root) {
        if (root == null) return;
        helper(mList, root.left);
        mList.add(root.val);
        helper(mList, root.right);
    }
}
