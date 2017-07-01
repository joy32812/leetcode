package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P572_SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        String ss = dfs(s);
        String tt = dfs(t);

        return ss.indexOf(tt) != -1;
    }

    private String dfs(TreeNode t) {
        if (t == null) {return "(null)";}
        return "(" + dfs(t.left) + t.val + dfs(t.right) + ")";
    }

}
