package com.leetcode;

/**
 * Created by xiaoyuan on 06/03/2017.
 */
public class P98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return ifOkay(root, -1l + Integer.MIN_VALUE, 1l + Integer.MAX_VALUE);
    }

    private boolean ifOkay(TreeNode root, long min, long max) {
        if (root == null) {return true;}
        if (root.val <= min || root.val >= max) {return false;}
        return ifOkay(root.left, min, Math.min(max, root.val)) && ifOkay(root.right, Math.max(min, root.val), max);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        System.out.println(new P98_ValidateBinarySearchTree().isValidBST(t2));

    }

}
