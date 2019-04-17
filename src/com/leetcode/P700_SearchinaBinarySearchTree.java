package com.leetcode;

public class P700_SearchinaBinarySearchTree {


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

}
