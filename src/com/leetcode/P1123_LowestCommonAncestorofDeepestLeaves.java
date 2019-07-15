package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1123_LowestCommonAncestorofDeepestLeaves {

    class AnsNode {
        TreeNode node;
        int depth;

        public AnsNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * lca
     * @param root
     * @return
     */
    private AnsNode dfs(TreeNode root) {
        if (root == null) return new AnsNode(null, 0);

        AnsNode leftAns = dfs(root.left);
        AnsNode rightAns = dfs(root.right);

        TreeNode now = root;
        if (leftAns.depth > rightAns.depth) now = leftAns.node;
        if (leftAns.depth < rightAns.depth) now = rightAns.node;

        return new AnsNode(now, Math.max(leftAns.depth, rightAns.depth) + 1);
    }


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }



}
