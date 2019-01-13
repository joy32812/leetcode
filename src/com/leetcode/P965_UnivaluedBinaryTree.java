package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P965_UnivaluedBinaryTree {


    Set<Integer> numberSet;

    /**
     * easy traversal
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {

        numberSet = new HashSet<>();
        dfs(root);

        return numberSet.size() == 1;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        numberSet.add(root.val);

        dfs(root.left);
        dfs(root.right);
    }


    public static void main(String[] args) {

    }

}
