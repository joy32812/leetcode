package com.leetcode;

/**
 * Created by xiaoyuan on 27/06/2017.
 */
public class P538_ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {

        work(root, 0);

        return root;
    }

    private int work(TreeNode root, int fatherSum) {
        if (root == null) {return 0;}

        int val = root.val;
        int rightSum = work(root.right, fatherSum);
        int leftSum = work(root.left, rightSum + root.val + fatherSum);
        root.val += rightSum + fatherSum;

        return leftSum + val + rightSum;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(-4);
        TreeNode t5 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        TreeNode root = new P538_ConvertBSTtoGreaterTree().convertBST(t1);
        System.out.println(root);
    }

}
