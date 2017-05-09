package com.leetcode;

/**
 * Created by xiaoyuan on 09/05/2017.
 */
public class P333_LargestBSTSubtree {

    private class RNode {
        boolean isBST;
        int number;
        int minVal;
        int maxVal;

        public RNode(boolean isBST, int number, int minVal, int maxVal) {
            this.isBST = isBST;
            this.number = number;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }
    private int ans;
    public int largestBSTSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private RNode dfs(TreeNode root) {
        if (root == null) {
            return new RNode(true, 0, 0, 0);
        }

        RNode left = dfs(root.left);
        RNode right = dfs(root.right);
        if (!left.isBST || !right.isBST) {
            return new RNode(false, 0, 0, 0);
        }

        if (left.number > 0 && root.val <= left.maxVal) {
            return new RNode(false, 0, 0, 0);
        }

        if (right.number > 0 && root.val >= right.minVal) {
            return new RNode(false, 0, 0, 0);
        }


        int minVal = root.val;
        int maxVal = root.val;
        if (left.number > 0) {minVal = left.minVal;}
        if (right.number > 0) {maxVal = right.maxVal;}
        ans = Math.max(ans, left.number + right.number + 1);
        return new RNode(true, left.number + right.number + 1, minVal, maxVal);
    }

}
