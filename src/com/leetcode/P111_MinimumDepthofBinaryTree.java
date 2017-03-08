package com.leetcode;

/**
 * Created by xiaoyuan on 08/03/2017.
 */
public class P111_MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {return 0;}
        if (root.left == null && root.right == null) {return 1;}

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int hLeft = minDepth(root.left);
        int hRight = minDepth(root.right);
        return Math.min(hLeft, hRight) + 1;
    }

    public static void main(String[] args) {

    }

}
