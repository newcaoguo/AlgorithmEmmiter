public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else {
            return getDepth(root) != -1;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.left) + 1;
        int rightDepth = getDepth(root.right) + 1;
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth);
    }

}
