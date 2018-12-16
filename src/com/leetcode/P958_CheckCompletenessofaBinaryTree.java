package com.leetcode;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P958_CheckCompletenessofaBinaryTree {


    /**
     * just level-order traversal
     * after the last
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        boolean end = false;

        while (!Q.isEmpty()) {
            TreeNode now = Q.poll();

            if (now == null) end = true;
            else {
                if (end) return false;

                Q.add(now.left);
                Q.add(now.right);
            }
        }

        return true;
    }



    int h;
    Map<TreeNode, Integer> ansMap;

    /**
     * check if complete for level(h - 1)
     * and check if level h is continuous
     * messy code
     * @param root
     * @return
     */
    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) return true;

        h = getHeight(root);

        ansMap = new HashMap<>();
        dfs(root, 1, 0);

        if (ansMap == null) return false;

        boolean[] visit = new boolean[1000];
        for (int v : ansMap.values()) {
            visit[v] = true;
        }
        for (int i = 0; i < 500; i++) {
            if (visit[i] == false && visit[i + 1]) return false;
        }

        return true;
    }

    private void dfs(TreeNode root, int d, int v) {
        if (ansMap == null) return;

        if (d == h) {
            if (root == null) return;

            ansMap.put(root, v);
            return;
        }

        if (root == null) {
            ansMap = null;
            return;
        }

        dfs(root.left, d + 1, 2 * v);
        dfs(root.right, d + 1, 2 * v + 1);

    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    public static void main(String[] args) {

    }
}
