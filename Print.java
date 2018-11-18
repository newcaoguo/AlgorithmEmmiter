package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pRoot.val);
        result.add(list);
        stack1.push(pRoot);
        while (stack1.isEmpty() || stack2.isEmpty()) {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                break;
            }
            ArrayList<Integer> temp = new ArrayList<>();
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    if (stack1.peek().right != null) {
                        temp.add(stack1.peek().right.val);
                        stack2.push(stack1.peek().right);
                    }
                    if (stack1.peek().left != null) {
                        temp.add(stack1.peek().left.val);
                        stack2.push(stack1.peek().left);
                    }
                    stack1.pop();
                }
            } else {
                while (!stack2.isEmpty()) {
                    if (stack2.peek().left != null) {
                        temp.add(stack2.peek().left.val);
                        stack1.push(stack2.peek().left);
                    }
                    if (stack2.peek().right != null) {
                        temp.add(stack2.peek().right.val);
                        stack1.push(stack2.peek().right);
                    }
                    stack2.pop();
                }
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
        }
        return result;
    }


    @Test
    public void test() {
        TreeNode pRoot = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        pRoot.left = left;
        pRoot.right = right;
        Print(pRoot);
    }

}
