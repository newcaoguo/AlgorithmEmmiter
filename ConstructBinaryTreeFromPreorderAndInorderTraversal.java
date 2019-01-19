package com.company;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1,
                preorder, inorder);
    }
    //preorder = [3,9,20,15,7]
    //inorder = [9,3,15,20,7]
    // inIndex = 1
    //left (1, 0, 0)
    //right (0 + 1 - 0 + 1 = 2, 2, 4)
    public TreeNode helper(int preStart, int inStart, int inEnd,
                           int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++)
            if (inorder[i] == root.val) inIndex = i;
        root.left = helper(preStart + 1, inStart, inIndex - 1,
                preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd,
                preorder, inorder);
        return root;
    }
}
