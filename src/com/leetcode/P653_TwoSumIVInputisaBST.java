package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 09/08/2017.
 */
public class P653_TwoSumIVInputisaBST {

    Set<Integer> set;
    int K;
    boolean ans;
    public boolean findTarget(TreeNode root, int k) {

        set = new HashSet<>();
        K = k;
        ans = false;

        dfs(root);

        return ans;
    }


    private void dfs(TreeNode root) {
        if (root == null) {return;}

        dfs(root.left);
        if (set.contains(K - root.val)) {
            ans = true;
            return;
        }
        set.add(root.val);
        dfs(root.right);

    }

}
