package com.leetcode;

/**
 * Created by xiaoyuan on 28/06/2017.
 */
public class P543_DiameterofBinaryTree {

    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;

        work(root);

        return ans == 0 ? 0 : ans - 1;
    }

    private int work(TreeNode root) {
        if (root == null) {return 0;}

        int left = work(root.left);
        int right = work(root.right);
        ans = Math.max(ans, left + right + 1);

        return Math.max(left, right) + 1;
    }

}
