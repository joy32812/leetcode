package com.leetcode;

public class P988_SmallestStringStartingFromLeaf {

    String ans;
    public String smallestFromLeaf(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        dfs(root, sb);

        return ans;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        sb.append((char)('a' + root.val));

        if (root.left == null && root.right == null) {
            StringBuilder nsb = new StringBuilder(sb);
            String now = nsb.reverse().toString();

            if (ans == null || ans.compareTo(now) > 0) ans = now;
        }

        if(root.left != null) dfs(root.left, sb);
        if(root.right != null) dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }


    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("abcde");
        sb.reverse();

        System.out.println(sb.toString());

        TreeNode t1 = new TreeNode(25);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;


        System.out.println(new P988_SmallestStringStartingFromLeaf().smallestFromLeaf(t1));
    }

}
