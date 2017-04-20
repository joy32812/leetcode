package com.leetcode;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P285_InorderSuccessorinBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return dfs(root, p, null);
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode lastNode) {
        if (root == null || p == null) {return null;}

        if (root.val < p.val) {
            return dfs(root.right, p, lastNode);
        } else if (root.val == p.val) {
            if (root.right == null) {return lastNode;}

            return dfs(root.right, p, lastNode);
        } else {
            if (root.left != null) {
                return dfs(root.left, p, root);
            }

            return root;
        }
    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t4.left = t2;
        t4.right = t5;

        t2.left = t1;
        t2.right = t3;


        System.out.println(new P285_InorderSuccessorinBST().inorderSuccessor(t4, t5).val);

    }

}
