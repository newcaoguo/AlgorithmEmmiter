import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTreeLevelOrderTraversalII {
    private static List<List<Integer>> res = new ArrayList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                System.out.println(temp.val + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return res;
        levelDown(root, 0);
        Collections.reverse(res);
        return res;
    }

    private static void levelDown(TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(level, temp);
        } else {
            res.get(level).add(root.val);
        }
        levelDown(root.left, level + 1);
        levelDown(root.right, level + 1);
        return;
    }

    public static void main(String[] args) {

        /**
         *
         *      3
         *   9    20
         *      15  7
         *
         *output:
         *[
         *  [15,7],
         *  [9,20],
         *  [3]
         *]
         *
         *
         */
        // 初始化二叉树数据
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.right = rootRight;
        rootRight.left = new TreeNode(15);
        rootRight.right = new TreeNode(7);

        levelOrderBottom(root);
        for (List<Integer> integerList : res) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
        }
    }
}
