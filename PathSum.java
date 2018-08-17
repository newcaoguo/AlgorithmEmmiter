public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int pasum, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return pasum + root.val == sum;
        return dfs(root.left, pasum + root.val, sum) || dfs(root.right, pasum + root.val, sum);
    }
}
