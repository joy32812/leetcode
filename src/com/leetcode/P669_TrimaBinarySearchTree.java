package com.leetcode;

/**
 * Created by xiaoyuan on 05/09/2017.
 */
public class P669_TrimaBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }

    private TreeNode dfs(TreeNode root, int l, int r) {
        if (root == null) {return null;}


        if (root.val < l) {
            return dfs(root.right, l, r);
        } else if (root.val >= l && root.val <= r) {
            root.left = dfs(root.left, l, r);
            root.right = dfs(root.right, l, r);
            return root;
        } else {
            return dfs(root.left, l, r);
        }
    }

}
