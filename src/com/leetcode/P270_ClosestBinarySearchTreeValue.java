package com.leetcode;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {

        int ans = root.val;
        if (root.val < target) {
            if (root.right != null) {
                int v = closestValue(root.right, target);
                if (Math.abs(v - target) < Math.abs(ans - target)) {
                    ans = v;
                }
            }
        } else {
            if (root.left != null) {
                int v = closestValue(root.left, target);
                if (Math.abs(v - target) < Math.abs(ans - target)) {
                    ans = v;
                }
            }
        }

        return ans;
    }

}
