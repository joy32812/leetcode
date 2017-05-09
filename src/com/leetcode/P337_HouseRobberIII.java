package com.leetcode;

/**
 * Created by xiaoyuan on 09/05/2017.
 */
public class P337_HouseRobberIII {

    private class BTVal {
        int robVal;
        int noRobVal;

        public BTVal(int robVal, int noRobVal) {
            this.robVal = robVal;
            this.noRobVal = noRobVal;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {return 0;}

        BTVal result = dfs(root);
        return Math.max(result.robVal, result.noRobVal);
    }

    private BTVal dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new BTVal(root.val, 0);
        }

        if (root.left == null) {
            BTVal right = dfs(root.right);
            return new BTVal(root.val + right.noRobVal, Math.max(right.robVal, right.noRobVal));
        } else if (root.right == null) {
            BTVal left = dfs(root.left);
            return new BTVal(root.val + left.noRobVal, Math.max(left.robVal, left.noRobVal));
        } else {
            BTVal left = dfs(root.left);
            BTVal right = dfs(root.right);
            return new BTVal(root.val + right.noRobVal + left.noRobVal, Math.max(left.robVal, left.noRobVal) + Math.max(right.robVal, right.noRobVal));
        }

    }

}
