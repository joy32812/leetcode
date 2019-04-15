package com.leetcode;

public class P814_BinaryTreePruning {

    /**
     * easy
     * recursively traverse the tree
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {

        int total = dfs(root);
        return root;
    }


    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        if (leftSum == 0) root.left = null;
        if (rightSum == 0) root.right = null;

        return root.val + leftSum + rightSum;
    }

}
