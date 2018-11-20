package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Serialize {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        return RSerialize(root, "");
    }

    String RSerialize(TreeNode root, String str) {
        if (root == null) str += "NULL,";
        else {
            str += str.valueOf(root.val) + ",";
            str = RSerialize(root.left, str);
            str = RSerialize(root.right, str);
        }
        return str;
    }

    TreeNode Deserialize(String str) {
        String[] dataArray = str.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return RDeserialize(dataList);
    }

    TreeNode RDeserialize(List<String> strList) {
        if (strList.get(0).equals("NULL")) {
            strList.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strList.get(0)));
        strList.remove(0);
        node.left = RDeserialize(strList);
        node.right = RDeserialize(strList);
        return node;
    }
}
