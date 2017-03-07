package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 07/03/2017.
 */
public class P104_MaximumDepthofBinaryTree {

    private int ans;
    private void dfs(TreeNode root, int level) {
        if (root == null) {return;}
        ans = Math.max(ans, level);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int maxDepth(TreeNode root) {
        ans = 0;
        dfs(root, 1);
        return ans;
    }

    public static void main(String[] args) {

    }

}
