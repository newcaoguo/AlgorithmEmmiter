package com.company;

public class Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一棵二叉搜索树，
     * 将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，
     * 只能调整树中结点指针的指向。
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        TreeNode[] pre = new TreeNode[1];
        helper(pRootOfTree, pre);
        //已经完成双向链表的链接，找链表头节点返回
        TreeNode p = pRootOfTree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }


    private void helper(TreeNode root, TreeNode[] pre) {
        if (root.left != null) {
            helper(root.left, pre);
        }
        root.left = pre[0];  //设置left指向前一个节点
        if (pre[0] != null) {
            pre[0].right = root;  //pre right指向root
        }
        //记录当前节点为尾节点
        pre[0] = root;
        if (root.right != null) {
            helper(root.right, pre);
        }
    }
}
