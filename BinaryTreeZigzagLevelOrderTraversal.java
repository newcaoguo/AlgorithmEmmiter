package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mList = new ArrayList<>();
        if (root == null) return mList;
        helper(mList, root, 0);
        return mList;
    }

    public void helper(List<List<Integer>> mList, TreeNode root, int height) {
        if (height >= mList.size()) mList.add(new LinkedList<>());
        if (height % 2 == 0) {
            mList.get(height).add(0, root.val);
        } else {
            mList.get(height).add(root.val);
        }
        if (root.right != null) helper(mList, root.right, height + 1);
        if (root.left != null) helper(mList, root.left, height + 1);
    }

    @Test
    public void test() {
        List<Integer> mList = new LinkedList<>();
        mList.add(5);
        mList.add(0, 6);
        for (Integer a : mList) System.out.print(a + " ");
    }

}
