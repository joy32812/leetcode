package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 05/09/2017.
 */
public class P671_SecondMinimumNodeInaBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {

        int ans = dfs(root);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {return Integer.MAX_VALUE;}
        if (root.left == null) {return Integer.MAX_VALUE;}

        if (root.left.val < root.right.val) {
            if (root.val == root.left.val) {
                return Math.min(dfs(root.left), root.right.val);
            }
            return root.left.val;
        } else if (root.left.val == root.right.val) {
            if (root.val == root.left.val) {
                return Math.min(dfs(root.left), dfs(root.right));
            }
            return root.left.val;
        } else {
            if (root.val == root.right.val) {
                return Math.min(root.left.val, dfs(root.right));
            }
            return root.right.val;
        }
    }

}
