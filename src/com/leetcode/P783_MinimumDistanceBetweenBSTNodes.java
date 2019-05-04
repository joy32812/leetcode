package com.leetcode;

public class P783_MinimumDistanceBetweenBSTNodes {

    int ans;
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if (prev != null) ans = Math.min(ans, Math.abs(prev.val - root.val));
        prev = root;

        dfs(root.right);
    }



}
