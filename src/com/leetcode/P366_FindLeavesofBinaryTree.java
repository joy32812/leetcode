package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 17/05/2017.
 */
public class P366_FindLeavesofBinaryTree {

    private List<List<Integer>> ans;
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();

        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int depth = 1 + Math.max(left, + right);

        if (ans.size() <= depth) {
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(root.val);

        return depth;
    }
}
