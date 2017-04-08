package com.leetcode;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P235_LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (root.val >= p.val && root.val <= q.val) {
            return root;
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

}
