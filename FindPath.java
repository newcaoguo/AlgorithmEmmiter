package com.company;

import java.util.ArrayList;

public class FindPath {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return list;

        //每访问到一个结点的时候，都把当前的结点添加到路径中去，并调整target的值
        path.add(root.val);
        target -= root.val;

        //已到叶节点并且和为target，则把当前路径添加到输出列表里
        //因为add添加的是引用，如果不new一个的话，最终list保存到的只是最后一个path
        if (target == 0 && root.left == null && root.right == null)
            list.add(new ArrayList<>(path));

        //否则继续遍历
        FindPath(root.left, target);
        FindPath(root.right, target);

        //已到叶节点之后会跳过两个递归函数到这里，此时要把最后一个结点从路径中删除，才能返回上层结点
        path.remove(path.size() - 1);
        return list;
    }

}
