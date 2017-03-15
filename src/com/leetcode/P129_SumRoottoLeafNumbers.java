package com.leetcode;

/**
 * Created by xiaoyuan on 15/03/2017.
 */
public class P129_SumRoottoLeafNumbers {

    private int ans;

    public void travel(TreeNode root, int now) {
        if (root == null) {return ;}

        if (root.left == null && root.right == null) {
            ans += (now * 10 + root.val);
            return;
        }

        travel(root.left, now * 10 + root.val);
        travel(root.right, now * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        ans = 0;
        travel(root, 0);
        return ans;
    }

}
