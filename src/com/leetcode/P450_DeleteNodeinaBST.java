package com.leetcode;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P450_DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {return root;}

        if (key == root.val) {
            if (root.left == null) {return root.right;}

            int val = findMax(root.left);
            root.val = val;
            root.left = deleteNode(root.left, val);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private int findMax(TreeNode root) {
        if (root.right == null) {return root.val;}
        return findMax(root.right);
    }

}
