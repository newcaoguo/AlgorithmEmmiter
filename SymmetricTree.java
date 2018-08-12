import jdk.nashorn.api.tree.Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断一个二叉树是否对称
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * 判断是否为镜像
     *
     * @param leftNode
     * @param rightNode
     * @return
     */
    public static boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true; // 如果树为空，或者只有一个结点的时候，为 true
        else if (leftNode == null || rightNode == null) return false; // 如果左子树或者右子树为空的时候，为 false
        if (leftNode.val == rightNode.val) { // 如果是根节点
            return isMirror(leftNode.left, rightNode.right) // 那么判断它的左右子树是否镜像
                    && isMirror(leftNode.right, rightNode.left); // 左子树的左结点是否与右子树的右结点相等
            // 左子树的右结点是否与右子树的左结点相等
        }
        return false;
    }

    public static void main(String[] args) {
        //TODO: 测试
    }

}
