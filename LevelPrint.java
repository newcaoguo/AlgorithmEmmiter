package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelPrint {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> mResultLists = new ArrayList<>();
        if (pRoot == null) return mResultLists;
        //奇数行打印
        Queue<TreeNode> oddStack = new LinkedList<>();
        //偶数行打印
        Queue<TreeNode> evenStack = new LinkedList<>();
        ArrayList<Integer> mList = new ArrayList<>();
        mList.add(pRoot.val);
        mResultLists.add(mList);
        evenStack.add(pRoot);
        while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
            if (evenStack.isEmpty() && oddStack.isEmpty()) break;
            mList = new ArrayList<>();
            if (oddStack.isEmpty()) {
                while (!evenStack.isEmpty()) {
                    if (evenStack.peek().left != null) {
                        mList.add(evenStack.peek().left.val);
                        oddStack.add(evenStack.peek().left);
                    }
                    if (evenStack.peek().right != null) {
                        mList.add(evenStack.peek().right.val);
                        oddStack.add(evenStack.peek().right);
                    }
                    evenStack.poll();
                }
            } else {
                while (!oddStack.isEmpty()) {
                    if (oddStack.peek().left != null) {
                        mList.add(oddStack.peek().left.val);
                        evenStack.add(oddStack.peek().left);
                    }
                    if (oddStack.peek().right != null) {
                        mList.add(oddStack.peek().right.val);
                        evenStack.add(oddStack.peek().right);
                    }
                    oddStack.poll();
                }
            }
            if (mList.size() > 0) mResultLists.add(mList);
        }
        return mResultLists;
    }
}
