package com.leetcode;

/**
 * Created by xiaoyuan on 05/04/2017.
 */
public class P226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return null;}

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);

        root.left = left;
        root.right = right;

        return root;
    }

}
