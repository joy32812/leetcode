package com.leetcode;

/**
 * Created by xiaoyuan on 08/03/2017.
 */
public class P112_PathSum {

    private boolean ans;

    public void dfs(TreeNode now, int total, int sum) {
        if (now == null) {return;}
        if (now.left == null && now.right == null) {
            if (total + now.val == sum) {
                ans = true;
            }
            return;
        }

        dfs(now.left, total + now.val, sum);
        if (ans) {return;}
        dfs(now.right, total + now.val, sum);
        if (ans) {return;}
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        ans = false;
        dfs(root, 0, sum);
        return ans;
    }

    public static void main(String[] args) {

    }

}
