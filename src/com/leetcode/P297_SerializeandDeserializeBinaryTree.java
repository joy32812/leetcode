package com.leetcode;

/**
 * Created by xiaoyuan on 24/04/2017.
 */
public class P297_SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {return "null";}

        String leftS = serialize(root.left);
        String rightS = serialize(root.right);

        int leftNum = 0;
        int rightNum = 0;
        if (!leftS.equals("null")) {
            leftNum = Integer.parseInt(leftS.split("_")[0]) + Integer.parseInt(leftS.split("_")[1]) + 1;
        }
        if (!rightS.equals("null")) {
            rightNum = Integer.parseInt(rightS.split("_")[0]) + Integer.parseInt(rightS.split("_")[1]) + 1;
        }

        String now = leftNum + "_" + rightNum + "_" + root.val + "," + (leftS.equals("null") ? "" : leftS) + (rightS.equals("null") ? "" : rightS);
        return now;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {return null;}

        String[] nodeArr = data.split(",");

        return work(nodeArr, 0, nodeArr.length - 1);
    }

    private TreeNode work(String[] nodeArr, int l, int r) {
        if (l > r) {return null;}

        TreeNode nowNode = new TreeNode(Integer.parseInt(nodeArr[l].split("_")[2]));
        int leftNum = Integer.parseInt(nodeArr[l].split("_")[0]);

        TreeNode left = work(nodeArr, l + 1, l + leftNum);
        TreeNode right = work(nodeArr, l + leftNum + 1, r);

        nowNode.left = left;
        nowNode.right = right;

        return nowNode;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;

        P297_SerializeandDeserializeBinaryTree obj = new P297_SerializeandDeserializeBinaryTree();

        String data = obj.serialize(t1);

        TreeNode t = obj.deserialize(data);

        System.out.println("H");

    }

}
