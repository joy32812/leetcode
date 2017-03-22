package com.leetcode;

/**
 * Created by xiaoyuan on 22/03/2017.
 */
public class P156_BinaryTreeUpsideDown {

    public TreeNode dfs(TreeNode root, TreeNode ll, TreeNode rr) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = ll;
        root.right = rr;

        if (left == null && right == null) {
            return root;
        }
        return dfs(left, right, root);
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {return root;}
        return dfs(root, null, null);
    }

    public static void main(String[] args) {
    }

}
