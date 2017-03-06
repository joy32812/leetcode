package com.leetcode;

/**
 * Created by xiaoyuan on 06/03/2017.
 */
public class P100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else {
            if (p.val != q.val) {return false;}
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {

    }

}
