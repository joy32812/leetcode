package com.leetcode;

public class P897_IncreasingOrderSearchTree {

    /**
     * recursive
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        return dfs(root, null);
    }

    private TreeNode dfs(TreeNode root, TreeNode tail) {
        if (root == null) return tail;

        TreeNode res = dfs(root.left, root);
        root.left = null;
        root.right = dfs(root.right, tail);

        return res;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);

        t1.left = t2;

        TreeNode treeNode = new P897_IncreasingOrderSearchTree().increasingBST(t1);

        System.out.println(treeNode);
    }

}
