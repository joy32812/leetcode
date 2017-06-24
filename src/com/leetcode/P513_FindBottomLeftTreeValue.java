package com.leetcode;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P513_FindBottomLeftTreeValue {

    private int depth;
    private int ans;
    public int findBottomLeftValue(TreeNode root) {

        depth = 0;
        ans = 0;
        work(root, 1);

        return ans;
    }

    private void work(TreeNode root, int d) {
        if (root == null) {return;}
        if (d > depth) {
            depth = d;
            ans = root.val;
        }

        work(root.left, d + 1);
        work(root.right, d + 1);
    }

}
