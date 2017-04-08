package com.leetcode;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P230_KthSmallestElementinaBST {

    private TreeNode ans;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return ans.val;
    }

    private int dfs(TreeNode root, int k) {
        if (root == null) {return 0;}

        int leftNum = dfs(root.left, k);
        if (ans != null) {return leftNum;}

        if (k == leftNum + 1) {
            ans = root;
            return leftNum;
        }

        int rightNum = dfs(root.right, k - leftNum - 1);
        return leftNum + rightNum + 1;
    }

}
