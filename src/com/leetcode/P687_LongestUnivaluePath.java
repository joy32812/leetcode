package com.leetcode;

/**
 * Created by xiaoyuan on 01/10/2017.
 */
public class P687_LongestUnivaluePath {

    int ans;
    public int longestUnivaluePath(TreeNode root) {

        ans = 0;
        dfs(root);

        return ans;
    }

    private int dfs(TreeNode root) {

        if (root == null) return 0;

        int res = 1;
        int now = 1;
        if (root.left != null) {
            int l = dfs(root.left);

            if (root.val == root.left.val) {
                now += l;
                res = Math.max(res, 1 + l);
            }

        }
        if (root.right != null) {
            int r = dfs(root.right);

            if (root.val == root.right.val) {
                now += r;
                res = Math.max(res, 1 + r);
            }
        }

        ans = Math.max(ans, now - 1);

        return res;
    }


    public static void main(String[] args) {

    }

}
