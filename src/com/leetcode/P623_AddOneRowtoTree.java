package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P623_AddOneRowtoTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        return work(root, v, d, 1, true);

    }

    private TreeNode work(TreeNode root, int v, int d, int nowDepth, boolean isLeft) {

        if (nowDepth == d) {
            TreeNode nowNode = new TreeNode(v);
            if (isLeft) {
                nowNode.left = root;
            } else {
                nowNode.right = root;
            }
            return nowNode;
        }

        if (root == null) {return null;}

        root.left = work(root.left, v, d, nowDepth + 1, true);
        root.right = work(root.right, v, d, nowDepth + 1, false);

        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;


        System.out.println(new P623_AddOneRowtoTree().addOneRow(t1, 1, 2));
    }


}
