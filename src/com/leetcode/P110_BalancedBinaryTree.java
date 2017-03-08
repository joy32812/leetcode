package com.leetcode;

/**
 * Created by xiaoyuan on 08/03/2017.
 */
public class P110_BalancedBinaryTree {

    public int findHeight(TreeNode root) {
        if (root == null) {return 0;}
        int hLeft = findHeight(root.left);
        int hRight = findHeight(root.right);

        if (hLeft < 0 || hRight < 0) {return -1;}
        if (Math.abs(hLeft - hRight) > 1) {return -1;}

        return Math.max(hLeft, hRight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
    }


    public static void main(String[] args) {

    }
}
