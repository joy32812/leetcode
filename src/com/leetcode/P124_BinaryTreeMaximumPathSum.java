package com.leetcode;

/**
 * Created by xiaoyuan on 14/03/2017.
 */
public class P124_BinaryTreeMaximumPathSum {

    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {return 0;}

        int left = dfs(root.left);
        int right = dfs(root.right);

        int now = root.val;
        now = Math.max(now, root.val + Math.max(left, right));

        ans = Math.max(ans, now);
        ans = Math.max(ans, root.val + left + right);

        return now;
    }

    public static void main(String[] args) {

    }
}
