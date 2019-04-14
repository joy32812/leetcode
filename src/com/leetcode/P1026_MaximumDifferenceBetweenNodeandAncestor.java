package com.leetcode;

public class P1026_MaximumDifferenceBetweenNodeandAncestor {


    int ans;

    /**
     * medium
     * for every subtree, get the result with max and min
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {

        ans = Integer.MIN_VALUE;
        dfs(root, null, null);

        return ans;
    }

    private void dfs(TreeNode root, Integer max, Integer min) {
        if (root == null) return;

        if (max == null) {
            max = root.val;
            min = root.val;
        }

        ans = Math.max(ans, Math.abs(max - root.val));
        ans = Math.max(ans, Math.abs(min - root.val));

        dfs(root.left, Math.max(max, root.val), Math.min(min, root.val));
        dfs(root.right, Math.max(max, root.val), Math.min(min, root.val));
    }

    public static void main(String[] args) {

    }

}
