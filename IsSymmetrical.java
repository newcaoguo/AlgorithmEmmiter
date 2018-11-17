package com.company;

import org.junit.Test;

import java.util.Stack;

public class IsSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //{8,6,6,5,7,7,5}


    /*boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        if (pRoot.left == null && pRoot.right == null) return true;

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if ((leftNode == null && rightNode != null) ||
                (rightNode == null && leftNode != null)) return false;
        return leftNode.val == rightNode.val &&
                isSymmetrical(leftNode.left, rightNode.right) &&
                isSymmetrical(leftNode.right, rightNode.left);
    }*/

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> mStack = new Stack<>();
        mStack.push(pRoot.left);
        mStack.push(pRoot.right);
        while (!mStack.isEmpty()) {
            TreeNode rightNode = mStack.pop();
            TreeNode leftNode = mStack.pop();
            if (rightNode == null && leftNode == null) continue;
            if ((rightNode == null && leftNode != null) ||
                    leftNode == null && rightNode != null) return false;
            if (leftNode.val != rightNode.val) return false;
            mStack.push(leftNode.left);
            mStack.push(rightNode.right);
            mStack.push(leftNode.right);
            mStack.push(rightNode.left);
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode pRoot = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        pRoot.left = node1;
        pRoot.right = node2;

        System.out.println(isSymmetrical(pRoot));
    }
}
