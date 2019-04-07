package com.leetcode;

public class P1022_SumofRootToLeafBinaryNumbers {


    long ans = 0;
    long MOD = 1000000000 + 7;

    /**
     * easy
     * back tracing
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {

        ans = 0;
        dfs(root, 0l);

        return (int) (ans % MOD);
    }

    private void dfs(TreeNode root, long now) {
        if (root == null) return;

        long current = (now * 2 + root.val) % MOD;
        if (root.left == null && root.right == null) {
            ans = (ans + current) % MOD;
            return;
        }

        if (root.left != null) dfs(root.left, current);
        if (root.right != null) dfs(root.right, current);
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);

        t1.left = t2;

        System.out.println(new P1022_SumofRootToLeafBinaryNumbers().sumRootToLeaf(t1));

    }
}
