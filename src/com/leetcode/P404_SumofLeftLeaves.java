package com.leetcode;

/**
 * Created by xiaoyuan on 29/05/2017.
 */
public class P404_SumofLeftLeaves {


    int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {return 0;}

        ans = 0;
        work(root, false);
        return ans;
    }

    private void work(TreeNode root, boolean isLeft) {
        if (root == null) {return;}

        if (isLeft && root.left == null && root.right == null) {
            ans += root.val;
            return;
        }

        work(root.left, true);
        work(root.right, false);
    }

}
