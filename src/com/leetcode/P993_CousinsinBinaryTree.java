package com.leetcode;

public class P993_CousinsinBinaryTree {

    /**
     * get height and parent, then check
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        int[] aa = getHeightAndParent(root, 0, -1, x);
        int[] bb = getHeightAndParent(root, 0, -1, y);

        return aa[0] != -1 && aa[0] == bb[0] && aa[1] != bb[1];
    }

    private int[] getHeightAndParent(TreeNode root, int d, int parent, int now) {
        if (root == null) return new int[]{-1, -1};
        if (root.val == now) return new int[]{d, parent};

        int[] ans = getHeightAndParent(root.left, d + 1, root.val, now);
        if (ans[0] != -1) return ans;

        return getHeightAndParent(root.right, d + 1, root.val, now);
    }


    public static void main(String[] args) {

    }
}
