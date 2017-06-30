package com.leetcode;

/**
 * Created by xiaoyuan on 30/06/2017.
 */
public class P563_BinaryTreeTilt {

    private int ans;
    public int findTilt(TreeNode root) {

        ans = 0;

        work(root);

        return ans;
    }

    private int work(TreeNode root) {
        if (root == null) {return 0;}

        int sumLeft = work(root.left);
        int sumRight = work(root.right);

        ans += Math.abs(sumLeft - sumRight);

        return sumLeft + sumRight + root.val;
    }

}
