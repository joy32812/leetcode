package com.leetcode;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P250_CountUnivalueSubtrees {

    private class Node {
        int cnt;
        boolean allSame;

        public Node(int cnt, boolean allSame) {
            this.cnt = cnt;
            this.allSame = allSame;
        }
    }

    public int countUnivalSubtrees(TreeNode root) {
        return dfs(root).cnt;
    }
    public Node dfs(TreeNode root) {
        if (root == null) {return new Node(0, true);}


        Node leftNode = dfs(root.left);
        Node rightNode = dfs(root.right);

        int ans = leftNode.cnt + rightNode.cnt;
        if (leftNode.allSame == false || rightNode.allSame == false) {return new Node(ans, false);}

        if (root.left != null && root.right != null) {
            if (root.val != root.left.val) {return new Node(ans, false);}
            if (root.val != root.right.val){return new Node(ans, false);}
            if (root.left.val != root.right.val) {return new Node(ans, false);}
        } else if (root.left != null) {
            if (root.val != root.left.val) {return new Node(ans, false);}
        } else if (root.right != null) {
            if (root.val != root.right.val) {return new Node(ans, false);}
        }

        return new Node(ans + 1, true);
    }

}
