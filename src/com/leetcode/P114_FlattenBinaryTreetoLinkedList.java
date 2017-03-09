package com.leetcode;

/**
 * Created by xiaoyuan on 09/03/2017.
 */
public class P114_FlattenBinaryTreetoLinkedList {

    private class Wrapper {
        TreeNode top;
        TreeNode bottom;

        public Wrapper(TreeNode top, TreeNode bottom) {
            this.top = top;
            this.bottom = bottom;
        }
    }

    private Wrapper dfs(TreeNode root) {
        if (root == null) {
            return new Wrapper(null, null);
        }
        Wrapper left = dfs(root.left);
        Wrapper right = dfs(root.right);

        if (left.top == null) {
            root.right = right.top;
        } else {
            root.right = left.top;
            left.bottom.right = right.top;
        }

        root.left = null;
        return new Wrapper(root, right.bottom == null ? (left.bottom == null ? root : left.bottom) : right.bottom);
    }


    public void flatten(TreeNode root) {
        if (root == null) {return;}
        dfs(root);
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t2.left = t3;

        new P114_FlattenBinaryTreetoLinkedList().flatten(t1);

    }

}
