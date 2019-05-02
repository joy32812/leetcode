package com.leetcode;

public class P865_SmallestSubtreewithalltheDeepestNodes {


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return root;

        Object[] result = dfs(root, 0);
        return (TreeNode) result[0];
    }

    private Object[] dfs(TreeNode root, int d) {
        if (root == null) return new Object[]{root, 0};

        Object[] left = dfs(root.left, d + 1);
        Object[] right = dfs(root.right, d + 1);

        TreeNode l = (TreeNode) left[0];
        TreeNode r = (TreeNode) right[0];

        int leftH = (int) left[1];
        int rightH = (int) right[1];

        if (l == null && r == null) return new Object[]{root, d};

        if (l == null) return right;
        if (r == null) return left;

        if (leftH > rightH) return left;
        if (leftH < rightH) return right;

        return new Object[]{root, leftH};
    }


}
