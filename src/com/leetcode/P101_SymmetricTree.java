package com.leetcode;

/**
 * Created by xiaoyuan on 07/03/2017.
 */
public class P101_SymmetricTree {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {return true;}
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if( left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else {
            if (left.val != right.val) {return false;}
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }

    public static void main(String[] args) {

    }

}
