package com.leetcode;

public class P872_LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        StringBuilder sb1 = new StringBuilder();
        dfs(root1, sb1);

        StringBuilder sb2 = new StringBuilder();
        dfs(root2, sb2);

        return sb1.toString().equals(sb2.toString());

    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        if (root.left == null && root.right == null) sb.append("(" + root.val + ")");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }


}
