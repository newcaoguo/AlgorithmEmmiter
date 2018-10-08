package com.company;

import org.junit.Test;

public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        boolean result = false;
        if (root1.val == root2.val) result = isHaveChildTree(root1, root2);

        if (!result) {
            return HasSubtree(root1.left, root2)
                    || HasSubtree(root1.right, root2);
        } else {
            return true;
        }

    }

    public boolean isHaveChildTree(TreeNode mTreeNode1, TreeNode mTreeNode2) {
        if (mTreeNode2 == null) return true;
        else if (mTreeNode1 == null) return false;
        if (mTreeNode1.val != mTreeNode2.val) return false;
        else {
            return isHaveChildTree(mTreeNode1.left, mTreeNode2.left)
                    && isHaveChildTree(mTreeNode1.right, mTreeNode2.right);
        }
    }


    @Test
    public void test() {
        TreeNode mTreeNode1 = new TreeNode(1);
        TreeNode mLeftTreeNode1 = new TreeNode(2);
        TreeNode mRightTreeNode1 = new TreeNode(2);
        mTreeNode1.left = mLeftTreeNode1;
        mTreeNode1.right = mRightTreeNode1;
        TreeNode mTreeNode2 = new TreeNode(2);
        System.out.println(HasSubtree(mTreeNode1, mTreeNode2));
    }

}
