package com.leetcode;

/**
 * Created by xiaoyuan on 24/04/2017.
 */
public class P298_BinaryTreeLongestConsecutiveSequence {

    private int ans;

    public int longestConsecutive(TreeNode root) {
        ans = 0;
        work(root);

        return ans;
    }
    public int work(TreeNode root) {
        if (root == null) {return 0;}

        int left = work(root.left);
        int right = work(root.right);

        int now = 1;
        if (left > 0 && root.val + 1 == root.left.val) {
            now = Math.max(now, left + 1);
        }
        if (right > 0 && root.val + 1 == root.right.val) {
            now = Math.max(now, right + 1);
        }

        ans = Math.max(ans, now);
        return now;
    }

}
