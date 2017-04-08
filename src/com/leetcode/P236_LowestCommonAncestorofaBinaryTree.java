package com.leetcode;

/**
 * Created by xiaoyuan on 08/04/2017.
 */
public class P236_LowestCommonAncestorofaBinaryTree {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);

        return ans;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {return 0;}

        int leftNum = dfs(root.left, p, q);
        int rightNum = dfs(root.right, p, q);

        if (ans == null && leftNum == 1 && rightNum == 1) {
            ans = root;
        }
        if (ans == null && (root == p || root == q) && leftNum + rightNum == 1) {
            ans = root;
        }

        int now = 0;
        if (root == p || root == q) {
            now = 1;
        }

        return leftNum + rightNum + now;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;

        System.out.println(new P236_LowestCommonAncestorofaBinaryTree().lowestCommonAncestor(t1, t2, t6));

    }

}
