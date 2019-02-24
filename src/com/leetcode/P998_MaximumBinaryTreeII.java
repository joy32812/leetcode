package com.leetcode;

public class P998_MaximumBinaryTreeII {


    /**
     * easy, find the postion recursively
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }


        if (val > root.val) {
            TreeNode now = new TreeNode(val);
            now.left = root;

            return now;
        }


        root.right = insertIntoMaxTree(root.right, val);

        return root;
    }

    public static void main(String[] args) {

    }

}
