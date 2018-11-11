package com.leetcode;

public class P938_RangeSumofBST {


    /**
     * binary tree range sum
     * easy dfs
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int total = 0;
        if (root.val >= L && root.val <= R) total += root.val;

        if (root.left != null && root.val >= L) total += rangeSumBST(root.left, L, R);
        if (root.right != null && root.val <= R) total += rangeSumBST(root.right, L, R);

        return total;
    }

    public static void main(String[] args) {

    }

}
