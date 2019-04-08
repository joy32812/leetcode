package com.leetcode;

public class P979_DistributeCoinsinBinaryTree {

    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root, null);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode father) {
        if (root.left != null) dfs(root.left, root);
        if (root.right != null) dfs(root.right, root);

        if (root.val != 1) {
            father.val = father.val + (root.val - 1);
            ans += Math.abs(root.val - 1);
            root.val = 1;
        }
    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);

        t1.left = t2;
        t1.right = t3;

        System.out.println(new P979_DistributeCoinsinBinaryTree().distributeCoins(t1));


    }


}
