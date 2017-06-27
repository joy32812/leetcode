package com.leetcode;

/**
 * Created by xiaoyuan on 27/06/2017.
 */
public class P530_MinimumAbsoluteDifferenceinBST {

    int ans;
    int last;
    public int getMinimumDifference(TreeNode root) {

        ans = Integer.MAX_VALUE;
        last = -1;

        work(root);

        return ans;
    }

    private void work(TreeNode root) {
        if (root == null) {return;}

        work(root.left);

        if (last != -1) {
            ans = Math.min(ans, Math.abs(last - root.val));
        }
        last = root.val;


        work(root.right);

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        t1.right = t2;
        t2.left = t3;

        System.out.println(new P530_MinimumAbsoluteDifferenceinBST().getMinimumDifference(t1));
    }


}
