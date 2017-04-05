package com.leetcode;

/**
 * Created by xiaoyuan on 05/04/2017.
 */
public class P222_CountCompleteTreeNodes {

    public int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {return 0;}

        int hLeft = height(root.left);
        int hRight = height(root.right);

        if (hLeft == hRight) {
            return ((1 << hLeft) - 1) + 1 + countNodes(root.right);
        } else {
            return ((1 << hRight) - 1) + 1 + countNodes(root.left);
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        System.out.println(new P222_CountCompleteTreeNodes().countNodes(t1));
    }
}
